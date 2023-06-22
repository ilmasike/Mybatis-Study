package com.kuang.dao;

import com.kuang.pojo.Blog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //    1.环境准备，先在数据库中插入数据：

    int addBlog(Blog blog);

    //    2.IF   例子：查询博客
    List<Blog> queryBlogIF(Map map);


    //    3.Choose  例子：查询
    List<Blog> queryBlogChoose(Map map);

//    3.set  例子：更新博客
    int updateBlog(Map map);

//    4.查询第1-2-3号记录的博客：
    List<Blog> queryBlogForeach(Map map);


}
