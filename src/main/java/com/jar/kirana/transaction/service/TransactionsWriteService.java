package com.jar.kirana.transaction.service;

import com.jar.kirana.transaction.data.TransactionRequest;
import com.jar.kirana.transaction.data.TransactionResponse;

public interface TransactionsWriteService {

    TransactionResponse createTransaction(TransactionRequest transaction);

}
