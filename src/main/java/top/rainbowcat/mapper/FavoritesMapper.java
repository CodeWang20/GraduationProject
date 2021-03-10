package top.rainbowcat.mapper;

import top.rainbowcat.entity.Favorites;

import java.util.List;

public interface FavoritesMapper {
    void add(Favorites favorites);

    void delFavorites(int id);

    void updateVisibility(int id);

    List<Favorites> getFavByUserId(int userId);
}
