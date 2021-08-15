package com.xuming.pay.degisnpatterns.strategy;

/**
 * 运算上下文
 *
 * @author xuming.chen
 * @create 2021/8/15 11:01 上午
 **/
public class OperationContext {
    private OperationStrategy operationStrategy;

    /**
     * 用运算策略构造运算上下文
     *
     * @param operationStrategy 运算策略
     */
    public OperationContext(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    /**
     * 执行策略(运算)
     *
     * @param num1 操作数1
     * @param num2 操作数2
     * @return
     */
    public int executeStrategy(int num1, int num2) {
        return operationStrategy.doOperation(num1, num2);
    }
}
