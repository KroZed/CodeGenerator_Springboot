package com.prj.api;
import com.prj.common.ApiControllerBase;
import com.prj.common.FileHelper;
import com.prj.common.RestApiResult;
import com.prj.config.ProjectConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping(ProjectConfig.API_PREFIX + "/file")
public class FileController extends ApiControllerBase {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @PostMapping("/upload")
    public RestApiResult fileUpload(MultipartFile file) throws Exception{
        logger.debug(file.getName());
        logger.debug(file.getOriginalFilename());
        logger.debug(String.valueOf(file.getSize()));
        String path = FileHelper.getPath("static" + ProjectConfig.getUploadPath());
        String filename = FileHelper.saveFile(file,path);
        if(filename!=null) {
            return RestApiResult.success(ProjectConfig.getUploadPath() + filename);
        }else{
            return RestApiResult.fail(500,"文件上传失败！");
        }
    }
}
