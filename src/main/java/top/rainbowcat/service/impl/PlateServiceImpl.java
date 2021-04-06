package top.rainbowcat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Transactional(rollbackFor = Exception.class)
public class PlateServiceImpl extends ServiceImpl<PlateMapper, Plate> implements PlateService {

    @Value("${rainbowcat.plate.disable}")
    private Integer DISABLE;

    @Autowired
    private PlateMapper plateMapper;

    @Override
    public List<Plate> findAll() {
        QueryWrapper<Plate> wrapper = new QueryWrapper<>();
        return plateMapper.selectList(wrapper);
    }

    @Override
    public Plate selectByName(String name) {
        LambdaQueryWrapper<Plate> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Plate::getName, name);
        return plateMapper.selectOne(wrapper);
    }

    @Override
    public void createPlate(Plate plate) {
        plateMapper.insert(plate);
    }

    @Override
    public void deletePlateById(String id) {
        plateMapper.deleteById(id);
    }

    @Override
    public List<Plate> selectPlateList() {
        LambdaQueryWrapper<Plate> wrapper = new LambdaQueryWrapper<>();
        wrapper.ne(Plate::getDisable, DISABLE);
        return plateMapper.selectList(wrapper);
    }

    @Override
    public Plate selectPlateInfoById(String id) {
        return plateMapper.selectPlateInfoById(id);
    }
}
