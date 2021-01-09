package mains.controller;

import cn.hutool.core.util.IdUtil;
import mains.mappers.CategoryMapper;
import mains.mappers.ImgUpMapper;
import mains.mappers.VideoCourseMapper;
import mains.mappers.VideoLessonMapper;
import mains.model.imgUp;
import mains.model.videoCourse;
import mains.model.videoLesson;
import mains.other.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

@RestController
public class VideoCourse {

    static SqlSessionFactory sessionFactory = null;
    static SqlSession sqlSession = null;

    static {
        String resource = "mybatisConfig.xml";
        // 加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建sqlSession的工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession，默认是手动提交事务的，使用自动提交的话加上参数 true
        sqlSession = sessionFactory.openSession(true);
    }

    @PostMapping("/admin/addVideoCourse")
    public Result addVideoCourse(int first_category_id,int second_category_id,String title,String cover,String direction,int view_times,int video_tag_id ){

        videoCourse video_course = new videoCourse();
        video_course.setFirst_category_id(first_category_id);
        video_course.setSecond_category_id(second_category_id);
        video_course.setTitle(title);
        video_course.setCover(cover);
        video_course.setDirection(direction);
        video_course.setView_times(view_times);
        video_course.setVideo_tag_id(video_tag_id);
        VideoCourseMapper videoCourseMapper = sqlSession.getMapper(VideoCourseMapper.class);

        videoCourseMapper.addVideoCourse(video_course);
        return Result.ok("成功");
    }




}
