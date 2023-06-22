package com.kuang.test;

import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class TestDemo01 {


    //    一、测试配置是否成功
    @org.junit.Test
    public void getTeacher(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            Teacher teacher = mapper.getTeacher(1);//执行dao层的方法
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }

    //    二、* 需求1：获取所有学生信息，以及对应的所有老师的信息。:按查询嵌套处理(类似于子查询)-
    @org.junit.Test
    public void StudentMapper(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            List<Student> student = mapper.getStudent();//执行dao层的方法
            for (Student student1 : student) {
                System.out.println(student1);
            }




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }


    @org.junit.Test   //按结果嵌套处理
    public void StudentMapper2(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            List<Student> student = mapper.getStudent2();//执行dao层的方法
            for (Student student1 : student) {
                System.out.println(student1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }





}
