package top.rainbowcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Article;
import top.rainbowcat.service.ArticleService;
import top.rainbowcat.service.CollectService;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    CollectService collectService;

    @PostMapping("/creation")
    public Result creation(@RequestBody Article article){
        article.setCreated(new Date());
        try {
            articleService.addArticle(article);
            return Result.succ("发布成功！", null);
        }catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/popular")
    public Result popularArticles(){
        List<Article> popularList = articleService.popularArticles();
        popularList.forEach(article -> {
            article.setCollect(collectService.getCollections(article.getId()));
        });
        return Result.succ(popularList);
    }

    @GetMapping("/detail")
    public Result detail(int id){
        Article detail = articleService.getDetailById(id);
        if (detail != null){
            detail.setCollect(collectService.getCollections(id));
            return Result.succ(detail);
        }
        return Result.fail(404, "该文章已被删除！",null);
    }

    @GetMapping("/updateViews")
    public Result updateViews(int id){
        Article article = new Article();
        articleService.addViews(id);
        return Result.succ(null);
    }
}
