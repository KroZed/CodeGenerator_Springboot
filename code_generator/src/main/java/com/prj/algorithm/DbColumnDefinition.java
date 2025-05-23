package com.prj.algorithm;
import io.swagger.models.auth.In;
public class DbColumnDefinition {
    private String name;
    private String type;
    private Integer length;
    private Integer precision;
    private Integer scale;
    private Boolean isNullable;
    private String defaultValue;
    private Boolean isPrimaryKey;
    public DbColumnDefinition() {
    }
    public DbColumnDefinition(String name, String type, boolean isPrimaryKey) {
        this.name = name;
        this.type = type;
        this.isPrimaryKey = isPrimaryKey;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }   
    public Integer getPrecision() {
        return precision;
    }
    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
    public Integer getScale() {
        return scale;
    }
    public void setScale(Integer scale) {
        this.scale = scale;
    }
    public Boolean getIsNullable() {
        return isNullable;
    }
    public void setIsNullable(Boolean isNullable) {
        this.isNullable = isNullable;
    }
    public String getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    public Boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }
    public void setIsPrimaryKey(Boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }
    public String getJavaType(){
        if(type.equals("int") || type.equals("bigint") || type.equals("smallint") || type.equals("tinyint")){
            return "Integer";
        }else if(type.equals("varchar") || type.equals("char")){
            return "String";
        }else if(type.equals("date") || type.equals("datetime")){
            return "Date";
        }else if(type.equals("decimal") || type.equals("float") || type.equals("double")){
            return "Double";
        }else if(type.equals("boolean")){
            return "Boolean";
        }else if(type.equals("text") || type.equals("longtext")){
            return "String";
        }
        return "Object";
    }
    public String getCamelCaseName(){
        String[] words = name.split("_");
        String camelCaseName = "";
        for(String word : words){
            camelCaseName += word.substring(0, 1).toUpperCase() + word.substring(1);
        }
        return camelCaseName;
    }
    public String getPascalCaseName(){
        return getCamelCaseName().substring(0, 1).toUpperCase() + getCamelCaseName().substring(1);
    }
}
