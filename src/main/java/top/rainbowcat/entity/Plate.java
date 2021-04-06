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
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Plate extends Model<Plate> implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 版块名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 版块创建时间
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;

    /**
     * 上次更新时间
     */
    @TableField(value = "last_update", fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdate;

    /**
     * 版块是否被禁用
     */
    @TableField(value = "disable")
    private Integer disable;

    /**
     * 是否被删除
     *      1：未删除
     *      0：已删除
     */
    @TableLogic(value = "1", delval = "0")
    @TableField(value = "deleted")
    private Integer deleted;
}
