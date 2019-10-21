package com.zhb.inclass;

/**
 * @program: StudyJavaSE
 * @description:
 * @author: rainboz
 * @create: 2019-10-15 13:31
 **/
public class OutClass {
    private String str = "out str";
    int i = 1;
    static int j = 12;
    public InnerClass out(){
        class Pclass extends InnerClass{
            int i = 9;
        }
        System.out.println("out  method");
        System.out.println("out-i: "+i);
        System.out.println("out-str: "+str);
        return new Pclass();
    }

    class InnerClass{
        int i = 2;
        int j = 13;
        public void in(){
            System.out.println("in method");
            System.out.println("in-i: "+i);
            System.out.println("在内部类调用外部类同名属性："+OutClass.this.i);
            System.out.println("在内部类调用外部类同名属性："+OutClass.j+"--"+j);
            System.out.println("in-str: "+str);
        }
    }
    public static void main(String[] args){
        OutClass outClass = new OutClass();
        InnerClass out = outClass.out();
        System.out.println("------------------------");
        out.in();
        System.out.println("------------------------");

        InnerClass out_in =  outClass.new InnerClass();
        out_in.in();
    }
}
