package top.rainbowcat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.Favorites;
import top.rainbowcat.mapper.FavoritesMapper;
import top.rainbowcat.service.FavoritesService;

import java.util.List;

@Service
@Transactional
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    FavoritesMapper favoritesMapper;

    @Override
    public void createFavorites(Favorites favorites) {
        favoritesMapper.add(favorites);
    }

    @Override
    public void delFavorites(int id) {
        favoritesMapper.delFavorites(id);
    }

    @Override
    public void visibility(Favorites favorites) {
        favoritesMapper.updateVisibility(favorites);
    }

    @Override
    public List<Favorites> getFavByUserId(int userId) {
        return favoritesMapper.getFavByUserId(userId);
    }

    @Override
    public Favorites isExist(String type) {
        return favoritesMapper.getFavByType(type);
    }

    @Override
    public Favorites getFavByFavId(int favId) {
        return favoritesMapper.getFavByFavId(favId);
    }

    @Override
    public void updateType(Favorites favorites) {
        favoritesMapper.updateType(favorites);
    }
}
