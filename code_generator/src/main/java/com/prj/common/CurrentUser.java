package com.prj.common;
public class CurrentUser {
    private long id;
    private String name;
    private String role;
    private String face;
    private Long sysId;
    public CurrentUser(long id, String name, String role) {
        this(id,name,role,null);
    }
    public CurrentUser(long id, String name, String role, String face) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.face = face;
    }
    public CurrentUser(long id, String name, String role, String face, Long sysId) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.face = face;
        this.sysId = sysId;
    }
    public String getFace() {
        return face;
    }
    public void setFace(String face) {
        this.face = face;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Long getSysId() {
        return sysId;
    }
    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }
}
