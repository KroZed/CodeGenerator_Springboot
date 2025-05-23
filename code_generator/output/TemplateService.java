package com.prj.service;
import com.prj.entity.Template;
import java.util.List;
public interface TemplateService {
    Template getById(Object Id);
    List<Template> findAll();
    boolean save(Template Template);
    boolean update(Template Template);
    boolean deleteById(Object Id);
} 
