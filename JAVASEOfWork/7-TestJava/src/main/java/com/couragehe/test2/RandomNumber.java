package com.couragehe.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 3. 产生10个100之内的随机整数输出，并把这10个数按从小到大的顺序输出。
 * @author 52423
 *
 */
public class RandomNumber {
	//快速排序
//	public static  void quickSort(Integer[]arr,int bgn,int end) {
//		//数组arr空or仅有一个元素则退出
//		if (bgn >= (end - 1))
//        	return;
//		int left = bgn;
//		int right = end-1;
//		int num = arr[left];
//		while(left < right) {
//			while(left < right) {
//				if(arr[right] < num) {
//					arr[left++] = arr[right];
//					break;
//				}
//				--right;
//			}
//			while(left < right) {
//				if(arr[left] >= num) {
//					arr[right--] = arr[left];
//					break;
//				}
//			}
//			++left;
//		}
//		arr[left] = num;
//		quickSort(arr, bgn, left);
//		quickSort(arr, right+1, end);
//				
//	}
//	public static Integer[] sortedRandomNumber(){
//		Integer[] arr = new Integer[10];
//		for(int i = 0;i<10;i++) {
//			int num = (int) (Math.random()*100);
//			arr[i] = num;		
//		}
//		quickSort(arr,0,arr.length);
//		return arr;
//	}
	public static List<Integer> sortedRandomNumber(){
		List<Integer>  list = new ArrayList<Integer>();
		for(int i = 0;i<10;i++) {
			int num = (int) (Math.random()*100);
			list.add(num);
		}
		Collections.sort(list);
		return list;
	}
	public static void main(String[]args) {
		List<Integer>  list= sortedRandomNumber();
		for(Integer i : list) {
			System.out.println(i+" ");
		}
	}

}
