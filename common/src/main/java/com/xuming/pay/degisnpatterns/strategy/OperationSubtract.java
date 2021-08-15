package com.xuming.pay.degisnpatterns.strategy;

/**
 * 减法运算
 *
 * @author xuming.chen
 * @create 2021/8/15 10:59 上午
 **/
public class OperationSubtract implements OperationStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
