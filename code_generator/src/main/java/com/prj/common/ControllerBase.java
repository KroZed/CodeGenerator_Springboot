package com.prj.common;
import com.prj.config.ProjectConfig;
import com.prj.util.HttpRequestUtil;
import com.prj.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;
public class ControllerBase extends AbstractControllerBase {
    protected CurrentUser getCurrentUser(HttpServletRequest request) {
        return AppEnv.getCurrentUser();
    }
    protected void setCurrentUser(CurrentUser user){
        HttpSession session = request.getSession();
        session.setAttribute(AppEnv.CURRENT_USER_KEY, user);
    }
    protected boolean isLogin() {
        return getCurrentUser(request) != null;
    }
    protected void logout() {
        HttpSession session = request.getSession();
        session.removeAttribute(AppEnv.CURRENT_USER_KEY);
    }
    protected String saveUploadFile(MultipartFile file, String savePathUrl) throws Exception{
        savePathUrl = StringUtil.isNullOrEmppty(savePathUrl)? ProjectConfig.getUploadPath() : savePathUrl;
        String path = HttpRequestUtil.getRealPath(savePathUrl);
        String filename = FileHelper.saveFile(file,path);
        if(filename!=null) {
            return savePathUrl + filename;
        }
        return null;
    }
    @RequestMapping("/ajaxUpload")
    public @ResponseBody RestApiResult ajaxUpload(@RequestParam("file") MultipartFile file) throws Exception{
        String fileUrl = saveUploadFile(file, ProjectConfig.getUploadPath());
        return RestApiResult.success(fileUrl);
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename, Model model)throws Exception {
        String urlString = filename.substring(filename.indexOf("/upload"));
        String path = request.getServletContext().getRealPath("/");
        File file = new File(path + File.separator + urlString);
        HttpHeaders headers = new HttpHeaders();
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment", downloadFielName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
    protected String setMsgAndReturn(String msg,String url){
        request.getSession().setAttribute("ErrMsg", msg);
        return url;
    }
}
