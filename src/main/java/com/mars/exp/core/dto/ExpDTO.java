package com.mars.exp.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * 这里面尽量用包装器类型，比如用Integer不用int，
 * 因为包装器类型可以赋值为null，这样如果不需要被sql用到的时候，可以赋值为null，免被带入到sql
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExpDTO {

    /**
     * 如果没有加JsonProperty注解，那么：
     * 1. 这里的字段名必须跟查询语句中的字段名 一模一样（如果取了别名就跟别名一样）
     * 2. 如果是增删改操作，并且你用的是框架自带的方法，那么必须跟数据表的字段名一模一样
     * 3. 如果数据库是user_name 那么这里也必须是user_name，不可以是userName
     * 如果加了JsonProperty注解，那么只要保证value属性跟数据库字段名一样即可
     */
    @JsonProperty(value = "数据库字段名")
    private Integer id;

    /**
     * 如果是Date类型的字段，必须设置JsonFormat，否则在插入和修改的时候，框架识别不了，会报错
     */
    @JsonProperty(value = "数据库字段名")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
