package swu606309.swuFind.service;

import swu606309.swuFind.domain.User;

public interface UserService {

    //注册用户
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
