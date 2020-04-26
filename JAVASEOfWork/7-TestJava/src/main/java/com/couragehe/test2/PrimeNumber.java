package com.couragehe.test2;
/**
 * 计算1---50之间所有素数的和。
 * @author 52423
 *
 */
public class PrimeNumber {
	/**
	 * 计算一定范围内的素数和
	 * @param from 起点
	 * @param end 终点
	 * @return 素数之和
	 */
	public static int primeNumberSum(int from,int end) {
		//开平方验证是否为素数
		int sum =0 ;
		boolean isPrime = true;
		//1不是素数，自动重置为2
		if(from ==1) from=2;
		for(int i = from;i<=end;i++ ) {
			isPrime = true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j ==0) {
					isPrime = false;break;
				}
			}
			if(isPrime) {
				sum+=i;	
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(primeNumberSum(1,50));
		
	}

}
