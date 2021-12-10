package swu606309.swuFind.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import swu606309.swuFind.dao.pageQueryDao;
import swu606309.swuFind.domain.list_info;
import swu606309.swuFind.util.JDBCUtils;

import java.util.List;

public class pageQueryDaoImpl implements pageQueryDao {
//create a database connection
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    //查找该板块下共有多少帖子
    @Override
    public int findTotalCount(int cid) {
        String sql="select count(*) from tab_detail where cid =?";
//        System.out.println("cid is:"+cid);
        return template.queryForObject(sql,Integer.class,cid);
    }
    //查找每页需要展示的数据
    @Override
    public List<list_info> findByPage(int cid, int start, int rows) {
        String sql="select * from tab_detail where cid=? limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<list_info>(list_info.class),cid,start,rows);
    }
}
