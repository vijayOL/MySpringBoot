package com.will.demo.mapper;

import com.will.demo.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
//user 持久化接口
@Component(value = "userMapper")
public interface UserMapper {
    @Select("Select * from t_user p where p.name = #{name}")
    User queryUserByName(@Param("name") String name);

    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    Integer addUser(@Param("name") String name,@Param("password") String password,@Param("phone") String phone);
}
