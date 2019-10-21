package com.zhb.array;

/**
 * @program: StudyJavaSE
 * @description: 创建一个char类型的26个元素的数组，分别 放置'A'-'Z'。使用for循环访问所有元素并打印出来。
 * @author: rainboz
 * @create: 2019-10-13 15:43
 **/
public class TestChar {
    public static void main(String[] args){
        char[] chars = new char[26];
        chars[0] = 'A';
        for (int i = 1; i < chars.length; i++) {
            chars[i] = (char) (chars[i-1]+1);
        }
        for (char x: chars) {
            System.out.println(x);
        }
    }
}
