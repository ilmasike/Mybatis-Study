package com.kuang.utils;
/*
* 工具类：1.把mybatis-config.xml资源加载进来
* 2.创建一个能执行sql的对象： return sqlSessionFactory.openSession();
*
* 这所有的，就相当于以前的jdbc的drivermanage等等对象。就能连接数据库了
* */
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//工具类：是为了获得官方文档中的sqlSessionFactory（此工厂必然是来构建sqlSession的。工厂是生产产品的，其产品就是sqlSession）
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {//静态代码块，让他一初始化就加载
        //1.拿到官方三行代码：这三句话是死代码。故弄成工具类：
//        1.1 使用mybatis第一步：获得官方文档中的sqlSessionFactory对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //        2.既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。SqlSession
//        提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();//我们就把sqlSession想象成操作数据库的对象。
    }




}
