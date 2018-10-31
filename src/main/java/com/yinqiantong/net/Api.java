package com.yinqiantong.net;

import com.google.gson.Gson;
import com.yinqiantong.Yinqiantong;
import com.yinqiantong.common.Constants;
import com.yinqiantong.model.Options;
import com.yinqiantong.model.Order;
import com.yinqiantong.model.OrderRes;
import com.yinqiantong.model.OrderStateRes;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.util.List;


public class Api {
    public static OrderRes createOrder(Yinqiantong yinqiantong, Options options) throws Exception {
        List<NameValuePair> form = Form.form()
                .add(Constants.KEY.APPID, yinqiantong.getAppId())
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
                .add(Constants.KEY.TS, String.valueOf(options.getTs()))
                .add(Constants.KEY.SIGN, yinqiantong.createSign(options))
                .add(Constants.KEY.CLIENT_OUT_TRADE_NO, options.getClientOutTradeNo())
                .build();

        String order = Request.Post(Constants.URL.ORDER)
                .connectTimeout(yinqiantong.getRequestTimeout())
                .socketTimeout(yinqiantong.getRequestTimeout())
                .bodyForm(form)
                .execute().returnContent().asString();

        Gson gson = new Gson();
        OrderRes res = gson.fromJson(order, OrderRes.class);

        Order resOrder = res.getOrder();
        if (resOrder != null) {
            resOrder.setApp_id(yinqiantong.getAppId());
            resOrder.setChannel(options.getChannel());
            resOrder.setPlatform(options.getPlatform());
            resOrder.setMoney(options.getMoney());
            resOrder.setClient_ip(options.getClientIp());
            resOrder.setOpenId(options.getOpenId());
            resOrder.setSubject(options.getSubject());
            resOrder.setDescription(options.getDescription());
            resOrder.setExtra(options.getExtra());
            resOrder.setNotify_url(options.getNotifyUrl());
            resOrder.setReturn_url(options.getReturnUrl());
            resOrder.setClient_out_trade_no(options.getClientOutTradeNo());
        }

        return res;
    }

    public static OrderStateRes getOrderStateByOutTradeNo(Yinqiantong yinqiantong, String outTradeNo) throws Exception {
        String url = String.format("%s?appid=%s&out_trade_no=%s&ts=%s",
                Constants.URL.ORDER, yinqiantong.getAppId(), outTradeNo, System.currentTimeMillis() / 1000);
        return executeOrderGet(yinqiantong, url);
    }

    public static OrderStateRes getOrderStateByClientOutTradeNo(Yinqiantong yinqiantong, String clientOutTradeNo) throws Exception {
        String url = String.format("%s?appid=%s&client_out_trade_no=%s&ts=%s",
                Constants.URL.ORDER, yinqiantong.getAppId(), clientOutTradeNo, System.currentTimeMillis() / 1000);
        return executeOrderGet(yinqiantong, url);
    }

    private static OrderStateRes executeOrderGet(Yinqiantong yinqiantong, String url) throws Exception {
        String order = Request.Get(url)
                .connectTimeout(yinqiantong.getRequestTimeout())
                .socketTimeout(yinqiantong.getRequestTimeout())
                .execute()
                .returnContent()
                .asString();

        Gson gson = new Gson();
        return gson.fromJson(order, OrderStateRes.class);
    }
}
