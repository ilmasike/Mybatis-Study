package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

//public interface UserDao {//专业名字：mapper
public interface UserMapper {


    //    2.根据id查询用户方法:需要传参。用到了parameterType，传入SQL语句的参数类型 。
    User getUserById(int id);






}
