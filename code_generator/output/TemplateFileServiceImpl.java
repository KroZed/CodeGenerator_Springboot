package com.prj.service.impl;
import com.prj.dao.TemplateFileDao;
import com.prj.entity.TemplateFile;
import com.prj.service.TemplateFileService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class TemplateFileServiceImpl implements TemplateFileService {
    @Autowired
    private TemplateFileDao TemplateFileDao;
    @Override
    public TemplateFile getById(Object Id) {
        return TemplateFileDao.getById(Id);
    }
    @Override
    public List<TemplateFile> findAll() {
        return TemplateFileDao.findAll();
    }
    @Override
    public boolean save(TemplateFile TemplateFile) {
        return TemplateFileDao.insert(TemplateFile) > 0;
    }
    @Override
    public boolean update(TemplateFile TemplateFile) {
        return TemplateFileDao.update(TemplateFile) > 0;
    }
    @Override
    public boolean deleteById(Object Id) {
        return TemplateFileDao.deleteById(Id) > 0;
    }
} 
