package top.rainbowcat.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Author;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.UserProfile;
import top.rainbowcat.service.ArticleService;
import top.rainbowcat.service.AttentionService;
import top.rainbowcat.service.CollectService;
import top.rainbowcat.service.UserProfileService;


/**
 * 关注功能Controller
 * @author wangxiao
 */
@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private AttentionService attentionService;

    /**
     *  动态更新用户信息
     */
    @RequestMapping("/update")
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
    @GetMapping("/user")
    public Result userProfile(String id){
        try {
            UserProfile userProfile = userProfileService.getUserProfileById(id);
            return Result.succ("", userProfile);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 获取文章作者的信息
     * @param id 作者id
     */
    @GetMapping("/author")
    public Result authorProfile(String id){
        Author author = new Author();
        try {
            UserProfile userProfile = userProfileService.getUserProfileById(id);
            BeanUtils.copyProperties(userProfile, author);
            //文章数量
            author.setArticles(articleService.getArticleNumByUserId(id));
            //收藏文章数量
            author.setCollect(collectService.getCollectNumByUserId(id));
            //粉丝
            author.setAttention(attentionService.getFansNumByUserId(id));
            //关注
            author.setAttention(attentionService.getAttentionNumByUserId(id));
            return Result.succ("", author);
        }catch (Exception e){
            throw e;
        }
    }
}
