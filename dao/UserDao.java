package pageQuery.dao;

import pageQuery.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {


//查询总记录数
    int findTotalCount();
//查询list（页面展示所需要的数据）
    List<User> findByPage(int start, int rows);

}
