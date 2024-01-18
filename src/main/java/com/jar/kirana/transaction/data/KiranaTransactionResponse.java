package com.jar.kirana.transaction.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KiranaTransactionResponse {

    private Long transactionId;
    private String message;

}
