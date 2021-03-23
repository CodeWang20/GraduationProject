package top.rainbowcat.service;

import top.rainbowcat.entity.Favorites;

import java.util.List;

public interface FavoritesService {
    /**
     * 新建收藏夹
     */
    void createFavorites(Favorites favorites);

    /**
     * 根据id删除收藏夹（实际上需要：将其中的文章移入默认收藏夹）
     */
    void delFavorites(int id);

    /**
     * 更改可见性
     */
    void visibility(Favorites favorites);

    List<Favorites> getFavByUserId(int userId);

    Favorites isExist(String type);

    /**
     * 根据favId查询
     */
    Favorites getFavByFavId(int favId);

    /**
     * 动态更新
     */
    void updateType(Favorites favorites);
}
