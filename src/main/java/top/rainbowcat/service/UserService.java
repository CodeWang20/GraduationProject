package top.rainbowcat.service;

import top.rainbowcat.common.lang.Author;
import top.rainbowcat.entity.User;


public interface UserService {

    User login(User user);

    void register(User user);

    User findByUserName(String username);

    void setLastLogin(User user);

    User getUserInfoById(int id);

    User getAuthorInfoById(int id);
}
