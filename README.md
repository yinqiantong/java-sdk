# Yinqiantong SDK for Java

# 安装

您可以通过以下的其中一种方式引入 SDK

1，Gradle：

```
compile 'com.github.yinqiantong:java-sdk:0.0.9'
```

2，Maven:

```
<dependency>
  <groupId>com.github.yinqiantong</groupId>
  <artifactId>java-sdk</artifactId>
  <version>0.0.9</version>
</dependency>
```

3，Jar 包引入：

[下载 Jar](https://search.maven.org/remotecontent?filepath=com/github/yinqiantong/java-sdk/0.0.9/java-sdk-0.0.9-sources.jar)

4，其他：

更多方式，欢迎到 [Sonatype](https://search.maven.org/artifact/com.github.yinqiantong/java-sdk/0.0.9/jar) 中了解更多


## 创建订单

```
Yinqiantong.create(appId, appSecret)
        .createOrder(Options options = Options.newInstance()
                 .setChannel("1")
                 .setPlatform("2")
                 .setMoney(1)
                 .setClientIp("127.0.0.1")
                 .setNotifyUrl("https://yinqiantong.com/test")
                 .setClientOutTradeNo(createClientOutTradeNo());
```


## 验证签名

```
Yinqiantong.create(appId, appSecret).checkSign(notifyDataStr);
```

## 生成签名

```
Yinqiantong.create(appId, appSecret).createSign(yourData);
```