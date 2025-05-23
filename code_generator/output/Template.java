package com.prj.entity;
import java.util.Date;
import java.io.Serializable;
public class Template implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object Id;
    private Object SysId;
    private Object Name;
    private Object Path;
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
    public Object getName() {
        return Name;
    }
    public void setName(Object Name) {
        this.Name = Name;
    }
    public Object getPath() {
        return Path;
    }
    public void setPath(Object Path) {
        this.Path = Path;
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
