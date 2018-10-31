package com.yinqiantong;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.yinqiantong.common.Constants;
import com.yinqiantong.model.Options;
import com.yinqiantong.model.Order;
import com.yinqiantong.model.OrderRes;
import com.yinqiantong.model.OrderStateRes;
import com.yinqiantong.net.Api;
import com.yinqiantong.util.SignUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public final class Yinqiantong {
    private String appId;
    private String appSecret;

    private int requestTimeout = 1000;

    public static Yinqiantong create(String appId, String appSecret) {
        if (StringUtils.isEmpty(appId) || StringUtils.isEmpty(appSecret)) {
            throw new IllegalArgumentException("empty key");
        }

        return new Yinqiantong(appId, appSecret);
    }

    private Yinqiantong(String appId, String appSecret) {
        this.appId = appId;
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

    public String getAppSecret() {
        return appSecret;
    }

    public String createSign(Options options) {
        return SignUtil.createSign(getAppId(), getAppSecret(), options);
    }

    public String createSign(Map<String, Object> data) {
        if (!data.containsKey(Constants.KEY.APPID)) {
            data.put(Constants.KEY.APPID, appId);
        }
        return SignUtil.createSign(data, appSecret);
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

    public OrderStateRes getOrderStateByOutTradeNo(String outTradeNo) throws Exception {
        return Api.getOrderStateByOutTradeNo(this, outTradeNo);
    }

    public OrderStateRes getOrderStateByClientOutTradeNo(String clientOutTradeNo) throws Exception {
        return Api.getOrderStateByClientOutTradeNo(this, clientOutTradeNo);
    }

    public boolean checkSign(Map<String, Object> data, String sign) {
        if (StringUtils.isEmpty(sign) || data == null) {
            return false;
        }

        String currSign = createSign(data);

        return sign.equals(currSign);
    }

    public boolean checkSign(Map<String, Object> data) {
        if (data == null || !data.containsKey(Constants.KEY.SIGN)) {
            return false;
        }

        String sign = String.valueOf(data.get(Constants.KEY.SIGN));
        if (StringUtils.isEmpty(sign)) {
            return false;
        }

        String currSign = createSign(data);
        return sign.equals(currSign);
    }

    public boolean checkSign(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        }

        // int to double problem in Gson
        Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(new TypeToken<Map<String, Object>>() {
                }.getType()
                , new MapTypeAdapter()).create();

        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> data;
        try {
            data = gson.fromJson(json, type);
        } catch (Exception e) {
            return false;
        }

        return checkSign(data);
    }

    public static class MapTypeAdapter extends TypeAdapter<Object> {
        @Override
        public Object read(JsonReader in) throws IOException {
            JsonToken token = in.peek();
            switch (token) {
                case BEGIN_ARRAY:
                    List<Object> list = new ArrayList<>();
                    in.beginArray();
                    while (in.hasNext()) {
                        list.add(read(in));
                    }
                    in.endArray();
                    return list;

                case BEGIN_OBJECT:
                    Map<String, Object> map = new LinkedTreeMap<>();
                    in.beginObject();
                    while (in.hasNext()) {
                        map.put(in.nextName(), read(in));
                    }
                    in.endObject();
                    return map;

                case STRING:
                    return in.nextString();

                case NUMBER:
                    double dbNum = in.nextDouble();

                    // 数字超过long的最大值，返回浮点类型
                    if (dbNum > Long.MAX_VALUE) {
                        return dbNum;
                    }

                    // 判断数字是否为整数值
                    long lngNum = (long) dbNum;
                    if (dbNum == lngNum) {
                        return lngNum;
                    } else {
                        return dbNum;
                    }

                case BOOLEAN:
                    return in.nextBoolean();

                case NULL:
                    in.nextNull();
                    return null;

                default:
                    throw new IllegalStateException();
            }
        }

        @Override
        public void write(JsonWriter jsonWriter, Object o) throws IOException {

        }
    }

}
