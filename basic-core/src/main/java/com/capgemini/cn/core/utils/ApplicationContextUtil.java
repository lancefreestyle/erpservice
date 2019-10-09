package com.capgemini.cn.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    public ApplicationContextUtil() {
        log.info("初始化ApplicationContextUtil类。");
    }

    /**
     * 根据指定类型获取Spring中管理的Bean对象实例
     *
     * @param requiredType 需要获取Bean实例的对象类型
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        return context.getBean(requiredType);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        ApplicationContextUtil.context = context;
    }
}
