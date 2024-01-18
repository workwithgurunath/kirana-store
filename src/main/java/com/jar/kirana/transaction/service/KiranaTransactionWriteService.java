package com.jar.kirana.transaction.service;

import com.jar.kirana.transaction.data.KiranaTransactionRequest;
import com.jar.kirana.transaction.data.KiranaTransactionResponse;

public interface KiranaTransactionWriteService {

    KiranaTransactionResponse createTransaction(KiranaTransactionRequest transaction);

}
