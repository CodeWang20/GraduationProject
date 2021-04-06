package top.rainbowcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.rainbowcat.entity.User;


/**
 * @author wangxiao
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param user 用户信息
     */
    void register(User user);

    /**
     * 根据用户名查询用户是否存在
     * @param username 用户名（登录帐号）
     * @return 用户信息（登陆用）
     */
    User findByUserName(String username);

    /**
     * 用户登陆，更新上次登陆时间
     * @param user 当前登陆的用户信息
     */
    void updateLastLogin(User user);
}
