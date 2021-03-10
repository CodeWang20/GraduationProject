package top.rainbowcat.service.impl;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.common.lang.Author;
import top.rainbowcat.entity.User;
import top.rainbowcat.mapper.UserMapper;
import top.rainbowcat.service.UserService;
import top.rainbowcat.utils.SaltUtil;

import java.util.Date;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void register(User user) {
        //明文密码进行md5 + slat + hash散列
        String salt = SaltUtil.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        user.setCreated(new Date());
        System.out.println("最终要存入数据库的user----------------->>" + user);
        userMapper.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public void setLastLogin(User user) {
        userMapper.setLastLogin(user);
    }

    @Override
    public User getAuthorInfoById(int id) {
        return userMapper.getAuthorInfoById(id);
    }

    @Override
    public User getUserInfoById(int id) {
        return userMapper.getUserInfoById(id);
    }


}
