package com.jar.kirana.transaction.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest implements Serializable {

    private List<String> itemsPurchased;

    private BigDecimal amount;

    private String currency;

    private String transactionType;

}
