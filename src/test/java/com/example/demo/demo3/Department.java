package com.example.demo.demo3;

import java.util.List;

/**
 * @description:部门实体类
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class Department {

    private Long id;
    private String name;
    private List<Department> children;

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
}
