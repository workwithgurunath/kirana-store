package com.jar.kirana.transaction.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.jar.kirana.transaction.data.KiranaTransactionRequest;
import com.jar.kirana.transaction.data.KiranaTransactionResponse;
import com.jar.kirana.transaction.domain.KiranaTransactions;
import com.jar.kirana.transaction.domain.KiranaTransactionsRepository;
import com.jar.kirana.transaction.service.KiranaTransactionWriteService;

@Service
public class KiranaTransactionWriteServiceImpl implements KiranaTransactionWriteService {

    private final KiranaTransactionsRepository kiranaTransactionRepository;

    public KiranaTransactionWriteServiceImpl(KiranaTransactionsRepository kiranaTransactionRepository) {
        this.kiranaTransactionRepository = kiranaTransactionRepository;
    }

    @Override
    public KiranaTransactionResponse createTransaction(KiranaTransactionRequest transaction) {
        // todo validate the requestbody
        KiranaTransactions kiranaTransaction = KiranaTransactions.builder()
                .itemsPurchased(transaction.getItemsPurchased().toString()).amount(transaction.getAmount())
                .currency(transaction.getCurrency()).transactionType(transaction.getTransactionType())
                .transactionDate(LocalDateTime.now()).build();
        this.kiranaTransactionRepository.save(kiranaTransaction);

        return KiranaTransactionResponse.builder()
                .transactionId(kiranaTransaction.getId())
                .message("Transaction recorded successfully")
                .build();
    }

}
