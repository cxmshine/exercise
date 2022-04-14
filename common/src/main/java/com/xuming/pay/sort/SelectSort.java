package com.xuming.pay.sort;

/**
 * 选择排序
 * 时间复杂度为O(N^2)
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:52
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, -3, 5, -5, 7, -7, 12456, -46725};
        //输出排序前数组
        SortUtil.display(arr);
        selectSort(arr);
        //输出排序后数组
        SortUtil.display(arr);
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        int N = arr.length;
        int minIndex;
        for (int i = 0; i < N - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                SortUtil.swap(arr, minIndex, i);
            }
        }
    }
}
