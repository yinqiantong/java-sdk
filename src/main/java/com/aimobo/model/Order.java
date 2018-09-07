package com.aimobo.model;

public class Order {
    private String appId;
    private String channel;
    private String platform;
    private String outTradeNo;
    private String status;
    private long money;
    private String clientIp;
    private String openId;
    private String subject;
    private String description;
    private String notifyUrl;
    private String successUrl;
    private String extra;
    private String payBody;
    private long payTime;
    private long expireTime;
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
