package mains.model;

public class videoChapter {
    private int first_category_id;
    private int second_category_id;
    private int video_course_id;
    private int is_del;
    private String chapter_name;

    public videoChapter(){}

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

    public int getVideo_course_id() {
        return video_course_id;
    }

    public void setVideo_course_id(int video_course_id) {
        this.video_course_id = video_course_id;
    }

    public int getIs_del() {
        return is_del;
    }

    public void setIs_del(int is_del) {
        this.is_del = is_del;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }
}
