package top.rainbowcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Collect;
import top.rainbowcat.entity.Favorites;
import top.rainbowcat.service.ArticleService;
import top.rainbowcat.service.CollectService;
import top.rainbowcat.service.FavoritesService;

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
     * 获取用户收藏夹列表
     */
    @RequestMapping("/all")
    public Result favorites(int userId){
        List<Favorites> favoritesList = favoritesService.getFavByUserId(userId);
        favoritesList.forEach(favorites -> {
            List<Collect> collects = collectService.getCollectionsByFavIdAndUserId(favorites.getId(), userId);
        });
        return Result.succ(favoritesList);
    }

    /**
     * 新建收藏夹
     */
    @RequestMapping("/create")
    public Result createFavorites(@RequestBody Favorites favorites){
        try {
            favoritesService.createFavorites(favorites);
            return Result.succ(null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 删除收藏夹
     */
    @RequestMapping("/delete")
    public Result delFavorites(int id){
        try {
            favoritesService.delFavorites(id);
            return Result.succ(null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 更改可见性为私密
     */
    @RequestMapping("/visibility")
    public Result visibility(int id){
        try {
            favoritesService.visibility(id);
            return Result.succ(null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
