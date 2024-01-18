package com.jar.kirana.transaction.service;

import java.util.List;

import com.jar.kirana.transaction.domain.KiranaTransactions;

public interface KiranaTransactionReadService {

    List<KiranaTransactions> getTransactions();

    List<KiranaTransactions> getDailyReport(String date);

}
