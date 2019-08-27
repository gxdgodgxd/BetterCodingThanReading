# Learning spark: lightning-fast data analysis

## notice
*using scala as demo language*

## s2 入门

### 2.3 spark核心概念

#### sparkContext sc
```scala
val conf = new SparkConf().setMaster("local").setAppName("app name")
val sc+ new SparkContext(conf)
```

## s3 RDD编程

### RDD Resilient Distributed Dataset

### 3.1 RDD基础
1. 创建RDD
2. 转化操作 transformation / 行动操作 action
3. 持久化 到MEM或硬盘

### 3.2 创建RDD
1. from array
```scala
val lines = sc.parallelize(List("a","b","c"))
```
2. from file
```scala
val lines = sc.textFile("/a/b/c")
```

### 3.3 操作RDD

#### 3.3.1 转化

#### 3.3.2 行动

#### 3.3.3 惰性求值

### 3.4 向spark传递函数

**把所需要的字段从对象中拿出来放到一个局部变量中，然后传递局部变量；否则将会传递函数、字段所在的对象，传递的数据会增多，并且容易导致不可序列化的风险**

### 3.5 常见操作

#### 转化操作
1. map
2. filter
3. flatMap

#### 伪集合操作
1. distinct(性能差)
2. union(不去重)
3. intersection(去重,性能差)
4. subtract(去重,性能差)
5. cartesian 笛卡尔积

性能差原因：通过网络进行数据混洗（data shuffle）

#### 行动操作
1. reduce(func)
2. fold(0)(func) = reduce(func) 多提供一个初始值
3. aggregate(zeroValue)(seqOp, combOp)

























