### SpringMVC

##### 基本概念

* MVC是一种架构思想，将软件按模型，试图，控制器来划分

  * M：Model模型，指工程中的JavaBan，处理数据
    * 实体类bean 专门存储数据的，例如User等
    * 业务处理bean 处理业务逻辑的，例如service和dao等

  * V：View视图层，工程中的jsp，html等，用来与用户交互，展示数据
  * C：Controller控制层，工程中的servlet，用来接受请求以及相应浏览器

* MVC的工作流程：

  *用户通过视图层发送请求至服务器，服务器请求被collectroller接受，collectroller调用service处理请求，处理完成之后返回给collectroller，collectroller根据请求结果找到对应的view，渲染数据，响应给浏览器*

* springMVC特点

  * 与IOC无缝衔接
  * 基于原生的servlet,通过前段控制器DispatcherServlet，对请求和响应进行统一处理
  * 代码清晰简洁，组件化程度高，即插即用，性能卓越

* 环境搭建

  * 使用spring-webmvc；logback-classic；thymeleaf-spring5
  * 配置web.xml文件-->开启包扫描；配置Thymeleaf视图解析器

* hello world

  使用requestMapping注解，表示地址，return一个"index"即可，因为配置了前缀和后缀

  要跳转到其他地址时，配置requestMapping地址及方法即可，用的是请求转发

  ---

  浏览器发送请求后，请求地址符合我们前端控制器的url-pattern(就是/)，之后被DispatchServlet处理，通过组件扫描得到控制器，将请求地址和控制器注解中的路径比较，匹配成功后，处理请求之后通过返回的字符串加上前后缀匹配视图，渲染后，转发到视图对应的页面

  ---

  

