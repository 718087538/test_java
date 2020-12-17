package mains.category;

import mains.model.FisrtCategory;
import mains.mappers.CategoryMapper;
import mains.other.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/t100")
    public String t100() {

         return "t1000";
    }
    @PutMapping("/admin/category")
    public Result putFirstCategory(int id,String first_category){
        FisrtCategory fisrtCategory = new FisrtCategory(id,first_category);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.putFirstCategory(fisrtCategory);
        return Result.ok("修改成功");
    }
    @PostMapping("/admin/category")
    public Result addFirstCategory(String first_category){
        FisrtCategory fisrtCategory = new FisrtCategory(first_category);
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        categoryMapper.addFirstCategory(fisrtCategory);
        return Result.ok("成功插入");
    }



    @GetMapping("/admin/category")
    public List<FisrtCategory> category(){
        CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
        List<FisrtCategory> category = categoryMapper.getCategory();
        return category;
    }
}
