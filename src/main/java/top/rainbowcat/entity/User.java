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
@TableName(value = "user")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class User extends Model<User> implements Serializable {

    /**
     * 用户表主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 帐号创建日期
     */
    @TableField(value = "created", fill = FieldFill.INSERT)
    private Date created;

    /**
     * 上次登陆时间
     */
    @TableField(value = "last_login")
    private Date lastLogin;

    /**
     * 帐号状态
     */
    @TableField(value = "status")
    private int status;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 随机盐
     */
    @TableField(value = "salt")
    private String salt;
}
