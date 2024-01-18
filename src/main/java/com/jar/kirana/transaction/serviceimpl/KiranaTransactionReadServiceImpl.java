package com.jar.kirana.transaction.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.jar.kirana.transaction.domain.KiranaTransactions;
import com.jar.kirana.transaction.domain.KiranaTransactionsRepository;
import com.jar.kirana.transaction.service.KiranaTransactionReadService;

@Service
public class KiranaTransactionReadServiceImpl implements KiranaTransactionReadService {

    KiranaTransactionsRepository kiranaTransactionRepository;
    NamedParameterJdbcTemplate jdbcTemplate;

    public KiranaTransactionReadServiceImpl(KiranaTransactionsRepository kiranaTransactionRepository,
            NamedParameterJdbcTemplate jdbcTemplate) {
        this.kiranaTransactionRepository = kiranaTransactionRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<KiranaTransactions> getTransactions() {
        // we can use jdbcTemplate.queryForList() to get the list of transactions but i
        // am using the repository
        return this.kiranaTransactionRepository.findAll();

    }

    @Override
    public List<KiranaTransactions> getDailyReport(String transactionDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("transactionDate", transactionDate);

        String sql = "SELECT * FROM kirana_transactions WHERE DATE(transaction_date) = :transactionDate";

        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(KiranaTransactions.class));
    }

}
