package top.rainbowcat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Article;
import top.rainbowcat.service.ArticleService;
import top.rainbowcat.service.CollectService;

import java.util.HashMap;
import java.util.List;

/**
 * @author wangxiao
 */
@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    CollectService collectService;

    /**
     * 根据id删除文章
     * @param id 文章id
     */
    @GetMapping("/deleteBlog")
    public Result deleteBlog(String id){
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
     * @param userId 当前用户id
     * @param currentPage 当前页
     * @param pageSize 每页条数
     * @return 分页的数据
     */
    @GetMapping("/selfBlogs")
    public Result selfBlogs(String userId, int currentPage, int pageSize){
        IPage<Article> iPage = new Page<>(currentPage, pageSize);
        IPage<Article> page = articleService.selfBlogsByUserId(iPage, userId);

        HashMap<String, Object> map = new HashMap<>();
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);
        map.put("totalCount", page.getTotal());
        map.put("totalPage", page.getPages());
        map.put("blogs", page.getRecords());
        return Result.succ(map);
    }

    /**
     * 创作、更新文章（通过id判断文章已存在则更新）
     * @param article 文章内容
     */
    @PostMapping("/creation")
    public Result creation(@RequestBody Article article){
        try {
            articleService.addArticle(article);
            return Result.succ("发布成功！", null);
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 获取首页最新热门文章
     * @return 当天最新热门文章浏览量前十的文章
     */
    @GetMapping("/popular")
    public Result popularArticles(){
        List<Article> popularList = articleService.popularArticles();
        popularList.forEach(article -> {
            article.setCollect(collectService.getCollections(article.getId()));
        });
        return Result.succ(popularList);
    }

    /**
     * 根据id查询当前文章的详细内容
     * @param id 文章id
     * @return 当前文章的相关数据
     */
    @GetMapping("/detail")
    public Result detail(String id){
        Article detail = articleService.getDetailById(id);
        if (detail != null){
            detail.setCollect(collectService.getCollections(id));
            return Result.succ(detail);
        }
        return Result.fail(404, "该文章已被删除！",null);
    }

    @GetMapping("/updateViews")
    public Result updateViews(String id){
        articleService.addViews(id);
        return Result.succ(null);
    }
}
