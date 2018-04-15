package camt.se234.project.graphql;

import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.entity.User;
import camt.se234.project.service.AuthenticationService;
import camt.se234.project.service.ProductService;
import camt.se234.project.service.SaleOrderService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryProduct  implements GraphQLQueryResolver {
    @Autowired
    ProductService productService;
    @Autowired
    SaleOrderService saleOrderService;
    @Autowired
    AuthenticationService authenticationService;
    public List<Product> getProducts(){
        return productService.getAvailableProducts();
    }

    public List<SaleTransaction> getSaleTransactions(){
        return null;
    }
    public List<SaleOrder> getSaleOrders(){return saleOrderService.getSaleOrders();};
    public User getUser(String username,String password){return authenticationService.authenticate(username,password);}
}
