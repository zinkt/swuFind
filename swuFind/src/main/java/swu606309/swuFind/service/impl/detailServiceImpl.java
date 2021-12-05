package swu606309.swuFind.service.impl;

import swu606309.swuFind.dao.detailDao;
import swu606309.swuFind.dao.impl.detailDaoImpl;
import swu606309.swuFind.domain.list_info;
import swu606309.swuFind.service.detailService;

public class detailServiceImpl implements detailService{
    private detailDao detailDao=new detailDaoImpl();
    @Override
    public list_info findDetail(String _did) {
        int did=Integer.parseInt(_did);
        return detailDao.findDetail(did);
    }
}
