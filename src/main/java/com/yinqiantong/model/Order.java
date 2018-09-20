package com.yinqiantong.model;

public class Order {
    private String app_id;
    private String channel;
    private String platform;
    private String out_trade_no;
    private String status;
    private long money;
    private String client_ip;
    private String openId;
    private String subject;
    private String description;
    private String notify_url;
    private String success_url;
    private String extra;
    private String pay_body;
    private long pay_time;
    private long expire_time;
    private long create_time;

    public String getApp_id() {
        return app_id;
    }

    public String getChannel() {
        return channel;
    }

    public String getPlatform() {
        return platform;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public String getStatus() {
        return status;
    }

    public long getMoney() {
        return money;
    }

    public String getClient_ip() {
        return client_ip;
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

    public String getNotify_url() {
        return notify_url;
    }

    public String getSuccess_url() {
        return success_url;
    }

    public String getExtra() {
        return extra;
    }

    public String getPay_body() {
        return pay_body;
    }

    public long getPay_time() {
        return pay_time;
    }

    public long getExpire_time() {
        return expire_time;
    }

    public long getCreate_time() {
        return create_time;
    }
}
