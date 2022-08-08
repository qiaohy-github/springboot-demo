package com.example.demo.demo3;

import java.util.*;

/**
 * @description:数组去重
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class TestNotDuplicated {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("123abccd");
        list.add("abcdc123");
        list.add("1234abc");
        list.add("ab1234cd");

        List<String> newList = getNotDuplicated(list);
        System.out.println(newList);

    }

    /**
     * 去重方法
     * @param list 去重前的集合
     * @return 去重后的集合
     */
    private static List<String> getNotDuplicated(List<String> list) {
        if(list == null || list.isEmpty())
            return list;

        List<String> newList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String str : list){
            StringBuilder sb = new StringBuilder();

            for(char c : str.toCharArray()){
                if(Character.isDigit(c)){//判断字符是否为数字
                    sb.append(c);
                }else{
                    if(sb.length() != 0)
                        break;
                }
            }
            map.put(sb.toString(), str);
        }
        Collection<String> values = map.values();
        newList.addAll(values);

        return newList;
    }

}
