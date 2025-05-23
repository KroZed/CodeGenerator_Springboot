package com.prj.util;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
public class HttpHeaderUtil {
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static Integer getInteger(String key) {
        HttpServletRequest request = getRequest();
        String s = request.getHeader(key);
        Integer i = null;
        if(s!=null && s.length()>0) {
            i = Integer.valueOf(s);
        }
        return i;
    }
    public static Long getLong(String key) {
        HttpServletRequest request = getRequest();
        String s = request.getHeader(key);
        Long i = null;
        if(s!=null && s.length()>0) {
            i = Long.valueOf(s);
        }
        return i;
    }
    public static String getString(String key) {
        return getRequest().getHeader(key);
    }
}
