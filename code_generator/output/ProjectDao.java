package com.prj.dao;
import com.prj.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface ProjectDao {
    Project getById(@Param("Id") Object Id);
    List<Project> findAll();
    int insert(Project Project);
    int update(Project Project);
    int deleteById(@Param("Id") Object Id);
} 
