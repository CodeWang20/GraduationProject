package top.rainbowcat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.rainbowcat.common.lang.Result;
import top.rainbowcat.entity.Collect;
import top.rainbowcat.service.CollectService;

import java.util.Date;

@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    CollectService collectService;

    @GetMapping("/addCollect")
    public Result addCollect(Collect collect){
        Collect collected = collectService.isCollected(collect);
        if (collected == null){
            try {
                collect.setCreated(new Date());
                collectService.addCollect(collect);
                return Result.succ( "收藏成功！", null);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return Result.fail(null);
    }
    @GetMapping("/cancelCollect")
    public Result cancelCollect(Collect collect){
        try {
            collectService.cancelCollect(collect);
            return Result.succ("取消收藏成功！", null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Result.fail("收藏失败！");
    }

    @GetMapping("/isCollected")
    public Result isCollected(Collect collect){
        Collect collected = collectService.isCollected(collect);
        if (collected != null){
            return Result.succ("", collected);
        }
        return Result.succ(404, "", null);
    }
}
