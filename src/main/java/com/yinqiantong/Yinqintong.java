package com.yinqiantong;

import com.yinqiantong.model.Options;
import com.yinqiantong.model.Order;
import com.yinqiantong.model.Res;
import com.yinqiantong.net.Api;
import com.yinqiantong.util.SignUtil;
import org.apache.commons.lang3.StringUtils;

public final class Yinqintong {
    private String appId;
    private String appKey;
    private String appSecret;

    private int requestTimeout = 1000;

    public static Yinqintong create(String appId, String appKey, String appSecret) {
        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(appKey) || StringUtils.isEmpty(appSecret)) {
            throw new IllegalArgumentException("empty key");
        }

        return new Yinqintong(appId, appKey, appSecret);
    }

    private Yinqintong(String appId, String appKey, String appSecret) {
        this.appId = appId;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public Yinqintong setRequestTimeout(int timeout) {
        this.requestTimeout = timeout;
        return this;
    }

    public int getRequestTimeout() {
        return requestTimeout;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String createSign(Options options) {
        return SignUtil.createSign(this, options);
    }

    public Order createOrder(Options options) throws Exception {
        Res.OrderRes res = Api.createOrder(this, options);
        if (!res.isSuccess()) {
            throw new Exception(res.getMsg());
        }

        return res.getData();
    }

    public Order getOrder(String outTradeNo) throws Exception {
        Res.OrderRes res = Api.getOrder(this, outTradeNo);
        if (!res.isSuccess()) {
            throw new Exception(res.getMsg());
        }

        return res.getData();
    }

}
