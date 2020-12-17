package mains.course;

/**
 * Person pojo
 *
 * @author fangjiehui created on 2020/09/18 19:51:49
 */
public class Person {
    private String name;
    private Integer code;

    Person(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

}
