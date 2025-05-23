package com.prj.util;
import java.util.List;
public class StringUtil {
    public static final String EMPTY = "";
    public static String join(String delimiter, List<? extends Object> list) {
        StringBuffer sb = new StringBuffer();
        if(list==null) {
            return "";
        }
        if(list.size()==0) {
            return "";
        }
        for(Object o : list) {
            if(o==null) {
                sb.append(delimiter).append("NULL");
            }else{
                sb.append(delimiter).append(o.toString());
            }
        }
        return sb.substring(1);
    }
    public static boolean isNullOrEmppty(String s) {
        return null==s || 0==s.trim().length();
    }
    public static String padLeft(String v, String chr, int len){
        if(v==null){return null;}
        if(chr==null || chr.length()==0) {return  v;}
        if(v.length()>=len){return v;}
        String tmp = "";
        for(int i = v.length(); i < len; i+=chr.length()){
            tmp+=chr;
        }
        tmp=tmp.substring(tmp.length()-(len-v.length()));
        return tmp+v;
    }
    public static String padLeft(Long num, String chr, int len){
        if(num==null){return null;}
        return padLeft(String.valueOf(num), chr, len);
    }
    public static String toTimeString(int hour, int minute){
        return padLeft((long)hour,"0",2)+":"+padLeft((long)minute,"0",2);
    }
}
