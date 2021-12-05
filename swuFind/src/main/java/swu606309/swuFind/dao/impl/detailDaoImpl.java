package swu606309.swuFind.dao.impl;

import swu606309.swuFind.dao.detailDao;
import swu606309.swuFind.domain.list_info;
import swu606309.swuFind.util.JDBCUtils;
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
