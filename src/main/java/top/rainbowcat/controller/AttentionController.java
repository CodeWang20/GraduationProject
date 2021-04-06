package top.rainbowcat.controller;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Attention;
import top.rainbowcat.service.AttentionService;

/**
 * @Author wangxiao
 * @Date 2021/4/6 上午8:30
 */

@Slf4j
@RestController
@RequestMapping("/attention")
public class AttentionController {

    @Autowired
    private AttentionService attentionService;


    /**
     * 添加关注
     * @param attention 主要信息：用户id（关注人）、作者id（被关注的人）
     */
    @PostMapping("/add")
    public Result addAttention(@RequestBody Attention attention){
        Attention query = attentionService.isFollowed(attention.getUserId(), attention.getAuthorId());
        if (!ObjectUtils.isEmpty(query)){
            return Result.fail("您已关注该作者，谢谢支持哦～");
        }try {
            attentionService.addFollowed(attention);
            return Result.succ("关注成功！", null);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail("操作失败！");
        }
    }

    /**
     * 取消关注
     * @param attention 主要信息：用户id（关注人）、作者id（被关注的人）
     */
    @GetMapping("/cancel")
    private Result cancelFollow(@RequestBody Attention attention){
        attentionService.cancelFollow(attention);
        return Result.succ("取消关注操作成功！", null);
    }

    /**
     * 查询是否已经关注
     * @param attention 主要信息：用户id（关注人）、作者id（被关注的人）
     */
    @GetMapping("/isFollowed")
    public Result isFollowed(@RequestBody Attention attention){
        Attention query = attentionService.isFollowed(attention.getUserId(), attention.getAuthorId());
        if (!ObjectUtils.isEmpty(query)){
            return Result.succ(query);
        }
        return Result.succ(null);
    }
}
