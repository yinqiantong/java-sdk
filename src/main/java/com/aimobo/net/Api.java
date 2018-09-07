package com.aimobo.net;

import com.aimobo.Yinqintong;
import com.aimobo.common.Constants;
import com.aimobo.model.Options;
import com.aimobo.model.Res;
import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.util.List;


public class Api {
    public static Res.OrderRes createOrder(Yinqintong yinqintong, Options options) throws Exception {
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
                .connectTimeout(yinqintong.getRequestTimeout())
                .socketTimeout(yinqintong.getRequestTimeout())
                .addHeader(Constants.KEY.APPID, yinqintong.getAppId())
                .addHeader(Constants.KEY.APPKEY, yinqintong.getAppKey())
                .addHeader(Constants.KEY.TS, String.valueOf(options.getTs()))
                .addHeader(Constants.KEY.SIGN, yinqintong.createSign(options))
                .bodyForm(form)
                .execute().returnContent().asString();

        Gson gson = new Gson();
        return gson.fromJson(order, Res.OrderRes.class);
    }

    public static Res.OrderRes getOrder(Yinqintong yinqintong, String outTradeNo) throws Exception {
        String url = String.format("%s/%s", Constants.URL.ORDER, outTradeNo);

        String order = Request.Get(url)
                .addHeader(Constants.KEY.APPID, yinqintong.getAppId())
                .addHeader(Constants.KEY.APPKEY, yinqintong.getAppKey())
                .execute().returnContent().asString();

        Gson gson = new Gson();
        return gson.fromJson(order, Res.OrderRes.class);
    }
}
