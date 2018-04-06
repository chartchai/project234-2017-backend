package camt.se234.project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
public class SaleOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String saleOrderId;
    @Builder.Default
    @OneToMany(mappedBy = "order")
    List<SaleTransaction> transactions = new ArrayList<>();
    public double getTotalPrice(){
        return 0;
    }
}
