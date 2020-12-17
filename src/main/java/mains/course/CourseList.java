package mains.course;

public class CourseList {

    private String id;
    private String direction;
    private String classify;
    private String tag_id;
    private String view_times;
    private String video_src;
    private String cover;
    private String name;

    public CourseList(String id, String direction, String classify, String tag_id, String view_times, String video_src, String cover, String name) {
        this.id = id;
        this.direction = direction;
        this.classify = classify;
        this.tag_id = tag_id;
        this.view_times = view_times;
        this.video_src = video_src;
        this.cover = cover;
        this.name = name;
    }

    public String getid() {
        return id;
    }

    public String getDirection() {
        return direction;
    }

    public String getClassify() {
        return classify;
    }

    public String getTag_id() {
        return tag_id;
    }

    public String getView_times() {
        return view_times;
    }

    public String getVideo_src() {
        return video_src;
    }

    public String getCover() {
        return cover;
    }

    public String getName() {
        return name;
    }

    public void setVideo_src(String video_src) {
        this.video_src = video_src;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public void setView_times(String view_times) {
        this.view_times = view_times;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "video_src='" + video_src + '\'' +
                "cover='" + cover + '\'' +
                "tag_id='" + tag_id + '\'' +
                '}';
    }

}
