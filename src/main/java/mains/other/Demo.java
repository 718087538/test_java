package mains.other;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@RestController
@Slf4j
public class Demo {
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

    @RequestMapping("/hello")//不限定请求方式
    public List<Customer> hello() {
        System.out.println("调用hello");

        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);

        List<Customer> all = userMapper.getAll();
        all.stream().forEach(System.out::println);
//        List<Customer> customerList = jdbcTemplate.query(
//                "SELECT * FROM user",
//                (rs, rowNum) -> new Customer(rs.getString("name"),rs.getString("password"))
//        );
//        return customerList;
        return all;

    }

    @PostMapping("/addDate")
    public void addDate(String a) {
        System.out.println("2222");
        jdbcTemplate.execute("INSERT INTO `user` VALUES ('" + a + "', '11','11','111');");
    }

    @PostMapping("/addSentence")
    public String addSentence(String content) {
        jdbcTemplate.execute("INSERT  INTO `sentence` VALUES ('" + content + "' ,'0')");
        return "成功";
    }

    @GetMapping("/getSentence")
    public List<Sentence> getSentence() {
        List<Sentence> senList = jdbcTemplate.query(
                "SELECT * FROM sentence",
                (rs, rowNum) -> new Sentence(rs.getString("content"))
        );
        return senList;
    }

    @RequestMapping("/course")
    public void course() {
        System.out.println("增加课程");
        jdbcTemplate.execute("INSERT INTO `course` VALUES ('11', '11','11','111','222');");
    }
}
