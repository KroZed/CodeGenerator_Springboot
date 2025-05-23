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
@TableName("`project`")
public class Project extends EntityBase implements Serializable {
    @TableField(value = "`sys_id`")private Long sysId;
    @NotNull(message = "必须填写所有者")
    @TableField(value = "`owner_id`")private Long ownerId;
    @TableField(exist = false)private User owner;
    @Size(max = 45, message = "类型的长度不能超过45个字符")
    @TableField(value = "`type`")private String type;
    @NotNull(message = "必须填写名称")
    @Size(min = 1, message = "必须填写名称")
    @Size(max = 45, message = "名称的长度不能超过45个字符")
    @TableField(value = "`name`")private String name;
    @NotNull(message = "必须填写数据库服务器")
    @Size(min = 1, message = "必须填写数据库服务器")
    @Size(max = 255, message = "数据库服务器的长度不能超过255个字符")
    @TableField(value = "`db_host`")private String dbHost;
    @NotNull(message = "必须填写端口")
    @TableField(value = "`port`")private Integer port;
    @NotNull(message = "必须填写数据库名")
    @Size(min = 1, message = "必须填写数据库名")
    @Size(max = 45, message = "数据库名的长度不能超过45个字符")
    @TableField(value = "`db_schema`")private String dbSchema;
    @NotNull(message = "必须填写登录名")
    @Size(min = 1, message = "必须填写登录名")
    @Size(max = 45, message = "登录名的长度不能超过45个字符")
    @TableField(value = "`db_username`")private String dbUsername;
    @NotNull(message = "必须填写密码")
    @Size(min = 1, message = "必须填写密码")
    @Size(max = 45, message = "密码的长度不能超过45个字符")
    @TableField(value = "`db_password`")private String dbPassword;
    @NotNull(message = "必须填写模板")
    @TableField(value = "`template_id`")private Long templateId;
    @TableField(exist = false)private Template template;
    @Size(max = 255, message = "输出路径的长度不能超过255个字符")
    @TableField(value = "`output_path`")private String outputPath;
    public Long getSysId() { return sysId; }
    public void setSysId(Long sysId) { this.sysId = sysId; }
    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    public User getOwner () { return owner; }
    public void setOwner (User owner) { this.owner = owner; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDbHost() { return dbHost; }
    public void setDbHost(String dbHost) { this.dbHost = dbHost; }
    public Integer getPort() { return port; }
    public void setPort(Integer port) { this.port = port; }
    public String getDbSchema() { return dbSchema; }
    public void setDbSchema(String dbSchema) { this.dbSchema = dbSchema; }
    public String getDbUsername() { return dbUsername; }
    public void setDbUsername(String dbUsername) { this.dbUsername = dbUsername; }
    public String getDbPassword() { return dbPassword; }
    public void setDbPassword(String dbPassword) { this.dbPassword = dbPassword; }
    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    public Template getTemplate () { return template; }
    public void setTemplate (Template template) { this.template = template; }
    public String getOutputPath() { return outputPath; }
    public void setOutputPath(String outputPath) { this.outputPath = outputPath; }
    @Override
    public String getDisplayTitle() {
        return name;
    }
    public static final String ID = "id";
    public static final String SYS_ID = "sys_id";
    public static final String OWNER_ID = "owner_id";
    public static final String TYPE = "type";
    public static final String NAME = "name";
    public static final String DB_HOST = "db_host";
    public static final String PORT = "port";
    public static final String DB_SCHEMA = "db_schema";
    public static final String DB_USERNAME = "db_username";
    public static final String DB_PASSWORD = "db_password";
    public static final String TEMPLATE_ID = "template_id";
    public static final String OUTPUT_PATH = "output_path";
    public static final String EXTRA_DATA = "extra_data";
    public static final String DELETED = "deleted";
}
