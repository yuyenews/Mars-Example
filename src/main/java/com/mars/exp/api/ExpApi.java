package com.mars.exp.api;

import com.mars.common.annotation.api.MarsApi;
import com.mars.common.annotation.api.RequestMethod;
import com.mars.common.annotation.enums.ReqMethod;
import com.mars.exp.api.vo.ExpVO;
import com.mars.server.server.request.HttpMarsResponse;

import java.util.List;

@MarsApi(refBean = "expApiService")
public interface ExpApi {

    /**
     * get请求示例
     * http://127.0.0.1:8080/expGetRequest?name=张三&names=王五&names=赵六
     * @param expVO
     * @return
     */
    List<ExpVO> expGetRequest(ExpVO expVO);

    /**
     * post请求示例
     * http://127.0.0.1:8080/expPostRequest
     * 传参用表单，不支持json传参
     * @param expVO
     * @return
     */
    @RequestMethod(ReqMethod.POST)
    List<ExpVO> expPostRequest(ExpVO expVO);

    /**
     * 文件上传示例
     * http://127.0.0.1:8080/expUploadRequest
     * 传参用formData，不支持json传参
     * @param expVO
     * @return
     */
    @RequestMethod(ReqMethod.POST)
    String expUploadRequest(ExpVO expVO) throws Exception ;

    /**
     * 文件下载示例
     * http://127.0.0.1:8080/expDownLoadRequest
     */
    void expDownLoadRequest(HttpMarsResponse response) throws Exception;
}
