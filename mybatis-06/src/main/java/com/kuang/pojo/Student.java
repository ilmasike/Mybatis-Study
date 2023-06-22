package com.kuang.pojo;

import lombok.Data;

@Data
public class Student {
    private  int id;
    private String name;
//    学生要关联老师：
//    private int tid;不要直接这样写
    private Teacher teacher;


}
