package com.mju.band3.utils;

import java.io.Serializable;

public class BaseResult implements Serializable {

    public static final Integer STATUS_SUCCESS=200;
    public static final Integer  STATUS_FAIL=500;

    private Integer status;
    private String message;

    public static BaseResult success(){
    return createResult(STATUS_SUCCESS,"成功");
    }
    public static BaseResult success(String message){
        return createResult(STATUS_SUCCESS,message);
    }
    public static BaseResult fail(){
        return createResult(STATUS_FAIL,"失败");
    }
    public static BaseResult fail(String message){
        return createResult(STATUS_FAIL,message);
    }
    public static BaseResult fail(String message,Integer status){
        return createResult(status,message);
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    private static BaseResult createResult(Integer status,String message){
        BaseResult baseResult=new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }
}
