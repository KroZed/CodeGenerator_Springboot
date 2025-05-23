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
@TableName("`template`")
public class Template extends EntityBase implements Serializable {
    @TableField(value = "`sys_id`")private Long sysId;
    @NotNull(message = "必须填写名称")
    @Size(min = 1, message = "必须填写名称")
    @Size(max = 45, message = "名称的长度不能超过45个字符")
    @TableField(value = "`name`")private String name;
    @NotNull(message = "必须填写路径")
    @Size(min = 1, message = "必须填写路径")
    @Size(max = 255, message = "路径的长度不能超过255个字符")
    @TableField(value = "`path`")private String path;
    public Long getSysId() { return sysId; }
    public void setSysId(Long sysId) { this.sysId = sysId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    @Override
    public String getDisplayTitle() {
        return name;
    }
    public static final String ID = "id";
    public static final String SYS_ID = "sys_id";
    public static final String NAME = "name";
    public static final String PATH = "path";
    public static final String EXTRA_DATA = "extra_data";
    public static final String DELETED = "deleted";
}
