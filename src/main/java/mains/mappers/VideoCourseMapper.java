package mains.mappers;

import mains.model.videoCourse;
import org.apache.ibatis.annotations.Insert;

public interface VideoCourseMapper {
    @Insert("insert into video_chapter (first_category_id, second_category_id,video_course_id,chapter_name) values(#{first_category_id}, #{second_category_id},#{video_course_id}, #{chapter_name})")
    public int addVideoCourse(videoCourse videoCourse);
}
