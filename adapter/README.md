#### 1. 定义
- 将一个类的接口(被适配者)转换成客户期望的另外一个接口(目标类)；使原本接口不兼容的类可以一起工作
- 类型:结构型
#### 2. 应用场景
- 1. 已经存在的类，他的方法和需求不匹配时(方法结果相同或者相似)。
- 2. 不是软件设计阶段考虑的设计模式，是随着软件维护，由于不同产品、不同厂家造成功能类似而接口不相同情况下的解决方案

#### 3. 优点
- 1. 能提高类的透明性和复用，现有的类复用但不需要改变
- 2. 目标类和适配器类解耦，提高程序扩展性
- 3. 符合开闭原则
#### 4. 缺点
- 1.  适配器编写过程需要全面考虑，可能会增加系统的复杂性。
- 2. 增加系统代码可读的难度。
#### 5. 适配器相关设计模式
- 1. 适配器模式和外观模式
    - 适配器模式：都是对现有系统的封装, 使用现有的接口，是两个接口相互协调工作。
    - 外观模式：都是对现有系统的封装, 定义新的接口，在现有的系统中提供一个入口。适配整个系统，针对的力度大。
#### 6. 源码
- 1. javax.xml.bind.annotation.adapters.XmlAdapter


- 2. org.springframework.aop.framework.adapter.AdvisorAdapter


- 3. org.springframework.orm.jpa.JpaVendorAdapter; 这是接口，可以看其实现。
- 4.org.springframework.web.servlet.HandlerAdapter ：mvc

- 5. org.springframework.web.servlet.mvc.Controller









