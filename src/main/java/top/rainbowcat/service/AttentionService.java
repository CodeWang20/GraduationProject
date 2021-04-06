package top.rainbowcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.rainbowcat.entity.Attention;

/**
 * @Author wangxiao
 * @Date 2021/4/6 上午8:28
 */


public interface AttentionService extends IService<Attention> {
    /**
     * 根据userId和authorId查询该用户是否关注该作者
     * @param userId 用户iid
     * @param authorId 作者id
     * @return null或一条记录
     */
    Attention isFollowed(String userId, String authorId);

    /**
     * 添加关注
     * @param attention 主要信息：用户id（关注人）、作者id（被关注的人）
     */
    void addFollowed(Attention attention);

    /**
     * 取消关注
     * @param attention 主要信息：用户id（关注人）、作者id（被关注的人）
     */
    void cancelFollow(Attention attention);

    /**
     * 获取用户的粉丝数量
     * @param id 用户id（对应数据库表中的author_id）
     * @return 该用户的粉丝总数（被关注数量）
     */
    int getFansNumByUserId(String id);

    /**
     * 获取用户的关注数量
     * @param id 用户id（对应数据库表中的user_id）
     * @return 该用户关注了多少作者
     */
    int getAttentionNumByUserId(String id);
}
