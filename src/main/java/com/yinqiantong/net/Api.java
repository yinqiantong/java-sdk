package com.yinqiantong.net;

import com.google.gson.Gson;
import com.yinqiantong.Yinqiantong;
import com.yinqiantong.common.Constants;
import com.yinqiantong.model.Options;
import com.yinqiantong.model.OrderRes;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.util.List;


public class Api {
    public static OrderRes createOrder(Yinqiantong yinqiantong, Options options) throws Exception {
        List<NameValuePair> form = Form.form()
                .add(Constants.KEY.CHANNEL, options.getChannel())
                .add(Constants.KEY.PLATFORM, options.getPlatform())
                .add(Constants.KEY.MONEY, String.valueOf(options.getMoney()))
                .add(Constants.KEY.CLIENT_IP, options.getClientIp())
                .add(Constants.KEY.OPEN_ID, options.getOpenId())
                .add(Constants.KEY.SUBJECT, options.getSubject())
                .add(Constants.KEY.DESCRIPTION, options.getDescription())
                .add(Constants.KEY.EXTRA, options.getExtra())
                .add(Constants.KEY.CODE, options.getCode())
                .add(Constants.KEY.NOTIFY_URL, options.getNotifyUrl())
                .add(Constants.KEY.RETURN_URL, options.getReturnUrl())
                .add(Constants.KEY.CLIENT_OUT_TRADE_NO, options.getClientOutTradeNo())
                .build();

        String order = Request.Post(Constants.URL.ORDER)
                .connectTimeout(yinqiantong.getRequestTimeout())
                .socketTimeout(yinqiantong.getRequestTimeout())
                .addHeader(Constants.KEY.APPID, yinqiantong.getAppId())
                .addHeader(Constants.KEY.APPKEY, yinqiantong.getAppKey())
                .addHeader(Constants.KEY.TS, String.valueOf(options.getTs()))
                .addHeader(Constants.KEY.SIGN, yinqiantong.createSign(options))
                .bodyForm(form)
                .execute().returnContent().asString();

        Gson gson = new Gson();
        return gson.fromJson(order, OrderRes.class);
    }

    public static OrderRes getOrder(Yinqiantong yinqiantong, String outTradeNo) throws Exception {
        String url = String.format("%s?out_trade_no=%s", Constants.URL.ORDER, outTradeNo);
        return executeOrderGet(yinqiantong, url);
    }

    public static OrderRes getClientOrder(Yinqiantong yinqiantong, String clientOutTradeNo) throws Exception {
        String url = String.format("%s?client_out_trade_no=%s", Constants.URL.ORDER, clientOutTradeNo);
        return executeOrderGet(yinqiantong, url);
    }

    private static OrderRes executeOrderGet(Yinqiantong yinqiantong, String url) throws Exception {
        long ts = System.currentTimeMillis() / 1000L;
        String order = Request.Get(url)
                .addHeader(Constants.KEY.APPID, yinqiantong.getAppId())
                .addHeader(Constants.KEY.APPKEY, yinqiantong.getAppKey())
                .addHeader(Constants.KEY.TS, String.valueOf(ts))
                .addHeader(Constants.KEY.SIGN, yinqiantong.createSign(null, ts))
                .execute().returnContent().asString();

        Gson gson = new Gson();
        return gson.fromJson(order, OrderRes.class);
    }
}
