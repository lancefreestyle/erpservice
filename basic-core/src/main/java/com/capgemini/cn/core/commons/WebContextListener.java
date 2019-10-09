package com.capgemini.cn.core.commons;


import com.capgemini.cn.core.utils.WebContextUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 初始化WEB项目的上下文路径
        String contextPath = sce.getServletContext().getContextPath();
        log.info("初始化Web项目上下文路径。上下文路径是:'{}'", contextPath);
        WebContextUtils.setWebContext(contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("WebContextListener已经被销毁。");
    }
}
