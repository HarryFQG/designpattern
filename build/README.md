####1. 定义
-    将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
-    用户只需要指定需要建造的类型就可以得到它们，建造过程及细节不需要知道
-    类型：创建型

####2. 优点
-    1.封装性好，创建 和使用分离
-    2.扩展性好、建造类之间独立、一定程度上解耦

####3. 缺点
-    1.产生多余的Builder 对象
-    2. 产品内部发生变化，建造者都要修改，成本较大。


####4. 使用场景
- JDK
    - StringBuilder: append(Object obj)、append(String str);


- Spring
    - BeanDefinitionBuilder: genericBeanDefinition(String beanClassName)、genericBeanDefinition(Class<?> beanClass)、genericBeanDefinition(Class<T> beanClass, Supplier<T> instanceSupplier)、setFactoryMethod(String factoryMethod)；

    - SqlSessionFactoryBuilder: build(Reader reader)、build(Reader reader, String environment)、build(InputStream inputStream, String environment)

