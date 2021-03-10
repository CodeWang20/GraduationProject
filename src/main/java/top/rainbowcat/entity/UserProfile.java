package top.rainbowcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserProfile implements Serializable {

    private int id;
    private String name;
    private String nickname;
    private String sex;
    private String avatar;
    private String email;
    private String telephone;
    private String introduction;
}
