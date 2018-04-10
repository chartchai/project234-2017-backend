package camt.se234.project.graphql;

import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.service.ProductService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryProduct  implements GraphQLQueryResolver {
    @Autowired
    ProductService productService;
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    public List<SaleTransaction> getSaleTransactions(){
        return null;
    }
}
