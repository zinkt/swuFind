package swu606309.swuFind.dao.impl;

import swu606309.swuFind.dao.UserDao;
import swu606309.swuFind.domain.User;
import swu606309.swuFind.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            //1定义sql
            String sql = "select * from tab_user where username = ?";
            //2执行
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        } catch (Exception e) {
        }

        return user;
    }

    @Override
    public void save(User user) {
        String sql = "insert into tab_user(username,password,stu_id, sex,email,status,code) values(?,?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),
                user.getPassword(),
                user.getStu_id(),
                user.getSex(),
                user.getEmail(),
                user.getStatus(),
                user.getCode());
    }
/*
根据激活码查询对象用户
 */
    @Override
    public User findByCode(String code) {
        User user = null;

        try {
            String sql = "select * from tab_user where code= ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
/*
修改指定用户状态
 */
    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid=?";
        template.update(sql,user.getUid());
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            //1定义sql
            String sql = "select * from tab_user where username = ? and password = ?";
            //2执行
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        } catch (Exception e) {
        }
        return user;
    }
}
