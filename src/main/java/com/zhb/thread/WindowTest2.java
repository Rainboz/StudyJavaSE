package com.zhb.thread;

import java.util.concurrent.locks.Lock;

/**
 * @program: StudyJavaSE
 * @description:窗口买票，实现Runnable方式
 * @author: rainboz
 * @create: 2019-10-20 18:43
 **/
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 implements Runnable {
    private int ticket = 100;
//    Object object = new Object();
    Dog dog = new Dog();
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票 票号: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
class Dog{}
