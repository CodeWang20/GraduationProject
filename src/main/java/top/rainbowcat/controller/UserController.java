package top.rainbowcat.controller;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.common.lang.UserProfile;
import top.rainbowcat.entity.User;
import top.rainbowcat.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresAuthentication
    @RequestMapping("/one")
    public Result one(){
        User user = userService.findByUserName("rainbowcat");
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(user, userProfile);
        System.out.println(userProfile);
        return Result.succ(userProfile);
    }
}
