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
@TableName("`user`")
public class User extends EntityBase implements Serializable {
    @TableField(value = "`sys_id`")private Long sysId;
    @NotNull(message = "必须填写登录名")
    @Size(min = 1, message = "必须填写登录名")
    @Size(max = 45, message = "登录名的长度不能超过45个字符")
    @TableField(value = "`login_name`")private String loginName;
    @NotNull(message = "必须填写密码")
    @Size(min = 1, message = "必须填写密码")
    @Size(max = 45, message = "密码的长度不能超过45个字符")
    @TableField(value = "`password`")private String password;
    @NotNull(message = "必须填写姓名")
    @Size(min = 1, message = "必须填写姓名")
    @Size(max = 45, message = "姓名的长度不能超过45个字符")
    @TableField(value = "`realname`")private String realname;
    @NotNull(message = "必须填写身份")
    @Size(min = 1, message = "必须填写身份")
    @Size(max = 45, message = "身份的长度不能超过45个字符")
    @TableField(value = "`role`")private String role;
    @NotNull(message = "必须填写状态")
    @Size(min = 1, message = "必须填写状态")
    @Size(max = 45, message = "状态的长度不能超过45个字符")
    @TableField(value = "`status`")private String status;
    @Size(max = 255, message = "电子邮箱的长度不能超过255个字符")
    @TableField(value = "`email`")private String email;
    public Long getSysId() { return sysId; }
    public void setSysId(Long sysId) { this.sysId = sysId; }
    public String getLoginName() { return loginName; }
    public void setLoginName(String loginName) { this.loginName = loginName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRealname() { return realname; }
    public void setRealname(String realname) { this.realname = realname; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    @Override
    public String getDisplayTitle() {
        return realname;
    }
    public static final String ID = "id";
    public static final String SYS_ID = "sys_id";
    public static final String LOGIN_NAME = "login_name";
    public static final String PASSWORD = "password";
    public static final String REALNAME = "realname";
    public static final String ROLE = "role";
    public static final String STATUS = "status";
    public static final String EXTRA_DATA = "extra_data";
    public static final String DELETED = "deleted";
    public static final String EMAIL = "email";
}
