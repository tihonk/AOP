package com.example.dao;

import com.example.oldApp.Deposit;
import com.example.oldApp.Order;
import com.example.oldApp.Payment;
import com.example.oldApp.Price;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class OrderDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Order get(Long id)
    {
        return jdbcTemplate.queryForObject("select * from orders where order_id = ? ", new RowMapper<Order>()
        {
            public Order mapRow(ResultSet resultSet, int i) throws SQLException
            {
                Order order = new Order();
                order.setId(resultSet.getInt("order_id"));
                order.setName(resultSet.getString("order_name"));

                Deposit deposit = new Deposit();
                deposit.setId(resultSet.getInt("deposit_id"));
                order.setDeposit(deposit);
                Price price = new Price();
                price.setId(resultSet.getInt("price_id"));
                order.setPrice(price);
                Payment payment = new Payment();
                payment.setId(resultSet.getInt("payment_id"));
                order.setPayment(payment);

                return order;
            }
        }, new Object[] {id});
    }

    public List<Order> getAll()
    {
        List<Order> orders = new ArrayList<Order>();

        String sql = "SELECT * FROM orders";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

        for (Map result : results) {
            Order order = new Order();
            order.setId((Integer) result.get("order_id"));
            orders.add(order);
        }
        return orders;
    }
}
