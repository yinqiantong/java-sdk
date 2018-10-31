package com.yinqiantong.model;

import com.yinqiantong.common.Constants;

public class OrderRes {
    private String msg;
    private int code;
    private Order order;

    public boolean isSuccess() {
        return code == Constants.CODE.SUCCESS;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public Order getOrder() {
        return order;
    }
}
