package com.zhb.array;

import java.util.Arrays;

/**
 * 创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
 * @author Rainboz
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = new int[6];
		//随机1-30,Math.random()是[0-1)的随机数,[0-30),[1-31)
		System.out.println((int)(Math.random()*30+1));
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*29+1); 
			
			for (int j = 0; j < i; j++) {
				if(array[i] == array[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

}
