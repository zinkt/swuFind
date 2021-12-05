package swu606309.swuFind.service;

import swu606309.swuFind.domain.PageBean;
import swu606309.swuFind.domain.list_info;

/**
 * 用户管理的业务接口
 */
public interface pageQuery {


    /*
    分页查询
     */
    PageBean<list_info> findUserByPage(String cid, String currentPage, String rows);

}
