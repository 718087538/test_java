package mains.mappers;

import mains.controller.VideoChapter;
import mains.course.Tag;
import mains.model.videoChapter;
import org.apache.ibatis.annotations.Insert;

public interface VideoChapterMapper {
    @Insert("insert into video_chapter (first_category_id, second_category_id,video_course_id,chapter_name) values(#{first_category_id}, #{second_category_id},#{video_course_id}, #{chapter_name})")
    public int addVideoChapter(videoChapter videoChapter);
}
