package com.zhb.thread;

/**
 * @program: StudyJavaSE
 * @description: 实现Runnable接口，使用同步方法解决线程安全问题
 * @author: rainboz
 * @create: 2019-10-21 10:44
 **/
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一:");
        t2.setName("窗口二:");
        t3.setName("窗口三:");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show() {//同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票-票号: " + ticket);
            ticket--;
        }
    }
}
