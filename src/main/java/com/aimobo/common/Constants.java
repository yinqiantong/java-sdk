package com.aimobo.common;

public final class Constants {
    public static final class URL {
        private static final String HOST = "http://127.0.0.1:8000";
        public static final String ORDER = HOST + "/order";
    }

    public static final class KEY {
        public static final String CHANNEL = "channel";
        public static final String CLIENT_IP = "client_ip";
        public static final String DESCRIPTION = "description";
        public static final String EXTRA = "extra";
        public static final String MONEY = "money";
        public static final String OPEN_ID = "open_id";
        public static final String PLATFORM = "platform";
        public static final String SUBJECT = "subject";
        public static final String TS = "ts";
        public static final String APP_SECRET = "app_secret";
        public static final String APPKEY = "appkey";
        public static final String APPID = "appid";
        public static final String SIGN = "sign";
    }

    public static final class CODE {
        public static final int SUCCESS = 200;
    }
}
