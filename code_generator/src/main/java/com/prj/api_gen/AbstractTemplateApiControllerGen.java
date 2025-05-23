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
public abstract class AbstractTemplateApiControllerGen extends AbstractApiController<Template> {
    private final static Logger logger = LoggerFactory.getLogger(AbstractTemplateApiControllerGen.class);
    @Autowired protected TemplatePersistenceService templatePersistenceService;
    @Autowired protected com.prj.persistence.EntityHelper entityHelper;
	@Autowired protected TransactionUtil transactionUtil;
	@Override protected PersistenceServiceBase<Template> getPersistenceService() { return templatePersistenceService; }
	@Override protected void setConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
			criteria.eq(Template.DELETED, false);
			QueryWrapperHelper.setCondition(criteria, request, Template.ID, "id", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, Template.ID, "idFrom", CriteriaOperatorEnum.GreaterOrEquals);
		QueryWrapperHelper.setCondition(criteria, request, Template.ID, "idTo", CriteriaOperatorEnum.LessOrEqual);
		QueryWrapperHelper.setCondition(criteria, request, Template.SYS_ID, "sysId", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, Template.SYS_ID, "sysIdFrom", CriteriaOperatorEnum.GreaterOrEquals);
		QueryWrapperHelper.setCondition(criteria, request, Template.SYS_ID, "sysIdTo", CriteriaOperatorEnum.LessOrEqual);
		QueryWrapperHelper.setCondition(criteria, request, Template.NAME, "name", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Template.PATH, "path", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Template.EXTRA_DATA, "extraData", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, Template.DELETED, "deleted", CriteriaOperatorEnum.Equals);
		setCustomConditions(criteria, request);
	}
	@Override protected void validate(Template e) {
		if(null == e.getName()) { throw new ApplicationException("必须填写名称"); }
		if(null == e.getPath()) { throw new ApplicationException("必须填写路径"); }
		if(null == e.getDeleted()) { throw new ApplicationException("必须填写状态"); }
		if(null == e.getId() || e.getId() == 0) {
			if(entityHelper.countTemplate(new QueryWrapper<Template>().eq(Template.DELETED,false).eq(Template.ID,e.getId())) > 0){
				throw new ApplicationException("【编号】已存在！");
			}
			validateWhenAdd(e);
		} else {
			if(entityHelper.countTemplate(new QueryWrapper<Template>().eq(Template.DELETED,false).eq(Template.ID,e.getId()).ne(Template.ID, e.getId())) > 0){
				throw new ApplicationException("【编号】已存在！");
			}
			validateWhenUpdate(e);
		}
	}
	@Override protected void setFkObject(Template e){
		if(null == e){ return;}
        entityHelper.setFks(e);
	}
	@Override protected void setDefaultValueWhenAdd(Template e) { 
					if(null == e.getSysId()){ e.setSysId(AppEnv.getCurrentSysId()); }
		if(null == e.getDeleted()){ e.setDeleted(false);}
	}
	@Override protected void setDefaultValueWhenUpdate(Template e) { }
}
