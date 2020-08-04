package com.mars.exp.core.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 这里面尽量用包装器类型，比如用Integer不用int，
 * 因为包装器类型可以赋值为null，这样如果不需要被sql用到的时候，可以赋值为null，免被带入到sql
 */
public class ExpDTO {

    /**
     * 如果没有加JSONField注解，那么：
     * 1. 这里的字段名必须跟查询语句中的字段名 一模一样（如果取了别名就跟别名一样）
     * 2. 如果是增删改操作，并且你用的是框架自带的方法，那么必须跟数据表的字段名一模一样
     * 3. 如果数据库是user_name 那么这里也必须是user_name，不可以是userName
     * 如果加了JSONField注解，那么只要保证name属性跟数据库字段名一样即可
     */
    @JSONField(name = "数据库字段名")
    private Integer id;
}
