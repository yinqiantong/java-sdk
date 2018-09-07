package com.yinqiantong.model;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class Options {
    private String channel;
    private String platform;
    private int money;
    private String clientIp;
    private String openId;
    private String subject;
    private String description;
    private String extra;
    private long ts;

    public static Options newInstance() {
        return new Options();
    }

    public String getChannel() {
        return channel;
    }

    public Options setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public Options setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public int getMoney() {
        return money;
    }

    public Options setMoney(int money) {
        this.money = money;
        return this;
    }

    public String getClientIp() {
        return clientIp;
    }

    public Options setClientIp(HttpServletRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("request is null");
        }
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (StringUtils.isEmpty(ip)) {
            ip = request.getRemoteAddr();
            if (StringUtils.isEmpty(ip)) {
                ip = "127.0.0.1";
            }
        }
        this.clientIp = ip;
        return this;
    }

    public Options setClientIp(String clientIp) {
        this.clientIp = clientIp;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public Options setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Options setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Options setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public Options setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    public long getTs() {
        return ts;
    }

    public Options setTs(long ts) {
        if (ts > 9999999999L) {
            ts /= 1000L;
        }
        this.ts = ts;
        return this;
    }
}
