package com.couragehe.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindRandomNumber {
	public static List<Integer> sortedRandomNumber(){
		List<Integer>  list = new ArrayList<Integer>();
		int i = 0;
		while(i<20) {
			int num = (int) (Math.random()*100);
			if(num >= 50) {
				i++;
				list.add(num);			
			}
		}
		Collections.sort(list);
		return list;
	}
	public static void main(String[]args) {
		List<Integer>  list= sortedRandomNumber();
		int i = 1;
		int max =0,min =0;
		System.out.print("排序随机数：");
		for(Integer num : list) {
			if(i==1) {
				min = num;
			}else if(i ==20) {
				max = num;
			}
				i++;
			System.out.print(" "+num);				
		}
		System.out.println("\n最小数:"+min);	
		System.out.println("最大数:"+max);
	}
}
