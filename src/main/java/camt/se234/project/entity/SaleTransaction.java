package camt.se234.project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class SaleTransaction {
    @Id
    Long id;
    Product product;
    int amount;
    public double getTotalPrice(){
        return 0;
    }
}
