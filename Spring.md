

###                                																Spring

##### IOC的过程

（xml解析，工厂模式，反射）

* 第一步xml配置文件，配置创建的对象

  ```xm
  <bean id = "dao" class = "com.yang.dao.UserDao"></bean>
  ```

* 第二步 创建工厂类，

  ```java
  class UserFactory {
      public static UserDao getDao(){
          String classValue = class属性值;//xml的解析
          Class clazz = Clas.forName(clasValue);//通过反射创建对象
          return (UserDao)clazz.newInstance();
      }
  }
  ```

##### IOC接口

* IOC的思想是基于IOC容器完成的，IOC容器的底层则是对象工厂
* Spring提供IOC容器的两种实现：
  * BeanFactory IOC容器基本实现，是内部使用的接口
    * 加载配置文件时不会创建对象，在获取或使用时才会创建对象。
  * ApplicationContext 是BF的子接口，提供了更多的功能，开发者使用
    * 在加载配置文件就会创建
    * 常用的有FileSystemXmlApplicationContext磁盘任意目录；ClassPathXmlApplicationContext类的路径

##### IOC操作(Bean管理)

* Bean管理是指 Spring创建对象，Spring注入属性
* Bean管理的两种操作方式

###### 基于==xml==的配置文件

* (创建==对象==)在spring的配置文件中使用bean标签，标签添加对应属性

  * id属性：唯一标识；class属性：类全路径

  * 创建对象的时候默认也是无参构造器完成对象创建
* (注入==属性==)DI：依赖注入 ------>*bean1.xml*

  * 原始方式：使用set方法；使用有参构造器
* 注入特殊属性

  * ==null==值

  * 特殊符号   使用==CD==(<![CDATA[<<湖北崇阳老家>>]]>)进行包含--->*bean1.xml*
* 注入==外部bean==---->*bean2.xml*

* 注入==内部bean==和级联赋值----->*bean2.xml*
  * 一对多的关系使用部门和员工的模式；在员工中有一个属性是部门类，在设置部门属性时，加入bean，设置property

* 注入==集合==属性

  * 数组注入；list注入；map注入；set注入（*bean3.xml*）

  * 将集合提取为公共的  创建新的命名空间(util)，使用util标签

* 工厂Bean(==FactoryBean==) 

  * Spring有两种bean一种是普通bean一种是工厂bean

    * 普通bean定义什么类型就返回什么类型；工厂bean配置文件中定义的类型可以和返回的类型不同

  * Bean的==作用域==-->创建的bean是单例还是多例

    * 默认情况是单实例对象
    * 通过bean标签中的scope属性设置--->(prototype多实例；默认就是singleton单实例)
      * ==singleton==，在加载spring配置文件的时候就完成单实例对象创建
      * ==prototype==，在调用getBean方法时创建多实例对象
      * request，    一次请求，和当前请求的转发
      * session，     一次会话
      * globalSession 一次全局会话

  * Bean的==生命周期==      (*bean1.xml*)

    1. 通过构造器创建bean实例(无参构造器)
    2. 为bean的属性设置值和对其他bean的引用(调用set方法)
    3. 调用bean的初始化方法(需要配置)
    4. bean可以使用了(对象获取到)
    5. 当容器关闭时，调用bean的销毁方法(需要配置)

    * 在第三步的前后各有一个后置处理器的调用(postProcessBeforeInitialization,postProcessAfterInitialization)

* 自动装配(*基于xml的了解一哈*)

  * 根据指定的装配规则(属性名称，属性类型)，Spring会自动将匹配的属性值进行注入

* 外部配置文件引入    (bean2和jdbc.properties)

  1.创建properties；2.映入context空间，使用<context>标签；3.使用${}获取配置文件的值

###### 基于==注解==的配置文件

* 针对Bean管理==创建对象==提供的注解

  * @Component   配置了一个bean标签

  * @Service

  * @Controller

  * Repository

    上述四个注解功能是一样的，都可以创建bean

* 实现注解创建对象

  * 先导入aop的jar包
  * 开启扫描组件 --->*annotation-->bean.xml*
    * ```xml
      <context:component-scan base-package="com.yang"></context:component-scan>
      ```

* 实现==属性值的注入==提供的注解---->UserService(ioc_ann)
  * @Autowired  根据属性类型进行自动装配，当类型重复，会把变量名当作bean的id去找
  * @Qualifier     根据属性名称进行 注入(要结合Autowired使用)
  * @Resource    可以根据类型，也可以根据名称注入(是javax中的，不建议)
  * @Value           注入普通类型

* 可以使用纯注解来完成属性的注入，spring中还是会用xml去配置 Boot会详解----->SpringConfig

  * @Configuration        表示为配置文件
  * @ComponentScan   表示开启扫描
  * @Bean                        可以将结果存入spring容器中
  * @Import                     可以将其他配置类引入


---

**ioc是指一种思想，控制反转，目的是为了解耦，即将对象的创建和属性的注入交给spring去管理，ioc基于ioc容器去实现的；而ioc容器又由bean工厂实现，通过配置文件，xml，反射，工厂模式实现了这一过程；DI是依赖注入，可通过xml配置，也可以通过注解去注入属性**

---

##### AOP

###### 基本概念

面向切面编程，降低耦合，提高开发效率，提高可重复率

不通过修改源代码，在主干功能中添加新功能

###### 底层原理

* 动态代理
  * 有接口 使用==jdk==动态代理
    * 创建接口实现类的代理对象，增强类方法
      * 使用proxy类来实现
  * 无接口 使用==CGLIB==代理
    * 创建子类的代理对象，增强类的方法

