package com.will.demo.mapper;

import com.will.demo.vo.Girl;
import com.will.demo.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
//user 持久化接口
@Component(value = "girlMapper")
public interface GirlMapper {

    @Insert("INSERT INTO girl(name, school) VALUES(#{name}, #{school})")
    Integer insertGirl(Girl girl);
}
