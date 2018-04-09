package camt.se234.project.dao;

import camt.se234.project.entity.SaleTransaction;

import java.util.List;

public interface SaleTransactionDao {
    SaleTransaction addSaleTransaction(SaleTransaction saleTransaction);
    List<SaleTransaction> getSaleTransactions();
}
