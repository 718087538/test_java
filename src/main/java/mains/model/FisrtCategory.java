package mains.model;

public class FisrtCategory {
    private String first_category;
    private int id;



    public FisrtCategory() {

    }

    public FisrtCategory(String first_category) {
        this.first_category = first_category;
    }

    public FisrtCategory(int id ,String first_category) {
        this.id = id;
        this.first_category = first_category;
    }

    public String getFirst_category() {
        return first_category;
    }

    public void setFirst_category(String first_category) {
        this.first_category = first_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
