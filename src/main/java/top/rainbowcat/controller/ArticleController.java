package top.rainbowcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Article;
import top.rainbowcat.service.ArticleService;
import top.rainbowcat.service.CollectService;
import top.rainbowcat.utils.SystemDateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    CollectService collectService;

    /**
     * 删除
     */
    @GetMapping("/deleteBlog")
    public Result deleteBlog(int id){
        try {
            articleService.deleteBlog(id);
            return Result.succ("删除成功！", null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 根据当前用户id查询已发布过的列表
     */
    @GetMapping("/selfBlogs")
    public Result selfBlogs(int userId, int currentPage, int pageSize){
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("currentPage", currentPage);
            map.put("pageSize", pageSize);
            int totalCount = articleService.selfBlogsCount(userId);
            int totalPage = totalCount % pageSize == 0 ? (totalCount / pageSize) : (totalCount / pageSize) + 1;
            map.put("totalCount", totalCount);
            map.put("totalPage", totalPage);
            List<Article> blogs = articleService.selfBlogsList(userId, currentPage, pageSize);
            map.put("blogs", blogs);
            return Result.succ(map);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 创作
     */
    @PostMapping("/creation")
    public Result creation(@RequestBody Article article){
        if (article.getId() == 0){
            try {
                Date now = SystemDateUtils.getDaDate();
                article.setCreated(now);
                article.setLastUpdate(now);
                articleService.addArticle(article);
                return Result.succ("发布成功！", null);
            }catch (Exception e){
                throw e;
            }
        }else {
            try {
                article.setLastUpdate(SystemDateUtils.getDaDate());
                articleService.updateArticle(article);
                return Result.succ("编辑成功！", null);
            }catch (Exception e){
                throw e;
            }
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
