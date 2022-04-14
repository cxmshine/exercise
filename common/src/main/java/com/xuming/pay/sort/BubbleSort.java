package com.xuming.pay.sort;

/**
 * 冒泡排序
 * 时间复杂度为O(N^2)
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:49
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, -3, 5, -5, 7, -7, 12456, -46725};
        //输出排序前数组
        SortUtil.display(arr);
        bubbleSort(arr);
        //输出排序后数组
        SortUtil.display(arr);
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtil.swap(arr, j, j + 1);
                }
            }
        }
    }


}
