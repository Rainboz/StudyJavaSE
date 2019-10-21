package com.zhb.thread;

/**
 * @program: StudyJavaSE
 * @description: 1. 创建一个实现了Runnable接口的类
 * 2. 实现抽象方法run
 * 3. 创建实现类对象
 * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread对象
 * 5. 通过Thread类的对象调用start方法
 * @author: rainboz
 * @create: 2019-10-20 18:10
 **/
public class ThreadTest2 {
    public static void main(String[] args) {
        //3
        MThread mThread = new MThread();
        //4
        Thread t1 = new Thread(mThread);
        //5
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.start();
    }
}

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
