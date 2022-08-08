package com.example.demo.demo4;

import java.util.*;

/**
 * @description:
 * @author: qiaohy
 * @time: 2022/3/22
 */
public class Test1 {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        List<String> list2 =new LinkedList<>();

        //String a = "啊";

        //System.out.println(a.hashCode());

        Map<String,String> map = new HashMap<>();
        map.put("刘一", "刘一");
        map.put("陈二", "陈二");
        map.put("张三", "张三");
        map.put("李四", "李四");
        map.put("王五", "王五");
        map.put("java_jiagou","java_jiagou");



        for (String key : map.keySet()){

            System.out.printf("key:%s,hash值:%s,存储位置:%s\r\n", key, key.hashCode(), Math.abs(key.hashCode() % 15));
        }

        int a = 0;
        int b = 0;
        a = a++;
        System.out.println(a);
        b = a++;
        System.out.println("a = " + a + ", b = " + b); // a = 1, b = 0



    }




}
