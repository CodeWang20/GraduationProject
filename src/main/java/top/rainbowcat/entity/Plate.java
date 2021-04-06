package top.rainbowcat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Plate extends Model<Plate> implements Serializable {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    private String name;
    private Date created;
    private Date lastUpdate;
    private int deleted;

}
