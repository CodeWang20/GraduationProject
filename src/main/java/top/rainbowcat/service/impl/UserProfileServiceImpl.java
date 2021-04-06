package top.rainbowcat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.UserProfile;
import top.rainbowcat.mapper.UserProfileMapper;
import top.rainbowcat.service.UserProfileService;

/**
 * @author wangxiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserProfileServiceImpl extends ServiceImpl<UserProfileMapper, UserProfile> implements UserProfileService {

    @Autowired
    UserProfileMapper userProfileMapper;

    @Override
    public int updateProfile(UserProfile userProfile) {
        return userProfileMapper.updateProfile(userProfile);
    }

    @Override
    public UserProfile getUserProfileById(String id) {
        return userProfileMapper.selectById(id);
    }
}
