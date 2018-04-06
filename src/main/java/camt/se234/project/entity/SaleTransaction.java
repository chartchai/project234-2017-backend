package camt.se234.project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
public class SaleTransaction {
    @Id
    Long id;
    String transactionId;
    @OneToOne
    Product product;
    int amount;
}
