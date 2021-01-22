package top.rainbowcat.mapper;

import top.rainbowcat.common.lang.Author;
import top.rainbowcat.entity.User;

public interface UserMapper {

    User login(User user);

    void save(User user);

    User findByUserName(String username);

    void setLastLogin(User user);

    User getUserById(int id);
}
