package com.zhb.thread.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: StudyJavaSE
 * @description: Lock(锁 : java5.0)
 * @author: rainboz
 * @create: 2019-10-21 15:26
 **/
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一: ");
        t2.setName("窗口二: ");
        t3.setName("窗口三: ");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {

    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock(true);//公平锁

    @Override
    public void run() {
        while (true) {
            try {
                //2. 调用锁定方法：lock()
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买票--票号:" + ticket);

                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3. 调用解锁方法
                lock.unlock();
            }

        }
    }
}
