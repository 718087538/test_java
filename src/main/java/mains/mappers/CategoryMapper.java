package mains.mappers;

import mains.model.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CategoryMapper {
    @Insert("insert into second_category (first_category_id,second_category) values(#{first_category_id},#{second_category})")
    public int addSecondCategory(SecondCategory second_category);
    @Select("select * from second_category")
    public  List<SecondCategory> getSecondCategory();


    @Update("update first_category set first_category=#{first_category} where id=#{id}")
    public int putFirstCategory(FisrtCategory first_category);

    @Insert("insert into first_category (first_category) values(#{first_category})")
    public int addFirstCategory(FisrtCategory first_category);

    @Select("select * from first_category where trim(first_category)!=''")
    public List<FisrtCategory> getCategory();
}
