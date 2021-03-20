package com.mars.exp.core.service;

import com.mars.common.annotation.bean.MarsBean;
import com.mars.common.annotation.bean.MarsTimer;
import com.mars.common.annotation.bean.MarsWrite;
import com.mars.common.base.InitBean;
import com.mars.common.util.JSONUtil;
import com.mars.exp.api.vo.ExpVO;
import com.mars.exp.core.dao.ExpDAO;
import com.mars.server.server.jwt.JwtManager;
import com.mars.server.server.request.HttpMarsResponse;
import com.mars.server.server.request.model.MarsFileUpLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * service层
 */
@MarsBean("expApiService")
public class ExpApiService implements InitBean {

    private Logger logger = LoggerFactory.getLogger(ExpApiService.class);

    /**
     * 为了让大家可以快速的跑起来，所以本示例没有连接数据库
     * 所以自然也就不会调用dao的方法了，这里注入进来dao，只是为了演示IOC的用法
     */
    @MarsWrite
    private ExpDAO expDAO;

    /**
     * 初始化bean示例
     */
    @Override
    public void init() {
        logger.info("执行了初始化bean, bean里面注入了DAO: "+expDAO);

        try {
            JwtManager jwtManager = JwtManager.getJwtManager();

            ExpVO expVO = new ExpVO();
            expVO.setName("aaaa");
            String token = jwtManager.createToken(expVO);

            System.out.println(token);

            expVO = jwtManager.getObject(token, ExpVO.class);
            System.out.println(expVO);
            System.out.println(JSONUtil.toJSONString(expVO));
        } catch (Exception e){
            logger.error("JWT创建token异常", e);
        }
    }

//    @Traction(level = TractionLevel.READ_COMMITTED)
    public List<ExpVO> expPostRequest(ExpVO expVO) {
        // 打印expDAO，如果不为null就说明已经注入了
        logger.info(String.valueOf(expDAO == null));

        // 打印接收到的参数，看是否接收成功
        logger.info(expVO.getName());
        logger.info(JSONUtil.toJSONString(expVO.getNames()));
        logger.info(String.valueOf(expVO.getDate()));
        List<ExpVO> expVOList = expVO.getList();
        if(expVOList != null){
            for(ExpVO expVO1 : expVOList){
                logger.info("name:{},date:{}",expVO1.getName(), expVO1.getDate());
            }
        }
        // 返回数据
        return getExpResultData();
    }

    public String expUploadRequest(ExpVO expVO) throws Exception {
        // 打印expDAO，如果不为null就说明已经注入了
        logger.info(String.valueOf(expDAO == null));

        // 打印接收到的参数，看是否接收成功
        logger.info(expVO.getName());
        logger.info(JSONUtil.toJSONString(expVO.getNames()));
        logger.info(String.valueOf(expVO.getDate()));

        // 打印接收到的文件，看是否接收成功
        MarsFileUpLoad[] marsFileUpLoads = expVO.getMarsFileUpLoad();
        if(marsFileUpLoads == null){
            return "上传失败";
        }
        for(MarsFileUpLoad marsFileUpLoad : marsFileUpLoads){
            System.out.println(marsFileUpLoad.getFileName());
            System.out.println(marsFileUpLoad.getInputStream());

            InputStream inputStream = marsFileUpLoad.getInputStream();
            writeToLocal("/Users/yuye/Downloads/aaa/"+marsFileUpLoad.getFileName(),inputStream);
        }
//        MarsFileUpLoad marsFileUpLoad = expVO.getFile();
//        writeToLocal("/Users/yuye/Downloads/aaa/aaas"+marsFileUpLoad.getFileName(),marsFileUpLoad.getInputStream());
        return "上传成功";
    }

    public void expDownLoadRequest(HttpMarsResponse response) throws Exception{
        InputStream inputStream = new FileInputStream(new File("/Users/yuye/Downloads/vvv2.zip"));
        response.downLoad("aaa2.zip",inputStream);
    }

    /**
     * 定时任务示例
     * 5秒执行一次
     */
    @MarsTimer(loop = 5000)
    public void timerExp(){
        logger.info("执行了定时任务");
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

    private static void writeToLocal(String destination, InputStream input)
            throws IOException {
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream(destination);
        while ((index = input.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        downloadFile.close();
        input.close();
    }
}
