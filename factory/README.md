## 工厂方法
#### 1. 定义
-    定义一个创建对象的接口，但让实现这个接口的类来决定实例化哪个类，工厂方法让类的实例化推迟到子类中进行。
-    类型：创建型
#### 2. 使用场景
-    创建对象需要大量的重复代码
-    客户端(应用层)不依赖于产品类实例如何被创建、实现等细节。
-    一个类通过其子类来指定创建哪个对象

#### 3. 优点
-    用户只需要关心所需要产品对应的工厂，无需关心创建细节
-    加入新产品符合开闭原则，提高可扩展行

#### 4. 缺点
-     类的个数容易过多，增加复杂度
-     增加了系统的抽象性和理解难度

#### 5. 源码体现
1. java.util.Collection 是一个抽象工厂，看他的 java.lang.Iterable 的 iterator()就是一个工厂方法。ArrayList 就是一个具体实现工厂，实现了Iterator()方法；
2. java.net.URLStreamHandlerFactory  网络传输协议，sun.misc.Launcher.Factory 是实现工厂，sun.net.www.protocol.http.Handler 使用实现java.net.URLStreamHandler。
3. org.slf4j.ILoggerFactory







## 抽象工厂
#### 1.定义
-    定义:抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口；无须指定他们具体的类；
-    类型:创建型


#### 2. 适用场景
-    客户端不依赖于产品类实例如何被创建、实现等细节；
-    强调一系列相关的产品对象(属于同一产品族)一起使用创建对象需要大量重复的代码；
-    提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。

#### 3. 优点
-    具体产品在应用层代码隔离，无须关心创建细节；
-    将一个系列的产品族统一到一起创建。

#### 4. 缺点
-    规定了所有可能被创建的产品集合，产品族中扩展新的产品困难，需要修改抽象工厂的接口；
-    增加了系统的抽象性和理解难度。























