package top.rainbowcat.service;

import top.rainbowcat.entity.Collect;

import java.util.List;

public interface CollectService {
    /**
     * 添加收藏文章
     * @return
     */
    void addCollect(Collect collect);
    /**
     * 取消收藏文章
     * @return
     */
    void cancelCollect(Collect collect);
    /**
     * 判断当前用户是否已经收藏当前文章
     */
    Collect isCollected(Collect collect);

    /**
     * 根据文章id获取收藏数量
     */
    int getCollections(int articleId);

    List<Collect> collection(int userId, int favId);

    List<Collect> getCollectionsByFavIdAndUserId(int id, int userId);

    /**
     * 查询fav_id
     * @param userId
     */
    List<Collect> getFavIdByUserId(int userId);

    /**
     * 将文章移入默认收藏夹
     */
    void changeFavId(int favId);
}
