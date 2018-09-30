package com.yinqiantong;

import com.yinqiantong.model.Options;
import com.yinqiantong.model.Order;
import com.yinqiantong.model.OrderRes;
import com.yinqiantong.net.Api;
import com.yinqiantong.util.SignUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public final class Yinqiantong {
    private String appId;
    private String appKey;
    private String appSecret;

    private int requestTimeout = 1000;

    public static Yinqiantong create(String appId, String appKey, String appSecret) {
        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(appKey) || StringUtils.isEmpty(appSecret)) {
            throw new IllegalArgumentException("empty key");
        }

        return new Yinqiantong(appId, appKey, appSecret);
    }

    private Yinqiantong(String appId, String appKey, String appSecret) {
        this.appId = appId;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public Yinqiantong setRequestTimeout(int timeout) {
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

    public String createSign(Map<String, Object> data, long ts) {
        return SignUtil.createSign(data, ts, appSecret);
    }

    public Order createOrder(Options options) throws Exception {
        if (options.getTs() <= 0L) {
            options.setTs(System.currentTimeMillis() / 1000L);
        }
        OrderRes res = Api.createOrder(this, options);
        if (!res.isSuccess()) {
            throw new Exception(res.getMsg());
        }

        return res.getOrder();
    }

    public Order getOrder(String outTradeNo) throws Exception {
        OrderRes res = Api.getOrder(this, outTradeNo);
        if (!res.isSuccess()) {
            throw new Exception(res.getMsg());
        }

        return res.getOrder();
    }

    public Order getClientOrder(String clientOutTradeNo) throws Exception {
        OrderRes res = Api.getClientOrder(this, clientOutTradeNo);
        if (!res.isSuccess()) {
            throw new Exception(res.getMsg());
        }

        return res.getOrder();
    }

    public boolean checkSign(Map<String, Object> data, long ts, String sign) {
        if (StringUtils.isEmpty(sign)) {
            return false;
        }

        String currSign = createSign(data, ts);

        return sign.equals(currSign);
    }

}
