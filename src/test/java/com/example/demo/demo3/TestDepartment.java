package com.example.demo.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:得到指定部门名称id集合
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class TestDepartment {

    public static void main(String[] args) {

        List<Long> ids = new ArrayList<>();//id集合
        Department dep = new Department();

        List<Long> ids2 = getDepartmentId(dep, ids, "部门名称");

        System.out.println(ids2);

    }

    /**
     * 递归方法
     * @param dep 部门
     * @param ids  id的集合
     * @param name 部门名称
     * @return
     */
    private static List<Long> getDepartmentId(Department dep, List<Long> ids, String name) {
        if(dep == null)
            return new ArrayList<>();

        if(name.equals(dep.getName()))
            ids.add(dep.getId());

        List<Department> chil = dep.getChildren();
        if(chil != null && chil.size() > 0){
            for (Department dep2 : chil){
                getDepartmentId(dep2, ids, name);
            }
        }
        return ids;
    }


}
