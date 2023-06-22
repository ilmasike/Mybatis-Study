package com.kuang.test;

import com.kuang.dao.UserMapper;
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
}
