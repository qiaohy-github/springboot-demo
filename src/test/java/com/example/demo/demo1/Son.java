package com.example.demo.demo1;

import java.util.Objects;

public class Son extends Father {

    public Son() {
    }

    public static void display() {
        String a = "string";
        System.out.println(a.hashCode());

        //Set<Object> objects = new HashSet<Object>();
        Objects.hashCode(a);

        System.out.println("Son's display");
        System.out.println(4 & 5);
    }

    public static void main(String[] args) {
        //System.out.println(Thread.currentThread());
        Son son = new Son();

        son.display();

        //son.my2();
    }

}
