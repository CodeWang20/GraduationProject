package top.rainbowcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.rainbowcat.entity.Collect;

import java.util.List;

/**
 * @author wangxiao
 */
public interface CollectService extends IService<Collect> {
    /**
     * 添加收藏文章
     * @param collect 收藏信息
     */
    void addCollect(Collect collect);

    /**
     * 取消收藏文章
     * @param collect 要取消收藏的数据
     */
    void cancelCollect(Collect collect);

    /**
     * 判断当前用户是否已经收藏当前文章
     * @param collect 收藏数据
     * @return null或一条记录
     */
    Collect isCollected(Collect collect);

    /**
     * 根据文章id获取收藏数量
     * @param articleId 文章id
     * @return 该文章被收藏的数量
     */
    int getCollections(String articleId);

    /**
     * 根据收藏夹id获取当前用户某一收藏收藏夹下有哪些记录
     * @param userId 用户id
     * @param favId 收藏夹id
     * @return 该收藏夹下的收藏记录
     */
    List<Collect> collection(String userId, String favId);

    /**
     * 根据favId和userId查询该用户的收藏的文章id
     * @param favId 收藏夹
     * @param userId 用户id
     * @return 该用户的收藏数据
     */
    List<Collect> getCollectionsByFavIdAndUserId(String favId, String userId);

    /**
     * 查询fav_id
     * @param userId
     */
    List<Collect> getFavIdByUserId(String userId);

    /**
     * 获取当前用户收藏文章总数
     * @param userId 用户id
     * @return 总数收藏数
     */
    int getCollectNumByUserId(String userId);
}
