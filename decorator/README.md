#### 1. 定义
- 再不改变原有对象的基础上，将功能附加到对象上；提供了比继承更有弹性的替代方案(扩展原有对象功能);
- 类型：结构型
#### 2. 适用场景
- 1. 扩展一个类的功能或给一个类添加附加职责
- 2. 动态的给一个对象添加功能，这些功能可以再动态撤销。
#### 3. 优点
- 1. 继承的有力补充，比继承灵活，不改变原有对象的情况下给一个对象扩展功能
- 2. 通过使用不同装饰类以及这些装饰类的排列组合，可以实现不同效果
- 3. 符合开闭原则

#### 4. 缺点
- 1. 会出现更多的代码，更多的类，增加程序的复杂性。
- 2. 动态装饰时，多层装饰时会更复杂
#### 5. 装饰者相关的模式
- 1. 装饰者模式和代理模式
    - 装饰者模式: 关注在一个对象上动态添加对象，通常将原始对象作为一个参数传给构造器
    - 代理模式:  关注与控制对对象的访问，通常代理类内创建一个对象
- 2. 装饰者模式和适配器模式
    - 装饰者模式: 
    - 适配器模式:可以适配不同的接口
#### 6.源码
- 1. jdk 中io 方面的类，java.io.BufferedReader，java.io.BufferedInputStream


- 2. org.springframework.cache.transaction.TransactionAwareCacheDecorator : 


- 3.org.springframework.session.web.http.SessionRepositoryRequestWrapper:



- org.apache.ibatis.cache.Cache:装饰器模式




















