package com.example.dao;

import com.example.oldApp.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class AddressDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Address get(Long id)
    {

        return jdbcTemplate.queryForObject("select * from address where address_id = ?", new RowMapper<Address>()
        {
            public Address mapRow(ResultSet resultSet, int i) throws SQLException
            {
                Address address = new Address();
                address.setId(resultSet.getInt("address_id"));
                address.setAddress(resultSet.getString("address"));
                return address;
            }
        }, new Object[] {id});

    }
    public List<Address> getAll()
    {
        String sql = "SELECT * FROM address";

        List<Address> addresses = new ArrayList<Address>();

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        for (Map result : results) {
            Address address = new Address();
            address.setId((Integer)(result.get("address_id")));
            addresses.add(address);
        }
        return addresses;
    }

}
