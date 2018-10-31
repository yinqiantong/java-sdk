package com.yinqiantong.common;

public final class Constants {
    public static final class URL {
        private static final String HOST = "https://api.yqtapi.com";
        public static final String ORDER = HOST + "/order";
    }

    public static final class KEY {
        public static final String CHANNEL = "channel";
        public static final String CODE = "code";
        public static final String CLIENT_IP = "client_ip";
        public static final String DESCRIPTION = "description";
        public static final String EXTRA = "extra";
        public static final String MONEY = "money";
        public static final String OPEN_ID = "open_id";
        public static final String PLATFORM = "platform";
        public static final String SUBJECT = "subject";
        public static final String TS = "ts";
        public static final String APP_SECRET = "app_secret";
        public static final String APPID = "appid";
        public static final String SIGN = "sign";
        public static final String NOTIFY_URL = "notify_url";
        public static final String CLIENT_OUT_TRADE_NO = "client_out_trade_no";
        public static final String RETURN_URL = "return_url";
    }

    public static final class CODE {
        public static final int SUCCESS = 200;
        public static final int UNPAID = 4201;
        public static final int PAY_FAIL = 4400;
        public static final int ORDER_EXPIRED = 4408;
        public static final int NOT_FOUND = 4404;
        public static final int PARAM_ERROR = 4414;
        public static final int SERVER_ERROR = 4500;
    }
}
