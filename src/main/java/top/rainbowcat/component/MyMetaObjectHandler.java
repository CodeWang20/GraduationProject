package top.rainbowcat.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用于处理MP插入和更新时，自动填入时间信息
 *
 * @Author wangxiao
 * @Date 2021/3/28 下午9:37
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入时：创建时间和修改时间....");
        //插入时：创建时间和修改时间
        this.setFieldValByName("created", new Date(), metaObject);
        this.setFieldValByName("lastUpdate", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时：修改时间....");
        this.setFieldValByName("lastUpdate", new Date(), metaObject);
    }
}
