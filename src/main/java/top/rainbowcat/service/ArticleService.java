package top.rainbowcat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.rainbowcat.entity.Article;

import java.util.List;

/**
 * @author wangxiao
 */
public interface ArticleService extends IService<Article> {

    /**
     * 获取首页最新热门文章
     * @return 当天最新热门文章浏览量前十的文章
     */
    List<Article> popularArticles();

    /**
     * 根据id查询当前文章的详细内容
     * @param id 文章id
     * @return 当前文章的相关数据
     */
    Article getDetailById(String id);

    /**
     * 创作、更新文章（通过id判断文章已存在则更新）
     * @param article 文章内容
     */
    void addArticle(Article article);

    /**
     * 根据id删除文章
     * @param id 文章id
     */
    void deleteBlog(String id);


    /**
     * 根据用户id分页查询用户的文章list
     * @param iPage MP分页插件对象
     * @param userId 用户id
     * @return 该用户的文章列表
     */
    IPage<Article> selfBlogsByUserId(IPage<Article> iPage, String userId);

    /**
     * 根据文章id列表查询文章list
     * @param articleIds 文章id列表
     * @return 文章list
     */
    List<Article> selectArticleByIds(List<Object> articleIds);

    /**
     * 获取当前用户发表的文章总数
     * @param userId 用户id
     * @return 文章数量
     */
    int getArticleNumByUserId(String userId);
}
