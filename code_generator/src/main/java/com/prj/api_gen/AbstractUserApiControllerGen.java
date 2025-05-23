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
public abstract class AbstractUserApiControllerGen extends AbstractApiController<User> {
    private final static Logger logger = LoggerFactory.getLogger(AbstractUserApiControllerGen.class);
    @Autowired protected UserPersistenceService userPersistenceService;
    @Autowired protected com.prj.persistence.EntityHelper entityHelper;
	@Autowired protected TransactionUtil transactionUtil;
	@Override protected PersistenceServiceBase<User> getPersistenceService() { return userPersistenceService; }
	@Override protected void setConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
			criteria.eq(User.DELETED, false);
			criteria.ne(User.STATUS, EntityStatusEnum.已删除);
		QueryWrapperHelper.setCondition(criteria, request, User.ID, "id", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, User.ID, "idFrom", CriteriaOperatorEnum.GreaterOrEquals);
		QueryWrapperHelper.setCondition(criteria, request, User.ID, "idTo", CriteriaOperatorEnum.LessOrEqual);
		QueryWrapperHelper.setCondition(criteria, request, User.SYS_ID, "sysId", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, User.SYS_ID, "sysIdFrom", CriteriaOperatorEnum.GreaterOrEquals);
		QueryWrapperHelper.setCondition(criteria, request, User.SYS_ID, "sysIdTo", CriteriaOperatorEnum.LessOrEqual);
		QueryWrapperHelper.setCondition(criteria, request, User.LOGIN_NAME, "loginName", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, User.PASSWORD, "password", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, User.REALNAME, "realname", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, User.ROLE, "role", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, User.STATUS, "status", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, User.EXTRA_DATA, "extraData", CriteriaOperatorEnum.Like);
		QueryWrapperHelper.setCondition(criteria, request, User.DELETED, "deleted", CriteriaOperatorEnum.Equals);
		QueryWrapperHelper.setCondition(criteria, request, User.EMAIL, "email", CriteriaOperatorEnum.Like);
		setCustomConditions(criteria, request);
	}
	@Override protected void validate(User e) {
		if(null == e.getLoginName()) { throw new ApplicationException("必须填写登录名"); }
		if(null == e.getPassword()) { throw new ApplicationException("必须填写密码"); }
		if(null == e.getRealname()) { throw new ApplicationException("必须填写姓名"); }
		if(null == e.getRole()) { throw new ApplicationException("必须填写身份"); }
		if(null == e.getStatus()) { throw new ApplicationException("必须填写状态"); }
		if(null == e.getDeleted()) { throw new ApplicationException("必须填写状态"); }
		if(null == e.getId() || e.getId() == 0) {
			if(entityHelper.countUser(new QueryWrapper<User>().eq(User.DELETED,false).eq(User.ID,e.getId())) > 0){
				throw new ApplicationException("【编号】已存在！");
			}
			validateWhenAdd(e);
		} else {
			if(entityHelper.countUser(new QueryWrapper<User>().eq(User.DELETED,false).eq(User.ID,e.getId()).ne(User.ID, e.getId())) > 0){
				throw new ApplicationException("【编号】已存在！");
			}
			validateWhenUpdate(e);
		}
	}
	@Override protected void setFkObject(User e){
		if(null == e){ return;}
        entityHelper.setFks(e);
	}
	@Override protected void setDefaultValueWhenAdd(User e) { 
				if(null == e.getSysId()){ e.setSysId(AppEnv.getCurrentSysId()); }
		if(null == e.getRole()){ e.setRole("用户");}
		if(null == e.getStatus()){ e.setStatus("正常");}
		if(null == e.getDeleted()){ e.setDeleted(false);}
	}
	@Override protected void setDefaultValueWhenUpdate(User e) { }
	protected abstract void beforeChangeStatus(User e, String oldStatus, String newStatus);
	protected abstract void afterChangeStatus(User e, String oldStatus, String newStatus);
	@RequestMapping("/changeStatus")
	public Object changeStatus(@ApiParam(value = "对象标识符", required = true) long id,
							   @ApiParam(value = "旧状态") String oldStatus,
							   @ApiParam(value = "新状态", required = true)String newStatus) {
		User e = userPersistenceService.getById(id);
		transactionUtil.scope(()->{
			beforeChangeStatus(e, oldStatus, newStatus);
			e.setStatus(newStatus);
			afterChangeStatus(e, oldStatus, newStatus);
			entityHelper.update(e);
		});
		return RestApiResult.success(e);
	}
}
