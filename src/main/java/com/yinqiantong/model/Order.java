package com.yinqiantong.model;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("app_id")
    private String appId;
    private String channel;
    private String platform;
    @SerializedName("out_trade_no")
    private String outTradeNo;
    private String status;
    private long money;
    @SerializedName("client_ip")
    private String clientIp;
    private String openId;
    private String subject;
    private String description;
    @SerializedName("notify_url")
    private String notifyUrl;
    @SerializedName("success_url")
    private String successUrl;
    private String extra;
    @SerializedName("pay_body")
    private String payBody;
    @SerializedName("pay_time")
    private long payTime;
    @SerializedName("expire_time")
    private long expireTime;
    @SerializedName("create_time")
    private long createTime;

    public String getAppId() {
        return appId;
    }

    public String getChannel() {
        return channel;
    }

    public String getPlatform() {
        return platform;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public String getStatus() {
        return status;
    }

    public long getMoney() {
        return money;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getOpenId() {
        return openId;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public String getExtra() {
        return extra;
    }

    public String getPayBody() {
        return payBody;
    }

    public long getPayTime() {
        return payTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public long getCreateTime() {
        return createTime;
    }
}
