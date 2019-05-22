package com.example.dao;

import com.example.oldApp.Address;
import com.example.oldApp.Payment;
import com.example.oldApp.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class TenantDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Tenant get(Long id)
    {
        return jdbcTemplate.queryForObject("select * from tenant where tenant_id = ? ", new RowMapper<Tenant>()
        {
            public Tenant mapRow(ResultSet resultSet, int i) throws SQLException
            {
                Tenant tenant = new Tenant();
                tenant.setId(resultSet.getInt("tenant_id"));
                Address address = new Address();
                address.setId((resultSet.getInt("address_id")));
                tenant.setAddress(address);
                Payment payment = new Payment();
                payment.setId((resultSet.getInt("payment_id")));
                tenant.setPayment(payment);
                return tenant;
            }
        }, new Object[] {id});

    }
    public List<Tenant> getAll()
    {
        String sql = "SELECT * FROM tenant";

        List<Tenant> tenants = new ArrayList<Tenant>();

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        for (Map result : results) {
            Tenant tenant = new Tenant();
            tenant.setId((Integer)(result.get("tenant_id")));
            tenants.add(tenant);
        }
        return tenants;
    }
}
