package camt.se234.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String saleOrderId;
    @Builder.Default
    @OneToMany(mappedBy = "order")
    List<SaleTransaction> transactions = new ArrayList<>();
    public double getTotalPrice(){
        double totalPrice = 0;
        for (SaleTransaction transaction :
                transactions) {
            totalPrice += transaction.getAmount() * transaction.getProduct().getPrice();
        }
        return totalPrice;
    }
}
