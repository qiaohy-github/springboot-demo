package com.example.demo.demo1;

public class Test66 {

    public static void main(String[] args) {
        //testqqq();

        //使用匿名内部类创建Thread对象(继承Thread类)
        new Thread(){
            @Override
            public void run(){
                System.out.println("11111");
            }
        }.start();

        //使用匿名内部类创建Runnable接口实例
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("222222");
            }
        }).start();


    }

    public static boolean testqqq(){
        int a = 10;
        for(;;){//死循环
            System.out.println("sssss");
            a = a-1;
            if(a==0)
                return true;

        }


    }

}
