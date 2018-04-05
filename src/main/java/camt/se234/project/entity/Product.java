package camt.se234.project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Product {
    @Id
    Long id;
    String productId;
    String name;
    String description;
    String imageLocation;
    double price;

}
