package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.SaleOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {
    OrderDao orderDao;
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public SaleOrder addSaleOrder(SaleOrder order) {
        return orderDao.addOrder(order);
    }

    @Override
    public List<SaleOrder> getSaleOrders() {
        return orderDao.getOrders();
    }

    @Override
    public double getAverageSaleOrderPrice() {
        List<SaleOrder> orders = orderDao.getOrders();
        double totalPrice = 0;
        for (SaleOrder order :
                orders) {
            totalPrice += order.getTotalPrice();
        }
        return totalPrice/orders.size();
    }
}
