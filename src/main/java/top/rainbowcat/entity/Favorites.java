package top.rainbowcat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author wangxiao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Favorites extends Model<Favorites> implements Serializable {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    @NonNull
    private String type;
    @NonNull
    private int visibility;

    private String userId;
}
