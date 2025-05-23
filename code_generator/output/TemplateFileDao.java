package com.prj.dao;
import com.prj.entity.TemplateFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface TemplateFileDao {
    TemplateFile getById(@Param("Id") Object Id);
    List<TemplateFile> findAll();
    int insert(TemplateFile TemplateFile);
    int update(TemplateFile TemplateFile);
    int deleteById(@Param("Id") Object Id);
} 
