package code_space.service.impl;

import code_space.dao.PublishDao;
import code_space.dao.impl.PublishDaoImpl;
import code_space.domain.Publish_info;
import code_space.service.PublishService;

public class PublishServiceImpl implements PublishService {
    private PublishDao dao=new PublishDaoImpl();
    @Override
    public void publish(Publish_info info){
        dao.publish(info);
    }
}
