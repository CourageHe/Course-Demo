# Java - Class知识

## 1、ClassLoader

### 1.1 ClassLoader相关概念

​	当写好一个java程序后，编译之后都是由若干份 **.class**文件组织而成的一个完整的java程序，当程序在运行时，即会调用改程序的一个入口函数来调用系统的相关功能，而这些功能都被封装在不同的class文件中，所以经常要从这个class文件中调用另外一个class文件中的方法，如果另外一个文件不存在，则会引发系统异常。程序在启动时，并不会一次性加载所有要用的class文件，而是根据程序需要，通过java的类加载机制（ClassLoader）来动态加载某个class文件到内存中，从而只有class文件被存入到内存之后，才能被其他class所引用。所以ClassLoader就是用来加载class文件到内存中去的。

### 1.2 Java默认ClassLoader

1. **Bootstrap CLassloder**

   最顶层的加载类，主要加载核心类库，%JRE_HOME%\lib下的jar文件和class文件。

2. **Extention ClassLoader**

   扩展的类加载器，加载目录%JRE_HOME%\lib\ext目录下的jar包和class文件。

3. **AppClassLoader**

   又名为SystemAppClass加载当前应用的classpath的所有类。

### 1.3 加载顺序以及文件

1. **Bootstrap CLassloder**

```java
public void printBootClassLoaderJar() {
		System.out.println(System.getProperty("sun.boot.class.path"));
//		F:\software\envir_config\Java\jre1.8.0_202\lib\resources.jar;
//		F:\software\envir_config\Java\jre1.8.0_202\lib\rt.jar;
//		F:\software\envir_config\Java\jre1.8.0_202\lib\sunrsasign.jar;
//		F:\software\envir_config\Java\jre1.8.0_202\lib\jsse.jar;
//		F:\software\envir_config\Java\jre1.8.0_202\lib\jce.jar;
//		F:\software\envir_config\Java\jre1.8.0_202\lib\charsets.jar;
//		F:\software\envir_config\Java\jre1.8.0_202\lib\jfr.jar;
//		F:\software\envir_config\Java\jre1.8.0_202\classes
	}
```

2. **Extention ClassLoader**

```java
	public void printExtClassLoaderJar() {
		System.out.println(System.getProperty("java.ext.dirs"));
//		F:\software\envir_config\Java\jre1.8.0_202\lib\ext;
//		C:\WINDOWS\Sun\Java\lib\ext
	}
```

2. **AppClassLoader**

```java
    public void printAppClassLoaderJar() {
            System.out.println(System.getProperty("java.class.path"));
    //		F:\java\CourseDemo\ClassStudy\bin
        }
```

### 1.4 父类加载器

​	每个类加载器都有一个父加载器，比如加载Test.class是由AppClassLoader完成，AppClassLoader也有一个父加载器，可以用getParent()获取。parent的赋值是在ClassLoader对象的构造方法中：

	1. 有外部类创建ClassLoader时直接指定一个ClassLoader为parent
 	2. 由getSystemClassLoader()方法生成，也即是咋sun.misc.launcher通过getClassLoader()获取，也就是AppClassLoader。（即：一个ClassLoader创建时如果灭有指定parent，那么他的parent默认就是AppClassLoader）

```java
    ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
    System.out.println("ClassLoader is:"+ classLoader);
    //ClassLoader is:sun.misc.Launcher$AppClassLoader@73d16e93

    System.out.println("ClassLoader's parent is:"+ classLoader.getParent());
    //ClassLoader's parent is:sun.misc.Launcher$ExtClassLoader@15db9742

    System.out.println("ClassLoader's grand is:"+classLoader.getParent().getParent());
    //ClassLoader's grand is:null
    //父加载器不是指父类
    //getParent()实际上返回的是一个ClassLoader为parent
    classLoader = int.class.getClassLoader();
    System.out.println("ClassLoader is:"+ classLoader);
    //ClassLoader is:null
```

​		**Bootstrap CLassloder**是由C++编写，本身是java虚拟机的一部分，所以它并不是Java类，所以无法在Java代码中获取他的引用，jvm启动时通过BootStrap类加载器加载rt.jar等核心jar包中的class文件。int.class String.class都是由它加载，因此会出现null;

