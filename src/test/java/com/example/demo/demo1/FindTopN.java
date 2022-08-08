package com.example.demo.demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangyonglu
 */
public class FindTopN {


    public static void main(String[] args) {
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        resultList.add(2);
        resultList.add(6);
        resultList.add(12);
        resultList.add(78);

        List<Integer> resultList2 = new ArrayList<>();
        resultList2.add(14);
        resultList2.add(109);
        resultList2.add(1);
        resultList2.add(34);

        List<Integer> resultList3= new ArrayList<>();
        resultList3.add(896);
        resultList3.add(123);
        resultList3.add(456);
        resultList3.add(444);

        allList.add(resultList);
        allList.add(resultList2);
        allList.add(resultList3);


        List<Integer> topN = findTopN(allList, 3);
        for (Integer rel : topN){
            System.out.println(rel);
        }
    }

    /**
     * 查找最大的N个数
     * @param allList
     * @param n
     */
    private static List<Integer> findTopN(List<List<Integer>> allList,int n){
        List<Integer> resultList = new ArrayList<>();
        if(allList==null||allList.isEmpty()){
            return resultList;
        }
        resultList = allList.get(0);
        for(int i = 1;i<allList.size();i++){
            List<Integer> list = allList.get(i);
            if(!list.isEmpty()){
                resultList = merge(resultList,list,n);
            }
        }
        return resultList;
    }

    /**
     * 合并两个List 并 提取出最大的 n 个数
     * @param first 第一个集合
     * @param second 第二个集合
     * @param n 需要查找的数量
     * @return 返回提取出最大的 n 个数
     */
    private static List<Integer> merge(List<Integer> first,List<Integer>  second,int n){
        first.addAll(second);
        int firstSize = first.size();
        if(firstSize <= n){
            return first;
        }
        Collections.sort(first);
        int fromIndex = firstSize - n;
        return first.subList(fromIndex, firstSize);
    }


}
