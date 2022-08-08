package com.example.demo.demo4;

import java.math.BigDecimal;
import java.util.*;

/**
 * @description:
 * @author: qiaohy
 * @time: 2022/3/22
 */
public class Test3 {


    public static void main(String[] args) {
        BigDecimal bigDecimal0 = BigDecimal.valueOf(0);
        BigDecimal bigDecimal = BigDecimal.valueOf(0,3);

        BigDecimal bigDecimal1 = new BigDecimal("0.000");

        BigDecimal bigDecimal2 = new BigDecimal(0.1d);
        BigDecimal bigDecimal3 = new BigDecimal(0.1f);
        BigDecimal bigDecimal4 = new BigDecimal(0.01);

        System.out.println(bigDecimal0);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);
        System.out.println(bigDecimal3);
        System.out.println(bigDecimal4);

        Map<Long, BigDecimal> newMap =  new HashMap<>();

        newMap.put(1l,new BigDecimal("0.001"));
        newMap.put(2l,new BigDecimal("0.002"));
        newMap.put(3l,new BigDecimal("0.003"));
        newMap.put(4l,new BigDecimal("0.004"));


        System.out.println(newMap.get(1l));
        System.out.println(newMap.get(3l));
        System.out.println(newMap.get(4l));
        System.out.println(newMap.get(5l));

    }




}
