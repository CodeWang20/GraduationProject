package top.rainbowcat.mapper;

import top.rainbowcat.entity.Collect;

public interface CollectMapper {
    void add(Collect collect);

    void delete(Collect collect);

    Collect getByUserIdAndArticleId(Collect collect);

    int getCollections(int articleId);
}
