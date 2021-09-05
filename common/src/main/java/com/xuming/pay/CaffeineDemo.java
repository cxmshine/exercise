package com.xuming.pay;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;

import java.util.concurrent.TimeUnit;

/**
 * 缓存之Caffeine学习
 *
 * @author xuming.chen
 * @create 2021/9/5 10:11 上午
 **/
public class CaffeineDemo {

    private static final Integer LOOP_TIMES = 5;

    private static final Long DURATION = 5L;

    /**
     * 声明Caffeine缓存
     */
    private static final Cache<Integer, Integer> cache = Caffeine.newBuilder()
            /*** expireAfterWrite(duration, unit):在最后一次写入缓存后开始计时，在指定的时间后过期 ***/
            /*** 此处设置的持续时间为5秒 ***/
            .expireAfterWrite(DURATION, TimeUnit.SECONDS)
            /*** a listener instance that caches should notify each time an entry is removed ***/
            .removalListener((Integer key, Integer value, RemovalCause cause) ->
                    System.out.printf("Key %s was removed (%s)%n", key, cause))
            .build();

    public static void main(String[] args) throws InterruptedException {
        // 1.往缓存中放入数据
        for (int i = 0; i < LOOP_TIMES; i++) {
            /**
             * 0-0
             * 1-1
             * 2-4
             * 3-9
             * 4-16
             */
            cache.put(i, i * i);
        }

        printDividingLine();

        // 2.查缓存中的数据
        for (int i = 0; i < LOOP_TIMES + 1; i++) {
            /**
             * 0
             * 1
             * 4
             * 9
             * 16
             * 25 ==> i=5,缓存中原先没有这个值,get的时候拿不到值,会根据第二个参数的Function去设置值
             */
            System.out.println(cache.get(i, key -> getDataFromDB(key)));
        }

        printDividingLine();

        // 3.睡眠7秒之后再查缓存中的数据，预期是取不到原值，因为已经过了缓存有效期5秒
        TimeUnit.SECONDS.sleep(7);
        for (int i = 0; i < LOOP_TIMES + 1; i++) {
            // 若缓存过期，设置值为-1，预期是打印出来的值都为-1
            System.out.println(cache.get(i, key -> -1));
        }
    }

    /**
     * 打印分隔线
     */
    private static void printDividingLine() {
        System.out.println("=====================================");
    }

    /**
     * 模拟本地缓存取不到数据时，从后端DB取数据(其实更常见的可能是本地缓存->分布式缓存(如Redis)->后端数据库)，此处暂不考虑分布式缓存
     *
     * @param i
     * @return
     */
    private static Integer getDataFromDB(Integer i) {
        return i * i;
    }
}
