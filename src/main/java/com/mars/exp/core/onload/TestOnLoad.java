package com.mars.exp.core.onload;

import com.mars.common.annotation.bean.MarsOnLoad;
import com.mars.common.annotation.bean.MarsWrite;
import com.mars.common.base.BaseOnLoad;
import com.mars.exp.core.service.ExpApiService;

@MarsOnLoad
public class TestOnLoad implements BaseOnLoad {

    @MarsWrite("expApiService")
    private ExpApiService expApiService;

    @Override
    public void before() throws Exception {
        System.out.println("onload before"+(expApiService != null));
    }

    @Override
    public void after() throws Exception {
        System.out.println("onload after"+(expApiService != null));
    }
}
