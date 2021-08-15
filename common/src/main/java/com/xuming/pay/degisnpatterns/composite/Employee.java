package com.xuming.pay.degisnpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于演示组合模式的员工类
 *
 * 组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。
 * 这种模式创建了一个包含自己对象组的类。该类提供了修改相同对象组的方式。
 * 关键代码:树枝内部组合该接口，并且含有内部属性List，里面放Component
 *
 * @author xuming.chen
 * @create 2021/8/15 11:26 上午
 **/
public class Employee {

    /**
     * 姓名
     */
    private String name;

    /**
     * 部门
     */
    private String department;

    /**
     * 下属员工列表
     * 列表的泛型E就是Employee类
     */
    private List<Employee> subordinates;

    /**
     * others...
     */

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
        // 下属员工列表初始化为一个空列表
        this.subordinates = new ArrayList<>();
    }

    /**
     * 添加下属员工
     *
     * @param employee
     */
    public void add(Employee employee) {
        subordinates.add(employee);
    }

    /**
     * 移除下属员工
     *
     * @param employee
     */
    public void remove(Employee employee) {
        subordinates.remove(employee);
    }

    /**
     * 获取下属员工列表
     *
     * @return
     */
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return ("Employee:[Name:" + name + ", department:" + department + " ]");
    }


}
