package ecnc.schedulesystembackend.dao;

import ecnc.schedulesystembackend.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where id = #{id}")
    User getUserById(Integer id);

    @Insert("insert into user (name,password,age,sex) values (#{name},#{password},#{age},#{sex})")
    int addUser(User user);

    @Select("select * from user where name=#{name}")
    User getUserByName(String name);

    @Update("update user set password = #{password} where name = #{name}")
    int updatePassword(@Param("name") String name, @Param("password") String password);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") Integer id);
}
