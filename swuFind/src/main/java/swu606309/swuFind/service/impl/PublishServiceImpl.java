package swu606309.swuFind.service.impl;

import swu606309.swuFind.dao.PublishDao;
import swu606309.swuFind.dao.impl.PublishDaoImpl;
import swu606309.swuFind.domain.Publish_info;
import swu606309.swuFind.service.PublishService;

public class PublishServiceImpl implements PublishService {
    private PublishDao dao=new PublishDaoImpl();
    @Override
    public void publish(Publish_info info){
        dao.publish(info);
    }
}
