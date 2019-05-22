package com.example.dao;

import com.example.oldApp.Price;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

public class PriceDao
{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Price get(Long id)
    {
        return jdbcTemplate.queryForObject("select * from price where price_id = ? ", new RowMapper<Price>()
        {
            public Price mapRow(ResultSet resultSet, int i) throws SQLException
            {
                Price price = new Price();
                price.setId(resultSet.getInt("price_id"));
                price.setTotalPrice(resultSet.getDouble("amount"));
                return price;
            }
        }, new Object[] {id});
    }

    public List<Price> getAll()
    {
        String sql = "SELECT * FROM price";
        List<Price> prices = new ArrayList<Price>();

        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        for (Map result : results) {
            Price price = new Price();
            price.setId((Integer) result.get("price_id"));
            prices.add(price);
        }
        return prices;
    }
}
