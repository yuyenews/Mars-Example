package com.mars.exp.config;

import com.mars.common.base.config.MarsConfig;
import com.mars.common.base.config.model.ThreadPoolConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 更多配置项，请到官网查看官方文档
 */
public class ExpConfig extends MarsConfig {

    /**
     * 这个是有默认值的，不是必配的，完全可以不实现这个方法
     * @return
     */
    @Override
    public ThreadPoolConfig getThreadPoolConfig() {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();
        // 最大TCP连接池(并发数)
        threadPoolConfig.setBackLog(50);

        // 核心线程数，同时允许几个线程处理请求
        threadPoolConfig.setCorePoolSize(5);
        // 最大线程数，最多允许几个线程处理请求
        threadPoolConfig.setMaxPoolSize(1000);
        // 线程多久不执行会被回收
        threadPoolConfig.setKeepAliveTime(20);
        return threadPoolConfig;
    }

    /**
     * 配置数据源
     * @return
     */
//    @Override
//    public List<Properties> jdbcProperties() {
//        List<Properties> list = new ArrayList<>();
//
//        // 用的是阿里巴巴的 druid数据源，其他属性可自行查阅
//        Properties properties = new Properties();
//        properties.put("name","dataSource");
//        properties.put("url","");
//        properties.put("username","");
//        properties.put("password","");
//        properties.put("driverClassName","com.mysql.jdbc.Driver");
//
//        list.add(properties);
//
//        // 如果要多个数据源，add多个到list即可
//
//        return list;
//    }
}
