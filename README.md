# Yinqiantong SDK for Java

# 安装

您可以通过以下的其中一种方式引入 SDK

1，Gradle：

```
compile 'com.github.yinqiantong:java-sdk:0.0.7'
```

2，Maven:

```
<dependency>
  <groupId>com.github.yinqiantong</groupId>
  <artifactId>java-sdk</artifactId>
  <version>0.0.7</version>
</dependency>
```

3，Jar 包引入：

[下载 Jar](https://search.maven.org/remotecontent?filepath=com/github/yinqiantong/java-sdk/0.0.7/java-sdk-0.0.7-sources.jar)

4，其他：

更多方式，欢迎到 [Sonatype](https://search.maven.org/artifact/com.github.yinqiantong/java-sdk/0.0.7/jar) 中了解更多

## 创建订单

```
Yinqiantong.create(appId, appKey, appSecret)
        .createOrder(Options options = Options.newInstance()
                 .setChannel("alipay")
                 .setPlatform("app")
                 .setMoney(1)
                 .setClientIp("127.0.0.1")
                 .setNotifyUrl("https://yinqiantong.com/test")
                 .setClientOutTradeNo(createClientOutTradeNo())
                 .setTs(System.currentTimeMillis() / 1000L));
```
