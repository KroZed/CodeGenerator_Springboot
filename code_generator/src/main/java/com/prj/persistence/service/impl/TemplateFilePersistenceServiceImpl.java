package com.prj.persistence.service.impl;
import org.springframework.stereotype.Service;
import com.prj.common.PersistenceServiceBaseImpl;
import com.prj.persistence.entity.TemplateFile;
import com.prj.persistence.mapper.TemplateFileMapper;
import com.prj.persistence.service.TemplateFilePersistenceService;
@Service
public class TemplateFilePersistenceServiceImpl extends PersistenceServiceBaseImpl<TemplateFileMapper, TemplateFile> implements TemplateFilePersistenceService{
}
