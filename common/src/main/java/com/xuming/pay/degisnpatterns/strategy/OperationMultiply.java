package com.xuming.pay.degisnpatterns.strategy;

/**
 * 乘法运算
 *
 * @author xuming.chen
 * @create 2021/8/15 11:00 上午
 **/
public class OperationMultiply implements OperationStrategy {

    /**
     * 重点在于策略模式的学习,此处不考虑整数溢出的情况
     *
     * @param num1 操作数1
     * @param num2 操作数2
     * @return
     */
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
