package top.rainbowcat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.common.lang.PageBean;
import top.rainbowcat.entity.Article;
import top.rainbowcat.mapper.ArticleMapper;
import top.rainbowcat.service.ArticleService;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> popularArticles() {
        return articleMapper.getHotArticle();
    }

    @Override
    public int getLikesByArticleId(int id) {
        return articleMapper.getLikesByArticleId(id);
    }

    @Override
    public Article getDetailById(int id) {
        return articleMapper.getDetailById(id);
    }

    @Override
    public void addViews(int id) {
        articleMapper.addViews(id);
    }

    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }


    @Override
    public List<Article> selfBlogsList(int userId, int currentPage, int pageSize) {
        int start = (currentPage - 1) * pageSize;
        return articleMapper.selfBlogsList(userId, start, pageSize);
    }
    @Override
    public int selfBlogsCount(int userId) {
        return articleMapper.selfBlogsCount(userId);
    }

    @Override
    public void deleteBlog(int id) {
        articleMapper.delete(id);
    }

}
