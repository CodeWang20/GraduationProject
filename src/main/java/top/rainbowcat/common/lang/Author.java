package top.rainbowcat.common.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 作者信息
 * @author wangxiao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Author implements Serializable {

    private String id;
    private String nickname;
    private String avatar;
    private int articles;
    private int attention;
    private int collect;
    private int fans;
}
