package com.kuang.pojo;

import lombok.Data;

@Data
public class Student {
    private  int id;
    private String name;
////    学生要关联老师：
////    private int tid;不要直接这样写
//    private Teacher teacher;


//    现在是一对多，学生不再需要老师，而是老师配置学生
  private int tid;


}
