package com.prj.util;
import java.io.Serializable;
public class ApplicationException extends RuntimeException implements Serializable {
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    private int code = -1;
    public ApplicationException(){}
    public ApplicationException(int code){
        this(code,"");
    }
    public ApplicationException(String message) {
        this(-1, message);
    }
    public ApplicationException(int code, String message) {
        super(message);
        setCode(code);
    }
    public ApplicationException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
    public ApplicationException(Throwable throwable, String message) {
        super(message, throwable);
    }
}
