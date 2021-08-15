package com.xuming.pay.degisnpatterns.strategy;

/**
 * 策略模式学习
 * 此处定义一个运算策略接口
 *
 * 策略模式:定义一系列的算法，将它们逐个封装起来，并且使它们可相互替换。
 * 主要解决在多个算法相似的情况下，使用if-else带来的复杂和难以维护。
 * 应用实例:本例子中的加减乘运算；旅行的出游方式，高铁/飞机/自驾/长途客车等，每一种出游方式就是一个策略
 * 如果策略多于四个，需要考虑使用混合模式，解决策略类膨胀的问题。
 *
 * 一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 *
 * @author xuming.chen
 * @create 2021/8/15 10:55 上午
 **/
public interface OperationStrategy {
    /**
     * 对两个整数进行运算
     *
     * @param num1 操作数1
     * @param num2 操作数2
     * @return 运算结果
     */
    int doOperation(int num1, int num2);
}
