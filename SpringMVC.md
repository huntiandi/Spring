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

##### @RequestMapping注解

collectroller

* 作用：将请求和处理请求的控制器方法关联起来，建立映射关系
* 位置：类，方法；在类上是请求路径的初始信息，方法上是请求路径的具体信息
* ==value属性==：可以是个数组，只要满足数组中任一值，即可访问---------》404
* ==method属性==：通过请求方式匹配->get或者post通过RequestMethod去点，可以是多个值----》405
* 派生的注解，请求方式必须是对应的请求方法
  * @GetMapping        浏览器直接提交是get
  * @PostMapping      form表单可以设置为post
  * PutMapping            需要使用spring提供的过滤器HiddenHttpMethodFilter
  * DeleteMapping
* params属性：必须全部符合才能调用，通过请求参数匹配----------》400
* heards属性：必须全部符合才能调用，通过请求头信息匹配--------》404
* springMVC支持Ant风格，所以value里面可以使用?,*,**
  * 使用两个*时，要使用/**/xxx风格
* ==springMVC支持路径占位符==
  * 在传参数时使用rest方式：/deleteUser/1等同于原始的：/deleteUser?id=1
  * 路径中的占位符常用于restful风格，通过==@PathVariable==注解，将占位符表示的数据赋值给控制器方法的参数

---

##### SpringMVC获取请求参数

* 使用servletAPI获取：前端控制器会把request传入，所以可以直接使用HttpServletRequest中
* 通过控制器形参获取参数(形参名必须和参数名一致)
  * 当只有一个参数时，直接拿字符串接受即可，当有多个同名参数时，例如复选框，还可以拿字符串接受，接收到的是以逗号分割的参数，也可以使用字符串数组接受
* 通过控制器注解获取参数
  * ==@RequestParam注解==：将请求参数和控制器方法的形参创建映射关系；
  * 若没有该注解映射的参数会报错400，可以修改required为FALSE若没有就会使用null默认值
  * 不管required值是什么，==设置defaultValue属性==当没有传输或者传输为空的时候会使用默认值
* 获取请求头信息
  * ==@RequestHeader注解==：将请求头信息与控制器方法的形参创建映射关系
  * 也有required和defaultValue这两属性，作用和使用方式一样
* 获取cookie信息
  * @CookieValue：将cookie和控制器方法的形参创建映射关系，同样拥有上面两个属性
* 通过JavaBean获取参数
  * 在控制器方法中直接拿bean接受即可，但是前台的参数名要和bean的属性名一致
  * 解决post响应编码，在web.xml中配置spring的过滤器，CharacterEncodingFilter

---

##### 域对象共享数据

model

###### 五种方式向request域共享对象

五种方式底层都是使用ModelAndView

* Servlet共享，在控制器方法中加入HttpServletRequest对象；不建议
* 使用==ModelAndView==向request域对象共享数据
  * 返回值必须是ModelAndView，设置数据使用addObject，设置视图使用setViewName
* 使用Model向request域对象共享
  * 在控制器方法传入model对象，使用model.addAttribute方法，返回的是string
* 使用map向request域对象共享
  * 在控制器方法传入map对象，使用map.put存放数据，返回还是String
* 使用ModelMap向request域对象共享
  * 在控制器传入ModelMap对象，使用put或者addAttribute，放回是string

###### 几种方式的关系

* Model，Map，ModelMap的关系-------》本质上都是BindingAwareModelMap
  * Model是一个接口，ModelMap继承了linkedHashMap，ExtendedModelMap继承了ModelMap实现了Model，而BindingAwareModelMap继承了ExtendedModelMap
  * ModelAndView返回值必须是ModelAndView其他的返回String即可

###### 向session域共享数据

* 建议使用HttpSession共享，方便

###### 向application域共享数据

* 先获取ServletContext，例如session.getServletContext()，在插入数据

---

##### SpringMVC的视图

view

###### 基本概念

* SpringMVC的视图是view接口，视图的作用是渲染数据，将模型Model的数据展示给用户
* 默认有两种一种是转发视图一种是重定向视图，还有jstl视图以及ThymeleafView

###### 1.转发视图

* 需要添加forward:前缀，就是InternalResourceView视图了；视图名称就不会被配置文件解析，而是去掉前缀跳转指定路径
* 当前资源是jsp时，没有前缀和forward前缀创建的都是InternalResourceView转发视图；使用"redirect:"前缀是重定向视图

###### 2.重定向视图

* 需要添加"redirect:"前缀，就是RedirectView视图了；视图名称就不会被配置文件解析，而是去掉前缀,将剩余部分作为全路径去重定向跳转

###### 3.Thymeleaf视图

* 当没有任何前缀时，会被视图解析器解析，配置的是什么就是什么，我们配置的是Thymeleaf所以，解析后加上前后缀就变成了ThymeleafView，转发到对应的路径

###### 4.视图控制器view-controller

* 在控制器方法中，仅仅用来实现页面跳转，即只需要设置视图名称时，可以将控制器方法使用view-controller标签进行表示；例如首页；
* 当开始控制器标签后，其他控制器映射全部失效，需要开启MVC注解驱动

---

##### RESTFul

###### 基本概念

* 是一种风格；就是一种规范：GET ,POST，PUT，DELETE
* ReST表现层资源状态转移；资源就是部署在服务器上的各种文件等等；资源的表述是指资源在某个特定时刻状态的描述；状态转移是说在客户端和服务器之间转移代表资源状态的表述，通过转移和操作资源的表述来间接操作资源

