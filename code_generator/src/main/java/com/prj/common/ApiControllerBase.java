package com.prj.common;
import com.prj.util.HttpRequestUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@RestController
@CrossOrigin
public class ApiControllerBase extends AbstractControllerBase {
    protected void downloadFile(String path, HttpServletRequest request, HttpServletResponse response) throws  IOException {
        try(InputStream inputStream = new FileInputStream(new File(HttpRequestUtil.getRealPath(path)));
            OutputStream outputStream = response.getOutputStream()) {
            response.setContentType("application/x-download");
            logger.debug("要下载的路径：" + path);
            response.addHeader("Content-Disposition", "attachment;filename=file");
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }
}
