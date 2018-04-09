package camt.se234.project.dao;

import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.repository.SaleTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class SaleTransactionDaoImpl implements SaleTransactionDao{
    @Autowired
    SaleTransactionRepository saleTransactionRepository;
    @Override
    public SaleTransaction addSaleTransaction(SaleTransaction saleTransaction) {
        return saleTransactionRepository.save(saleTransaction);
    }

    @Override
    public List<SaleTransaction> getSaleTransactions() {
        return StreamSupport.stream(saleTransactionRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
