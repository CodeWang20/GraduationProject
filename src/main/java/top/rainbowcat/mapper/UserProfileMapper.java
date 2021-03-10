package top.rainbowcat.mapper;

import top.rainbowcat.entity.UserProfile;

public interface UserProfileMapper {

    int updateProfile(UserProfile userProfile);

    UserProfile getUserProfileById(int id);
}

