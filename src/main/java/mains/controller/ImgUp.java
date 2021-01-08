package mains.controller;

import cn.hutool.core.util.IdUtil;
import mains.mappers.CategoryMapper;
import mains.mappers.ImgUpMapper;
import mains.model.imgUp;
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
public class ImgUp {

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

    @GetMapping("/test000")
    public String test(){
        return "111111111";
    }

    @PostMapping("/upImg")
    public Result testupimg(MultipartFile img) throws IOException {
        String oldName = img.getOriginalFilename();
        System.out.println("旧的文件名：" + oldName);
//        String path = "E:/kingw2/test_java/src/main/resources/static/files/" +oldName;//可行

        String dir = System.getProperty("user.dir");
        String suffix ="." + oldName.substring(oldName.lastIndexOf(".") + 1);//文件后缀

        String uuid = IdUtil.simpleUUID();
        String filePath = dir + "/src/main/resources/static/image/" + uuid + suffix;
//        String filePath = dir + "/src/main/resources/static/image/"  + oldName;
        String path = "/image/" + uuid + suffix;
        //创建文件路径
        File dest = new File(filePath);
        img.transferTo(dest); //保存文件

        imgUp img_up = new imgUp();
        img_up.setPath(path);
        img_up.setName(oldName);
        ImgUpMapper imgUpMapper = sqlSession.getMapper(ImgUpMapper.class);

        imgUpMapper.addImgUp(img_up);
        return Result.ok(path);
    }


}
