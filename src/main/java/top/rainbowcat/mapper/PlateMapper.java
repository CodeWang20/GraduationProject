package top.rainbowcat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.rainbowcat.entity.Plate;

import java.util.List;

/**
 * @author wangxiao
 */
public interface PlateMapper extends BaseMapper<Plate> {
    List<Plate> findAll();
}
