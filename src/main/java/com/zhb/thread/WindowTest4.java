package com.zhb.thread;

/**
 * @program: StudyJavaSE
 * @description: 使用同步方法处理继承Thread类的方式中的线程安全问题
 * @author: rainboz
 * @create: 2019-10-21 10:52
 **/
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口1:");
        w2.setName("窗口2:");
        w3.setName("窗口3:");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window4 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private static synchronized void show() {//同步监听器：当前类(Window4.class)
    //private synchronized void show() {此时this分别是3个线程的对象，所以不是同一个锁
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票--票号: " + ticket);
            ticket--;
        }
    }
}
