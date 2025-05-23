package com.prj.common;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
public class FileHelper {
    public static String saveFile(MultipartFile file, String path) throws IOException {
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        filename = Math.abs(UUID.randomUUID().hashCode()) +"."+suffix;
        File filePath = new File(path,filename);
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        file.transferTo(filePath);
        return filename;
    }
    public static String  getPath(String subdirectory){
        File upload = null;
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) {path = new File("");}
            upload = new File(path.getAbsolutePath(),subdirectory);
            if(!upload.exists()) {upload.mkdirs();}//如果不存在则创建目录
            String realPath = upload + "/";
            return realPath;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("获取服务器路径发生错误！");
        }
    }
    public static String  getFilePath(String filePath){
        File upload = null;
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) {path = new File("");}
            upload = new File(path.getAbsolutePath(),filePath);
            String realPath = upload + "";
            return realPath;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("获取服务器路径发生错误！");
        }
    }
}