​		JVM初始化sun.misc.Launcher并创建Extension ClassLoader和AppClassLoader实例。并将ExtClassLoader设置为AppClassLoader的父加载器。Bootstrap没有父加载器，但是它却可以作用一个ClassLoader的父加载器。比如ExtClassLoader。这也可以解释之前通过ExtClassLoader的getParent方法获取为Null的现象。

### 1.5 双亲委托

​		一个类加载器查找Class和resource是，是通过”委托模式“进行的，他首先判断是不是已经加载成功，如果没有地话他并不是自己进行查找，而是首先通过父加载器，然后递归下去，直到BootStrap ClassLoader;如果BootStrap ClassLoader找到了，则直接返回，如果没有找到，则一级一级返回，最后到达自身去查找这些对象！！！

![](https://imgconvert.csdnimg.cn/aHR0cDovL2ltZy5ibG9nLmNzZG4ubmV0LzIwMTcwMjEwMTkyOTMxNTA1?x-oss-process=image/format,png)

## 2、获取对象

### 2.1 获取对象的三种方法

+ **new**一个对象获取

```java
 	Gum gum = new Gum();
	Class clazz2=gum.getClass();Class.forName(path)
```

+ Class.forName()

```java
	Class clazz=Class.forName("com.couragehe.Gum");
	Gum gum = clazz.newInstance();
```

+ classLoader()方法

  应用程序继承ClassLoader实现自己的类装载器。

```java
Class clazz = ClassLoader.loadClass("Dog");
Dog dog = clazz.newInstance();
```

  ​		第一种和第二种使用的类加载器是相同的，都是当前类加载器。（this.getClass().getClassLoader()）第三种由用户指定类加载器。如果需要在当前类路径以外寻求类，则只能采用第三种方式。第一种是静态加载，第二、三种是动态加载。

### 2.2 Class对象初始化解读

```java
class Initable{
	//编译器静态常量
	static final int staticFinal = 47;
	//非编译器静态常量
	static final int staticFinal2 = ClassInitialization.rand.nextInt();
	static {
		System.out.println("Initializing Initable");
	}
}
class Initable2{
	//编译器静态常量
	static  int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}
class Initable3{
	//编译器静态常量
	static  int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}
public class ClassInitialization {
	public static Random  rand = new Random(47);
	public static void main(String[]args) throws ClassNotFoundException {
		//字面常量获取方式获取Class对象
	    Class initable = Initable.class;
	    System.out.println("After creating Initable ref");
	    //不触发类初始化
	    System.out.println(Initable.staticFinal);
	    //会触发类初始化
	    System.out.println(Initable.staticFinal2);
	    //会触发类初始化
	    System.out.println(Initable2.staticNonFinal);
	    //forName方法获取Class对象
	    Class initable3 = Class.forName("com.couragehe.Initable3");
	    System.out.println("After creating Initable3 ref");
	    System.out.println(Initable3.staticNonFinal);
	}
}
```

### 2.3 Class泛型

T  bean ;

Class<T> bean;

Class<?> bean;

单独的T代表一个类型，而Class<T>和Class<?>代表这个类型所对应的类

Class<T>在实例化的时候，T要替换成具体类

Class<?>它是个通配泛型，?可以代表任何类型   

<? extends T>受限统配，表示T的一个未知子类。

<? super T>下限统配，表示T的一个未知父类。

public T find(Class<T> clazz, int id);

根据类来反射生成一个实例，而单独用T没法做到。

Object类中包含一个方法名叫getClass，利用这个方法就可以获得一个实例的类型类。类型类指的是代表一个类型的类，因为一切皆是对象，类型也不例外，在Java使用类型类来表示一个类型。所有的类型类都是Class类的实例。getClass()会看到返回Class<?>。

JDK中，普通的Class.newInstance()方法的定义返回Object，要将该返回类型强制转换为另一种类型;

但是使用泛型的Class<T>，Class.newInstance()方法具有一个特定的返回类型;

## 参考：

1. https://blog.csdn.net/briblue/article/details/54973413