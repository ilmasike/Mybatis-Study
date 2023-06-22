package com.kuang.dao;
/*
 缓存：
*
*/
import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

//    1.查询指定用户：
    User queryUserById(@Param("id") int id);

//    2.修改用户：
    int updateUser(User user);


}
