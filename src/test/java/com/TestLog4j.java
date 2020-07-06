package com;

import org.apache.log4j.Logger;

/**
 * Log4j测试类
 * @author jiejie
 * @date 2020/4/28 11:59
 */
public class TestLog4j {
    private static Logger logger=Logger.getLogger(TestLog4j.class); // 获取logger实例

    public static void main(String[] args) {
        logger.info("普通Info信息");
        logger.debug("调试debug信息");
        logger.error("报错error信息");

        logger.error("报错信息",new IllegalArgumentException("非法参数"));
    }
}
