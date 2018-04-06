package camt.se234.project.repository;

import camt.se234.project.entity.SaleOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<SaleOrder,Long> {
}
