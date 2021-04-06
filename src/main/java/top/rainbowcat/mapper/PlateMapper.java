package top.rainbowcat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.rainbowcat.entity.Plate;

/**
 * @author wangxiao
 */
public interface PlateMapper extends BaseMapper<Plate> {

    /**
     * 自定义Sql,获取版块详细信息（包括逻辑已删除、禁用状态版块）
     * @param id 版块id
     * @return 版块信息
     */
    Plate selectPlateInfoById(String id);
}
