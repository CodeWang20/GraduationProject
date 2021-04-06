package top.rainbowcat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.rainbowcat.entity.UserProfile;

/**
 * @author wangxiao
 */
public interface UserProfileMapper extends BaseMapper<UserProfile> {

    int updateProfile(UserProfile userProfile);
}

