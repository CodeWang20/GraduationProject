package top.rainbowcat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.UserProfile;
import top.rainbowcat.service.UserProfileService;


@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping("/updateProfile")
    public Result updateProfile(@RequestBody UserProfile userProfile){
        int updateCount = userProfileService.updateProfile(userProfile);
        if (updateCount == 1){
            return Result.succ("更新成功！", null);
        }
        return Result.fail("");
    }

    /**
     * 获取登录用户的信息
     */
    @RequestMapping("/userProfile")
    public Result userProfile(int id){
        try {
            UserProfile userProfile = userProfileService.getUserProfileById(id);
            System.out.println(userProfile);
            return Result.succ("", userProfile);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 获取文章作者的信息
     */
//    @RequestMapping("/authorProfile")
//    public Result authorProfile(int userId){
//        try {
//            UserProfile userProfile = userProfileService.getAuthorProfileById(userId);
//            return Result.succ("", userProfile);
//        }catch (Exception e){
//            throw e;
//        }
//    }
}
