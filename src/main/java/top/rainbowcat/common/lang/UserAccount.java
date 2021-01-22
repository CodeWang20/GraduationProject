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
public class UserAccount implements Serializable {

    private int id;
    private String username;
    private String sex;
    private String email;
    private String telephone;
    private Date created;
    private Date last_login;
    private int status;
}
