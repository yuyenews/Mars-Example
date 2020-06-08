package com.mars.exp.api.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.mars.common.annotation.api.MarsDataCheck;
import com.mars.server.server.request.model.MarsFileUpLoad;

import java.util.Date;

/**
 * 所有实体类都支持lombok，这里为了兼容所有的环境，就还是采用的原始的get，set
 */
public class ExpVO {

    @MarsDataCheck(notNull = true, msg = "名称不可以为空")
    private String name;

    @MarsDataCheck(notNull = true, msg = "名称们不可以为空")
    private String[] names;

    /**
     * 这个变量名不需要跟参数key一样，他会把所有的文件都放里面
     * 如果key一致，则只放一个
     */
    private MarsFileUpLoad[] marsFileUpLoad;

    /**
     * 这个变量名要跟参数key一样
     */
    private MarsFileUpLoad file;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public MarsFileUpLoad[] getMarsFileUpLoad() {
        return marsFileUpLoad;
    }

    public void setMarsFileUpLoad(MarsFileUpLoad[] marsFileUpLoad) {
        this.marsFileUpLoad = marsFileUpLoad;
    }

    public MarsFileUpLoad getFile() {
        return file;
    }

    public void setFile(MarsFileUpLoad file) {
        this.file = file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
