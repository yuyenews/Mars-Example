package com.mars.exp.config;

import com.mars.common.base.config.MarsConfig;
import com.mars.common.base.config.model.FileUploadConfig;
import com.mars.common.base.config.model.JedisConfig;
import com.mars.common.base.config.model.RequestConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 更多配置项，请到官网查看官方文档
 */
public class ExpConfig extends MarsConfig {

    /**
     * 限制上传文件的大小
     * @return
     */
    @Override
    public FileUploadConfig fileUploadConfig() {
        FileUploadConfig fileUploadConfig = new FileUploadConfig();
        fileUploadConfig.setFileSizeMax(fileUploadConfig.getFileSizeMax()*100);
        fileUploadConfig.setSizeMax(fileUploadConfig.getSizeMax()*100);
        return fileUploadConfig;
    }

    @Override
    public RequestConfig requestConfig() {
        RequestConfig requestConfig = new RequestConfig();
        requestConfig.setReadTimeout(10000);
        requestConfig.setReadSize(1*1024*1024);
        return requestConfig;
    }

    /**
     * redis连接
     * @return
     */
    @Override
    public JedisConfig jedisConfig() {
        JedisConfig jedisConfig = new JedisConfig();
        jedisConfig.setHost("127.0.0.1");
        jedisConfig.setPort(6379);
        jedisConfig.setDatabase(5);

        // 实际场景下，这句最好配一下，根据具体情况进行连接池的参数配置
        // jedisConfig.setJedisPoolConfig();

        return jedisConfig;
    }

    /**
     * 配置数据源
     * @return
     */
    @Override
    public List<Properties> jdbcProperties() {
        List<Properties> list = new ArrayList<>();

        // 用的是阿里巴巴的 druid数据源，其他属性可自行查阅
        Properties properties = new Properties();
        properties.put("name","dataSource");
        properties.put("url","");
        properties.put("username","");
        properties.put("password","");
        properties.put("driverClassName","com.mysql.jdbc.Driver");

        list.add(properties);

        // 如果要多个数据源，add多个到list即可

        return list;
    }
}
