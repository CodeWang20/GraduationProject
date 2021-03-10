package top.rainbowcat.service;

import top.rainbowcat.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> popularArticles();

    int getLikesByArticleId(int id);

    Article getDetailById(int id);

    void addViews(int id);

    void addArticle(Article article);

    List<Article> selfBlogsList(int userId, int currentPage, int pageSize);
    int selfBlogsCount(int userId);

    void deleteBlog(int id);

    void updateArticle(Article article);
}
