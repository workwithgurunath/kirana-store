package com.jar.kirana.transaction.service;

import java.util.List;

import com.jar.kirana.transaction.domain.Transactions;

public interface TransactionsReadService {

    List<Transactions> getTransactions();

    List<Transactions> getDailyReport(String date);

}
