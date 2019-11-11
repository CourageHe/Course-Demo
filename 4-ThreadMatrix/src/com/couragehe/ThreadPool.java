package com.couragehe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 开启线程池进行矩阵乘法
 * @author 52423
 *
 */
public class ThreadPool {
	//缓存线程池
	public static void TestPool(int a[][],int b[][]) {	
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				MatrixOperation.multiplyMatrix(a, b);
				long end= System.currentTimeMillis();
				System.out.print("线程池：");
				System.out.println(+end-start+" ms");
			}
			
		});
	}	
}
