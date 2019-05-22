package com.example.dao;

import com.example.oldApp.Deposit;
import com.example.oldApp.Landlord;
import com.example.oldApp.Tenant;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class DepositDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Deposit get(Long id)
    {
        return jdbcTemplate.queryForObject("select * from deposit where deposit_id = ? ", new RowMapper<Deposit>()
        {
            public Deposit mapRow(ResultSet resultSet, int i) throws SQLException
            {
                Deposit deposit = new Deposit();
                deposit.setId(resultSet.getInt("deposit_id"));
                Landlord landlord = new Landlord();
                landlord.setId(resultSet.getInt("landlord_id"));
                deposit.setLandlord(landlord);
                Tenant tenant = new Tenant();
                tenant.setId(resultSet.getInt("tenant_id"));
                deposit.setTenant(tenant
                );
                return deposit;
            }
        }, new Object[] {id});
    }

    public List<Deposit> getAll()
    {
        List<Deposit> deposits = new ArrayList<Deposit>();

        String sql = "SELECT * FROM deposit";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

        for (Map result : results) {
            Deposit deposit = new Deposit();
            deposit.setId((Integer) result.get("deposit_id"));
            deposits.add(deposit);
        }
        return deposits;
    }
}
