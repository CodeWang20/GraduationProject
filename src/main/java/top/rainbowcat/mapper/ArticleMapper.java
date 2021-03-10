package top.rainbowcat.mapper;

import top.rainbowcat.entity.Article;

import java.util.List;

public interface ArticleMapper {
    List<Article> getHotArticle();

    int getLikesByArticleId(int id);

    Article getDetailById(int id);

    void addViews(int id);

    void addArticle(Article article);

    List<Article> selfBlogsList(int userId, int start, int pageSize);
    int selfBlogsCount(int userId);

    void delete(int id);

    void updateArticle(Article article);
}
