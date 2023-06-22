package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    //    一、查询所有对象
    @Test
    public void test(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            // 方法一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            // 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            List<User> userList = mapper.getUserList();//执行dao层的方法


            //方法二:
//List<User> users =  sqlSession.getUserList("com.kuang.mapper.UserMapper.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }

    // 二、通过id查询某个对象
    @Test
    public void getUserById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；

            User userById = mapper.getUserById(0);//执行dao层的方法
            System.out.println(userById);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    //  三、通过多个参数查询对象
    @Test
    public void getUserById2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id","1");
            map.put("name","卡卡羅特");
            User userById2 = mapper.getUserById2(map);//执行dao层的方法
            System.out.println(userById2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    //    四、增加对象
//注意增删改需要提交事务：
    @Test
    public void addUser(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；

            int result=mapper.addUser(new User(4,"mako","123456789aaa"));//执行dao层的方法
            if(result>0){
                System.out.println("插入成功！！");
            }
//            提交事务：
            sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    //    五、增加对象（Map方法）
    @Test
    public void addUser2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；

            Map<String, Object> map = new HashMap<String, Object>();
//            使用万能Map，这样我们不用像new User对象一样，把所有的参数都写一遍。而是想添加什么直接put()
            map.put("userId",5);
            map.put("userName","hello");
            map.put("userPwd","osaodfhasf");
            int i = mapper.addUser2(map);//执行dao层的方法
// 对比下，上一种新建user的写法：mapper.addUser(new User(4,"mako","123456789aaa"));
            if(i>0){
                System.out.println("插入成功！！");
            }
//            提交事务：
            sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }








    //      六、更改对象
    //注意增删改需要提交事务：
    @Test
    public void UpdateUser(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；

            int result=mapper.UpdateUser(new User(4,"卡卡羅特","dragon ball"));//执行dao层的方法
            if(result>0){
                System.out.println("修改成功！！");
            }
//            提交事务：
            sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    //     七、  删除对象
    //注意增删改需要提交事务：
    @Test
    public void deleteUser(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；

            int result=mapper.deleteUser(4);//执行dao层的方法
            if(result>0){
                System.out.println("删除成功！！");
            }
//            提交事务：
            sqlSession.commit(); //提交事务,重点!不写的话不会提交到数据库

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


    //    八、模糊查询：
    @Test
    public void getUserLike(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
//方法1：在Java代码中添加sql通配符。
            String wildcardname ="%赵%";
            List<User> userList = mapper.getUserLike(wildcardname);//执行dao层的方法
            for (User user : userList) {
                System.out.println(user);
            }

//        第2种：在sql语句中拼接通配符，会引起sql注入
 /*
        * string wildcardname = “smi”;
             list<name> names = mapper.selectlike(wildcardname);
      <select id=”selectlike”>
         select * from foo where bar like "%"#{value}"%"
      </select>
*/


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }








}
