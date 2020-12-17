package mains.mappers;

import mains.course.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {
    @Insert("insert into tag (tag_id, title) values(#{tag_id}, #{title})")
    public int add(Tag tag);


    @Select("select * from tag")
    public List<Tag> getAll();

}
