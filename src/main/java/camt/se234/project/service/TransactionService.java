package camt.se234.project.service;

import camt.se234.project.entity.SaleTransaction;

import java.util.List;

public interface TransactionService {
    SaleTransaction addSaleTransaction(SaleTransaction transaction);
    List<SaleTransaction> getSaleTransactions();
    double getAverageSaleTransactionPrice();
}
