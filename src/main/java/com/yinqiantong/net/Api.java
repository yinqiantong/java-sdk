package com.yinqiantong.net;

import com.yinqiantong.Yinqiantong;
import com.yinqiantong.common.Constants;
import com.yinqiantong.model.Options;
import com.yinqiantong.model.Res;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.util.List;


public class Api {
    public static Res.OrderRes createOrder(Yinqiantong yinqiantong, Options options) throws Exception {
        List<NameValuePair> form = Form.form()
                .add(Constants.KEY.CHANNEL, options.getChannel())
                .add(Constants.KEY.PLATFORM, options.getPlatform())
                .add(Constants.KEY.MONEY, String.valueOf(options.getMoney()))
                .add(Constants.KEY.CLIENT_IP, options.getClientIp())
                .add(Constants.KEY.OPEN_ID, options.getOpenId())
                .add(Constants.KEY.SUBJECT, options.getSubject())
                .add(Constants.KEY.DESCRIPTION, options.getDescription())
                .add(Constants.KEY.EXTRA, options.getExtra())
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
        return gson.fromJson(order, Res.OrderRes.class);
    }

    public static Res.OrderRes getOrder(Yinqiantong yinqiantong, String outTradeNo) throws Exception {
        String url = String.format("%s/%s", Constants.URL.ORDER, outTradeNo);

        String order = Request.Get(url)
                .addHeader(Constants.KEY.APPID, yinqiantong.getAppId())
                .addHeader(Constants.KEY.APPKEY, yinqiantong.getAppKey())
                .execute().returnContent().asString();

        Gson gson = new Gson();
        return gson.fromJson(order, Res.OrderRes.class);
    }
}
