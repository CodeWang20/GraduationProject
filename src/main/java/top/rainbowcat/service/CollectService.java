package top.rainbowcat.service;

import top.rainbowcat.entity.Collect;

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


    int getCollections(int articleId);
}
