package me.wuwenbin.items.campustalk.http.jxufe.support;

import java.util.List;

public class R {
    private Integer code;
    private String msg;
    private List<JxufeBo> data;

    public R() {
    }

    public R(Integer code, String msg, List<JxufeBo> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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


    public List<JxufeBo> getData() {
        return data;
    }

    public void setData(List<JxufeBo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
