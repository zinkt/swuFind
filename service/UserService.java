package pageQuery.service;

import pageQuery.domain.PageBean;
import pageQuery.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {


    /*
    分页查询
     */
    PageBean<User> findUserByPage(String currentPage, String rows);

}
