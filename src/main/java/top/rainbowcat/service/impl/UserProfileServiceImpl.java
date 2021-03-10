package top.rainbowcat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.UserProfile;
import top.rainbowcat.mapper.UserProfileMapper;
import top.rainbowcat.service.UserProfileService;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileMapper userProfileMapper;

    @Override
    public int updateProfile(UserProfile userProfile) {
        return userProfileMapper.updateProfile(userProfile);
    }

    @Override
    public UserProfile getUserProfileById(int id) {
        return userProfileMapper.getUserProfileById(id);
    }
}
