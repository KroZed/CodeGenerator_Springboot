package com.prj.persistence.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.prj.util.LocalDateTimeUtil;
import com.prj.util.LocalDateUtil;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
@TableName("`template_file`")
public class TemplateFile extends EntityBase implements Serializable {
    @TableField(value = "`sys_id`")private Long sysId;
    @NotNull(message = "必须填写模板")
    @TableField(value = "`template_id`")private Long templateId;
    @TableField(exist = false)private Template template;
    @NotNull(message = "必须填写名称")
    @Size(min = 1, message = "必须填写名称")
    @Size(max = 45, message = "名称的长度不能超过45个字符")
    @TableField(value = "`name`")private String name;
    @NotNull(message = "必须填写文件")
    @Size(min = 1, message = "必须填写文件")
    @Size(max = 255, message = "文件的长度不能超过255个字符")
    @TableField(value = "`file`")private String file;
    @NotNull(message = "必须填写命名规则")
    @Size(min = 1, message = "必须填写命名规则")
    @Size(max = 45, message = "命名规则的长度不能超过45个字符")
    @TableField(value = "`name_rule`")private String nameRule;
    @TableField(value = "`template_content`")private String templateContent;
    public Long getSysId() { return sysId; }
    public void setSysId(Long sysId) { this.sysId = sysId; }
    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    public Template getTemplate () { return template; }
    public void setTemplate (Template template) { this.template = template; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFile() { return file; }
    public void setFile(String file) { this.file = file; }
    public String getNameRule() { return nameRule; }
    public void setNameRule(String nameRule) { this.nameRule = nameRule; }
    public String getTemplateContent() { return templateContent; }
    public void setTemplateContent(String templateContent) { this.templateContent = templateContent; }
    @Override
    public String getDisplayTitle() {
        return name;
    }
    public static final String ID = "id";
    public static final String SYS_ID = "sys_id";
    public static final String TEMPLATE_ID = "template_id";
    public static final String NAME = "name";
    public static final String FILE = "file";
    public static final String NAME_RULE = "name_rule";
    public static final String TEMPLATE_CONTENT = "template_content";
    public static final String EXTRA_DATA = "extra_data";
    public static final String DELETED = "deleted";
}
