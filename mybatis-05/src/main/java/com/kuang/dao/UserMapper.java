package com.kuang.dao;
/*使用注解开发：UserMapper.xml可以删除了，注解就是替代他的*/
import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

//public interface UserDao {//专业名字：mapper
public interface UserMapper {

//    1.  获取全部用户方法：
//    通过注解，不用再写xml文件了。
    /*回忆以前的xml：
    *  <select id="getUserById" resultMap="UserMap">  <!--resultMap：结果集映射-->
        select  * from mybatis.user where id=#{id};
    </select>
    *
    * */


//1.注解查询所有用户：
@Select("select  * from mybatis.user")
    List<User> getUsers();

//    2.注解通过id查询用户：
//    方法存在多个参数时，所有的参数前面必须加上@Param("")，
@Select("select * from user where id =#{id} and name=#{name}")
    User getUserByID(@Param("id") int id,@Param("name") String name);/*  这里@Param("")，基本类型参数全部加上*/
//    User getUserByID(@Param("id") int id2,@Param("name") String name);
//    User getUserByID(@Param("id2") int id,@Param("name") String name);

//    3.注解添加用户
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);//引用对象不需要加上@Param("")，

//    4.修改：
    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

//    5.删除
    @Delete("delete from user where id =#{uid}")
    int deleteUser(@Param("uid") int id);



}
