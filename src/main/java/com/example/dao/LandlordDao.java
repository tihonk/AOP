package com.example.dao;

import com.example.oldApp.Address;
import com.example.oldApp.Landlord;
import com.example.oldApp.Payment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class LandlordDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Landlord get(Long id)
    {
        return jdbcTemplate.queryForObject("select * from landlord natural join address natural join payment where landlord_id = ? ", new RowMapper<Landlord>()
        {
            public Landlord mapRow(ResultSet resultSet, int i) throws SQLException
            {
                Landlord landlord = new Landlord();
                landlord.setId(resultSet.getInt("landlord_id"));
                Address address = new Address();
                address.setId((resultSet.getInt("address_id")));
                landlord.setAddress(address);
                Payment payment = new Payment();
                payment.setId((resultSet.getInt("payment_id")));
                landlord.setPayment(payment);
                return landlord;
            }
        }, new Object[] {id});

    }
    public List<Landlord> getAll()
    {
        String sql = "SELECT * FROM landlord";

        List<Landlord> landlords = new ArrayList<Landlord>();

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        for (Map result : results) {
            Landlord landlord = new Landlord();
            landlord.setId((Integer)(result.get("landlord_id")));
            landlords.add(landlord);
        }
        return landlords;
    }
}
