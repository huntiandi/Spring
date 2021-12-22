### MyBatis

###### 基本概念

* MyBatis 是一款优秀的持久层框架，它支持自定义 SQL、存储过程以及高级映射；底层还是JDBC
* 官网https://mybatis.net.cn/
* 实现：
  * 在pom文件中引入mybatis依赖，mysql驱动；在build加入资源插件
  * 创建配置xml：一个放在resource中定义创建连接实例的数据源对象和指定其他mapper文件位置
  * mapper文件：定义和dao接口在同一目录，一个表一个

###### 执行语句

* mybatis的核心类是SqlSessionFactory 

