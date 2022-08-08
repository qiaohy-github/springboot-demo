package com.example.demo.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test88 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123sads");
        list.add("asdas123");
        list.add("1234sdasd");
        list.add("1234sfsf");
        System.out.println(getNotDuplicateList(list));
    }
    private static List<String> getNotDuplicateList(List<String> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        List<String> results = new ArrayList<>();
        Map<String, Integer> duplicate = new HashMap<>();
        list.forEach(e -> {
            List<String> numbers = getNumString(e);
            if (numbers.size() == 0) {
                if (duplicate.get("null") == null) {
                    duplicate.put("null", 1);
                }
                results.add(e);
            } else if (numbers.size() > 0) {
            boolean isDuplicate = false; for (String num : numbers) {
                if (duplicate.get(num) != null) { isDuplicate = true; }
            }if (!isDuplicate) { results.add(e); numbers.forEach(num -> { duplicate.put(num, 1); }); } }
    });
        return results;
    }
    private static List<String> getNumString(String word) {
    List<String> numbers = new ArrayList<>();
    String num = "";
    for (char c : word.toCharArray()) {
        if (c > '0' && c < '9') {
            num = num + c;
            continue;
        } else if (!"".equals(num)) { numbers.add(num); num = "";
        }
    }
    if (!"".equals(num)) { numbers.add(num); }return numbers; } }