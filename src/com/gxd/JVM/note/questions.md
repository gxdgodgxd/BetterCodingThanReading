# jvm常见面试题
---

1. JVM的运行时内存区域如何划分？
2. JVM内存模型
3. GC机制： GC： hotspot系列虚拟机有哪些常用的GC算法？
4. JVM的性能调优
5. 类加载机制 双亲委派机制
6. JIT技术，为什么Oracle的Java虚拟机叫做HotSpot？

---

1. 内存模型以及分区，需要详细到每个区放什么。
2. 堆里面的分区：Eden，survival from to，老年代，各自的特点。
3. 对象创建方法，对象的内存分配，对象的访问定位。
4. GC的两种判定方法：引用计数与引用链。
5. GC的三种收集方法：标记清除、标记整理、复制算法的原理与特点，分别用在什么地方，如果让你优化收集方法，有什么思路？
6. GC收集器有哪些？CMS收集器与G1收集器的特点。
7. Minor GC与Full GC分别在什么时候发生？
8. 几种常用的内存调试工具：jmap、jstack、jconsole。
9. 类加载的五个过程：加载、验证、准备、解析、初始化。
10. 双亲委派模型：Bootstrap ClassLoader、Extension ClassLoader、ApplicationClassLoader。
11. 分派：静态分派与动态分派。
JVM过去过来就问了这么些问题，没怎么变，内存模型和GC算法这块问得比较多，可以在网上多找几篇博客来看看。


















