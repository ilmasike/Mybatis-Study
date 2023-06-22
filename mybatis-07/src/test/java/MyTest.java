import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

        //    需求1，(老师)一对多（学生）：
        @Test
        public void StudentMapper(){
            SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
            try {

//        1.获得sqlSession对象
                sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
                TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
                Teacher teacher = mapper.getTeacher2(1);//执行dao层的方法
                System.out.println(teacher);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //        3.关闭资源
                sqlSession.close();
            }
        }
        /*结果：
        * Teacher(id=1, name=秦老师, students=[Student(id=1, name=小明, tid=1),
         Student(id=2, name=小红, tid=1), Student(id=3, name=小张, tid=1),
         Student(id=4, name=小李, tid=1), Student(id=5, name=小王, tid=1)])
        * */



    @Test
    public void StudentMapperdemo02(){
        SqlSession sqlSession = null;//我们就把sqlSession想象成操作数据库的对象。
        try {

//        1.获得sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
//        2.执行sql:
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);//找到dao层；
// 面向接口编程：我们拿到dao接口即可。毕竟dao和UserMapper.xml二者不分家
            Teacher teacher = mapper.getTeacher3(1);//执行dao层的方法
            System.out.println(teacher);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //        3.关闭资源
            sqlSession.close();
        }
    }






}
