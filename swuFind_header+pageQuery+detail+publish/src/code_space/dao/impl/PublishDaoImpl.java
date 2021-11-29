package code_space.dao.impl;

import code_space.dao.PublishDao;
import code_space.domain.Publish_info;
import code_space.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;
public class PublishDaoImpl implements PublishDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void publish(Publish_info publish_info) {
        //1.定义sql,did为null
        String sql = "insert into tab_detail values(null,?,?,?,?,?)";
        //2.执行sql
        template.update(sql, publish_info.getTitle(), publish_info.getIntro(),publish_info.getContent(),publish_info.getCid(),publish_info.getRimage());
    }
}
