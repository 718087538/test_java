package mains.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;


@RestController
public class Test {

    @GetMapping("/test")
    public String addDate() {
        System.out.println("hello world");
        return "hello world";
    }

    @GetMapping("/test/readfile")
    public void readfilde() throws IOException {
        String path = "../public";
        File f = new File(path,"t.png"); // 建立File变量,并设定由f变量引用
        System.out.println("文件长度：" + f.length() + "字节");
        System.out.println("文件或者目录：" + (f.isFile() ? "是文件" : "不是文件"));
        System.out.println("文件或者目录：" + (f.isDirectory() ? "是目录" : "不是目录"));
        System.out.println("是否可读：" + (f.canRead() ? "可读取" : "不可读取"));
        System.out.println("是否可写：" + (f.canWrite() ? "可写入" : "不可写入"));
        System.out.println("是否隐藏：" + (f.isHidden() ? "是隐藏文件" : "不是隐藏文件"));
        System.out.println("最后修改日期：" + new Date(f.lastModified()));
        System.out.println("文件名称：" + f.getName());
        System.out.println("文件路径：" + f.getPath());
        System.out.println("绝对路径：" + f.getAbsolutePath());

        File f2 = new File("src/main/java/mains/public/t2.txt"); // 创建指向文件的File对象
        if (f2.exists()) // 判断文件是否存在
        {
            f2.delete(); // 存在则先删除
        }
        f2.createNewFile(); // 再创建
    }

    @PostMapping("/testupimg")
    public String testupimg(MultipartFile aaa) throws IOException {
        String oldName = aaa.getOriginalFilename();
        System.out.println("旧的文件名：" + oldName);
//        String path = "E:/kingw2/test_java/src/main/resources/static/files/" +oldName;
        String path = "src/main/resources/static/files/" +oldName;
//        String path = "src/main/static/files/" +oldName;

        //创建文件路径
        File dest = new File(path);
        aaa.transferTo(dest); //保存文件
//        aaa.transferTo(new File("/static/files","t3.png"));
        return oldName;
    }
}
