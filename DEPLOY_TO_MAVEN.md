
## Upgrade version in pom.xml

```
<version>0.0.2</version>
```

## Package and deploy to Maven center

```
$ cd project_dir
$ mvn clean deploy -P release
```

enter the password

> see also Evernote

##

After build success, visit [https://oss.sonatype.org/#stagingRepositories](https://oss.sonatype.org/#stagingRepositories)

Login in

Search `yinqiantong`

Select the Repository about `yinqiantong`

Click the button `close` and add some comment in the model dialog.

After a while, click the button `refresh`.

Click the button `Release` and add some description in the model dialog. 

## Get the maven repository

After a while, we can get the repository here.

[https://search.maven.org/search?q=yinqiantong](https://search.maven.org/search?q=yinqiantong)