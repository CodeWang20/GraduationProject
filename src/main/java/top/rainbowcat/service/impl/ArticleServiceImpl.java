package top.rainbowcat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.Article;
import top.rainbowcat.mapper.ArticleMapper;
import top.rainbowcat.service.ArticleService;

import java.util.List;

/**
 * @author wangxiao
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> popularArticles() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .orderByDesc(Article::getNowView)
                .apply("TO_DAYS(now())-TO_DAYS(created) < 30")
//                .apply("TO_DAYS(created) = TO_DAYS(NOW())")
                .last("limit 10");
        return articleMapper.selectList(wrapper);
    }

    @Override
    public Article getDetailById(String id) {
        return articleMapper.selectById(id);
    }

    @Override
    public void addViews(String id) {
        articleMapper.addViews(id);
    }

    @Override
    public void addArticle(Article article) {
        articleMapper.insert(article);
    }


    @Override
    public IPage<Article> selfBlogsByUserId(IPage<Article> iPage, String userId) {
        return articleMapper.getBlogsBuUserId(iPage, userId);
    }

    @Override
    public List<Article> selectArticleByIds(List<Object> articleIds) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(Article::getId, articleIds);
        return articleMapper.selectList(wrapper);
    }

    @Override
    public int getArticleNumByUserId(String userId) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Article::getUserId, userId);
        return articleMapper.selectCount(wrapper);
    }


    @Override
    public void deleteBlog(String id) {
        articleMapper.deleteById(id);
    }

}
