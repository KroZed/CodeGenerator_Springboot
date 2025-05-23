package com.prj.api;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import com.prj.api_gen.AbstractUserApiControllerGen;
import com.prj.common.*;
import com.prj.config.*;
import com.prj.enums.*;
import com.prj.persistence.entity.*;
import com.prj.persistence.service.*;
import com.prj.util.*;
@RestController
@RequestMapping(ProjectConfig.API_PREFIX + "/user")
@Api(tags = "用户 API 接口")
public class UserApiController extends AbstractUserApiControllerGen {
    private final static Logger logger = LoggerFactory.getLogger(UserApiController.class);
    @Override protected String getEntityTitle() { return "用户"; }
    @Override protected void setCustomConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
        String isMnt = HttpRequestUtil.getParameter(request, "isMnt");
        if(!StringUtil.isNullOrEmppty(isMnt)){
        }
        String orderBy = HttpRequestUtil.getParameter(request,"orderBy");
        if(orderBy!=null && orderBy.trim().length()>0){
            String[] parts = orderBy.split(",");
            for(int i=0;i<parts.length;i++){
                String fieldName = parts[i].trim();
                if(fieldName.length()==0){continue;}
                String[] subs = fieldName.split(" ");
                if(subs.length>1 && subs[1]!=null && "desc".equalsIgnoreCase(subs[1].trim())){
                    criteria = criteria.orderByDesc(subs[0]);
                    i++;
                } else {
                    criteria = criteria.orderByAsc(subs[0]);
                }
            }
        } else {
			criteria = criteria.orderByAsc(User.REALNAME);
        }
	}
    @Override protected void setSuggestConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
		criteria = criteria.orderByAsc(User.REALNAME);
	}
    @Override protected void validateWhenAdd(User e) { }
    @Override protected void validateWhenUpdate(User e) { }
    @Override protected void beforeSetFk(User e) { }
    @Override protected void customGetLogic(User e) { }
    @Override protected void customListLogic(User e) { }
    @Override protected void customListLogic(List<?> list) { }
    @Override protected void setDefaultValueWhenAdd(User e) { 
		super.setDefaultValueWhenAdd(e);
		setDefaultValueCommon(e);
	}
    @Override protected void setDefaultValueWhenUpdate(User e) { 
		super.setDefaultValueWhenUpdate(e);
		setDefaultValueCommon(e);
	}
    protected void setDefaultValueCommon(User e) { }
    @Override protected void beforeAdd(User e) { }
    @Override protected void afterAdd(User e) { }
    @Override protected void beforeUpdate(User e) { }
    @Override protected void afterUpdate(User e) { }
    @Override protected void beforeDelete(User e) { }
    @Override protected void afterDelete(User e) { }
	@Override protected void beforeChangeStatus(User e, String oldStatus, String newStatus) {}
	@Override protected void afterChangeStatus(User e, String oldStatus, String newStatus) {}
}
