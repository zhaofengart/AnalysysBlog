package com.analysys.blog.common;

/**
 * @author zhaofeng
 * @date 2019/5/22
 */

public class ReturnData {
    /**
     * 响应状态码
     */
    private boolean result;
    /**
     * 响应提示信息
     */
    private String message;
    /**
     * 响应结果对象
     */
    private Object data;

    private ReturnData(boolean result){
        this.result = result;
    }

    public static ReturnData buildSuccessResult(Object data){
        ReturnData returnData = new ReturnData(true);
        returnData.setData(data);
        return returnData;
    }

    public static ReturnData buildFailResult(String message) {
        ReturnData returnData = new ReturnData(false);
        returnData.setMessage(message);
        return returnData;
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
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
}
