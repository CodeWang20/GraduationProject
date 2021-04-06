package top.rainbowcat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wangxiao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserProfile extends Model<UserProfile> implements Serializable {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String name;
    private String nickname;
    private String sex;
    private String avatar;
    private String email;
    private String telephone;
    private String introduction;
}
