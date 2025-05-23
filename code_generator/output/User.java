package com.prj.entity;
import java.util.Date;
import java.io.Serializable;
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object Id;
    private Object SysId;
    private Object LoginName;
    private Object Password;
    private Object Realname;
    private Object Role;
    private Object Status;
    private Object ExtraData;
    private Object Deleted;
    private Object Email;
    public Object getId() {
        return Id;
    }
    public void setId(Object Id) {
        this.Id = Id;
    }
    public Object getSysId() {
        return SysId;
    }
    public void setSysId(Object SysId) {
        this.SysId = SysId;
    }
    public Object getLoginName() {
        return LoginName;
    }
    public void setLoginName(Object LoginName) {
        this.LoginName = LoginName;
    }
    public Object getPassword() {
        return Password;
    }
    public void setPassword(Object Password) {
        this.Password = Password;
    }
    public Object getRealname() {
        return Realname;
    }
    public void setRealname(Object Realname) {
        this.Realname = Realname;
    }
    public Object getRole() {
        return Role;
    }
    public void setRole(Object Role) {
        this.Role = Role;
    }
    public Object getStatus() {
        return Status;
    }
    public void setStatus(Object Status) {
        this.Status = Status;
    }
    public Object getExtraData() {
        return ExtraData;
    }
    public void setExtraData(Object ExtraData) {
        this.ExtraData = ExtraData;
    }
    public Object getDeleted() {
        return Deleted;
    }
    public void setDeleted(Object Deleted) {
        this.Deleted = Deleted;
    }
    public Object getEmail() {
        return Email;
    }
    public void setEmail(Object Email) {
        this.Email = Email;
    }
} 
