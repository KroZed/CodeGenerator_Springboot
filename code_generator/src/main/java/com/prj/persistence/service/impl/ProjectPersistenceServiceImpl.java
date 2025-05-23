package com.prj.persistence.service.impl;
import org.springframework.stereotype.Service;
import com.prj.common.PersistenceServiceBaseImpl;
import com.prj.persistence.entity.Project;
import com.prj.persistence.mapper.ProjectMapper;
import com.prj.persistence.service.ProjectPersistenceService;
@Service
public class ProjectPersistenceServiceImpl extends PersistenceServiceBaseImpl<ProjectMapper, Project> implements ProjectPersistenceService{
}
