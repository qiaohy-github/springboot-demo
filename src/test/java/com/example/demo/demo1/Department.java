package com.example.demo.demo1;

import java.util.ArrayList;
import java.util.List;


public class Department {

    private Long id;
    private String name;
    private List<Department> children;

    public Department(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public static void main(String[] args) {
        Department department = new Department();
        List<Long> idList = new ArrayList<>();
        findId(department,"语文",idList);
        System.out.println(idList);
    }

    /**
     * 递归 遍历部门树
     * @param department 部门树
     * @param name 查找的部门名称
     * @param resultIdList 结果
     * @return
     */
    public static List<Long> findId(Department department,String name,List<Long> resultIdList){
        if(name.equals(department.getName())){
            resultIdList.add(department.getId());
        }
        List<Department> children = department.getChildren();
        if(children!=null && children.size()>0){
            for(Department department1: children){
                findId(department1,name,resultIdList);
            }
        }
        return resultIdList;
    }
}