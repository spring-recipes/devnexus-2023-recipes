package dev.danvega.postgresdemo.dao;

import dev.danvega.postgresdemo.model.Coffee;
import dev.danvega.postgresdemo.model.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoffeeDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CoffeeDAO.class);
    private final JdbcTemplate jdbc;

    public CoffeeDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<Coffee> rowMapper = (rs, rowNum) -> {
        return new Coffee(
                rs.getInt("id"),
                rs.getString("name"),
                Size.valueOf(rs.getString("size"))
        );
    };

    public List<Coffee> list() {
        String sql = "SELECT id,name,size from coffee";
        return jdbc.query(sql,rowMapper);
    }

    public void create(Coffee coffee) {
        String sql = "insert into coffee(name,size) values(?,?)";
        int insert = jdbc.update(sql,coffee.name(),coffee.size().toString());
        if(insert == 1) {
            LOG.info("New Coffee Created: " + coffee.name());
        }
    }

}
