package com.prj.algorithm;
import java.util.ArrayList;
import java.util.List;
public class DbTableDefinition {
    private String name;
    private List<DbColumnDefinition> columns = new ArrayList<>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<DbColumnDefinition> getColumns() {
        return columns;
    }
    public void setColumns(List<DbColumnDefinition> columns) {
        this.columns = columns;
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
