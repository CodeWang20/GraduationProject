package top.rainbowcat.service;

import top.rainbowcat.entity.UserProfile;

public interface UserProfileService {
    int updateProfile(UserProfile userProfile);

    UserProfile getUserProfileById(int id);
}
