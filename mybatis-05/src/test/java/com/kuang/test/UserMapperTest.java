package com.kuang.test;
//通过注解，代替了UserMapper.xml层,也能输出结果。但是UserMapper.xml层的map映射功能没了，使得输出的password为null
import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserMapperTest {


    //    一、查询所有对象
    @Test
    public void getUsers(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            // 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            List<User> users = mapper.getUsers();//执行dao层的方法
            for (User user : users) {
                System.out.println(user);
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }







    //    二、通过id查询对象
    @Test
    public void getUserByID(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            // 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            User a = mapper.getUserByID(2, "张三");//执行dao层的方法
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }


    //    三、添加用户对象
//    工具类设置了自动提交，这里增删改就不用再提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            // 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            int i = mapper.addUser(new User(20, "mako2", "i_love_mako"));//执行dao层的方法
           if(i>0){
               System.out.println("插入成功！！！！");
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }



    //    四、修改用户
//    工具类设置了自动提交，这里增删改就不用再提交事务
    @Test
    public void updateUser(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            // 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            int i = mapper.updateUser(new User(20,"TUUT","123456789"));//执行dao层的方法
            if(i>0){
                System.out.println("修改成功！！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }


    //    五、删除用户
//    工具类设置了自动提交，这里增删改就不用再提交事务
    @Test
    public void deleteUser(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            // 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            int i = mapper.deleteUser(20);
            if(i>0){
                System.out.println("删除成功！！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }
















}
