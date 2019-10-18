# BlogServer

### 基于SpringBoot+MyBatis+AngularJS前后端分离的个人网络博客

### 主要技术
- SpringBoot
- MyBatis
- AngularJS

### 目前实现的主要功能
**前台**
- 主页所有文章显示
- 主页按类别进行分类
- 按分类进行查询
- 按标签进行查询
- 按标题或内容进行查询
- 查询高亮显示
- 日记详情显示
- 日记评论
- 日记点赞等

**管理后台**
- 查询所有日记
- 添加新日记
- 修改日记
- 代码Style
- 图片上传

### Run起来
1.你可以使用 
`git clone https://github.com/yangmingsen/BlogServer.git`将我的项目搞下来

2.然后使用IDEA 用maven方式导入即可

3.使用MySQL导入我项目上的**my_blog.sql**数据文件

4.OK,启动吧...

5.浏览器上输入`http://localhost:8080/index.html` 即可；后台管理端请访问`http://localhost:8080/admin/main.html`


### 项目结构
```text
Java
└─top
    └─yms
        └─server
            ├─config     // 运行配置文件,我配置了跨域一些东西
            ├─controller
            │  ├─admin   //管理后台业务控制
            │  └─blog    //博客前台
            ├─dao        //数据访问层
            ├─entity     //实体定义
            │  └─article 
            ├─service    //服务器控制
            └─utils      //一些小工具,如时间生成,Id生成...
            
Resources
└─static
    ├─admin                 //管理后台界面
    │  ├─css
    │  ├─fonts
    │  ├─images             //后台静态图片路径
    │  │  ├─404
    │  │  ├─arclist
    │  │  ├─banner
    │  │  ├─baoman
    │  │  ├─face
    │  │  ├─icon
    │  │  └─snow
    │  └─js                 //管理后台AngularJs控制文件                 
    │      ├─controller     //管理后台AngularJS控制层：控制前端的一些业务逻辑
    │      ├─js             //其他的一些JS文件
    │      └─service        //管理后台AngularJS的服务层: 掉服务接口的
    ├─css
    ├─images                //前台静态图片路径
    │  └─anonymous          //这个是匿名评论人的头像文件
    ├─js
    │  ├─controller         //前台AngularJs控制文件         
    │  ├─js
    │  └─service            //前台AngularJs服务层控制文件 
    ├─plugins
    │  ├─angularjs
    │  │  └─i18n
    │  └─markdown           //Markdown配置文件   
    │      ├─css
    │      ├─docs
    │      │  ├─fonts
    │      │  ├─scripts
    │      │  │  └─prettify
    │      │  └─styles
    │      ├─fonts
    │      ├─images
    │      │  └─logos
    │      ├─languages
    │      ├─lib            //Markdown的库文件   
    │      ├─plugins
    │      ├─scss
    │      │  └─lib
    │      ├─src
    │      └─tests
    │          ├─css
    │          ├─js
    │          └─qunit
    └─public

```


#### 注意
1.因为我还没有实现服务器,如果你要我的项目需要修改.\top\yms\server\controller\admin\FileController.java这个文件的图片存储路径
```java
private static String path = "D:\\setup\\tmp\\";
```
这里你需要修改为你的图片路径,或者你可以修改使用自己的图片服务器。

2.配置数据库连接
```yaml
spring:
  datasource:
    username: yms //配上自己的用户名
    password: 123456  //配上自己的密码
    url: jdbc:mysql://localhost:3306/my_blog?serverTimezone=GMT%2B8
    type: com.alibaba.druid.pool.DruidDataSource
    initialSize: 5
    minIdle: 1
    maxActive: 50
    maxWait: 60000
    timeBetweenEvictionRunsMillis: 60000
    minEvictableIdleTimeMillis: 300000
    validationQuery: SELECT 1 FROM DUAL
    testWhileIdle: true
    testOnBorrow: false
    testOnReturn: false
    poolPreparedStatements: true
    filters: stat,wall,log4j
    maxPoolPreparedStatementPerConnectionSize: 20
    useGlobalDataSourceStat: true
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
```

3.管理后台现在还没有实现登录


### 欢迎交流
- QQ:1710644559
- Mail: yangmingsen16@qq.com
