package com.capgemini.cn.core.utils;

public class WebContextUtils {

    /**
     * WEB项目的上下文路径
     */
    private static String webContext;

    /**
     * WEB项目的上下文路径
     */
    public static String getWebContext() {
        return webContext;
    }

    /**
     * WEB项目的上下文路径
     */
    public static void setWebContext(String webContext) {
        WebContextUtils.webContext = webContext;
    }
}
