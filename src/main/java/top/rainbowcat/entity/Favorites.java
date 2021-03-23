package top.rainbowcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Favorites implements Serializable {
    private int id;
    @NonNull
    private String type;
    @NonNull
    private int visibility;  //可见性

//    private List<Article> articles;
}
