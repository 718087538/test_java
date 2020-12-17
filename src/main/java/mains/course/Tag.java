package mains.course;

public class Tag {
    private String tag_id;
    private String title;

    public Tag() {

    }
    public Tag(String tag_id, String title) {
        this.tag_id = tag_id;
        this.title = title;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
