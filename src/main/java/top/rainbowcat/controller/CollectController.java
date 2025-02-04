package top.rainbowcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Article;
import top.rainbowcat.entity.Collect;
import top.rainbowcat.service.ArticleService;
import top.rainbowcat.service.CollectService;

import java.util.List;


@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    CollectService collectService;

    @Autowired
    ArticleService articleService;


    /**
     * 获取用户收藏信息
     */
    @GetMapping("/collection")
    public Result collection(int userId, int favId){
        try {
            List<Collect> collects = collectService.collection(userId, favId);
            collects.forEach(collect -> {
                Article detailById = articleService.getDetailById(collect.getArticleId());
                collect.setArticle(detailById);
            });
            return Result.succ("", collects);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 收藏文章
     */
    @GetMapping("/addCollect")
    public Result addCollect(Collect collect){
        Collect collected = collectService.isCollected(collect);
        if (collected == null){
            try {
                collectService.addCollect(collect);
                return Result.succ( "收藏成功！", null);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return Result.fail(null);
    }

    /**
     * 取消收藏
     */
    @GetMapping("/cancelCollect")
    public Result cancelCollect(Collect collect){
        try {
            collectService.cancelCollect(collect);
            return Result.succ("取消收藏成功！", null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail("收藏失败！");
    }

    /**
     * 获取当前用户是否收藏当前文章
     */
    @GetMapping("/isCollected")
    public Result isCollected(Collect collect){
        Collect collected = collectService.isCollected(collect);
        if (collected != null){
            return Result.succ("", collected);
        }
        return Result.succ(404, "", null);
    }
}
