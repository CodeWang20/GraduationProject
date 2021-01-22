package top.rainbowcat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.rainbowcat.entity.Plate;
import top.rainbowcat.mapper.PlateMapper;
import top.rainbowcat.service.PlateService;

import java.util.List;

@Service
@Transactional
public class PlateServiceImpl implements PlateService {

    @Autowired
    private PlateMapper plateMapper;

    @Override
    public List<Plate> findAll() {
        return plateMapper.findAll();
    }
}
