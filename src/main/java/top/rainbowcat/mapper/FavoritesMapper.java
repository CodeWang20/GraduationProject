package top.rainbowcat.mapper;

import top.rainbowcat.entity.Favorites;

import java.util.List;

public interface FavoritesMapper {
    void add(Favorites favorites);

    void delFavorites(int id);

    void updateVisibility(Favorites favorites);

    /**
     * 根据userID，从collect表查询fav_id,作为条件在从fav表查数据
     */
    List<Favorites> getFavByUserId(int userId);

    /**
     *根据type查询，防止重复插入
     */
    Favorites getFavByType(String type);

    Favorites getFavByFavId(int favId);

    void updateType(Favorites favorites);
}
