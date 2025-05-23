package com.prj.persistence;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.prj.persistence.entity.*;
import com.prj.persistence.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service public class EntityHelper {
    @Autowired public ProjectPersistenceService projectPersistenceService;
    public QueryWrapper<Project> projectQueryWrapper(){ return new QueryWrapper<Project>().eq(Project.DELETED, false);}
    public Project setFks(Project e){ 
        if(e==null){ return e; }
        e.setOwner(userPersistenceService.getById(e.getOwnerId()));
        setFks(e.getOwner());
        e.setTemplate(templatePersistenceService.getById(e.getTemplateId()));
        setFks(e.getTemplate());
        return e; 
    }
    public List<Project> setProjectFks(List<Project> list){
        if(list==null){ return list; }
        for(Project e : list){
            setFks(e);
        }
        return list;
    }
    public List<Long> listProjectIds(QueryWrapper<Project> criteria){
        return projectPersistenceService.list(criteria).stream().map(c->c.getId()).distinct().collect(Collectors.toList());
    }
    public List<Long> listProjectIds(QueryWrapper<Project> criteria, boolean forSearch){
        List<Long> ids = listProjectIds(criteria);
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public List<Project> listProjects(QueryWrapper<Project> criteria){
        List<Project> list = projectPersistenceService.list(criteria);
        setProjectFks(list);
        return list;
    }
    public long countProject(QueryWrapper<Project> criteria){
        return projectPersistenceService.count(criteria);
    }
    public Project save(Project e){
        projectPersistenceService.save(e);
        return e;
    }
    public Project update(Project e){
        projectPersistenceService.updateById(e);
        return e;
    }
    public Project delete(Project e){
        e.setDeleted(true);
        projectPersistenceService.updateById(e);
        return e;
    }
    public Project saveOrUpdate(Project e){
        projectPersistenceService.saveOrUpdate(e);
        return e;
    }
    public List<Long> listProjectIds(QueryWrapper<Project> criteria, boolean forSearch, Function<Project, Long> idSelector){
        List<Long> ids = new ArrayList<>();
        List<Project> list = listProjects(criteria);
        for(Project e : list){
            ids.add(idSelector.apply(e));
        }
        ids = ids.stream().distinct().collect(Collectors.toList());
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public Project getProjectById(Long id){
        Project e = projectPersistenceService.getById(id);
        setFks(e);
        return e;
    }
    public void removeProject(Long id){
        projectPersistenceService.removeById(id);
    }
    public void deleteProjects(QueryWrapper<Project> criteria){
        List<Project> list = listProjects(criteria);
        for(Project e : list){ delete(e); }
    }
    public void deleteProjects(List<Long> ids){
        List<Project> list = listProjects(projectQueryWrapper().in(Project.ID, ids));
        for(Project e : list){ delete(e); }
    }
    @Autowired public UserPersistenceService userPersistenceService;
    public QueryWrapper<User> userQueryWrapper(){ return new QueryWrapper<User>().eq(User.DELETED, false);}
    public User setFks(User e){ 
        if(e==null){ return e; }
        return e; 
    }
    public List<User> setUserFks(List<User> list){
        if(list==null){ return list; }
        for(User e : list){
            setFks(e);
        }
        return list;
    }
    public List<Long> listUserIds(QueryWrapper<User> criteria){
        return userPersistenceService.list(criteria).stream().map(c->c.getId()).distinct().collect(Collectors.toList());
    }
    public List<Long> listUserIds(QueryWrapper<User> criteria, boolean forSearch){
        List<Long> ids = listUserIds(criteria);
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public List<User> listUsers(QueryWrapper<User> criteria){
        List<User> list = userPersistenceService.list(criteria);
        setUserFks(list);
        return list;
    }
    public long countUser(QueryWrapper<User> criteria){
        return userPersistenceService.count(criteria);
    }
    public User save(User e){
        userPersistenceService.save(e);
        return e;
    }
    public User update(User e){
        userPersistenceService.updateById(e);
        return e;
    }
    public User delete(User e){
        e.setDeleted(true);
        userPersistenceService.updateById(e);
        return e;
    }
    public User saveOrUpdate(User e){
        userPersistenceService.saveOrUpdate(e);
        return e;
    }
    public List<Long> listUserIds(QueryWrapper<User> criteria, boolean forSearch, Function<User, Long> idSelector){
        List<Long> ids = new ArrayList<>();
        List<User> list = listUsers(criteria);
        for(User e : list){
            ids.add(idSelector.apply(e));
        }
        ids = ids.stream().distinct().collect(Collectors.toList());
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public User getUserById(Long id){
        User e = userPersistenceService.getById(id);
        setFks(e);
        return e;
    }
    public void removeUser(Long id){
        userPersistenceService.removeById(id);
    }
    public void deleteUsers(QueryWrapper<User> criteria){
        List<User> list = listUsers(criteria);
        for(User e : list){ delete(e); }
    }
    public void deleteUsers(List<Long> ids){
        List<User> list = listUsers(userQueryWrapper().in(User.ID, ids));
        for(User e : list){ delete(e); }
    }
    @Autowired public TemplatePersistenceService templatePersistenceService;
    public QueryWrapper<Template> templateQueryWrapper(){ return new QueryWrapper<Template>().eq(Template.DELETED, false);}
    public Template setFks(Template e){ 
        if(e==null){ return e; }
        return e; 
    }
    public List<Template> setTemplateFks(List<Template> list){
        if(list==null){ return list; }
        for(Template e : list){
            setFks(e);
        }
        return list;
    }
    public List<Long> listTemplateIds(QueryWrapper<Template> criteria){
        return templatePersistenceService.list(criteria).stream().map(c->c.getId()).distinct().collect(Collectors.toList());
    }
    public List<Long> listTemplateIds(QueryWrapper<Template> criteria, boolean forSearch){
        List<Long> ids = listTemplateIds(criteria);
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public List<Template> listTemplates(QueryWrapper<Template> criteria){
        List<Template> list = templatePersistenceService.list(criteria);
        setTemplateFks(list);
        return list;
    }
    public long countTemplate(QueryWrapper<Template> criteria){
        return templatePersistenceService.count(criteria);
    }
    public Template save(Template e){
        templatePersistenceService.save(e);
        return e;
    }
    public Template update(Template e){
        templatePersistenceService.updateById(e);
        return e;
    }
    public Template delete(Template e){
        e.setDeleted(true);
        templatePersistenceService.updateById(e);
        return e;
    }
    public Template saveOrUpdate(Template e){
        templatePersistenceService.saveOrUpdate(e);
        return e;
    }
    public List<Long> listTemplateIds(QueryWrapper<Template> criteria, boolean forSearch, Function<Template, Long> idSelector){
        List<Long> ids = new ArrayList<>();
        List<Template> list = listTemplates(criteria);
        for(Template e : list){
            ids.add(idSelector.apply(e));
        }
        ids = ids.stream().distinct().collect(Collectors.toList());
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public Template getTemplateById(Long id){
        Template e = templatePersistenceService.getById(id);
        setFks(e);
        return e;
    }
    public void removeTemplate(Long id){
        templatePersistenceService.removeById(id);
    }
    public void deleteTemplates(QueryWrapper<Template> criteria){
        List<Template> list = listTemplates(criteria);
        for(Template e : list){ delete(e); }
    }
    public void deleteTemplates(List<Long> ids){
        List<Template> list = listTemplates(templateQueryWrapper().in(Template.ID, ids));
        for(Template e : list){ delete(e); }
    }
    @Autowired public TemplateFilePersistenceService templateFilePersistenceService;
    public QueryWrapper<TemplateFile> templateFileQueryWrapper(){ return new QueryWrapper<TemplateFile>().eq(TemplateFile.DELETED, false);}
    public TemplateFile setFks(TemplateFile e){ 
        if(e==null){ return e; }
        e.setTemplate(templatePersistenceService.getById(e.getTemplateId()));
        setFks(e.getTemplate());
        return e; 
    }
    public List<TemplateFile> setTemplateFileFks(List<TemplateFile> list){
        if(list==null){ return list; }
        for(TemplateFile e : list){
            setFks(e);
        }
        return list;
    }
    public List<Long> listTemplateFileIds(QueryWrapper<TemplateFile> criteria){
        return templateFilePersistenceService.list(criteria).stream().map(c->c.getId()).distinct().collect(Collectors.toList());
    }
    public List<Long> listTemplateFileIds(QueryWrapper<TemplateFile> criteria, boolean forSearch){
        List<Long> ids = listTemplateFileIds(criteria);
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public List<TemplateFile> listTemplateFiles(QueryWrapper<TemplateFile> criteria){
        List<TemplateFile> list = templateFilePersistenceService.list(criteria);
        setTemplateFileFks(list);
        return list;
    }
    public long countTemplateFile(QueryWrapper<TemplateFile> criteria){
        return templateFilePersistenceService.count(criteria);
    }
    public TemplateFile save(TemplateFile e){
        templateFilePersistenceService.save(e);
        return e;
    }
    public TemplateFile update(TemplateFile e){
        templateFilePersistenceService.updateById(e);
        return e;
    }
    public TemplateFile delete(TemplateFile e){
        e.setDeleted(true);
        templateFilePersistenceService.updateById(e);
        return e;
    }
    public TemplateFile saveOrUpdate(TemplateFile e){
        templateFilePersistenceService.saveOrUpdate(e);
        return e;
    }
    public List<Long> listTemplateFileIds(QueryWrapper<TemplateFile> criteria, boolean forSearch, Function<TemplateFile, Long> idSelector){
        List<Long> ids = new ArrayList<>();
        List<TemplateFile> list = listTemplateFiles(criteria);
        for(TemplateFile e : list){
            ids.add(idSelector.apply(e));
        }
        ids = ids.stream().distinct().collect(Collectors.toList());
        if(forSearch){ids.add(-1L);}
        return ids;
    }
    public TemplateFile getTemplateFileById(Long id){
        TemplateFile e = templateFilePersistenceService.getById(id);
        setFks(e);
        return e;
    }
    public void removeTemplateFile(Long id){
        templateFilePersistenceService.removeById(id);
    }
    public void deleteTemplateFiles(QueryWrapper<TemplateFile> criteria){
        List<TemplateFile> list = listTemplateFiles(criteria);
        for(TemplateFile e : list){ delete(e); }
    }
    public void deleteTemplateFiles(List<Long> ids){
        List<TemplateFile> list = listTemplateFiles(templateFileQueryWrapper().in(TemplateFile.ID, ids));
        for(TemplateFile e : list){ delete(e); }
    }
}
