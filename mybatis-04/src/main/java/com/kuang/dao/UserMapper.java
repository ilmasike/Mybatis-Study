package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

//public interface UserDao {//专业名字：mapper
public interface UserMapper {
    //    1.根据id查询用户方法:需要传参。用到了parameterType，传入SQL语句的参数类型 。
    User getUserById(int id);

    //2.1选择全部用户实现分页
    List<User> getUserByLimit(Map<String,Integer> map);
//    2.2   通过RowBounds分页（了解即可。老代码）
List<User> getUserByRowBounds();








}
