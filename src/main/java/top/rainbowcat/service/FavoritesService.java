package top.rainbowcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.rainbowcat.entity.Favorites;

import java.util.List;

/**
 * @author wangxiao
 */
public interface FavoritesService extends IService<Favorites> {
    /**
     * 新建收藏夹
     * @param favorites 新建的收藏夹信息
     */
    void createFavorites(Favorites favorites);

    /**
     * 根据id删除收藏夹（实际上需要：将其中的文章移入默认收藏夹）
     * @param id 将要被删除的收藏夹id
     */
    void delFavorites(String id);

    /**
     * 根据type查询是否已经存在
     * @param type 收藏夹名称
     */
    Favorites isExist(String type);


    /**
     * 获取当前用户的收藏夹列表
     * @param userId 用户id
     */
    List<Favorites> selectFavoritesByUserId(String userId);
}
