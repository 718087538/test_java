package mains.model;

public class SecondCategory {
    private int id;
    private int first_category_id;
    private String second_category;
    private int id_del;

    public SecondCategory() {

    }
    public SecondCategory(int id){
        this.id = id;
    }
    public SecondCategory(int first_category_id, String second_category) {
        this.first_category_id = first_category_id;
        this.second_category = second_category;
    }
//    public  SecondCategory(int id, String second_category) {
//        this.id = id;
//        this.second_category = second_category;
//    }
    public SecondCategory(int id, int first_category_id, String second_category, int id_del) {
        this.id = id;
        this.first_category_id = first_category_id;
        this.second_category = second_category;
        this.id_del = id_del;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getfirst_category_id() {
        return first_category_id;
    }

    public void setfirst_category_id(int first_category_id) {
        this.first_category_id = first_category_id;
    }

    public String getSecond_category() {
        return second_category;
    }

    public void setSecond_category(String second_category) {
        this.second_category = second_category;
    }

    public int getId_del() {
        return id_del;
    }

    public void setId_del(int id_del) {
        this.id_del = id_del;
    }


}
