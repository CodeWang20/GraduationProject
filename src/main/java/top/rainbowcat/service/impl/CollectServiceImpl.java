package top.rainbowcat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.Collect;
import top.rainbowcat.mapper.CollectMapper;
import top.rainbowcat.service.CollectService;

import java.util.List;

/**
 * @author wangxiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public void addCollect(Collect collect) {
        collectMapper.insert(collect);
    }

    @Override
    public void cancelCollect(Collect collect) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Collect::getUserId, collect.getUserId())
                .eq(Collect::getArticleId, collect.getArticleId());
        collectMapper.delete(wrapper);
    }

    @Override
    public Collect isCollected(Collect collect) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Collect::getUserId, collect.getUserId())
                .eq(Collect::getArticleId, collect.getArticleId());
        return collectMapper.selectOne(wrapper);
    }

    @Override
    public int getCollections(String articleId) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Collect::getArticleId, articleId);
        return collectMapper.selectCount(wrapper);
    }

    @Override
    public List<Collect> collection(String userId, String favId) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Collect::getUserId, userId)
                .eq(Collect::getFavId, favId);
        return collectMapper.selectList(wrapper);
    }

    @Override
    public List<Collect> getCollectionsByFavIdAndUserId(String favId, String userId) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .select(Collect::getArticleId)
                .eq(Collect::getFavId, favId)
                .eq(Collect::getUserId, userId);
        return collectMapper.selectList(wrapper);
    }

    @Override
    public List<Collect> getFavIdByUserId(String userId) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .select(Collect::getFavId)
                .eq(Collect::getUserId, userId);
        return collectMapper.selectList(wrapper);
    }

    @Override
    public int getCollectNumByUserId(String userId) {
        QueryWrapper<Collect> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Collect::getUserId, userId);
        return collectMapper.selectCount(wrapper);
    }
}
