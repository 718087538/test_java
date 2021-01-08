package mains.mappers;

import mains.model.*;
import org.apache.ibatis.annotations.Insert;

public interface ImgUpMapper {


    @Insert("insert into img_up (url, name,path) values(#{url}, #{name}, #{path})")
    public int addImgUp(imgUp imgup);


    @Insert("insert into lesson (first_category_id,second_category_id,title,cover,direction) values(#{first_category_id},#{second_category_id},#{title},#{cover},#{direction})")
    public int addLesson(Lesson Lesson);
}
