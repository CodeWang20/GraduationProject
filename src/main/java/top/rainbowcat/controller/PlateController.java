package top.rainbowcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Plate;
import top.rainbowcat.service.PlateService;

import java.util.List;

@RestController
@RequestMapping("/plate")
public class PlateController {

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
}
