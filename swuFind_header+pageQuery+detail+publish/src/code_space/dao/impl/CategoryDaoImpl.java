package code_space.dao.impl;

import code_space.dao.CategoryDao;
import code_space.domain.Category;
import code_space.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
public class CategoryDaoImpl implements CategoryDao {
    // 创建连接
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category order by cid" ;
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
