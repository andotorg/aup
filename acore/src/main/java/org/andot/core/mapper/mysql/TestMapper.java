package org.andot.core.mapper.mysql;

import org.andot.core.entity.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    @Insert("INSERT INTO demo (Name, Age) VALUES (#{name}, #{age})")
    Integer addTestInfo(@Param("name") String name, @Param("age") Integer age);

    @Select("SELECT id, name, age FROM demo")
    List<Demo> getTestInfoByList();

}
