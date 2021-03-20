package com.mars.exp.core.service;

import com.mars.common.annotation.bean.MarsAop;
import com.mars.common.annotation.bean.MarsBean;
import com.mars.common.util.JSONUtil;
import com.mars.exp.api.vo.ExpVO;
import com.mars.exp.core.aop.ExpAop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@MarsBean("expApiServiceTwo")
public class ExpApiServiceTwo {

    private Logger logger = LoggerFactory.getLogger(ExpApiService.class);

    /**
     * 这个方法上加了aop监听
     * @param expVO
     * @return
     */
    @MarsAop(className = ExpAop.class)
    public List<ExpVO> expGetRequest(ExpVO expVO) {
        // 打印接收到的参数，看是否接收成功
        logger.info(expVO.getName());
        logger.info(JSONUtil.toJSONString(expVO.getNames()));
        logger.info(String.valueOf(expVO.getDate()));

        // 返回数据
        return getExpResultData();
    }

    /**
     * 这是把返回数据写死了，不然你们还得搭环境，连接数据库
     * @return
     */
    private List<ExpVO> getExpResultData(){
        List<ExpVO> list = new ArrayList<>();

        ExpVO exp = new ExpVO();
        exp.setName("hello world");
        list.add(exp);

        exp = new ExpVO();
        exp.setName("The world dies");
        list.add(exp);

        return list;
    }
}
