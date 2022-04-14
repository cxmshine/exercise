package com.xuming.pay.sort;

/**
 * 直接插入排序算法
 * 时间复杂度为O(N^2)
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:52
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, -3, 5, -5, 7, -7, 12456, -46725};
        //输出排序前数组
        SortUtil.display(arr);
        insertSort(arr);
        //输出排序后数组
        SortUtil.display(arr);
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                }
            }
        }
    }
}
