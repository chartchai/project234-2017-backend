package camt.se234.project.repository;

import camt.se234.project.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product,Long> {
    Product findByProductId(String productId);
}
