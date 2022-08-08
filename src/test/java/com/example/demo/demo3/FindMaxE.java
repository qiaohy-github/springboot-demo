package com.example.demo.demo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:找出最大的10个元素
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class FindMaxE {

    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2324);
        list1.add(4);
        lists.add(list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(11);
        lists.add(list2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        lists.add(list3);

        List<Integer> list4 = new ArrayList<>();
        list4.add(45);
        lists.add(list4);



        List<Integer> newList = getMaxE(lists, 5);

        System.out.println(newList);


    }

    /**
     * 获取最大的几个数
     * @param lists
     * @param num
     * @return
     */
    private static List<Integer> getMaxE(List<List<Integer>> lists, int num) {

        List<Integer> firstList = new ArrayList<>();
        if(lists == null || lists.isEmpty())
            return firstList;

        firstList = lists.get(0);
        for(int i = 1; i < lists.size(); i++){
            List<Integer> list = lists.get(i);
            if(list != null && list.size() > 0){
                mergeList(firstList, list, num);
            }
        }

        return firstList;
    }

    /**
     * 两个集合合并到一起，排序截取
     * @param firstList
     * @param list
     * @param num
     * @return
     */
    private static List<Integer> mergeList(List<Integer> firstList, List<Integer> list, int num){
        firstList.addAll(list);
        Collections.sort(firstList);//升序排序
        if(firstList.size() - num <= 0){
            return firstList;
        }else {
            return firstList.subList(firstList.size() - num, firstList.size());
        }

    }


}
