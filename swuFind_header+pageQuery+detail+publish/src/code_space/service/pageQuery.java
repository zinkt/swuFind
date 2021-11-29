package code_space.service;

import code_space.domain.PageBean;
import code_space.domain.list_info;

/**
 * 用户管理的业务接口
 */
public interface pageQuery {


    /*
    分页查询
     */
    PageBean<list_info> findUserByPage(String cid, String currentPage, String rows);

}
