package com.prj.util;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
public class HttpRequestUtil {
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    public static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }
    public static String getRealPath(String path) {
        return getServletContext().getRealPath(path);
    }
    public static String getParameter(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if(null!=value && value.trim().length()>0) {
            return value;
        }
        return null;
    }
    public static Integer getIntegerParameter(HttpServletRequest request, String key) {
        String value = getParameter(request, key);
        if(null==value) {
            return null;
        }
        try{
            return Integer.valueOf(value);
        }catch (Exception ex) {
            return null;
        }
    }
    public static int getIntParameter(HttpServletRequest request, String  key, int defaultValue) {
        Integer value = getIntegerParameter(request, key);
        if(null==value) {
            return defaultValue;
        } else {
            return value.intValue();
        }
    }
    public static Double getDoubleParameter(HttpServletRequest request, String key) {
        String value = getParameter(request, key);
        if(null==value) {
            return null;
        }
        try{
            return Double.valueOf(value);
        }catch (Exception ex) {
            return null;
        }
    }
    public static Long getLongParameter(HttpServletRequest request, String key) {
        String value = getParameter(request, key);
        if(null==value) {
            return null;
        }
        try{
            return Long.valueOf(value);
        }catch (Exception ex) {
            return null;
        }
    }
    public static long getLongParameter(HttpServletRequest request, String key, long defaultValue) {
        String value = getParameter(request, key);
        if(null==value) {
            return defaultValue;
        }
        try{
            return Long.valueOf(value);
        }catch (Exception ex) {
            return defaultValue;
        }
    }
}
