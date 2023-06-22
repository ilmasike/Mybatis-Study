package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

//public interface UserDao {//专业名字：mapper
public interface UserMapper {
    //    1.查询全部用户方法
    List<User> getUserList();

    //    2.根据id查询用户方法:需要传参。用到了parameterType，传入SQL语句的参数类型 。
    User getUserById(int id);



    //    3.insert一个用户方法：
    int addUser(User user);

    //    4.修改用户：
    int UpdateUser(User user);

    //    5.删除一个用户：
    int deleteUser(int id);


}
