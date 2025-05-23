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
import com.prj.api_gen.AbstractTemplateApiControllerGen;
import com.prj.common.*;
import com.prj.config.*;
import com.prj.enums.*;
import com.prj.persistence.entity.*;
import com.prj.persistence.service.*;
import com.prj.util.*;
@RestController
@RequestMapping(ProjectConfig.API_PREFIX + "/template")
@Api(tags = "模板 API 接口")
public class TemplateApiController extends AbstractTemplateApiControllerGen {
    private final static Logger logger = LoggerFactory.getLogger(TemplateApiController.class);
    @Override protected String getEntityTitle() { return "模板"; }
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
			criteria = criteria.orderByAsc(Template.NAME);
        }
	}
    @Override protected void setSuggestConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
		criteria = criteria.orderByAsc(Template.NAME);
	}
    @Override protected void validateWhenAdd(Template e) { }
    @Override protected void validateWhenUpdate(Template e) { }
    @Override protected void beforeSetFk(Template e) { }
    @Override protected void customGetLogic(Template e) { }
    @Override protected void customListLogic(Template e) { }
    @Override protected void customListLogic(List<?> list) { }
    @Override protected void setDefaultValueWhenAdd(Template e) { 
		super.setDefaultValueWhenAdd(e);
		setDefaultValueCommon(e);
	}
    @Override protected void setDefaultValueWhenUpdate(Template e) { 
		super.setDefaultValueWhenUpdate(e);
		setDefaultValueCommon(e);
	}
    protected void setDefaultValueCommon(Template e) { }
    @Override protected void beforeAdd(Template e) { }
    @Override protected void afterAdd(Template e) { }
    @Override protected void beforeUpdate(Template e) { }
    @Override protected void afterUpdate(Template e) { }
    @Override protected void beforeDelete(Template e) { }
    @Override protected void afterDelete(Template e) { }
}
