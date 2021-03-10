package top.rainbowcat.service;

import top.rainbowcat.entity.Favorites;

import java.util.List;

public interface FavoritesService {
    /**
     * 新建收藏夹
     */
    void createFavorites(Favorites favorites);

    /**
     * 根据id删除收藏夹
     * @param id
     */
    void delFavorites(int id);

    void visibility(int id);

    List<Favorites> getFavByUserId(int userId);
}
