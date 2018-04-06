package camt.se234.project.repository;

import camt.se234.project.entity.SaleTransaction;
import org.springframework.data.repository.CrudRepository;

public interface SaleTransactionRepository extends CrudRepository<SaleTransaction,Long> {
    SaleTransaction findByTransactionId(String transactionId);
}
