package top.rainbowcat.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取SpringBoot工厂的工具类
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * SpringBoot项目启动后会将创建好的工厂以参数的形式回传applicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.context = applicationContext;
    }

    /**
     * 根据bean的名字获取工厂中指定的bean 对象
     * 可以传递业务层的名字，拿到对应的userService
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
}
