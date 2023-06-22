import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutil;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {




    @Test
    public void StudentMapperdemo02(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家

            Blog blog = new Blog();
            blog.setId(IDutil.genId());
            blog.setTitle("Mybatis如此简单");
            blog.setAuthor("狂神说");
            blog.setCreateTime(new Date());
            blog.setViews(9999);
            mapper.addBlog(blog);
            blog.setId(IDutil.genId());
            blog.setTitle("Java如此简单");
            mapper.addBlog(blog);
            blog.setId(IDutil.genId());
            blog.setTitle("Spring如此简单");
            mapper.addBlog(blog);
            blog.setId(IDutil.genId());
            blog.setTitle("微服务如此简单");
            mapper.addBlog(blog);





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }



    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            Map<Object, String> map = new HashMap<Object, String>();
//            map.put("title","Spring如此简单");
            map.put("author","狂神说");
            List<Blog> blogs = mapper.queryBlogIF(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }


    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            Map<Object, String> map = new HashMap<Object, String>();
            map.put("author","狂神说");
            map.put("title","Mybatis如此简单");
            map.put("views","1000");//choose，故只会选择其中一个条件进行执行。
            List<Blog> blogs = mapper.queryBlogChoose(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }






    @Test
    public void updateBlog(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            Map<Object, String> map = new HashMap<Object, String>();
            map.put("title","动态223SQL");
            map.put("author","秦疆");
            map.put("id","3b33542367f445a3b97f06b468ee9669");



            int i = mapper.updateBlog(map);
            if(i>0){
                System.out.println("修改成功！");
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }







    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {
//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            Map  map = new HashMap ();
            List<Integer> ids = new ArrayList<Integer>(); //新建一个集合，关于id遍历的。
            ids.add(1);
            ids.add(2);
            map.put("ids",ids);   //map里面装 集合



            List<Blog> blogs = mapper.queryBlogForeach(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }









}
