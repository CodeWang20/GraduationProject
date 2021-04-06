package top.rainbowcat.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Plate;
import top.rainbowcat.service.PlateService;

import java.util.List;

/**
 * @author wangxiao
 */
@Slf4j
@RestController
@RequestMapping("/plate")
public class PlateController {

    @Value("${rainbowcat.plate.disable}")
    private Integer DISABLE;

    @Autowired
    private PlateService plateService;

    @GetMapping("/findAll")
    public Result findAll(){
        try {
            List<Plate> plateList = plateService.findAll();
            return Result.succ(plateList);
        }catch (Exception e){
            e.printStackTrace();
            //throw e;
            return Result.fail("未找到板块内容！");
        }
    }

    /**
     * 获取未被删除、未被禁用的版块列表
     * @return 版块列表
     */
    @GetMapping("/list")
    public Result plateList(){
        try {
            List<Plate> plateList = plateService.selectPlateList();
            return Result.succ(plateList);
        }catch (Exception e){
            e.printStackTrace();
            //throw e;
            return Result.fail("未找到板块内容！");
        }
    }


    /**
     * 新建版块
     *    流程：
     *      1、根据name查询数据库，数据库中无记录直接添加
     *      2、数据库中有记录，则根据disable字段分析
     *      3、disable： 根据状态（禁用/可用）返回不同的提示信息
     * @param plate 主要信息：name（版块名称）
     */
    @PostMapping("/create")
    public Result createPlate(@RequestBody Plate plate){
        Plate p = plateService.selectByName(plate.getName());
        if (ObjectUtils.isEmpty(p)){
            plateService.createPlate(plate);
            return Result.succ(plate.getName() + "版块创建完成！",null);
        }else if (p.getDisable().equals(DISABLE)){
            return Result.fail("该版块已经被禁用！");
        }
        return Result.fail("该版块已经存在，请勿重复创建！");
    }

    /**
     * 自定义Sql,获取版块详细信息（包括逻辑已删除、禁用状态版块）
     * @param id 版块id
     * @return 版块信息
     */
    @GetMapping("/info")
    public Result plateInfo(String id){
        Plate plate = plateService.selectPlateInfoById(id);
        return Result.succ(plate);
    }

    /**
     * 更新版块名称
     * @param plate 版块信息
     */
    @PostMapping("/update")
    public Result updatePlate(@RequestBody Plate plate){
        Plate p = plateService.selectByName(plate.getName());
        if (!ObjectUtils.isEmpty(p)){
            return Result.fail("该版块已经存在！");
        }
        LambdaUpdateWrapper<Plate> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(Plate::getName, plate.getName()).eq(Plate::getId, plate.getId());
        plateService.update(wrapper);
        return Result.succ("版块信息更新成功", null);
    }

    /**
     * 改变版块的状态
     * @param id 版块id
     */
    @GetMapping("/changeState")
    public Result changeState(@Validated String id){
        try {
            LambdaUpdateWrapper<Plate> wrapper = new LambdaUpdateWrapper<>();
            wrapper.setSql("disable = ((disable + 1) % 2)")
                    .eq(Plate::getId, id);
            plateService.update(wrapper);
            return Result.succ("操作成功！", null);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 删除版块
     * @param id 版块id
     */
    @GetMapping("/delete")
    public Result deletePlate(@Validated String id){
        plateService.deletePlateById(id);
        return Result.succ("版块删除成功！", null);
    }
}
