package pageQuery.dao.impl;

import pageQuery.dao.UserDao;
import pageQuery.domain.User;
import pageQuery.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
//create a database connection
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public int findTotalCount() {
        String sql="select count(*) from user";
        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql="select * from user limit ? , ?";

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);
    }
}
