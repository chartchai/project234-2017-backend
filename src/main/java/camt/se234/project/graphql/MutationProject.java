package camt.se234.project.graphql;

import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

@Component
public class MutationProject implements GraphQLMutationResolver {
    public SaleOrder addOrder(SaleOrder order){
        return null;
    }


}
