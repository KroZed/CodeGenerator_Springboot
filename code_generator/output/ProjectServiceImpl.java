package com.prj.service.impl;
import com.prj.dao.ProjectDao;
import com.prj.entity.Project;
import com.prj.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao ProjectDao;
    @Override
    public Project getById(Object Id) {
        return ProjectDao.getById(Id);
    }
    @Override
    public List<Project> findAll() {
        return ProjectDao.findAll();
    }
    @Override
    public boolean save(Project Project) {
        return ProjectDao.insert(Project) > 0;
    }
    @Override
    public boolean update(Project Project) {
        return ProjectDao.update(Project) > 0;
    }
    @Override
    public boolean deleteById(Object Id) {
        return ProjectDao.deleteById(Id) > 0;
    }
} 
