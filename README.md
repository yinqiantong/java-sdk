# Yinqiantong SDK for Java

## 创建订单

```
Yinqintong.create(appId, appKey, appSecret)
        .createOrder(Options.newInstance()
                .setChannel("alipay")
                .setPlatform("app")
                .setMoney(1)
                .setClientIp("127.0.0.1")
                .setTs(1536286756L));
```
