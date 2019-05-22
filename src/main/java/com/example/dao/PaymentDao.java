package com.example.dao;

import com.example.oldApp.Payment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class PaymentDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Payment get(Long id)
    {

        return jdbcTemplate.queryForObject("select * from Payment where payment_id = ?", new RowMapper<Payment>()
        {
            public Payment mapRow(ResultSet resultSet, int i) throws SQLException
            {
                Payment payment = new Payment();
                payment.setId(resultSet.getInt("payment_id"));
                payment.setSaleStatus(resultSet.getString("payment_status"));
                return payment;
            }
        }, new Object[] {id});

    }
    public List<Payment> getAll()
    {
        String sql = "SELECT * FROM payment";

        List<Payment> payments = new ArrayList<Payment>();

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        for (Map result : results) {
            Payment payment = new Payment();
            payment.setId((Integer)(result.get("payment_id")));
            payments.add(payment);
        }
        return payments;
    }

}
