package com.mars.exp.api;

import com.mars.common.annotation.api.MarsApi;
import com.mars.common.annotation.api.MarsReference;
import com.mars.common.annotation.api.RequestMethod;
import com.mars.common.annotation.enums.RefType;
import com.mars.common.annotation.enums.ReqMethod;
import com.mars.exp.api.vo.ExpVO;
import com.mars.server.server.request.HttpMarsResponse;

import java.util.List;

/**
 * Controller变成了一个interface
 */
@MarsApi(refBean = "expApiService")
public interface ExpApi {

    /**
     * get请求示例,此示例引用的是expApiServiceTwo里的方法
     * http://127.0.0.1:8080/expGetRequest?name=张三&names=王五&names=赵六
     * @param expVO
     * @return
     */
    @MarsReference(beanName = "expApiServiceTwo",refName = "expGetRequest",refType = RefType.METHOD)
    List<ExpVO> expGetRequest(ExpVO expVO);

    /**
     * post请求示例
     * http://127.0.0.1:8080/expPostRequest
     * @param expVO
     * @return
     */
    @RequestMethod(ReqMethod.POST)
    List<ExpVO> expPostRequest(ExpVO expVO);

    /**
     * 文件上传示例
     * http://127.0.0.1:8080/expUploadRequest
     * @param expVO
     * @return
     */
    @RequestMethod(ReqMethod.PUT)
    String expUploadRequest(ExpVO expVO) throws Exception ;

    /**
     * 文件下载示例
     * http://127.0.0.1:8080/expDownLoadRequest
     */
    void expDownLoadRequest(HttpMarsResponse response) throws Exception;
}
