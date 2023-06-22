import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家

            User user = mapper.queryUserById(1);
            System.out.println(user);
//            查了1号，有缓存，我们这里接着进行修改操作：会发现只要增删改，缓存就失效了（下面的查询语句会再次走sql）
             mapper.updateUser(new User(2, "makomako", "i_love_you"));
            System.out.println("================================================");
            sqlSession.clearCache();//手动清除缓存
            User user2 = mapper.queryUserById(1);
            System.out.println(user2);

            System.out.println(user==user2);
/*   发现sql其实只走了一次：
Opening JDBC Connection
==>  Preparing: select * from mybatis.user WHERE id=?
==> Parameters: 1(Integer)
User(id=1, name=卡卡羅特, pwd=dragon ball)
================================================
User(id=1, name=卡卡羅特, pwd=dragon ball)
true
Closing JDBC Connection [com.mysql.jdbc.JDBC4Connection@5c18298f]
* */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }


    @Test   /*看下在开启二级缓存的情况下， sql执行几次：*/
    public void cache(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        SqlSession sqlSession2 = null;
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            sqlSession2  = MybatisUtils.getSqlSession();


//        2.执行sql:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);//找到dao层；

            User user = mapper.queryUserById(1);/*第一次执行*/
            System.out.println(user);
            sqlSession.close();/*一级缓存的session结束，他会把缓存放到二级缓存中。*/
            System.out.println("======虽然是不同的sqlSession，但是是同一个mapper.xml=========================================================");
            System.out.println("===============================================================");
            User user2 = mapper2.queryUserById(1);  /*没有一级缓存，，此时有二级缓存：
            sql是否执行？会发现只查询一次*/
            System.out.println(user2);
            System.out.println(user==user2);/*二者是相同的。说明是缓存中获取的。*/
            sqlSession2.close();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }










}
