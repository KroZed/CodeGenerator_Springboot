package com.prj.dao;
import com.prj.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface UserDao {
    User getById(@Param("Id") Object Id);
    List<User> findAll();
    int insert(User User);
    int update(User User);
    int deleteById(@Param("Id") Object Id);
} 
