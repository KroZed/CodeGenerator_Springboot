package com.prj.entity;
import java.util.Date;
import java.io.Serializable;
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object Id;
    private Object SysId;
    private Object OwnerId;
    private Object Type;
    private Object Name;
    private Object DbHost;
    private Object Port;
    private Object DbSchema;
    private Object DbUsername;
    private Object DbPassword;
    private Object TemplateId;
    private Object OutputPath;
    private Object ExtraData;
    private Object Deleted;
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
    public Object getOwnerId() {
        return OwnerId;
    }
    public void setOwnerId(Object OwnerId) {
        this.OwnerId = OwnerId;
    }
    public Object getType() {
        return Type;
    }
    public void setType(Object Type) {
        this.Type = Type;
    }
    public Object getName() {
        return Name;
    }
    public void setName(Object Name) {
        this.Name = Name;
    }
    public Object getDbHost() {
        return DbHost;
    }
    public void setDbHost(Object DbHost) {
        this.DbHost = DbHost;
    }
    public Object getPort() {
        return Port;
    }
    public void setPort(Object Port) {
        this.Port = Port;
    }
    public Object getDbSchema() {
        return DbSchema;
    }
    public void setDbSchema(Object DbSchema) {
        this.DbSchema = DbSchema;
    }
    public Object getDbUsername() {
        return DbUsername;
    }
    public void setDbUsername(Object DbUsername) {
        this.DbUsername = DbUsername;
    }
    public Object getDbPassword() {
        return DbPassword;
    }
    public void setDbPassword(Object DbPassword) {
        this.DbPassword = DbPassword;
    }
    public Object getTemplateId() {
        return TemplateId;
    }
    public void setTemplateId(Object TemplateId) {
        this.TemplateId = TemplateId;
    }
    public Object getOutputPath() {
        return OutputPath;
    }
    public void setOutputPath(Object OutputPath) {
        this.OutputPath = OutputPath;
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
} 
