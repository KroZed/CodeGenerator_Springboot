package com.prj.persistence.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.google.gson.Gson;
import com.prj.util.StringUtil;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;
public abstract class EntityBase implements Serializable {
    @TableId(type= IdType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @TableField("extra_data")
    private String extraData;
    public String getExtraData() {
        return extraData;
    }
    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }
    @NotNull(message = "必须填写删除状态")
    @TableField(value = "deleted")
    private Boolean deleted = Boolean.FALSE;
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
    @TableField(exist = false)
    private String deletedString;
    public String getDeletedString() { return (deleted==null) ? "" : Boolean.TRUE.equals(deleted) ? "是" : "否"; }
    public void setDeletedString(String deletedString) {
        this.deletedString = deletedString;
    }
    @TableField(exist = false)
    private String displayTitle;
    public abstract String getDisplayTitle();
    public <T> T getExtraDataObject(Class<T> t){
        if(StringUtil.isNullOrEmppty(extraData)){return null;}
        return new Gson().fromJson(extraData, t);
    }
}
