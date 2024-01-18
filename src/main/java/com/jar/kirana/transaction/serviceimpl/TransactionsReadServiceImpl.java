package com.jar.kirana.transaction.serviceimpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.jar.kirana.transaction.domain.Transactions;
import com.jar.kirana.transaction.domain.TransactionsRepository;
import com.jar.kirana.transaction.service.TransactionsReadService;

@Service
public class TransactionsReadServiceImpl implements TransactionsReadService {

    TransactionsRepository transactionsRepository;
    NamedParameterJdbcTemplate jdbcTemplate;

    public TransactionsReadServiceImpl(TransactionsRepository transactionsRepository,
            NamedParameterJdbcTemplate jdbcTemplate) {
        this.transactionsRepository = transactionsRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transactions> getTransactions() {
        // we can use jdbcTemplate.queryForList() to get the list of transactions but i
        // am using the repository
        return this.transactionsRepository.findAll();

    }

    @Override
    public List<Transactions> getDailyReport(String transactionDate) {
        if (StringUtils.isBlank(transactionDate)) {
            transactionDate = LocalDate.now().toString();
        }
        Map<String, Object> params = new HashMap<>();
        params.put("transactionDate", transactionDate);

        String sql = "SELECT * FROM k_transactions WHERE DATE(transaction_date) = :transactionDate";

        return this.jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Transactions.class));
    }

}
