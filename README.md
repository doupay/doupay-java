# 该项目支持两种集成方式


## 1.maven,使用方法如下:

### 1.将 JitPack存储库添加到您的构建文件pom.xml

```javascript
 <repositories>
	<repository>
	     <id>jitpack.io</id>
		   <url>https://jitpack.io</url>
	</repository>
 </repositories>
```

###  2.添加依赖项

```javascript
  <dependency>
	  <groupId>com.github.doupay</groupId>
	  <artifactId>doupay-java</artifactId>
	  <version>1.0.23</version>
   </dependency>
```
#### 示例截图如下:
图中示例版本号"0.0.1"会随时变化,请随时关注本github更新,现在最新的版本号为1.0.23

<img width="864" alt="步骤" src="https://user-images.githubusercontent.com/86946898/124468680-feed5b80-ddcb-11eb-927f-c10855eeaf86.png">

### 项目中调用初始化方法,示例如下:

![111](https://user-images.githubusercontent.com/86946898/128279082-9869ff2e-e370-4cb4-b5f9-944f4a33389c.png)

### 以下方法可以设置语言类别

```java
Constants.setLanguage(Language.zh_CN);/// 中文
Constants.setLanguage(Language.en_US);/// 英文
```
#### secret为商户管理后台创建app得到的,appid为创建app得到的,privateKey为自己的私钥,publicKey为交换公钥后得到的平台公钥,expireTime为订单过期时间,秒为单位,expireTime大于1800秒,小于7200秒

## sdk中各方法请求和响应参数,请参照[wiki](https://github.com/doupay/doupay-java/wiki)

<!-- ## 2.jar包引入
   ### 1.1 把jar包拖入项目,如下图所示:jar包在文件中即DouPaySdk.jar,也可以自己用源代码打包
   
   <img width="1488" alt="1111" src="https://user-images.githubusercontent.com/86946898/127596834-639f94c0-e775-4911-9433-f976589852ee.png">
   
  ### 1.2 pom.xml配置文件中添加以下依赖,代码和截图见下方
  
   ```javascript
        <dependency>
            <groupId>com.github.doupay</groupId>
            <artifactId>doupay-java</artifactId>
            <version>1.0.8</version>
            <scope>system</scope>
            <systemPath>${basedir}/src/main/resources/lib/DouPaySDK.jar</systemPath>
        </dependency>
   ```
   
<img width="1644" alt="222" src="https://user-images.githubusercontent.com/86946898/127596733-766e8f04-8cd6-4d86-bc1a-d52e5c6e7213.png">

### 项目中调用初始化方法,示例如下:

![111](https://user-images.githubusercontent.com/86946898/128279082-9869ff2e-e370-4cb4-b5f9-944f4a33389c.png)

#### secret为商户管理后台创建app得到的,appid为创建app得到的,privateKey为自己的私钥,publicKey为交换公钥后得到的平台公钥,expireTime为订单过期时间,秒为单位

## sdk中各方法请求和响应参数,请参照[wiki](https://github.com/doupay/doupay-java/wiki)

 -->
