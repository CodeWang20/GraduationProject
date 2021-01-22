package top.rainbowcat.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Author;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.common.lang.UserAccount;
import top.rainbowcat.entity.User;
import top.rainbowcat.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //@RequiresAuthentication
    @RequestMapping("/one")
    public Result one(){
        User user = userService.findByUserName("rainbowcat");
        UserAccount userAccount = new UserAccount();
        BeanUtils.copyProperties(user, userAccount);
        return Result.succ(userAccount);
    }

    //TODO
    @GetMapping("/authorInfo")
    public Result authorInfoByUserId(int id){
        Author author = new Author();
        User user = userService.getUserById(id);
        author.setId(user.getId());

        return null;
    }
}
