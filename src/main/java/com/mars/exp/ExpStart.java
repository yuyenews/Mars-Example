package com.mars.exp;

import com.mars.common.annotation.start.MarsImport;
import com.mars.exp.config.ExpConfig;
import com.mars.start.StartMars;

/**
 * 启动类，
 * 如果要用tomcat启动，就把被注释掉的@MarsImport，给放开
 */
//@MarsImport(packageName = "com.mars.start.tomcat.starter")
public class ExpStart {

    public static void main(String[] args) {
        StartMars.start(ExpStart.class,new ExpConfig());
    }
}
