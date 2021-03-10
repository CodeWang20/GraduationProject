package top.rainbowcat.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Author;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.common.lang.UserAccount;
import top.rainbowcat.entity.User;
import top.rainbowcat.entity.UserProfile;
import top.rainbowcat.service.UserProfileService;
import top.rainbowcat.service.UserService;


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

    @RequestMapping("/userProfile")
    public Result userProfile(int id){
        try {
            UserProfile userProfile = userProfileService.getUserProfileById(id);
            return Result.succ("", userProfile);
        }catch (Exception e){
            throw e;
        }
    }
}
