package com.kuang.test;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserDaoTest {
    //    获得日志对象。参数为当前类的class
    static Logger logger = Logger.getLogger(UserDaoTest.class);


    //    一、通过id查询对象
    @Test
    public void test(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
            logger.info("info：进入test方法");
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





    //    使用日志，进行测试：
    @Test
    public void testLog4j(){
        logger.info("info：进入selectUser方法");  //info，信息的意思。
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User userById  = mapper.getUserById(2);
        System.out.println(userById);
        session.close();



    }


    //二.2.1选择全部用户实现分页
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；

            HashMap<String, Integer> map = new HashMap<String, Integer>();
            map.put("startIndex",0);
            map.put("pageSize",2);
            List<User> userByLimit = mapper.getUserByLimit(map);//执行dao层的方法
            for (User user : userByLimit) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }



    //二.2.2  通过RowBounds分页（了解即可。老代码）
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:  不用再通过 UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
            int currentPage = 2; //第几页
            int pageSize = 2; //每页显示几个
            RowBounds rowBounds = new RowBounds((currentPage)*pageSize,pageSize);
//通过session.**方法进行传递rowBounds，[此种方式现在已经不推荐使用了]
            List<User> users = sqlSession.selectList("com.kuang.dao.UserMapper.getUserByRowBounds", null, rowBounds);
            for (User user: users){
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
