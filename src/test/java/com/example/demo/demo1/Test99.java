package com.example.demo.demo1;

import java.util.*;

public class Test99 {
    public static void main(String[] args) {

        List<String> listStr = new ArrayList<>();
        listStr.add("123abccd");
        listStr.add("abcdc123");
        listStr.add("1234abc");
        listStr.add("ab1234cd");

        List<String> notDuplicatesList = removeDuplicates(listStr);
        System.out.println(notDuplicatesList);
    }

    /**
     * 按照约定规则删除重复项删除重复
     *
     * @param list 入参，可能有重复项的List集合
     * @return 返回去重后的结果
     */
    public static List<String> removeDuplicates(List<String> list) {
        List<String> resultList = new ArrayList<String>();
        if (list == null || list.isEmpty()) {
            return resultList;
        }
        Map<String, String> map = new HashMap<>();
        for (String a : list) {
            StringBuilder b = new StringBuilder();
            boolean flag = false;
            for (char c : a.toCharArray()) {
                if (isNum(c)) {
                    b.append(c);
                    flag = true;
                } else {
                    if (flag) {
                        break;
                    }
                }
            }
            map.put(b.toString(), a);
        }
        Collection<String> values = map.values();
        resultList.addAll(values);
        return resultList;
    }

    /**
     * 判断一个字符是否是0-9中的一个数字
     *
     * @param c
     */
    private static boolean isNum(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
