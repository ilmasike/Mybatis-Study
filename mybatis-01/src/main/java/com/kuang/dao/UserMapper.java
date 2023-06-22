package com.kuang.dao;

import com.kuang.pojo.User;
import jdk.nashorn.internal.ir.SetSplitState;

import java.util.List;
import java.util.Map;

//public interface UserDao {//专业名字：mapper
public interface UserMapper {
    //    1.查询全部用户方法
    List<User> getUserList();

    //    2.根据id查询用户方法:需要传参。用到了parameterType，传入SQL语句的参数类型 。
    User getUserById(int id);
    //    根据多个参数 查询：
    User getUserById2(Map<String ,Object> map);




    //    3.insert一个用户方法：
    int addUser(User user);
    int addUser2(Map<String ,Object> map);//使用万能Map
//    使用map的好处：参数太多时用。比如我不需要知道数据库都有哪些参数，只需要去查对应的字段

    //    4.修改用户：
    int UpdateUser(User user);

    //    5.删除一个用户：
    int deleteUser(int id);

//    6.模糊查询一个用户：
    List<User> getUserLike(String value);


}
