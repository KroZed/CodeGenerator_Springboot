package com.prj.common;
import com.prj.util.HttpHeaderUtil;
import org.springframework.stereotype.Component;
@Component
public class AppEnv {
    public final static String LOGIN_TOKEN_KEY = "LOGIN_TOKEN";
    public final static String USER_ID_KEY = "CURRENT_USER_ID";
    public final static String CURRENT_USER_KEY = "CURRENT_USER";
    public final static String WX_ID_KEY = "WX_ID";
    public final static String MOBILE_VC = "MOBILE_VC";
    public static String getWxId(){
        return (String) HttpHeaderUtil.getRequest().getSession().getAttribute(WX_ID_KEY);
    }
    public static void setWxId(String wxId){
        HttpHeaderUtil.getRequest().getSession().setAttribute(WX_ID_KEY, wxId);
    }
    public static String getMobileVc(){return (String) HttpHeaderUtil.getRequest().getSession().getAttribute(MOBILE_VC);}
    public static void setMobileVc(String vc){HttpHeaderUtil.getRequest().getSession().setAttribute(MOBILE_VC, vc);}
    public static String getLoginToken() {
        String token = HttpHeaderUtil.getString(LOGIN_TOKEN_KEY);
        if(token!=null && token.length()>0) {
            return token;
        }
        token = (String)HttpHeaderUtil.getRequest().getSession().getAttribute(LOGIN_TOKEN_KEY);
        return token;
    }
    public static Long getCurrentUserId() {
        if(getCurrentUser()!=null) {return getCurrentUser().getId();}
        Long id = HttpHeaderUtil.getLong(USER_ID_KEY);
        if(id==null) {
            id = (Long)HttpHeaderUtil.getRequest().getSession().getAttribute(LOGIN_TOKEN_KEY);
        }
        return id;
    }
    public static String getVCode(){
        return (String) HttpHeaderUtil.getRequest().getSession().getAttribute("VCODE");
    }
    public static CurrentUser getCurrentUser() {
        return (CurrentUser)HttpHeaderUtil.getRequest().getSession().getAttribute(CURRENT_USER_KEY);
    }
    public static void setCurrentUser(CurrentUser user) {
        HttpHeaderUtil.getRequest().getSession().setAttribute(CURRENT_USER_KEY, user);
    }
    public static boolean isLogin() {
        return getCurrentUserId() == null && getCurrentUser() == null;
    }
    public static Long getCurrentSysId() {return getCurrentUser()==null ? null : getCurrentUser().getSysId();}
    public static String getCurrentRole(){ return getCurrentUser()==null ? null : getCurrentUser().getRole();}
}
