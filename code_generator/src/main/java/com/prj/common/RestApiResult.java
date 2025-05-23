package com.prj.common;
import com.prj.util.LocalDateTimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
@ApiModel(description = "Api结果包")
public class RestApiResult implements Serializable {
    public static final int CODE_SUCCESS = 0;
    @ApiModelProperty("错误编号，0表示成功")
    private int code = CODE_SUCCESS;
    @ApiModelProperty("错误描述")
    private String message = "";
    @ApiModelProperty("数据")
    private Object data = null;
    @ApiModelProperty("结果产生时间")
    private String time = null;
    public RestApiResult(){
    }
    public RestApiResult(Object data) {
        this(CODE_SUCCESS,"", data);
    }
    public RestApiResult(int code, String message) {
        this(code,message,null);
    }
    public RestApiResult(int code, String message, Object data) {
        this(code,message,data,LocalDateTimeUtil.formatNow("yyyy-MM-dd HH:mm:ss"));
    }
    public RestApiResult(int code, String message, Object data, String time) {
        setCode(code);
        setMessage(message);
        setData(data);
        setTime(time);
    }
    public static RestApiResult success(Object data)
    {
        return new RestApiResult(CODE_SUCCESS,"操作成功",data);
    }
    public static RestApiResult success()
    {
        return new RestApiResult(CODE_SUCCESS,"操作成功");
    }
    public static RestApiResult fail(int code,String message)
    {
        return new RestApiResult(code,message);
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public boolean isSuccessful() {
        return 0==code;
    }
}
