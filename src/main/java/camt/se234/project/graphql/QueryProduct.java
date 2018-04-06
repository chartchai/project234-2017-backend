package camt.se234.project.graphql;

import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleTransaction;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryProduct  implements GraphQLQueryResolver {
    public List<Product> getProducts(){
        return null;
    }

    public List<SaleTransaction> getSaleTransactions(){
        return null;
    }
}
