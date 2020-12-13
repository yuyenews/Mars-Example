package com.mars.exp.core.onload;

import com.mars.common.annotation.bean.MarsOnLoad;
import com.mars.common.annotation.bean.MarsWrite;
import com.mars.common.base.BaseOnLoad;
import com.mars.exp.core.service.ExpApiService;

/**
 * 项目启动事件
 */
@MarsOnLoad
public class TestOnLoad implements BaseOnLoad {

    @MarsWrite("expApiService")
    private ExpApiService expApiService;

    /**
     * 服务器前执行
     * 此时服务还未启动，所以没有东西可以给expApiService注入，所以expApiService为空
     * @throws Exception
     */
    @Override
    public void before() throws Exception {
        System.out.println("onload before方法执行,"+(expApiService != null));
    }

    /**
     * 服务启动后执行
     * 此时服务已经启动了，有东西可以给expApiService注入，所以此时expApiService被注入可以用
     * @throws Exception
     */
    @Override
    public void after() throws Exception {
        System.out.println("onload after方法执行,"+(expApiService != null));
    }
}
