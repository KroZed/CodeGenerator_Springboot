package com.prj.service.impl;
import com.prj.dao.TemplateDao;
import com.prj.entity.Template;
import com.prj.service.TemplateService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class TemplateServiceImpl implements TemplateService {
    @Autowired
    private TemplateDao TemplateDao;
    @Override
    public Template getById(Object Id) {
        return TemplateDao.getById(Id);
    }
    @Override
    public List<Template> findAll() {
        return TemplateDao.findAll();
    }
    @Override
    public boolean save(Template Template) {
        return TemplateDao.insert(Template) > 0;
    }
    @Override
    public boolean update(Template Template) {
        return TemplateDao.update(Template) > 0;
    }
    @Override
    public boolean deleteById(Object Id) {
        return TemplateDao.deleteById(Id) > 0;
    }
} 
