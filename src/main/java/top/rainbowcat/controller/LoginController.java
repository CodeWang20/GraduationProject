package top.rainbowcat.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.dto.LoginDto;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.common.lang.UserAccount;
import top.rainbowcat.entity.User;
import top.rainbowcat.service.UserService;
import top.rainbowcat.utils.JwtUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto, HttpServletResponse response){
        log.info("用户请求------->>{}", loginDto);
        User user = userService.findByUserName(loginDto.getUsername());
        Assert.notNull(user, "用户不存在！");
        Md5Hash md5Hash = new Md5Hash(loginDto.getPassword(), user.getSalt(), 1024);

        if (!user.getPassword().equals(md5Hash.toHex())){
            return Result.fail("密码错误！");
        }
        user.setLast_login(new Date());
        userService.setLastLogin(user);

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        String jwt = jwtUtils.getToken(map);
        //将jwt设置进header,方便后面对jwt进行延期
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        UserAccount userAccount = new UserAccount();
        BeanUtils.copyProperties(user, userAccount);
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("user", userAccount);
        map1.put("token", jwt);
        return Result.succ("登录成功！", map1);
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        User u = userService.findByUserName(user.getUsername());
        if (u != null){
            return Result.fail("用户已存在！" );
        }
        try {
            userService.register(user);
            return Result.succ("注册成功！", null);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(401, "注册失败！");
        }
    }

    @GetMapping("/logout")
    @RequiresAuthentication
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.succ("注销成功！", null);
    }
}
