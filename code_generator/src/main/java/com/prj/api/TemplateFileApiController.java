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
import com.prj.api_gen.AbstractTemplateFileApiControllerGen;
import com.prj.common.*;
import com.prj.config.*;
import com.prj.enums.*;
import com.prj.persistence.entity.*;
import com.prj.persistence.service.*;
import com.prj.util.*;
@RestController
@RequestMapping(ProjectConfig.API_PREFIX + "/templateFile")
@Api(tags = "模板文件 API 接口")
public class TemplateFileApiController extends AbstractTemplateFileApiControllerGen {
    private final static Logger logger = LoggerFactory.getLogger(TemplateFileApiController.class);
    @Override protected String getEntityTitle() { return "模板文件"; }
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
			criteria = criteria.orderByAsc(TemplateFile.NAME);
        }
	}
    @Override protected void setSuggestConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
		criteria = criteria.orderByAsc(TemplateFile.NAME);
	}
    @Override protected void validateWhenAdd(TemplateFile e) { }
    @Override protected void validateWhenUpdate(TemplateFile e) { }
    @Override protected void beforeSetFk(TemplateFile e) { }
    @Override protected void customGetLogic(TemplateFile e) { }
    @Override protected void customListLogic(TemplateFile e) { }
    @Override protected void customListLogic(List<?> list) { }
    @Override protected void setDefaultValueWhenAdd(TemplateFile e) { 
		super.setDefaultValueWhenAdd(e);
		setDefaultValueCommon(e);
	}
    @Override protected void setDefaultValueWhenUpdate(TemplateFile e) { 
		super.setDefaultValueWhenUpdate(e);
		setDefaultValueCommon(e);
	}
    protected void setDefaultValueCommon(TemplateFile e) { }
    @Override protected void beforeAdd(TemplateFile e) { }
    @Override protected void afterAdd(TemplateFile e) { }
    @Override protected void beforeUpdate(TemplateFile e) { }
    @Override protected void afterUpdate(TemplateFile e) { }
    @Override protected void beforeDelete(TemplateFile e) { }
    @Override protected void afterDelete(TemplateFile e) { }
}
