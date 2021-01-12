package mains.model;

public class videoCourse {
    private int id;
    private int first_category_id;
    private int second_category_id;
    private int is_del;
    private int view_times;
    private String title;
    private String cover;
    private String direction;
    private int video_tag_id;

    public int getVideo_tag_id() {
        return video_tag_id;
    }

    public void setVideo_tag_id(int video_tag_id) {
        this.video_tag_id = video_tag_id;
    }

    public videoCourse() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getView_times() {
        return view_times;
    }

    public void setView_times(int view_times) {
        this.view_times = view_times;
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

    public int getIs_del() {
        return is_del;
    }

    public void setIs_del(int is_del) {
        this.is_del = is_del;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


}
