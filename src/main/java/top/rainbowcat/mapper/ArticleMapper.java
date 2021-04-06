package top.rainbowcat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.rainbowcat.entity.Article;

/**
 * @author wangxiao
 */
public interface ArticleMapper extends BaseMapper<Article> {

    void addViews(String id);

    /**
     * 根据用户id分页查询用户的文章list
     * @param iPage MP分页插件对象
     * @param userId 用户id
     * @return 该用户的文章列表
     */
    IPage<Article> getBlogsBuUserId(IPage<Article> iPage, String userId);
}
