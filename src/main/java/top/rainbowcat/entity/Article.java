package top.rainbowcat.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangxiao
 */
@Data
@TableName(value = "article")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Article extends Model<Article> implements Serializable {

    /**
     * 文章表主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 文章标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 文章摘要
     */
    @TableField(value = "summary")
    private String summary;

    /**
     *文章主体内容
     */
    @TableField(value = "content")
    private String content;

    @TableField(value = "picture")
    private String picture;

    /**
     *文章作者id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     *文章所属版块id
     */
    @TableField(value = "plate_id")
    private String plateId;

    /**
     *文章创作日期
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;

    /**
     *文章最后更新时间
     */
    @TableField(value = "last_update", fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdate;
    private int nowView;
    private int yesView;
    private int likes;
    private int collect;
    private int deleted;
}
