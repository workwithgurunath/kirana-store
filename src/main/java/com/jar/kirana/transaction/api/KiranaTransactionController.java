package com.jar.kirana.transaction.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jar.kirana.transaction.data.KiranaTransactionRequest;
import com.jar.kirana.transaction.data.KiranaTransactionResponse;
import com.jar.kirana.transaction.domain.KiranaTransactions;
import com.jar.kirana.transaction.service.KiranaTransactionReadService;
import com.jar.kirana.transaction.service.KiranaTransactionWriteService;

@RestController
@RequestMapping("/api/kirana")
public class KiranaTransactionController {

    private final KiranaTransactionWriteService kiranaTransactionWriteService;
    private final KiranaTransactionReadService kiranaTransactionReadService;

    public KiranaTransactionController(KiranaTransactionWriteService kiranaTransactionWriteService,
            KiranaTransactionReadService kiranaTransactionReadService) {
        this.kiranaTransactionWriteService = kiranaTransactionWriteService;
        this.kiranaTransactionReadService = kiranaTransactionReadService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<KiranaTransactionResponse> recordTransaction(
            @RequestBody KiranaTransactionRequest transaction) {
        KiranaTransactionResponse kiranaTransactionResponse = kiranaTransactionWriteService
                .createTransaction(transaction);
        return ResponseEntity.ok(kiranaTransactionResponse);
    }

    @GetMapping("/daily-report/{date}")
    public ResponseEntity<List<KiranaTransactions>> getDailyReport(@PathVariable final String date) {
        List<KiranaTransactions> dayTransactions = kiranaTransactionReadService.getDailyReport(date);
        return ResponseEntity.ok(dayTransactions);
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<KiranaTransactions>> getTransactions() {
        List<KiranaTransactions> dayTransactions = kiranaTransactionReadService.getTransactions();
        return ResponseEntity.ok(dayTransactions);
    }
}