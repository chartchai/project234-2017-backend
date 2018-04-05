package camt.se234.project.utility;

import camt.se234.project.repository.ProductRepository;
import camt.se234.project.repository.SaleTransactionRepository;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;

@Component
public class LoadDataFromExcel {
    @Value("${imageServer}")
    String imageServer;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleTransactionRepository saleTransactionRepository;
    @Transactional
    public void loadData(InputStream input) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheet("Farmers");
    }
}
