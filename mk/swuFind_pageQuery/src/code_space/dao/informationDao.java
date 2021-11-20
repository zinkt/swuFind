package code_space.dao;

import code_space.domain.list_info;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface informationDao {


//查询总记录数
    int findTotalCount(int cid);
//查询list（页面展示所需要的数据）
    List<list_info> findByPage(int cid, int start, int rows);

}
