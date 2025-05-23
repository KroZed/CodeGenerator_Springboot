package com.prj.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ProjectConfig {
    public static final String SMS_ACCESS_KEY_ID = "";
    public static final String SMS_ACCESS_KEY_SECRET = "";
    public static final String SMS_TEMPLATE_ID="";
    public static final String API_PREFIX = "/api";
    private static String projectName;
    private static String uploadPath;
    @Value("【项目名称】")
    public void setProjectName(String value){
        projectName=value;
    }
    public static String getProjectName() {
        return projectName;
    }
    @Value("${project.upload-path}")
    public void setUploadPath(String value) {uploadPath=value;}
    public static String getUploadPath(){return uploadPath;}
}
