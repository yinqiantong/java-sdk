package com.yinqiantong.model;

public class NotifyRes {
    private int code;
    private String msg;

    private NotifyRes setCode(int code) {
        this.code = code;
        return this;
    }

    private NotifyRes setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public static NotifyRes success() {
        return new NotifyRes().setCode(200).setMsg("ok");
    }

    public static NotifyRes fail() {
        return NotifyRes.fail("notify fail");
    }

    public static NotifyRes fail(String msg) {
        return new NotifyRes().setCode(400).setMsg(msg);
    }
}
