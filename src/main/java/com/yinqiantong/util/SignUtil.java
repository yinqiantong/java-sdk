package com.yinqiantong.util;

import com.yinqiantong.common.Constants;
import com.yinqiantong.model.Options;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SignUtil {
    public static String createSign(Map<String, Object> data, String appSecret) {
        StringBuilder signOrigin = new StringBuilder();
        if (data != null && !data.isEmpty()) {
            List<String> keys = new ArrayList<>(data.keySet());
            Collections.sort(keys);
            for (String key : keys) {
                if (StringUtils.isEmpty(key) || data.get(key) == null || key.equals(Constants.KEY.SIGN)) {
                    continue;
                }
                if (data.get(key) instanceof String) {
                    if (StringUtils.isEmpty((String) data.get(key))) {
                        continue;
                    }
                }
                signOrigin.append(key).append('=').append(data.get(key)).append('&');
            }
        }
        appendIfNotEmpty(signOrigin, Constants.KEY.APP_SECRET, appSecret);

        signOrigin.deleteCharAt(signOrigin.length() - 1);

        return DigestUtils.md5Hex(signOrigin.toString());
    }

    public static String createSign(String appId, String appSecret, Options options) {
        StringBuilder signOrigin = new StringBuilder();
        appendIfNotEmpty(signOrigin, Constants.KEY.APPID, appId);
        appendIfNotEmpty(signOrigin, Constants.KEY.CHANNEL, options.getChannel());
        appendIfNotEmpty(signOrigin, Constants.KEY.CLIENT_IP, options.getClientIp());
        appendIfNotEmpty(signOrigin, Constants.KEY.CLIENT_OUT_TRADE_NO, options.getClientOutTradeNo());
        appendIfNotEmpty(signOrigin, Constants.KEY.CODE, options.getCode());
        appendIfNotEmpty(signOrigin, Constants.KEY.DESCRIPTION, options.getDescription());
        appendIfNotEmpty(signOrigin, Constants.KEY.EXTRA, options.getExtra());
        appendIfNotEmpty(signOrigin, Constants.KEY.MONEY, options.getMoney());
        appendIfNotEmpty(signOrigin, Constants.KEY.NOTIFY_URL, options.getNotifyUrl());
        appendIfNotEmpty(signOrigin, Constants.KEY.OPEN_ID, options.getOpenId());
        appendIfNotEmpty(signOrigin, Constants.KEY.PLATFORM, options.getPlatform());
        appendIfNotEmpty(signOrigin, Constants.KEY.RETURN_URL, options.getReturnUrl());
        appendIfNotEmpty(signOrigin, Constants.KEY.SUBJECT, options.getSubject());

        appendIfNotEmpty(signOrigin, Constants.KEY.TS, options.getTs());
        appendIfNotEmpty(signOrigin, Constants.KEY.APP_SECRET, appSecret);

        signOrigin.deleteCharAt(signOrigin.length() - 1);

        return DigestUtils.md5Hex(signOrigin.toString());
    }

    private static void appendIfNotEmpty(StringBuilder sb, String key, String value) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        sb.append(key).append('=').append(value).append('&');
    }

    private static void appendIfNotEmpty(StringBuilder sb, String key, Object value) {
        sb.append(key).append('=').append(value).append('&');
    }
}
