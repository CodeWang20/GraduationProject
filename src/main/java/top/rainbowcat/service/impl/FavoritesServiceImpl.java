package top.rainbowcat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.Favorites;
import top.rainbowcat.mapper.FavoritesMapper;
import top.rainbowcat.service.FavoritesService;

import java.util.List;

/**
 * @author wangxiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements FavoritesService {

    @Autowired
    FavoritesMapper favoritesMapper;

    @Override
    public void createFavorites(Favorites favorites) {
        favoritesMapper.insert(favorites);
    }

    @Override
    public void delFavorites(String id) {
        favoritesMapper.deleteById(id);
    }

    @Override
    public Favorites isExist(String type) {
        QueryWrapper<Favorites> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Favorites::getType, type);
        return favoritesMapper.selectOne(wrapper);
    }

    @Override
    public List<Favorites> selectFavoritesByUserId(String userId) {
        QueryWrapper<Favorites> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Favorites::getUserId, userId)
                .orderByAsc(Favorites::getId);
        return favoritesMapper.selectList(wrapper);
    }
}
