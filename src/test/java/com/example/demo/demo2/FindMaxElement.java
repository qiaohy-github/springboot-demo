package com.example.demo.demo2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:找出最大的10个元素
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class FindMaxElement {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(5657);
        ids.add(102);
        List<Integer> ids2 = new ArrayList<>();
        ids2.add(278);
        ids2.add(247);
        ids2.add(90);
        List<Integer> ids3 = new ArrayList<>();
        ids3.add(14);
        ids3.add(143);
        ids3.add(14578);
        List<Integer> ids4 = new ArrayList<>();
        ids4.add(16);
        ids4.add(112346);
        ids4.add(12);

        lists.add(ids);
        lists.add(ids2);
        lists.add(ids3);
        lists.add(ids4);

        //List<List<Integer>> list = new ArrayList<>();


        List<Integer>  newList = getMaxElement(lists, 10);

        System.out.println(newList);

    }

    /**
     * 得到最大的几个数
     * @param lists
     * @param num
     * @return
     */
    private static List<Integer> getMaxElement(List<List<Integer>> lists, int num) {
        List<Integer> firstList = new ArrayList<>();

        if(lists == null && lists.size() == 0)
            return firstList;

        firstList = lists.get(0);
        for (int i = 1; i < lists.size(); i++){
            List<Integer> list = lists.get(i);
            if(list != null && lists.size() > 0){
                firstList = mergeList(firstList, list, num);
            }
        }

        return firstList;
    }

    /**
     * 两个集合合并到一个中，然后进行排序截取
     * @param firstList
     * @param list
     * @param num
     * @return
     */
    private static List<Integer> mergeList(List<Integer> firstList, List<Integer> list, int num) {
        firstList.addAll(list);
        Collections.sort(firstList);//升序排序
        if(firstList.size() - num <= 0)
            return firstList;
        else
            return firstList.subList(firstList.size() - num, firstList.size());
    }

}
