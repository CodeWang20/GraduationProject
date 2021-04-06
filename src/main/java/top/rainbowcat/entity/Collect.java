package top.rainbowcat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wangxiao
 */
@Data
@TableName(value = "collect")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Collect extends Model<Collect> implements Serializable {
    /**
     * 收藏表主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 当前收藏用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 当前被收藏文章的id
     */
    @TableField(value = "article_id")
    private String articleId;

    /**
     * 所属收藏夹id
     */
    @TableField(value = "fav_id")
    private String favId;

    @TableField(exist = false)
    private Article article;
}
