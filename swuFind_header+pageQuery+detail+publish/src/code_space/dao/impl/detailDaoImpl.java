package code_space.dao.impl;

import code_space.dao.detailDao;
import code_space.domain.list_info;
import code_space.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class detailDaoImpl implements detailDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public list_info findDetail(int did) {
        String sql="select * from tab_detail where did=?";

        return template.queryForObject(sql,new BeanPropertyRowMapper<list_info>(list_info.class),did);
    }
}
