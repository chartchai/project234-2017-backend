package camt.se234.project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class SaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String transactionId;
    @ManyToOne
    SaleOrder order;
    @OneToOne
    Product product;
    int amount;
}
