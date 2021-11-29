package code_space.service.impl;

import code_space.dao.detailDao;
import code_space.dao.impl.detailDaoImpl;
import code_space.domain.list_info;
import code_space.service.detailService;

public class detailServiceImpl implements detailService{
    private detailDao detailDao=new detailDaoImpl();
    @Override
    public list_info findDetail(String _did) {
        int did=Integer.parseInt(_did);
        return detailDao.findDetail(did);
    }
}
