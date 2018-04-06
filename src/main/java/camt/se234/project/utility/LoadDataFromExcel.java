package camt.se234.project.utility;

import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.entity.User;
import camt.se234.project.repository.OrderRepository;
import camt.se234.project.repository.ProductRepository;
import camt.se234.project.repository.SaleTransactionRepository;
import camt.se234.project.repository.UserRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Component
public class LoadDataFromExcel  extends AbstractDataLoadFromXlsx{
    @Value("${imageServer}")
    String imageServer;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleTransactionRepository saleTransactionRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Transactional
    public void loadData(InputStream input) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheet("user");
        loadUser(sheet);
        sheet = workbook.getSheet("product");
        loadProduct(sheet);
        sheet = workbook.getSheet("saleTransaction");
        loadTransaction(sheet);
        sheet = workbook.getSheet("SaleOrder");
        loadOrder(sheet);

    }

    protected void loadUser(XSSFSheet sheet){
        Iterator<Row> rowIterator = sheet.iterator();
        // skip first row
        rowIterator.next();
        // start reading
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            if (getCellData(row,"B") != ""){
                User user = User.builder()
                        .username(getCellData(row,"B"))
                        .password(getCellData(row,"C"))
                        .role(getCellData(row,"D"))
                        .build();
                userRepository.save(user);
            }
        }
    }

    protected void loadProduct(XSSFSheet sheet){
        Iterator<Row> rowIterator = sheet.iterator();
        // skip first row
        rowIterator.next();

        // start reading
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            if (getCellData(row,"B") != ""){
                Product product = Product.builder()
                        .productId(getCellData(row,"B"))
                        .name(getCellData(row,"C"))
                        .description(getCellData(row,"D"))
                        .imageLocation(imageServer+getCellData(row,"E"))
                        .price((Double) getAnyType(row,"F"))
                        .build();
                productRepository.save(product);
            }
        }
    }

    protected void loadTransaction(XSSFSheet sheet){
        Iterator<Row> rowIterator = sheet.iterator();
        // skip first row
        rowIterator.next();
        // start reading
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            if (getCellData(row,"B") != ""){
                SaleTransaction transaction = SaleTransaction.builder()
                        .transactionId(getCellData(row,"B"))
                        .amount(Integer.parseInt(getCellData(row,"D")))
                        .build();
                saleTransactionRepository.save(transaction);
                Product product = productRepository.findByProductId(getCellData(row,"C"));
                transaction.setProduct(product);
            }
        }
    }

    protected void loadOrder(XSSFSheet sheet){
        Iterator<Row> rowIterator = sheet.iterator();
        // skip first row
        rowIterator.next();
        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            if (getCellData(row,"B") != ""){
                SaleOrder order = SaleOrder.builder()
                        .saleOrderId(getCellData(row,"B"))
                        .build();
                orderRepository.save(order);
                String transactionList = getCellData(row,"C");
                String[] tList = transactionList.split(",");
                for(int i = 0; i < tList.length; i++){
                    SaleTransaction transaction = saleTransactionRepository.findByTransactionId(tList[i]);
                    transaction.setOrder(order);
                    order.getTransactions().add(transaction);
                }
            }
        }
    }
}
