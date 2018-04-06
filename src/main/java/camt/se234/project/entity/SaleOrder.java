package camt.se234.project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@Builder
@Data
public class SaleOrder {
    @Id
    Long id;
    String SaleOrderId;
    @OneToMany
    List<SaleTransaction> transactions;
    public double getTotalPrice(){
        return 0;
    }
}
