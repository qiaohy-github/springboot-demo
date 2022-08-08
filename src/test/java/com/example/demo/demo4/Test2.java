package com.example.demo.demo4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: qiaohy
 * @time: 2022/3/22
 */
public class Test2 {


    public static void main(String[] args) {

        List<MyUser> list = new ArrayList<MyUser>();

        MyUser user =new MyUser();
        user.setId(1);
        user.setName("zhangsan");
        user.setAddress("海淀");
        list.add(user);

        MyUser user2 =new MyUser();
        user2.setId(2);
        user2.setName("zhangsan2");
        user2.setAddress("海淀2");
        list.add(user2);

        /*User user3 =new User();
        user3.setId(3);
        user3.setName("zhangsan3");
        user3.setAddress("海淀3");
        list.add(user3);*/

        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        for (Integer l : list1){

            System.out.println(list);

            Iterator<MyUser> iterator = list.iterator();

            while (iterator.hasNext()){
                MyUser bean = iterator.next();

                if(l.intValue() == bean.getId().intValue()){

                    iterator.remove();
                    break;
                }

            }

        }



    }




}
