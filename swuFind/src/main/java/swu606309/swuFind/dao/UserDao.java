package swu606309.swuFind.dao;

import swu606309.swuFind.domain.User;

public interface UserDao {
    //根据用户名查询用户信息
    public User findByUsername(String username);
    //用户保存
    public void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
