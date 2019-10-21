package com.zhb.thread;

/**
 * @program: StudyJavaSE
 * @description: 窗口买票，继承Thread
 * @author: rainboz
 * @create: 2019-10-20 17:57
 **/
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread {
    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票 票号: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}



