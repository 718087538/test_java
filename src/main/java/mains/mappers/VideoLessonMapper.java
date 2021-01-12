package mains.mappers;

import mains.model.videoChapter;
import mains.model.videoLesson;
import org.apache.ibatis.annotations.Insert;

public interface VideoLessonMapper {
    @Insert("insert into video_lesson (first_category_id, second_category_id,video_course_id,chapter_id,name,tag_id) values(#{first_category_id}, #{second_category_id},#{video_course_id}, #{chapter_id}, #{name}, #{tag_id})")
    public int addVideoLesson(videoLesson videoLesson);
}
