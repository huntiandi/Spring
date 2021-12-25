### MyBatis

##### 基本概念

* MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射；底层还是JDBC
* 官网https://mybatis.net.cn/
* 实现：
  * 在pom文件中引入mybatis依赖，mysql驱动；在build加入资源插件
  * 创建配置xml：一个放在resource中定义创建连接实例的数据源对象和指定其他mapper文件位置；还可以设置日志功能
  * mapper文件：定义和dao接口在同一目录，一个表一个

---

##### 执行语句

* mybatis的核心类是SqlSessionFactory
* 使用SqlSession的方法执行语句 

##### 事务的提交

###### 自动提交

* 在获取SQLSession时openSession(true);即可自动提价事务

###### 手动提交

* SQLSession对象默认是手动提交事务；即在执行完insert，update，delete后要commit

---

##### 重要对象

* Resource：读取配置文件的对象
* SqlSessionFactoryBuild：负责创建SqlSessionFactory对象
* ==SqlSessionFactory==对象：重要对象
  * 是重量级对象，加载时间长，创建时要消耗大量时间与资源，有一个即可
  * openSession是重要的方法，参数为TRUE表示自动提交事务，不填或FALSE为手动提交事务
* sqlSession对象
  * 通过SqlSessionFactory获得，本身是一个接口；DefaultSqlSession实现类
  * 提供了大量的执行方法
  * 是线程不安全的；所以要在方法内部创建执行和关闭

##### dao代理

* mybatis创建Dao接口的实现类，完成sql语句的执行；mybatis会创建一个对象代替开发者的dao实现类；
* 使用代理的要求
  * mapper文件中的namespace必须是dao接口的全限定名称
  * mapper文件中的id必须是dao接口中的方法名称
* 实现方式：sqlSession对象的方法--->getMapper(dao.class)；等同于dao = new daoImpl

---

##### 参数

###### 基本概念

* 通过Java程序把数据传入到mapper文件中的SQL语句，参数主要是指dao接口的形参
* ==parameterType==
  * 表示参数类型，指定dao方法的形参数据类型，是给mybatis给SQL语句赋值时使用
  * 可以使用类型的全限定名称也可以是别名
  * mybatis通过反射可以拿到参数类型，可以不写

###### 简单类型参数

* 单个简单参数：Java基本类型和String都是简单类型；使用#{}获取
* 多个简单参数：要使用@Param参数在dao接口中命名形参
  * 也可以按位置，在dao中的从左到右的位置，在mapper中使用#{arg0},#{arg1}....不推荐
  * 还可以通过map传，在mapper中#{key}
* 使用Java对象：dao接口中的参数是一个对象即可，什么对象都行有属性有getset方法就行；在mapper文件中#{属性名}，会通过{}中的属性名去找形参对象中的对应的get方法拿到值；也可以设置JavaType和jdbcType，mybatis会自动检测不用写

---

##### 占位符#和$

###### $和#区别

* 占位符#的语法：#{字符}
  * mybatis处理时，会替换，会使用jdbc的PrepaerStatment对象来处理
  * 执行SQL语句效率高；能有效避免sql注入；常作为列的值使用；值和数据类型有关
* ${}的语法${字符}
  * 会进行拼接，相当于string中的+；使用的是Statement对象执行语句
  * 执行SQL语句效率低；存在sql注入风险；数据时原样使用不会区分数据类型；
  * ${}常用作表面，列名来使用，在保证数据安全情况使用

##### 封装返回结果

###### resultType

* 属性：在执行select时使用，表示结果类型，执行SQL后得到Java对象的类型，值有两种：Java类型的全限定名称，和别名
* mybatis会调用该名称的无参构造器，创建对象，同名的列赋值给同名属性；如果dao返回值是list集合，mybatis会把对象放入list集合
* 自定义别名：在mybatis配置文件中添加typeAliases标签；但不推荐，最好还是写全限定名
* 返回类型也可以是个map，如果是map只能是一行记录否则报错；一般都是使用对象为返回值类型，接受时用对象或list集合；单个的话就用简单类型

###### resultMap

* 结果映射，自定义列名和Java对象属性的对应关系，常用于列名和属性名不同情况下

  ①先定义resultMap标签，指定列名与属性名对应关系

  ②在select标签中使用resultMap属性，指定第一步中第一的resultMap中的id值

  ③可以多次复用，灵活多变

###### 比较

* resultType和resultMap二选一；不能同时使用
* 当有列名与属性名不同问题时，resultType使用别名解决；resultMap使用标签解决；resultMap更加灵活一些

##### 模糊查询

两种方式：

* 字符串中写好 "%张%"；mapper文件where name like#{}  ---->推荐，灵活
* 在mapper文件中写好 where name like "%"空格#{}空格"%"；Java传入"张"

---

##### 动态SQL

###### 基本概念

* 同一个dao的方法，根据不同的条件可以表示不同的sql语句，主要是where部分有变化，使用mybatis提供的标签，实现sql的能力；多用于多条件的查询中
* 主要有if，where，foreach，sql代码片段；其中使用到><等符号时要使用实体符号，否则会报错
* 使用动态sql时，dao传入的参数是Java对象

###### 动态sql-if

* 语法：在主sql后面添加if标签 当if标签中的test属性内容为真时会执行if标签中的sql代码段
* 一般配合where标签使用

###### 动态sql-where

* 使用if标签时，任意引起语法错误，使用where标签解决if产生的语法错误
* 使用时where标签中一个或多个if标签；当有一个if标签判断条件为true，where标签会转为WHERE关键字附加到sql语句后，如果一个if都不为真，忽略where和里面的if
* where标签会将紧跟这where的or或and去掉，以保证语法的正确性

###### 动态sql-foreach

* 可以循环数组，list集合，一般用在in语句中；<foreach/>标签

* 遍历查询简单类型集合
  * collection 是类型list或者array; open和close是开始结束符号; separate是分隔符； item是值
  * 在<foreach>标签中#{}来接受参数
* 遍历查询对象类型集合
  * 在属性item中取到的是一个对象，所以在<foreach>标签中使用#{对象.属性}的形式获取参数

###### 动态sql-代码片段

* 使用的是sql标签和include标签；sql标签中可以是表名，字段，where条件等；可以在其他地方复用
* sql标签通过id属性定义唯一标识；在其他位置使用include标签引用某个代码片段

---

##### MyBatis配置文件

###### 基本概念

* 有两大类配置文件：1.mybatis主配置文件；2.mapper文件
  * mybatis主配置文件，配置全局设置，例如日志，数据源，其他mapper位置等
  * mapper文件：主要写sql语句；一张表一个mapper文件

###### 主配置文件

* 主配置文件中的标签是由顺序的点击configuration查看顺序

1. properties：引用外部文件
2. setting：是mybatis的全局设置，影响整个mybatis的运行；一般使用默认值即可
3. typeAliases：别名的设置
4. ==environments==：环境标签，可以配置多个environment
5. ==mappers==：指定其他mapper文件；resource和package
   * package要求dao和mapper文件在同一目录；并且文件名要一致
   * ==注意==在使用package时，当把mapper文件放在resources目录下面时，要注意创建包时的方式，可以copy两个文件的真实路径比对一下

---

