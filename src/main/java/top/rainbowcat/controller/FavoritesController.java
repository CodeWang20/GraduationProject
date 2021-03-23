package top.rainbowcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Article;
import top.rainbowcat.entity.Collect;
import top.rainbowcat.entity.Favorites;
import top.rainbowcat.service.ArticleService;
import top.rainbowcat.service.CollectService;
import top.rainbowcat.service.FavoritesService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    FavoritesService favoritesService;
    @Autowired
    CollectService collectService;
    @Autowired
    ArticleService articleService;

    /**
     * 根据收藏夹获取其中的文章
     * @param favId 收藏夹ID
     * @param userId 用户ID
     */
    @GetMapping("/articles")
    public Result getArticleByFav(int favId, int userId){
        try {
            List<Collect> collects = collectService.getCollectionsByFavIdAndUserId(favId, userId);
            ArrayList<Article> articles = new ArrayList<>();
            collects.forEach(collect -> {
                articles.add(articleService.getDetailById(collect.getArticleId()));
            });
            return Result.succ(articles);
        }catch (HttpMessageNotReadableException e){
            throw e;
        }
    }

    /**
     * 获取用户收藏夹列表
     */
    @GetMapping("/favorite")
    public Result favorites(int userId){
        List<Collect> collects = collectService.getFavIdByUserId(userId);
        ArrayList<Favorites> list = new ArrayList<>();
        collects.forEach(collect -> list.add(favoritesService.getFavByFavId(collect.getFavId())));
        return Result.succ(list);
    }

    /**
     * 新建收藏夹
     */
    @PostMapping("/create")
    public Result createFavorites(@RequestBody Favorites favorites){
        Favorites f = favoritesService.isExist(favorites.getType());
        if (!ObjectUtils.isEmpty(f)){
            return Result.fail("该收藏夹已存在");
        }
        try {
            favoritesService.createFavorites(favorites);
            return Result.succ(favorites.getType() + "创建成功！");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 根据id删除收藏夹（实际上需要：将其中的文章移入默认收藏夹）
     */
    @RequestMapping("/delete")
    public Result delFavorites(int id){
        try {
            collectService.changeFavId(id);
            favoritesService.delFavorites(id);
            return Result.succ(null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 更改收藏夹名称
     */
    @PostMapping("/updateType")
    public Result updateType(@RequestBody Favorites favorites){
        try {
            favoritesService.updateType(favorites);
            return Result.succ("更新完成！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.succ("更新失败！");
        }
    }
    /**
     * 更改可见性为私密
     */
    @PostMapping("/visibility")
    public Result visibility(@RequestBody Favorites favorites){
        try {
            favorites.setVisibility((favorites.getVisibility() + 1) % 2);
            favoritesService.visibility(favorites);
            return Result.succ(null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
