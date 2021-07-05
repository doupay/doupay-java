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
	  <version>Tag</version>
   </dependency>
```
#### 示例截图如下:
图中示例版本号"0.0.1"会随时变化,请随时关注本github更新

<img width="864" alt="步骤" src="https://user-images.githubusercontent.com/86946898/124468680-feed5b80-ddcb-11eb-927f-c10855eeaf86.png">

### 项目中调用初始化方法,示例如下:

<img width="1178" alt="步骤2" src="https://user-images.githubusercontent.com/86946898/124469236-aff3f600-ddcc-11eb-9c21-554e901a1ee9.png">

sdk中各方法请求和响应参数,请参照[wiki](https://github.com/doupay/doupay-java/wiki)
