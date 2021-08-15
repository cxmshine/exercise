package com.xuming.pay.degisnpatterns.composite;

/**
 * 组合模式demo
 *
 * @author xuming.chen
 * @create 2021/8/15 12:25 下午
 **/
public class CompositePatternDemo {

    public static void main(String[] args) {
        // CEO
        Employee ceo = new Employee("John","CEO");

        // 市场部高管
        Employee headMarketing = new Employee("Michel","Marketing");

        // 市场部普通职员
        Employee clerk1 = new Employee("Laura","Marketing");
        Employee clerk2 = new Employee("Bob","Marketing");

        // 添加相应的下属员工
        ceo.add(headMarketing);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(ceo);
        // 输出所有员工的信息
        for (Employee headEmployee : ceo.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }


    }


}
