package top.rainbowcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.rainbowcat.entity.Plate;

import java.util.List;

/**
 * @author wangxiao
 */
@Service
public interface PlateService extends IService<Plate> {
    /**
     * 查询全部版块信息（仅未禁用状态）
     * @return 未禁用的版块信息
     */
    List<Plate> findAll();


    /**
     * 根据版块名称查询是否存在
     * @param name 版块名称
     * @return null或一条记录
     */
    Plate selectByName(String name);

    /**
     * 创建版块
     * @param plate 要创建的版块信息
     */
    void createPlate(Plate plate);

    /**
     * 删除版块
     * @param id 版块id
     */
    void deletePlateById(String id);

    /**
     * 获取版块列表（未被删除、禁用的版块）
     * @return 版块列表
     */
    List<Plate> selectPlateList();

    /**
     * 自定义Sql,获取版块详细信息（包括逻辑已删除、禁用状态版块）
     * @param id 版块id
     * @return 版块信息
     */
    Plate selectPlateInfoById(String id);
}
