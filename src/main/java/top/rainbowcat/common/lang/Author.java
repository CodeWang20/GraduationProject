package top.rainbowcat.common.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Author implements Serializable {

    private int id;//用户id
    private String nickname;
    private String avatar;
    private int likes;
    private int attention;
    private int collect;
    private int fans;
}
