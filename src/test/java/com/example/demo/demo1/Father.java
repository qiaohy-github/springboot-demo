package com.example.demo.demo1;

public abstract class Father {
    public Father() {
        //display();
    }

    public static void display() {
        System.out.println("Father's display");
    }

    public void my2(){
        display();
    }
}
