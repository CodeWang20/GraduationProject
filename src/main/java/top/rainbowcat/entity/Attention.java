package top.rainbowcat.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 关注信息实体类
 *
 * @Author wangxiao
 * @Date 2021/4/6 上午8:22
 */


@Data
@TableName(value = "attention")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode()
public class Attention {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 文章作者id
     */
    @TableField(value = "author_id")
    private String authorId;

    /**
     * 用户id（收藏人）
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 收藏时间
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;
}
