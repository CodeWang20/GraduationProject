package top.rainbowcat.mapper;

import top.rainbowcat.entity.Collect;

import java.util.List;

public interface CollectMapper {
    void add(Collect collect);

    void delete(Collect collect);

    Collect getByUserIdAndArticleId(Collect collect);

    int getCollections(int articleId);

    List<Collect> collection(int userId, int favId);

    List<Collect> getCollectionsByFavIdAndUserId(int favId, int userId);

    List<Collect> getFavIdByUserId(int userId);

    void changeFavId(int favId);
}
