package mains.course;

import com.power.common.util.UUIDUtil;
import mains.mappers.TagMapper;
import mains.other.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


@RestController
public class Course {
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


    @Autowired
    JdbcTemplate jdbcTemplate;

    @DeleteMapping("/ddd")
    public String dddd() {

        return "sdasd";
    }

    @GetMapping("/getcourse")
    public Person course() {

        // return "成功";
        return new Person("cnm2", 11);
    }

    @GetMapping("/api/admin/getcourse")
    public Result getcourse() {
        List<CourseList> courseLists = jdbcTemplate.query(
                "SELECT * FROM course",
                (rs, rowNum) -> new CourseList(
                        rs.getString("id"),
                        rs.getString("direction"),
                        rs.getString("classify"),
                        rs.getString("tag_id"),
                        rs.getString("view_times"),
                        rs.getString("video_src"),
                        rs.getString("cover"),
                        rs.getString("name")
                )
        );
//        return  courseLists;

        return Result.ok(courseLists);
    }

    @PostMapping("/api/admin/course")
    public String course(String mid, String direction, String classify, String tag_id, int view_times, String video_src, String cover, String name) {
        System.out.println(mid);
        if (mid == null || name == null) {
            return "mid,name不能为空";
        }
        jdbcTemplate.execute("INSERT INTO `course` (mid,direction,classify,tag_id,view_times,video_src,cover,name) VALUES ('" + mid + "', '" + direction + "','" + classify + "','" + tag_id + "','" + view_times + "','" + video_src + "','" + cover + "','" + name + "');");
//        jdbcTemplate.execute("INSERT INTO `course` VALUES ('123', '123','123','123','0');")
        return "成功";
    }

    @PostMapping("/admin/tag")
    public String addTag(String title) {
        System.out.println("调用tag  Get");
        String tag_id = UUIDUtil.getUuid32();
        Tag tag = new Tag(tag_id, title);
        TagMapper tagMapper = sqlSession.getMapper(TagMapper.class);
        String src = "mains.mappers.TagMapper.add";
        tagMapper.add(tag);

//      List<Tag> tag = tagMapper.getAll();

        return "成功";
    }

    @GetMapping("/admin/tag")
    public List<Tag> tag() {
        System.out.println("调用tag  Get");

        TagMapper tagMapper = sqlSession.getMapper(TagMapper.class);

        List<Tag> tag = tagMapper.getAll();

        return tag;
    }
}
