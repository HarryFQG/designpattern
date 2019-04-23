#### 1.定义
- 1. 将对象组合成树形结构表示"部分-整体"的层次结构,组合模式使客户端对单个对象和组合对象保持一致的方式处理
- 类型: 结构型
- 关键点：叶子对象和组合对象继承或实现相同接口。

#### 2. 优点
- 1. 清楚地定义层次的复杂对象，表示对象的全部或部分层次。
- 2. 让客户忽略层次的差异，方便对整个层次结构进行控制。
- 3. 简化客户端代码
- 4. 符合开闭原则

#### 3.缺点
- 1. 限制类型时会比较复杂。
- 2. 是设计变得更加抽象

#### 4. 相关设计模式
- 1. 组合模式和访问者模式

#### 5. 源码
- 1 java.awt.Container 继承Component, 下面的add() 方法。

- 2 HashMap 的putAll() 方法

- 3.  ArrayList 的addAll() 方法，实现List 接口，List继承Collection 接口。

- 4. mybatis:org.apache.ibatis.scripting.xmltags.SqlNode ,将多个对象组合成一个对象，通过 org.apache.ibatis.scripting.xmltags.MixedSqlNode 将多个SqlNode 对象合成一个对象。
    




















