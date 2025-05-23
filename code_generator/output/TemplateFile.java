package com.prj.entity;
import java.util.Date;
import java.io.Serializable;
public class TemplateFile implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object Id;
    private Object SysId;
    private Object TemplateId;
    private Object Name;
    private Object File;
    private Object NameRule;
    private Object TemplateContent;
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
    public Object getTemplateId() {
        return TemplateId;
    }
    public void setTemplateId(Object TemplateId) {
        this.TemplateId = TemplateId;
    }
    public Object getName() {
        return Name;
    }
    public void setName(Object Name) {
        this.Name = Name;
    }
    public Object getFile() {
        return File;
    }
    public void setFile(Object File) {
        this.File = File;
    }
    public Object getNameRule() {
        return NameRule;
    }
    public void setNameRule(Object NameRule) {
        this.NameRule = NameRule;
    }
    public Object getTemplateContent() {
        return TemplateContent;
    }
    public void setTemplateContent(Object TemplateContent) {
        this.TemplateContent = TemplateContent;
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
