package top.rainbowcat.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

/**
 * @author wangxiao
 */
@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Value("${rainbowcat.favorite.id}")
    private String DEFAULT_FAVORITE_ID;

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
    public Result getArticleByFav(String favId, String userId){
        try {
            List<Collect> collects = collectService.getCollectionsByFavIdAndUserId(favId, userId);
            ArrayList<Object> articleIds = new ArrayList<>();
            collects.forEach(item -> {
                articleIds.add(item.getArticleId());
            });
            System.out.println("发偶佛啊活佛啊合法化" + articleIds);
            if (articleIds.size() > 0) {
                List<Article> articleList = articleService.selectArticleByIds(articleIds);
                return Result.succ(articleList);
            }
            return Result.succ(null);
        }catch (HttpMessageNotReadableException e){
            throw e;
        }
    }

    /**
     * 根据userId获取用户收藏夹列表
     * @param userId 用户id
     * @return 该用户的收藏夹列表
     */
    @GetMapping("/favorite")
    public Result favorites(String userId){
        List<Favorites> favoritesList = favoritesService.selectFavoritesByUserId(userId);
        return Result.succ(favoritesList);
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
     * @param id 将要被删除的收藏夹id
     */
    @RequestMapping("/delete")
    public Result delFavorites(String id, String userId){
        try {
            LambdaUpdateWrapper<Collect> wrapper = new LambdaUpdateWrapper<>();
            wrapper.set(Collect::getFavId, DEFAULT_FAVORITE_ID)
                    .eq(Collect::getUserId, userId)
                    .eq(Collect::getFavId, id);
            collectService.update(wrapper);
            favoritesService.delFavorites(id);
            return Result.succ(null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 更改收藏夹名称
     * @param favorites 当前要修改的收藏夹信息
     */
    @PostMapping("/updateType")
    public Result updateType(@RequestBody Favorites favorites){
        try {
            LambdaUpdateWrapper<Favorites> wrapper = new LambdaUpdateWrapper<>();
            wrapper.set(Favorites::getType, favorites.getType())
                    .eq(Favorites::getId, favorites.getId());
            favoritesService.update(wrapper);
            return Result.succ("更新完成！");
        }catch (Exception e) {
            e.printStackTrace();
            return Result.succ("更新失败！");
        }
    }

    /**
     * 更改可见性
     *      采用取模的方式，保证该字段只有0和1两种状态
     * @param favorites 当前要修改的收藏夹信息
     */
    @PostMapping("/visibility")
    public Result visibility(@RequestBody Favorites favorites){
        try {
            LambdaUpdateWrapper<Favorites> wrapper = new LambdaUpdateWrapper<>();
            wrapper.set(Favorites::getVisibility,(favorites.getVisibility() + 1) % 2)
                    .eq(Favorites::getId, favorites.getId());
            favoritesService.update(wrapper);
            return Result.succ(null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
