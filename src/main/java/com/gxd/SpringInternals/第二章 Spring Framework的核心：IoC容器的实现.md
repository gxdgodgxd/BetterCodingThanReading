# 第二章 Spring Framework的核心：IoC容器的实现
#读书笔记# #读书笔记/SpringInternals#
- - - -
## Spring IoC容器概述

### 1 Ioc容器和依赖反转模式

```
Inversion of Control 控制反转  
Dependency injection 依赖注入
```

#### 目的

```
降低耦合  
可测试
```

## IoC容器系列的设计实现

```
BeanFactory（简单容器）
ApplicationContext（高级形态）
```

### 1 IoC容器系列

```
BeanFactory接口 -> IoC容器的最基本功能  
BeanDefination -> Bean的定义的抽象	

IoC容器用来存储的对象即为BeanDefination
```

### 2 IoC容器的设计

#### BeanFactory应用场景

BeanFactory是接口类，DefaultListableFactory/XmlBeanFactory等是容器附加某种功能的具体实现

```
tips: 可以通过&转义字符获取FactoryBean
```

```
例如
myJndiObject 是一个 FactoryBean
那么&myJndiObject 获取到的是FactoryBean， 而不是myJndiObject这个FactoryBean生产出来的对象
```

**BeanFactory 和 FactoryBean 的区别**

```
BeanFactory是一个IoC容器，是一个对象工厂。
在Spring中，所有的bean都是由BeanFactory来进行管理的。
但是FactoryBean不是一个简单的bean，而是一个能产生或者修饰对象生成的工厂bean，它的实现和设计模式中的工厂模式和装饰器模式类似。
```

BeanFactory接口

```
getBean();
containBean();
isSingleton();
isProtoType();
getType();
getAliases();
```

#### BeanFactory容器的设计原理

DefaultListableBeanFacoty 是一个默认的功能完整的IoC容器。

XmlBeanFactory extends DefaultListableBeanFacoty,并且添加了读取解析xml变为BeanDefination的功能。

#### ApplicationContext应用场景

与BeanFactory的区别：

```
1. 支持不同的信息源。 扩展MessageSource接口，用于实现国际化
2. 访问资源。 继承DefaultResourceLoader，可以灵活的获取Resource资源，获取Bean配置信息
3. 支持应用事件。 集成ApplicationEventPublisher接口，引入事件机制，方便Bean的管理
4. 在ApplicationContext中提供的附加服务
```

#### ApplicationContext容器的设计原理

以FileSystemXmlApplicationContext为例：
FileSystemXmlApplicationContext extends AbstractXmlApplicationContext，主要功能在AbstractXmlApplicationContext中已经实现，FileSystemXmlApplicationContext只需要实现和自身设计相关的两个功能

1. 在应用中直接使用FileSystemXmlApplicationContext，需要实例化这个应用上下文的支持，并且调用启动IoC容器的refresh（）过程
2. 从文件系统中加载Xml格式的Bean定义资源

## IoC容器的初始化过程
