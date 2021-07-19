## 该项目支持maven,使用方法如下:
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
	  <version>0.0.1</version>
   </dependency>
```

#### 示例截图如下:
图中示例版本号"0.0.1"会随时变化,请随时关注本github更新

<img width="864" alt="步骤" src="https://user-images.githubusercontent.com/86946898/124468680-feed5b80-ddcb-11eb-927f-c10855eeaf86.png">

### 项目中调用初始化方法,示例如下:

<img width="1212" alt="WX20210719-150251@2x" src="https://user-images.githubusercontent.com/86946898/126117050-cfe124c1-5a86-4101-8ab8-ecd051b2d8bb.png">

#### secret为商户管理后台创建app得到的,secretappid为创建app得到的,privateKey为自己的私钥,publicKey为交换公钥后得到的平台公钥,expireTime为订单过期时间,秒为单位

sdk中各方法请求和响应参数,请参照[wiki](https://github.com/doupay/doupay-java/wiki)
