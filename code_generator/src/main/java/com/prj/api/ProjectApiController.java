package com.prj.api;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.prj.algorithm.DbTableDefinition;
import com.prj.algorithm.MySqlParser;
import com.prj.algorithm.VelocityCodeGenerator;
import com.prj.api_gen.AbstractProjectApiControllerGen;
import com.prj.common.AppEnv;
import com.prj.common.RestApiResult;
import com.prj.config.ProjectConfig;
import com.prj.enums.RoleEnum;
import com.prj.persistence.entity.Project;
import com.prj.persistence.entity.TemplateFile;
import com.prj.util.HttpRequestUtil;
import com.prj.util.StringUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
@RequestMapping(ProjectConfig.API_PREFIX + "/project")
@Api(tags = "项目 API 接口")
public class ProjectApiController extends AbstractProjectApiControllerGen {
    private final static Logger logger = LoggerFactory.getLogger(ProjectApiController.class);
    @Override protected String getEntityTitle() { return "项目"; }
    @Override protected void setCustomConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
        if(null != AppEnv.getCurrentUser()) {
            if (RoleEnum.用户.equals(AppEnv.getCurrentUser().getRole())) {
                criteria = criteria.eq(Project.OWNER_ID, AppEnv.getCurrentUser().getId());
            }
        }
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
			criteria = criteria.orderByAsc(Project.NAME);
        }
	}
    @Override protected void setSuggestConditions(QueryWrapper<?> criteria, HttpServletRequest request) {
        if(null != AppEnv.getCurrentUser()) {
            if (RoleEnum.用户.equals(AppEnv.getCurrentUser().getRole())) {
                criteria = criteria.eq(Project.OWNER_ID, AppEnv.getCurrentUser().getId());
            }
        }
		criteria = criteria.orderByAsc(Project.NAME);
	}
    @Override protected void validateWhenAdd(Project e) { }
    @Override protected void validateWhenUpdate(Project e) { }
    @Override protected void beforeSetFk(Project e) { }
    @Override protected void customGetLogic(Project e) { }
    @Override protected void customListLogic(Project e) { }
    @Override protected void customListLogic(List<?> list) { }
    @Override protected void setDefaultValueWhenAdd(Project e) { 
		super.setDefaultValueWhenAdd(e);
		setDefaultValueCommon(e);
	}
    @Override protected void setDefaultValueWhenUpdate(Project e) { 
		super.setDefaultValueWhenUpdate(e);
		setDefaultValueCommon(e);
	}
    protected void setDefaultValueCommon(Project e) { }
    @Override protected void beforeAdd(Project e) { }
    @Override protected void afterAdd(Project e) { }
    @Override protected void beforeUpdate(Project e) { }
    @Override protected void afterUpdate(Project e) { }
    @Override protected void beforeDelete(Project e) { }
    @Override protected void afterDelete(Project e) { }
    @RequestMapping("/generate/{projectId}")
    public Object generate(@PathVariable Integer projectId) throws Throwable {
        Project project = projectPersistenceService.getById(projectId);
        List<TemplateFile> templateFiles = entityHelper.listTemplateFiles(entityHelper.templateFileQueryWrapper().eq(TemplateFile.TEMPLATE_ID, project.getTemplateId()));
        List<DbTableDefinition> tableDefinitions = MySqlParser.parse(project.getDbHost(), project.getPort(), project.getDbUsername(), project.getDbPassword(), project.getDbSchema());
        VelocityCodeGenerator.generateCode(templateFiles, tableDefinitions, "output");
        return RestApiResult.success();
    }
}
