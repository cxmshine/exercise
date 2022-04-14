package com.xuming.pay.sort;

/**
 * 归并排序
 * 时间复杂度为O(NlogN)
 * 记住2个点 : 1.要计算mid(在sortProcess函数中),然后在merge函数中要使用,因此merge函数的形参列表中有int mid
 *            2.要用到辅助数组 int[] help = new int[R-L+1] ;
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:52
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, -1, 3, -3, 5, -5, 7, -7, 12456, -46725};
        //输出排序前数组
        SortUtil.display(arr);
        mergeSort(arr);
        //输出排序后数组
        SortUtil.display(arr);
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return ;
        }
        int mid = L + (R - L) / 2;
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
