package com.gc.util.result;

public class R {
    private Integer code;
    
    private String msg;

    private Integer count = 10;

    private Object data;


    //把构造方法私有
    private R() {}

    //成功静态方法
    public static R ok() {
        R r = new R();
        r.setCode(ResultCode.SUCCESS);
        r.setMsg("成功");
        return r;
    }

    //失败静态方法
    public static R error() {
        R r = new R();
        r.setCode(ResultCode.ERROR);
        r.setMsg("失败");
        return r;
    }

    public R message(String message){
        this.setMsg(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(Object value){
        this.data = value;
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
