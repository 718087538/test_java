package mains.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import mains.model.FisrtCategory;
import mains.model.*;
import mains.mappers.CategoryMapper;
import mains.other.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@RestController
public class Category {
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

    //一级分类
    @GetMapping("/admin/firstCategory")
    public Result getFirstCategory(){
        FisrtCategory fisrtCategory = new FisrtCategory();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<FisrtCategory> data = categoryMapper.getFirstCategory();
        return Result.ok(data);
    }
    @PostMapping("/admin/firstCategory")
    public Result addFirstCategory(String first_category){
        FisrtCategory fisrtCategory = new FisrtCategory(first_category);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.addFirstCategory(fisrtCategory);
        return Result.ok("成功插入");
    }
    @PutMapping("/admin/firstCategory")
    public Result putFirstCategory(int id,String first_category){
        FisrtCategory fisrtCategory = new FisrtCategory(id,first_category);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.putFirstCategory(fisrtCategory);
        return Result.ok("修改成功");
    }
    @DeleteMapping("/admin/firstCategory")
    public Result delFirstCategory(int id){
        FisrtCategory fisrtCategory = new FisrtCategory();
        fisrtCategory.setId(id);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.delFirstCategory(fisrtCategory);
        return Result.ok("删除成功");
    }


    //二级分类
    @GetMapping("/admin/secondCategory")
    public Result getSecondCategory(){
        SecondCategory secondCategory = new SecondCategory();
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<SecondCategory> category = categoryMapper.getSecondCategory();
        return Result.ok(category);
    }

    @PostMapping("/admin/secondCategory")
    public Result addSecondCategory(int first_category_id,String second_category){
        SecondCategory secondCategory = new SecondCategory();
        secondCategory.setfirst_category_id(first_category_id);
        secondCategory.setSecond_category(second_category);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.addSecondCategory(secondCategory);
        return Result.ok("成功新增二级标签");
    }

    @DeleteMapping("/admin/secondCategory")
    public Result delSecondCategory(int id){
        SecondCategory secondCategory = new SecondCategory();
        secondCategory.setId(id);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.delSecondCategory(secondCategory);
        return Result.ok("删除成功");
    }
    @PutMapping("/admin/secondCategory")
    public Result putSecondCategory(int id,int first_category_id,String second_category){
        SecondCategory secondCategory = new SecondCategory();

        secondCategory.setId(id);
        secondCategory.setfirst_category_id(first_category_id);
        secondCategory.setSecond_category(second_category);

        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.putSecondCategory(secondCategory);
        return Result.ok("删除成功");
    }




    //下面的暂时不使用，测试用的

//    @GetMapping("/admin/secondCategory")
//    public List<SecondCategory> secondCategory(){
//        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
//        List<SecondCategory> categories = categoryMapper.getSecondCategory();
//        return  categories;
//    }

//    @DeleteMapping("/admin/secondCategory")
//    public Result delSecondCategory(int id){
//        SecondCategory secondCategory = new SecondCategory(id);
//        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
//        categoryMapper.delSecondCategory(secondCategory);
//        return Result.ok("删除成功");
//    }

//    @PutMapping("/admin/secondCategory")
//    public Result putSecondCategory(int id,String second_category){
//        System.out.println("id的值是："+id+"名字是"+second_category);
//
//        SecondCategory secondCategory = new SecondCategory();//???参数类型一样，值不一样，怎么办?
//        secondCategory.setId(id);
//        secondCategory.setSecond_category(second_category);
//        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
//        System.out.println("对象是"+categoryMapper);
//        categoryMapper.putSecondCategory(secondCategory);
//        return Result.ok("修改成功");
//    }

    //新建课程/教程
    @PostMapping("/admin/lesson")
    public Result addLesson(int first_category_id,int second_category_id,String title,String cover,String direction){
        Lesson lesson = new Lesson();
        System.out.println("参数"+first_category_id+","+second_category_id);
        lesson.setFirst_category_id(first_category_id);
        lesson.setSecond_category_id(second_category_id);
        lesson.setTitle(title);
        lesson.setCover(cover);
        lesson.setDirection(direction);

//        secondCategory.setSecond_category(second_category);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        System.out.println("对象是"+categoryMapper);
        categoryMapper.addLesson(lesson);
        return Result.ok("新增成功");
    }

    //后台查询课程列表
    @GetMapping("/admin/lesson")
    public Result getLesson(String title){
        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        System.out.println("title-------------"+title);
        CategoryMapper lessonMapper = sqlSession.getMapper(CategoryMapper.class);
        List<Lesson> lessons = lessonMapper.getLesson(lesson);
//        return lessons;
        return Result.ok(lessons);
    }
}