###### AOP术语

* 连接点          类中哪些方法可以被增强，这些方法就叫连接点
* 切入点          实际被增强的方法，叫切入点
* 通知(增强)    实际增强的逻辑就叫做通知(在查询前增加日志功能，日志功能就是增强)
  * 前置通知     @Before(value = "execution(* com.yang.aop.ann.User.add(..))")
  * 后置通知     @AfterReturning(value = "execution(* com.yang.aop.ann.User.add(..))")
  * 环绕通知     @Around(value = "execution(* com.yang.aop.ann.User.add(..))")-->还要有参数以及参数调用proceed方法
  * 异常通知     @AfterThrowing(value = "execution(* com.yang.aop.ann.User.add(..))")
  * 最终通知     @After(value = "execution(* com.yang.aop.ann.User.add(..))")
* 切面              是一个动作，将通知应用到切入点的过程

###### AOP操作

* 在spring中一般都使用AspectJ实现aop操作

  * 是一个独立的aop框架，一般把AspectJ和spring结合实现

    * 基于xml实现

    * 基于注解实现

      1. 创建类，在类中定义方法
      2. 创建增强类，编写增强逻辑
      3. 进行通知的配置(spring配置文件，开启扫描；使用注解创建对象；增强类添加注释；spring配置文件，开启代理)

      * ps：相同切入点的抽取,使用Pointcut注解
      * ps：有多个增强类，设置优先级-->在增强类上增加Order注解，设置值 值越小优先级越高

* 切入点表达式

  * 作用：知道对那个类里面的哪个方法进行增强
  * 语法：execution([权限修饰符] [返回类型] [类全路径] [方法名] ([参数列表]))
    * execution(* com.yang.dao.UserDao.*(..))  对UserDao所有方法增强

---

**aop是面向切面编程，在不改变源码的情况下，对原有功能进行增强；降低耦合，提高开发效率；aop底层使用了动态代理的模式实现了这一过程：如果有接口就是用jdk代理，没有就是用cglib代理；一般多应用于日志，事务等**

---

##### JDBCTemplate

###### 基本概念

* spring对jdc进行了封装，会更好的CRUD就是JDBCTemplate

使用步骤

1. 引入jar包--->德鲁伊，MySQL驱动，spring-tx，spring-orm，spring-jdbc
2. 配置数据源，创建JDBCTemplate对象，开启组件扫描
3. 在dao中注入jdbcTemplate，在service注入dao
4. 在dao中调用jdbcTemplate的update方法实现增删改，queryforObject查询，batchUpdate批量添加

---

##### 事务操作

###### 基本概念

* 数据库操作最基本单元，逻辑上一组操作，要么都成功，有一个失败就都失败

* 事务的四大特性（ACID）

    ps:以转账为例

  * 原子性   a--->b转账，a少一百，b多一百，有一个失败就都失败，必须全部成功
  * 一致性   a原来是100b是0转完后a是0 b是100；总和永远是一百
  * 隔离性   当有两个事务时，两者试图修改同一数据，应当保证当前只有一个事务在操作
  * 持久性   事务被提交后，最后存入数据库持久化
  
* 事务操作

    * Spring中的两种操作方式
      * 编程式  （了解）
      * ==声明式==事务操作
        * 基于==注解方式==和基于xml(了解)---->applicationContext.xml
          * 底层使用AOP
            1. 配置文件中创建事务管理器
            2. 开启事务注解 -->引入tx命名空间，开启事务
            3. 添加@Transactional注解 可以在类上也可以在方法上
      
    * 事务操作的API
      * 提供了一个接口，代表事务管理器，针对不同框架有不用不同的实现类-->DataSourceTransactionManager
      
    * 事务操作的参数管理

      | 参数          | 注释           | 解释                                                         |
      | ------------- | -------------- | ------------------------------------------------------------ |
      | propagation   | 事物的传播行为 | 多事务之间进行调用，这个过程事务是如何进行的管理的           |
      | isolation     | 事务的隔离级别 | 多事务操作间不会互相影响，设置隔离级别                       |
      | timeout       | 事务的超时时间 | 事务需要在一定时间内提交，若超时不提交则回滚，默认-1永不超时 |
      | readOnly      | 是否只读       | 默认是false表示可以读写，设置true只能读不能写                |
      | rollbackFor   | 回滚           | 出现哪些异常回滚                                             |
      | noRollbackFor | 不回滚         | 出现哪些异常不回滚                                           |

---

##### Spring5新特性

* 可以使用==spring集成junit==来实现测试方法，省去了写容器获取bean的过程

  **要注意的是，需要导入spring-test包，还有junit4.12以上的包，以及最关键的在使用@Test的时候要使用

    import org.junit.Test;                          适用与junit4         使用  @RunWith(SpringJUnit4ClassRunner.class) 有两步

    ==import org.junit.jupiter.api.Test;       适用于junit5         使用  @SpringJUnitConfig(locations = "配置文件")==

* 整合了log4J2，

  * 需要log4j-api和-core两个jar包，需要一个log4j.xml文件配置 固定写法，之后LogManager.getLogger获取

* @Nullable注解

  * 用在方法表示方法返回值可以为空，参数，属性上也可以用，都是代表可以为空

* 核心容器支持函数式风格

---

##### Spring集成web环境

* 使用监听器获取应用上下文

```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
```

* 使用WebApplicationContextUtils工具类获取应用上下文

---

##### SpringWebFlux
