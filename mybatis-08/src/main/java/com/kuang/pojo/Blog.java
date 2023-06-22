package com.kuang.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;//属性名和字段名（create_time）不一致。
    // 我们可以（在核心配置文件中）设置开启驼峰命名映射:<setting name="mapUnderscoreToCamelCase" value="true"/>
    private int views;
}
