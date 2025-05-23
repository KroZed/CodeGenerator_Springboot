package com.prj.dao;
import com.prj.entity.Template;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface TemplateDao {
    Template getById(@Param("Id") Object Id);
    List<Template> findAll();
    int insert(Template Template);
    int update(Template Template);
    int deleteById(@Param("Id") Object Id);
} 
