package com.java.common.base.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushuang
 * @date 2020/7/11 - 20:15
 *
 * 返回给前端的 通用bean
 */
public class Message {

    //状态码:  100-成功   200-失败
    private  int code;
    //提示信息
    private String msg;
    //后台返回给浏览器的数据
    private Map<String,Object> returnMap = new HashMap<String, Object>(0);

    public static Message success(){
        Message result = new Message();
        result.setCode(100);
        result.setMsg("处理成功!");
        return result;
    }

    public static Message fail(){
        Message result = new Message();
        result.setCode(200);
        result.setMsg("处理失败!");
        return result;
    }

    public Message add(String key, Object value){
        this.returnMap.put(key,value);
        return this;
    }




    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", returnMap=" + returnMap +
                '}';
    }

    public Message() {
    }

    public Message(int code, String msg, Map<String, Object> returnMap) {
        this.code = code;
        this.msg = msg;
        this.returnMap = returnMap;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getReturnMap() {
        return returnMap;
    }

    public void setReturnMap(Map<String, Object> returnMap) {
        this.returnMap = returnMap;
    }
}
