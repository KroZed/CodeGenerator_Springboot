package com.prj.common;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
public class LoginForm implements Serializable {
    @NotNull(message = "必须填写用户名！")
    @Size(min=1,message = "必须填写用户名！")
    private String loginName;
    @NotNull(message = "必须填写密码！")
    @Size(min=1,message = "必须填写密码！")
    private String password;
    private String validationCode;
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getValidationCode() {
        return validationCode;
    }
    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }
}
