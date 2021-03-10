package top.rainbowcat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.Collect;
import top.rainbowcat.mapper.CollectMapper;
import top.rainbowcat.service.CollectService;

import java.util.List;

@Service
@Transactional
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public void addCollect(Collect collect) {
        collectMapper.add(collect);
    }

    @Override
    public void cancelCollect(Collect collect) {
        collectMapper.delete(collect);
    }

    @Override
    public Collect isCollected(Collect collect) {
        return collectMapper.getByUserIdAndArticleId(collect);
    }

    @Override
    public int getCollections(int articleId) {
        return collectMapper.getCollections(articleId);
    }

    @Override
    public List<Collect> collection(int userId, int favId) {
        return collectMapper.collection(userId, favId);
    }

    @Override
    public List<Collect> getCollectionsByFavIdAndUserId(int favId, int userId) {
        return collectMapper.getCollectionsByFavIdAndUserId(favId, userId);
    }
}
