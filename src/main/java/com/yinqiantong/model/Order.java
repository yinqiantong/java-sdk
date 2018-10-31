package com.yinqiantong.model;

public class Order {
    private String app_id;
    private String channel;
    private String platform;
    private String out_trade_no;
    private String client_out_trade_no;
    private String status;
    private long money;
    private String client_ip;
    private String openId;
    private String subject;
    private String description;
    private String notify_url;
    private String return_url;
    private String extra;
    private String pay_body;
    private long expire_time;

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

    public String getClient_out_trade_no() {
        return client_out_trade_no;
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

    public String getReturn_url() {
        return return_url;
    }

    public String getExtra() {
        return extra;
    }

    public String getPay_body() {
        return pay_body;
    }

    public long getExpire_time() {
        return expire_time;
    }

    public Order setApp_id(String app_id) {
        this.app_id = app_id;
        return this;
    }

    public Order setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public Order setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public Order setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
        return this;
    }

    public Order setClient_out_trade_no(String client_out_trade_no) {
        this.client_out_trade_no = client_out_trade_no;
        return this;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public Order setMoney(long money) {
        this.money = money;
        return this;
    }

    public Order setClient_ip(String client_ip) {
        this.client_ip = client_ip;
        return this;
    }

    public Order setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public Order setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    public Order setNotify_url(String notify_url) {
        this.notify_url = notify_url;
        return this;
    }

    public Order setReturn_url(String return_url) {
        this.return_url = return_url;
        return this;
    }

    public Order setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    public Order setPay_body(String pay_body) {
        this.pay_body = pay_body;
        return this;
    }

    public Order setExpire_time(long expire_time) {
        this.expire_time = expire_time;
        return this;
    }

}
