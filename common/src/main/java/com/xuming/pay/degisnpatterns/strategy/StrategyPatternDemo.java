package com.xuming.pay.degisnpatterns.strategy;

/**
 * 策略模式demo
 *
 * @author xuming.chen
 * @create 2021/8/15 11:03 上午
 **/
public class StrategyPatternDemo {

    private static final int NUM1 = 10;
    private static final int NUM2 = 5;


    public static void main(String[] args) {
        // 1.加法运算策略
        OperationContext context = new OperationContext(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(NUM1, NUM2));

        // 2.减法运算策略
        context = new OperationContext(new OperationSubtract());
        System.out.println("10 - 5 = " + context.executeStrategy(NUM1, NUM2));

        // 3.乘法运算策略
        context = new OperationContext(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(NUM1, NUM2));
    }
}
