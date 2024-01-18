package com.jar.kirana.transaction.serviceimpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.jar.kirana.transaction.data.TransactionRequest;
import com.jar.kirana.transaction.data.TransactionResponse;
import com.jar.kirana.transaction.domain.Transactions;
import com.jar.kirana.transaction.domain.TransactionsRepository;
import com.jar.kirana.transaction.service.TransactionsWriteService;

@Service
public class TransactionsWriteServiceImpl implements TransactionsWriteService {

    private final TransactionsRepository transactionsRepository;

    public TransactionsWriteServiceImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public TransactionResponse createTransaction(TransactionRequest transaction) {
        // todo validate the requestbody
        Transactions transactions = Transactions.builder()
                .itemsPurchased(transaction.getItemsPurchased().toString()).amount(transaction.getAmount())
                .currency(transaction.getCurrency()).transactionType(transaction.getTransactionType())
                .transactionDate(LocalDateTime.now()).build();
        this.transactionsRepository.save(transactions);

        return TransactionResponse.builder()
                .transactionId(transactions.getId())
                .message("Transaction recorded successfully")
                .build();
    }

}
