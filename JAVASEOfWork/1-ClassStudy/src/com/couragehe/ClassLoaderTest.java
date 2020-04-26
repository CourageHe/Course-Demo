package com.couragehe;

public class ClassLoaderTest {
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
	public void printExtClassLoaderJar() {
		System.out.println(System.getProperty("java.ext.dirs"));
//		F:\software\envir_config\Java\jre1.8.0_202\lib\ext;
//		C:\WINDOWS\Sun\Java\lib\ext
	}
	public void printAppClassLoaderJar() {
		System.out.println(System.getProperty("java.class.path"));
//		F:\java\CourseDemo\ClassStudy\bin
	}
	public static void main(String[]args) {
		ClassLoaderTest LoaderTest = new ClassLoaderTest();
		LoaderTest.printBootClassLoaderJar();
		LoaderTest.printExtClassLoaderJar();
		LoaderTest.printAppClassLoaderJar();
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		System.out.println("ClassLoader is:"+ classLoader);
		//ClassLoader is:sun.misc.Launcher$AppClassLoader@73d16e93
		
		System.out.println("ClassLoader's parent is:"+ classLoader.getParent());
		//ClassLoader's parent is:sun.misc.Launcher$ExtClassLoader@15db9742
		
		System.out.println("ClassLoader's grand is:"+ classLoader.getParent().getParent());
		//ClassLoader's grand is:null
		//父加载器不是指父类
		//getParent()实际上返回的是一个ClassLoader为parent
		classLoader = int.class.getClassLoader();
		System.out.println("ClassLoader is:"+ classLoader);
		//ClassLoader is:null


	}
}
