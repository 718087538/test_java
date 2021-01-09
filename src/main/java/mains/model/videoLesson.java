package mains.model;

public class videoLesson {
    private int id;
    private int first_category_id;
    private int second_category_id;
    private int chapter_id;
    private int video_course_id;
    private String name;
    private String tag_id;
    private String is_del;

    public videoLesson(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirst_category_id() {
        return first_category_id;
    }

    public void setFirst_category_id(int first_category_id) {
        this.first_category_id = first_category_id;
    }

    public int getSecond_category_id() {
        return second_category_id;
    }

    public void setSecond_category_id(int second_category_id) {
        this.second_category_id = second_category_id;
    }

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

    public int getVideo_course_id() {
        return video_course_id;
    }

    public void setVideo_course_id(int video_course_id) {
        this.video_course_id = video_course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }
}
