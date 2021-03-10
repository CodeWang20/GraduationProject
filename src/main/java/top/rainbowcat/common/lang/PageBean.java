package top.rainbowcat.common.lang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean implements Serializable {
    private int currentPage;
    private int pageSize;
    private int totalPage;
    private int totalCount;
}
