package com.prj.service;
import com.prj.entity.TemplateFile;
import java.util.List;
public interface TemplateFileService {
    TemplateFile getById(Object Id);
    List<TemplateFile> findAll();
    boolean save(TemplateFile TemplateFile);
    boolean update(TemplateFile TemplateFile);
    boolean deleteById(Object Id);
} 
