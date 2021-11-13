package swu606309.swuFind.service.impl;

import swu606309.swuFind.dao.UserDao;
import swu606309.swuFind.dao.impl.UserDaoImpl;
import swu606309.swuFind.domain.User;
import swu606309.swuFind.service.UserService;
import swu606309.swuFind.util.MailUtils;
import swu606309.swuFind.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    //注册用户
    @Override
    public boolean regist(User user) {
        //1根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断用户是否存在
        if (u != null){
            return false;
        }
        //2保存用户信息
        //2.1设置激活码
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        userDao.save(user);

        //3发送邮件
        String content = "<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活【swuFind】</a>";
        MailUtils.sendMail(user.getEmail(),content,"swuFind激活邮件");

        return true;
    }

    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if (user != null){
            userDao.updateStatus(user);
            return true;
        }else {
        return false;
        }
    }

    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
