package com.prj.algorithm;
import com.prj.persistence.entity.TemplateFile;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class VelocityCodeGenerator {
    private static VelocityEngine velocityEngine;
    static {
        velocityEngine = new VelocityEngine();
        Properties props = new Properties();
        props.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        props.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        props.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        props.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        velocityEngine.init(props);
    }
    public static String generateCode(TemplateFile templateFile, DbTableDefinition tableDefinition) {
        try {
            VelocityContext context = new VelocityContext();
            context.put("table", tableDefinition);
            context.put("packageName", "com.prj"); // 这里可以从配置中读取包名
            org.apache.velocity.Template template = velocityEngine.getTemplate("/static" + templateFile.getFile(), "UTF-8");
            StringWriter writer = new StringWriter();
            template.merge(context, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("代码生成失败", e);
        }
    }
    public static void generateCode(List<TemplateFile> templateFiles, List<DbTableDefinition> tableDefinitions, String outputPath) throws Throwable {
        for (TemplateFile templateFile : templateFiles) {
            for (DbTableDefinition tableDefinition : tableDefinitions) {
                String code = generateCode(templateFile, tableDefinition);
                String fileName = templateFile.getNameRule().replaceAll("【table】", tableDefinition.getPascalCaseName());
                System.out.println(fileName);
                FileUtils.writeStringToFile(new File(outputPath + "/" + fileName), code, "UTF-8");
            }
        }
    }
    public static void main(String[] args) throws Throwable {
        List<DbTableDefinition> tableDefinitions = new ArrayList<>();
        DbTableDefinition table = new DbTableDefinition();
        table.setName("user");
        table.getColumns().add(new DbColumnDefinition("id", "int", true));
        table.getColumns().add(new DbColumnDefinition("name", "varchar", false));
        table.getColumns().add(new DbColumnDefinition("age", "int", false));
        tableDefinitions.add(table);
        table = new DbTableDefinition();
        table.setName("project");
        table.getColumns().add(new DbColumnDefinition("id", "int", true));
        table.getColumns().add(new DbColumnDefinition("name", "varchar", false));
        tableDefinitions.add(table);
        List<TemplateFile> templateFiles = new ArrayList<>();
        TemplateFile templateFile = new TemplateFile();
        templateFile.setFile("serviceImpl.vm");
        templateFile.setNameRule("【table】ServiceImpl.java");
        templateFiles.add(templateFile);
        templateFile = new TemplateFile();
        templateFile.setFile("entity.vm");
        templateFile.setNameRule("【table】Entity.java");
        templateFiles.add(templateFile);
        generateCode(templateFiles, tableDefinitions, "output");
    }
}
