package top.rainbowcat.common.lang;

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

    private Long id;
    private String username;
    private String name;
    private String sex;
    private int age;
    private String email;
    private String telephone;
    private String avatar;
    private String nickname;
    private Date created;
    private Date last_login;
    private int status;
}
