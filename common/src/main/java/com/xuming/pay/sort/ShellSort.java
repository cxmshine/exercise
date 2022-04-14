package com.xuming.pay.sort;

/**
 * 希尔排序算法(直接插入排序算法的升级版)
 * 时间复杂度为O(N^1.3)
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:50
 **/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, -3, 5, -5, 777, 1024, -20125, 36964, 0};
        //输出排序前数组
        SortUtil.display(arr);
        shellSort(arr);
        //输出排序后数组
        SortUtil.display(arr);
    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        int N = arr.length;
        int incremetn = N;
        while (incremetn > 1) {
            incremetn = incremetn / 3 + 1;
            for (int i = incremetn; i < N; i++) {
                for (int j = i; (j - incremetn) >= 0; j -= incremetn) {
                    if (arr[j - incremetn] > arr[j]) {
                        SortUtil.swap(arr, j - incremetn, j);
                    }
                }
            }
        }
    }


}
