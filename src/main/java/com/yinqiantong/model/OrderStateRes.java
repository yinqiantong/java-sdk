package com.yinqiantong.model;

import com.yinqiantong.common.Constants;

public class OrderStateRes {
    private int code;
    private String msg;

    public boolean isFail() {
        return code == Constants.CODE.PAY_FAIL;
    }

    public boolean isExpired() {
        return code == Constants.CODE.ORDER_EXPIRED;
    }

    public boolean isUnpaid() {
        return code == Constants.CODE.UNPAID;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
