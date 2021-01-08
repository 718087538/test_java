package mains.controller;

import mains.mappers.VideoChapterMapper;
import mains.model.videoChapter;
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
public class VideoChapter {

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


    @PostMapping("/admin/addVideoChapter")
    public Result addVideoChapter(int first_category_id,int second_category_id,int video_course_id,String chapter_name){

        videoChapter video_chapter = new videoChapter();
        video_chapter.setFirst_category_id(first_category_id);
        video_chapter.setSecond_category_id(second_category_id);
        video_chapter.setVideo_course_id(video_course_id);
        video_chapter.setChapter_name(chapter_name);
        VideoChapterMapper videoChapterMapper = sqlSession.getMapper(VideoChapterMapper.class);

        videoChapterMapper.addVideoChapter(video_chapter);
        return Result.ok("成功");
    }


}
