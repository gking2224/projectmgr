package demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataAccessObject {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void execute(String sql) {
        jdbcTemplate.execute(sql);
    }
    
}
