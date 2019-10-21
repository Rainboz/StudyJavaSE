package com.zhb.thread;

/**
 * @program: StudyJavaSE
 * @description:
 * @author: rainboz
 * @create: 2019-10-21 14:46
 **/
public class BankTest {
}

class Bank {
    private static Bank instance = null;

    private Bank() {
    }

    private static Bank getInstance() {
        //方式一:效率差
        /*synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }*/
        //方式二:效率更高
        if (instance == null){
            synchronized(Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
