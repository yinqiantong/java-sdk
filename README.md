# Yinqiantong SDK for Java

# 安装

您可以通过以下的其中一种方式引入 SDK

1，Gradle：

```
compile 'com.github.yinqiantong:java-sdk:0.0.2'
```

2，Maven:

```
<dependency>
  <groupId>com.github.yinqiantong</groupId>
  <artifactId>java-sdk</artifactId>
  <version>0.0.2</version>
</dependency>
```

3，Jar 包引入：

[下载 Jar](https://search.maven.org/remotecontent?filepath=com/github/yinqiantong/java-sdk/0.0.2/java-sdk-0.0.2-sources.jar)

4，其他：

更多方式，欢迎到 [Sonatype](https://search.maven.org/artifact/com.github.yinqiantong/java-sdk/0.0.2/jar) 中了解更多

## 创建订单

```
Yinqiantong.create(appId, appKey, appSecret)
        .createOrder(Options.newInstance()
                .setChannel("alipay")
                .setPlatform("app")
                .setMoney(1)
                .setNotifyUrl('https://host.com/notify_url')
                .setClientIp("127.0.0.1"));
```
