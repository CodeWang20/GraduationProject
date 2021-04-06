package top.rainbowcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.rainbowcat.entity.Plate;

import java.util.List;

/**
 * @author wangxiao
 */
public interface PlateService extends IService<Plate> {
    List<Plate> findAll();
}
