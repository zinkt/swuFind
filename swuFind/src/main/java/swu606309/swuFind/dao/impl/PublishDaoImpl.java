package swu606309.swuFind.dao.impl;

import swu606309.swuFind.dao.PublishDao;
import swu606309.swuFind.domain.Publish_info;
import swu606309.swuFind.util.JDBCUtils;
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
