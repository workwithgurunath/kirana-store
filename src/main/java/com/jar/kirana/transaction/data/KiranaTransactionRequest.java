package com.jar.kirana.transaction.data;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class KiranaTransactionRequest {
   
    private List<String> itemsPurchased;
    
    private BigDecimal amount;

    private String currency;

    private String transactionType;

}
