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
public class Article implements Serializable {
    private int id;
    private String title;
    private String summary;
    private String content;
    private String picture;
    private int userId;
    private int plateId;
    private Date created;
    private int nowView;
    private int yesView;
    private int likes;
    private int collect;
    private int deleted;
}
