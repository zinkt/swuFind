package code_space.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import code_space.dao.informationDao;
import code_space.domain.list_info;
import code_space.util.JDBCUtils;

import java.util.List;

public class informationDaoImpl implements informationDao {
//create a database connection
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    //查找该板块下共有多少帖子
    @Override
    public int findTotalCount(int cid) {
        String sql="select count(*) from tab_detail where cid =?";
        System.out.println("cid is:"+cid);
        return template.queryForObject(sql,Integer.class,cid);
    }
    //查找每页需要展示的数据
    @Override
    public List<list_info> findByPage(int cid, int start, int rows) {
        String sql="select * from tab_detail where cid=? limit ? , ?";

        return template.query(sql,new BeanPropertyRowMapper<list_info>(list_info.class),cid,start,rows);
    }
}
