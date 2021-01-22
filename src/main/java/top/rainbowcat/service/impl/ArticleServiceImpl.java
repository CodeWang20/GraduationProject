package top.rainbowcat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
