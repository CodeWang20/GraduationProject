package top.rainbowcat.service;

import top.rainbowcat.entity.UserProfile;

/**
 * @author wangxiao
 */
public interface UserProfileService {
    int updateProfile(UserProfile userProfile);

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return 用户信息
     */
    UserProfile getUserProfileById(String id);
}
