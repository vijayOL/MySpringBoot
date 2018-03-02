package com.will.demo.dao;

import com.will.demo.vo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GirlDao extends JpaRepository<Girl,Integer>{
    List<Girl> getGirlsByName(String name);

    @Query(value = "select * from Girl where name=?1 and school=?2",nativeQuery = true)
    Girl queryByNameAndSchool(String name,String school);

    @Query(value = "select * from Girl where name= :name and school= :school",nativeQuery = true)
    Girl queryByNameAndSchool1(@Param("name") String name, @Param("school") String school);

    @Query(value = "select * from Girl where name like %:name%",nativeQuery = true)
    List<Girl> queryGirlsLikeFirstName(@Param("name") String name);

}
