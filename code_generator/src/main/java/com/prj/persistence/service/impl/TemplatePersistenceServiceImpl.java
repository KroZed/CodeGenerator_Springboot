package com.prj.persistence.service.impl;
import org.springframework.stereotype.Service;
import com.prj.common.PersistenceServiceBaseImpl;
import com.prj.persistence.entity.Template;
import com.prj.persistence.mapper.TemplateMapper;
import com.prj.persistence.service.TemplatePersistenceService;
@Service
public class TemplatePersistenceServiceImpl extends PersistenceServiceBaseImpl<TemplateMapper, Template> implements TemplatePersistenceService{
}
