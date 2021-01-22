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
public class Plate implements Serializable {
    private int id;
    private String name;
    private Date created;
    private Date lastUpdate;
    private int deleted;

}
