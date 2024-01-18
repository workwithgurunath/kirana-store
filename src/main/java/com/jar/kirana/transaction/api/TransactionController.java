package com.jar.kirana.transaction.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jar.kirana.transaction.data.TransactionRequest;
import com.jar.kirana.transaction.data.TransactionResponse;
import com.jar.kirana.transaction.domain.Transactions;
import com.jar.kirana.transaction.service.TransactionsReadService;
import com.jar.kirana.transaction.service.TransactionsWriteService;

import io.swagger.annotations.Api;

@Api()
@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    private final TransactionsWriteService transactionsWriteService;
    private final TransactionsReadService transactionsReadService;

    public TransactionController(TransactionsWriteService transactionsWriteService,
            TransactionsReadService transactionsReadService) {
        this.transactionsWriteService = transactionsWriteService;
        this.transactionsReadService = transactionsReadService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<TransactionResponse> recordTransaction(
            @RequestBody TransactionRequest transaction) {
        TransactionResponse transactionResponse = transactionsWriteService
                .createTransaction(transaction);
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping("/transactions/daily-report")
    public ResponseEntity<List<Transactions>> getDailyReport(@RequestParam(required = false) String date) {
        List<Transactions> dayTransactions = transactionsReadService.getDailyReport(date);
        return ResponseEntity.ok(dayTransactions);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transactions>> getTransactions() {
        List<Transactions> dayTransactions = transactionsReadService.getTransactions();
        return ResponseEntity.ok(dayTransactions);
    }
}