###### RESTFul的实现

* 每个单词都是用/分割，不使用？键值对的形式传输，而是将数据作为路径的一部分

| 操作     | 传统方式        | RESTFul风格             |
| -------- | --------------- | ----------------------- |
| 查询操作 | getUserId?id=1  | user/1-->get请求方式    |
| 保存操作 | saveUser        | user-->post请求方式     |
| 删除操作 | deleteUser?id=1 | user/1-->delete请求方式 |
| 更新操作 | updateUser      | user/1-->put请求方式    |

* PUT和DELETE请求需要HiddenHttpMethodFilter过滤器
  * 整个过滤器要求提交方式必须是post并且，传入一个hidden标签，name是"_method"值是真正的请求方式；之后整个过滤器会把请求方式由post替换成相应的请求方式
  * 在配置过滤器时，要注意，设置编码的过滤器要放在第一个位置，否则因为HiddenHttpMethodFilter这个过滤器获取过参数了，编码过滤器就会失效。

##### HttpMessageConverter

###### 基本概念

* HttpMessageConverter是报文信息转换器，即将请求报文转换为Java对象；将Java对象转换为响应报文的过程
* 在此过程中提供了两个注解两个类：@RequestBody，==@ResponseBody==，RequestEntity，ResponseEntity

###### 1.@RequestBody

* 可以获取请求体，在控制器方法参数中使用该注解标注，改形参就会被请求体赋值

###### 2.RequestEntity

* 是封装请求报文的一种类型，在控制器方法参数中设置该类型的形参，即可获取请求头，请求体等信息

###### 3.@ResponseBody

* 用于标识一个控制器方法，可以将该方法的返回值作为响应报文的响应体直接响应到浏览器
* 返回对象时：1.需要引入gson；2.配置mvc驱动；3.使用@ResponseBody注解；4.将对象直接作为控制器方法返回值返回；就可以将对象自动转换成成JSON格式的字符串返回

###### 4.@RestController

* 相当于@Controller加@ResponseBody，即给控制器中的每一个方法都添加了@ResponseBody注解

###### 5.ResponseEntity

* 用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
* 实现文件下载功能

###### 6.文件上传与下载

* 下载功能要使用ResponseEntity类
* 上传功能要使用文件上传解析器，文件上传解析类 id必须是multipartResolver，否则会报错；
  * 上传功能控制器方法使用MultipartFile类接收文件
  * 使用UUID这个32位随机数，来命名文件名，防止重名问题

---

##### 拦截器

###### 基本概念

* 拦截器的执行位于dispatcherServlet与controller之间；用于拦截控制器方法的执行；而过滤器位于dispatcherServlet之前；
* 当一次请求发送到服务器时，会先经过过滤器，过滤器放行后去找到dispatcherServlet，ds会去找对应的控制器方法，在这之间会执行拦截器；

###### 拦截器的实现

* 拦截器必须在配置文件中配置，三种配置方式；需要实现HandlerInterceptor接口
* 拦截器的三个抽象方法
  * preHandle位于控制器方法之前执行；返回值为TRUE表示放行，返回为FALSE表示拦截
  * postHandle位于控制器方法之后执行
  * afterCompletion位于视图渲染之后执行

###### 多个拦截器的执行

* 拦截器顺序和配置文件中的顺序有关
  * 若返回都是TRUE时preHandle按顺序执行，其他两个按倒叙执行
  * 若返回为FALSE时，返回为FALSE的和他之前的preHandle会执行，POSTHandle都不执行；返回FALSE之前的afterCompletion执行

---

##### 异常处理器

###### 基本概念

* SpringMVC提供了处理控制器方法执行过程中所出现的异常的接口：HandlerExceptionResolver

* HandlerExceptionResolver有两个实现类，一个是默认的DefaultHandlerExceptionResolver一个是自定义的SimpleHandlerExceptionResolver

###### 基于配置的异常处理器

* 在SpringMVC.xml中设置SimpleMappingExceptionResolver这个bean配置参数即可

###### 基于注解的异常处理器

* @ControllerAdvice注解标识控制器，@ExceptionHandler标识方法，value中写错误类即可

---

##### 基于注解的SpringMVC

并不好用，详见WebInit

---

##### SpringMVC执行流程

###### 1.常用组件

* DispatcherServlet：前段控制器，用来统一处理请求与响应
* HandlerMapping：处理器映射，用来寻找url,method等信息调用的controller；实现路径和控制器方法的映射
* Handler：处理器，其实就是我们的controller，要自己写
* HandlerAdapter：处理器适配器，就是执行Handler的
* ViewResolve：视图解析器，进行视图解析，得到相应的视图
* View：视图，将数据通过页面渲染给用户

###### 2.SpringMVC的执行流程

1. 客户端发送请求
2. 经过过滤器后发送给了DispatcherServlet
3. Ds调用控制器映射器去寻找对应的控制器方法
4. 在通过拦截器后控制器适配器去执行控制器方法
5. 控制器方法将结果返回给适配器
6. 适配器返回给映射器
7. 映射器将结果返回给ds,ds调用视图解析器
8. 视图解析器将视图解析后返回给ds
9. ds将解析后的视图进行渲染
10. 响应给客户端

