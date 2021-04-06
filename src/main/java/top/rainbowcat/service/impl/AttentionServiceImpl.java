package top.rainbowcat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.rainbowcat.entity.Attention;
import top.rainbowcat.mapper.AttentionMapper;
import top.rainbowcat.service.AttentionService;

/**
 * @Author wangxiao
 * @Date 2021/4/6 上午8:29
 */


@Service
public class AttentionServiceImpl extends ServiceImpl<AttentionMapper, Attention> implements AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public Attention isFollowed(String userId, String authorId) {
        LambdaQueryWrapper<Attention> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attention::getUserId, userId)
                .eq(Attention::getAuthorId, authorId);
        return attentionMapper.selectOne(wrapper);
    }

    @Override
    public void addFollowed(Attention attention) {
        attentionMapper.insert(attention);
    }

    @Override
    public void cancelFollow(Attention attention) {
        LambdaQueryWrapper<Attention> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attention::getUserId, attention.getUserId())
                .eq(Attention::getAuthorId, attention.getAuthorId());
        attentionMapper.delete(wrapper);
    }

    @Override
    public int getFansNumByUserId(String id) {
        LambdaQueryWrapper<Attention> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attention::getAuthorId, id);
        return attentionMapper.selectCount(wrapper);
    }

    @Override
    public int getAttentionNumByUserId(String id) {
        LambdaQueryWrapper<Attention> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attention::getUserId, id);
        return attentionMapper.selectCount(wrapper);
    }
}
