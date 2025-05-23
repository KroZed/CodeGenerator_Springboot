package com.prj.api_gen;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.prj.util.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import java.time.*;
import com.prj.common.*;
import com.prj.config.*;
import com.prj.enums.*;
import com.prj.persistence.entity.*;
import com.prj.persistence.service.*;
import com.prj.util.*;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiParam;
import java.util.*;
public abstract class AbstractProjectApiControllerGen extends AbstractApiController<Project> {
    private final static Logger logger = LoggerFactory.getLogger(AbstractProjectApiControllerGen.class);
    @Autowired protected ProjectPersistenceService projectPersistenceService;
    @Autowired protected com.prj.persistence.EntityHelper entityHelper;
	@Autowired protected TransactionUtil transactionUtil;
	@Override protected PersistenceServiceBase<Project> getPersistenceService() { return projectPersistenceService; }
	@Override protected void setConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
			criteria.eq(Project.DELETED, false);
			QueryWrapperHelper.setCondition(criteria, request, Project.ID, "id", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, Project.ID, "idFrom", CriteriaOperatorEnum.GreaterOrEquals);
		QueryWrapperHelper.setCondition(criteria, request, Project.ID, "idTo", CriteriaOperatorEnum.LessOrEqual);
		QueryWrapperHelper.setCondition(criteria, request, Project.SYS_ID, "sysId", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, Project.SYS_ID, "sysIdFrom", CriteriaOperatorEnum.GreaterOrEquals);
		QueryWrapperHelper.setCondition(criteria, request, Project.SYS_ID, "sysIdTo", CriteriaOperatorEnum.LessOrEqual);
		QueryWrapperHelper.setCondition(criteria, request, Project.OWNER_ID, "ownerId", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, Project.TYPE, "type", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.NAME, "name", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.DB_HOST, "dbHost", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.PORT, "port", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, Project.PORT, "portFrom", CriteriaOperatorEnum.GreaterOrEquals);
		QueryWrapperHelper.setCondition(criteria, request, Project.PORT, "portTo", CriteriaOperatorEnum.LessOrEqual);
		QueryWrapperHelper.setCondition(criteria, request, Project.DB_SCHEMA, "dbSchema", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.DB_USERNAME, "dbUsername", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.DB_PASSWORD, "dbPassword", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.TEMPLATE_ID, "templateId", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, Project.OUTPUT_PATH, "outputPath", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.EXTRA_DATA, "extraData", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Project.DELETED, "deleted", CriteriaOperatorEnum.Equals);
		setCustomConditions(criteria, request);
	}
	@Override protected void validate(Project e) {
		if(null == e.getOwnerId()) { throw new ApplicationException("必须填写所有者"); }
		if(null == e.getName()) { throw new ApplicationException("必须填写名称"); }
		if(null == e.getDbHost()) { throw new ApplicationException("必须填写数据库服务器"); }
		if(null == e.getPort()) { throw new ApplicationException("必须填写端口"); }
		if(null == e.getDbSchema()) { throw new ApplicationException("必须填写数据库名"); }
		if(null == e.getDbUsername()) { throw new ApplicationException("必须填写登录名"); }
		if(null == e.getDbPassword()) { throw new ApplicationException("必须填写密码"); }
		if(null == e.getTemplateId()) { throw new ApplicationException("必须填写模板"); }
		if(null == e.getDeleted()) { throw new ApplicationException("必须填写状态"); }
		if(null == e.getId() || e.getId() == 0) {
			if(entityHelper.countProject(new QueryWrapper<Project>().eq(Project.DELETED,false).eq(Project.ID,e.getId())) > 0){
				throw new ApplicationException("【编号】已存在！");
			}
			validateWhenAdd(e);
		} else {
			if(entityHelper.countProject(new QueryWrapper<Project>().eq(Project.DELETED,false).eq(Project.ID,e.getId()).ne(Project.ID, e.getId())) > 0){
				throw new ApplicationException("【编号】已存在！");
			}
			validateWhenUpdate(e);
		}
	}
	@Override protected void setFkObject(Project e){
		if(null == e){ return;}
        entityHelper.setFks(e);
	}
	@Override protected void setDefaultValueWhenAdd(Project e) { 
					if(null == e.getSysId()){ e.setSysId(AppEnv.getCurrentSysId()); }
		if(null == e.getOwnerId()){ e.setOwnerId(AppEnv.getCurrentUserId()); }
		if(null == e.getDeleted()){ e.setDeleted(false);}
	}
	@Override protected void setDefaultValueWhenUpdate(Project e) { }
}
