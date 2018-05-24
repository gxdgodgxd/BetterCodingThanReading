# 第四章 性能监控与故障处理工具

## JDK的命令行工具

### jps 虚拟机进程状况工具
java process status tool 查看正在运行的虚拟机进程

	jps -l
	
### jstat 虚拟机统计信息监控工具
java statistic monitoring tool 查看虚拟机各种运行状态信息

	jstat [ option vmid [ intervel[s|ms] [count]] ]
	
	e.g. jstat -gc 2764 250 20
	查看2764进程的gc状况，250ms查一次，一共差20次
	
	FYI: 
	E = Eden  
	O = Old
	P = Permanent
	YGC = Young/Minor GC
	FGC = Full GC
	GCT = GC Time

### jinfo Java配置信息工具
Configuration Info for Java 查看和调整虚拟机参数

	jinfo -flag AAA pid
	返回：
	-XX:AAA=xxx
	
### jmap Java内存映像工具
Memery Map for Java 生成堆转储文件（heapdump）

	jmap -option vmid
	
	e.g. jmap -dump:format=b,file=eclipse.bin 3500
	
### jhat 虚拟机堆转储快照分析工具
JVM Heap Analysis Tool, 与jmap搭配使用

很简陋 后文推荐使用VisualVM来对dump的文件进行分析

### jstack java堆栈跟踪工具
stack trace for java用于生成虚拟机当前的线程快照threaddump,即当前JVM中每个线程正在执行的方法堆栈的集合

#### 目标
定位线程出现长时间停顿的原因，如死锁、死循环、请求外部资源等

	jstack [option] vmid
	
	e.g. jstack -l 3500
	-l 为 除堆栈外，显示关于锁的附加信息
	
java代码中可以利用Thread类的getAllStackTrace()方法达到jstack的效果

## JDK的可视化工具 

### JCONSOLE JAVA监视与管理控制台

基于JMX 针对MBean进行监控管理
#### 内存监控 jmap jhat jstat
#### 线程监控 jstack 

### VisualVM 多合一故障处理工具 （待回看）
#### 优点
1. 除了运行监控、故障处理，还可以性能分析
2. 对应用程序的实际性能影响小，可在生产环境运行
