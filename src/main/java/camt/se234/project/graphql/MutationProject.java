package camt.se234.project.graphql;

import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.service.SaleOrderService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationProject implements GraphQLMutationResolver {
    @Autowired
    SaleOrderService orderService;
    public SaleOrder addOrder(SaleOrder order){
        return orderService.addSaleOrder(order);
    }


}
