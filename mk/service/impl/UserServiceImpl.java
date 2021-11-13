package pageQuery.service.impl;

import pageQuery.dao.UserDao;
import pageQuery.dao.impl.UserDaoImpl;
import pageQuery.domain.PageBean;
import pageQuery.domain.User;
import pageQuery.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();




    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        //1.创建一个空的pb对象
        PageBean<User> pb=new PageBean<User>();
        //2.设置参数
        //request从前段获取消息数据，截取的是字符串,所以先转换类型
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用dao查询总记录数
        int totalCount= dao.findTotalCount();
        pb.setTotalCount(totalCount);
        //4.调用dao查询list(需要展示的内容集合)
        int start=(currentPage - 1) * rows;
        List<User> list=dao.findByPage(start,rows);
        pb.setList(list);

        //5.计算总页码
        int totalPage=(totalCount % rows ) == 0 ? totalCount/rows : (totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;




    }
}
