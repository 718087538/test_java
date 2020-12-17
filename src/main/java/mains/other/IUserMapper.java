package mains.other;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {
//    @Insert("insert into users (name, age) value(#{name}, #{age})")
//    public int add(Customer user);
//
//    @Delete("delete from users where id=#{id}")
//    public int deleteById(int id);
//
//    @Update("update users set name=#{name}, age=#{age} where id=#{id}")
//    public int update(Customer user);
//
//    @Select("select * from users where id=#{id}")
//    public Customer getById(int id);

    @Select("select * from customer")
    public List<Customer> getAll();
}
