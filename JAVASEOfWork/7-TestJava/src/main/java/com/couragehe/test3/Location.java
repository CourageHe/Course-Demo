package com.couragehe.test3;
/**
 * 1．	以下程序能否通过编译？上机验证并指明错误原因与改正方法
 * @author CourageHe
 *
 */
public class Location {
	//关键字private public 应该小写
	private int x,y;
	
	//构造函数 没有返回值
//	public void Location(int a,int b){ 
	public Location(int a,int b){ 
//		X=a;X应该小写 
		x=a;
		y=b;
	}
	public int getX(){return x;}
	public int getY(){return y;}
	
	public static void main(String args[]){
		
		Location loc=new Location(12,20);
		System.out.println(loc.getX());
		System.out.println(loc.getY());  
	}


}
