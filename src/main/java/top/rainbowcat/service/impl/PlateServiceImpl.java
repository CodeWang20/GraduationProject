package top.rainbowcat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.Plate;
import top.rainbowcat.mapper.PlateMapper;
import top.rainbowcat.service.PlateService;

import java.util.List;

/**
 * @author wangxiao
 */
@Service
@Transactional
public class PlateServiceImpl extends ServiceImpl<PlateMapper, Plate> implements PlateService {

    @Autowired
    private PlateMapper plateMapper;

    @Override
    public List<Plate> findAll() {
        return plateMapper.findAll();
    }
}
