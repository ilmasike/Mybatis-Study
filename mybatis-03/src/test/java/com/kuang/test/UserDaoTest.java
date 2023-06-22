package com.kuang.test;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.List;

public class UserDaoTest {
    //    一、通过id查询对象
    @Test
    public void test(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            // 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            User userById = mapper.getUserById(1);//执行dao层的方法
            System.out.println(userById);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }
}
