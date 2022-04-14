package com.xuming.pay.sort;

/**
 * 快排
 * 选定一个元素作为枢轴,想办法将它放到一个位置,使得它左边的值都小于等于它,右边的值都大于等于它.
 * 时间复杂度为O(NlogN)
 * 这是最简单的版本,还存在可优化之处
 * 代码是参考《大话数据结构》写出的
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:45
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 6, 9, 10, 12, 1};
        //输出排序前数组
        SortUtil.display(arr);
        quickSort(arr);
        //输出排序后数组
        SortUtil.display(arr);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int low, int high) {
        int pivotIndex;
        if (low < high) {
            pivotIndex = partition(arr, low, high);
            qSort(arr, low, pivotIndex - 1);
            qSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivotKey = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivotKey) {
                high--;
            }
            SortUtil.swap(arr, low, high);
            while (low < high && arr[low] <= pivotKey) {
                low++;
            }
            SortUtil.swap(arr, low, high);
        }

        return low;
    }

}
