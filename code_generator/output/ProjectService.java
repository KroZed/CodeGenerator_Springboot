package com.prj.service;
import com.prj.entity.Project;
import java.util.List;
public interface ProjectService {
    Project getById(Object Id);
    List<Project> findAll();
    boolean save(Project Project);
    boolean update(Project Project);
    boolean deleteById(Object Id);
} 
