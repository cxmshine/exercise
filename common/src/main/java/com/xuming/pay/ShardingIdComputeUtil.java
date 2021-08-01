package com.xuming.pay;

import java.util.zip.CRC32;

/**
 * 分片id计算工具类
 *
 * @author xuming.chen
 * @create 2021/8/1 4:28 下午
 **/
public class ShardingIdComputeUtil {

    /**
     * 订单号
     */
    private static final String ORDER_NO = "E20210801162250007800089";

    /**
     * 取模运算的数字
     */
    private static final Integer MODULO_NUMBER = 1024;

    public static void main(String[] args) {
        System.out.println(getShardingId(ORDER_NO));
    }

    /**
     * 获取分片id
     * 获取分片id的算法有很多，根据实际业务进行评估。这里只是其中一种
     *
     * @param orderNo 订单号
     * @return
     */
    public static int getShardingId(String orderNo) {
        CRC32 crc32 = new CRC32();
        crc32.update(orderNo.getBytes());
        long shardingId = crc32.getValue() % MODULO_NUMBER;
        return (int)shardingId;
    }


}
