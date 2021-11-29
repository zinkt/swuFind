package code_space.service.impl;

import code_space.dao.impl.pageQueryDaoImpl;
import code_space.dao.pageQueryDao;
import code_space.domain.PageBean;
import code_space.domain.list_info;
import code_space.service.pageQuery;

import java.util.List;

public class pageQueryImpl implements pageQuery {
    private pageQueryDao dao = new pageQueryDaoImpl();
    @Override
    public PageBean<list_info> findUserByPage(String _cid,String _currentPage, String _rows) {
        //1.创建一个空的pb对象
        PageBean<list_info> pb=new PageBean<list_info>();
        //2.设置参数
        //request从前段获取消息数据，截取的是字符串,所以先转换类型
        int cid=Integer.parseInt(_cid);
        int currentPage=Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //3.调用dao查询总记录数
        int totalCount= dao.findTotalCount(cid);
        pb.setTotalCount(totalCount);
        //4.调用dao查询list(需要展示的内容集合)
        int start=(currentPage - 1) * rows;
        List<list_info> list=dao.findByPage(cid,start,rows);
        pb.setList(list);

        //5.计算总页码
        int totalPage=(totalCount % rows ) == 0 ? totalCount/rows : (totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;




    }
}
