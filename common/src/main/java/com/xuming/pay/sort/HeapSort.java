package com.xuming.pay.sort;

/**
 * 堆排序
 * 时间复杂度为O(NlogN)
 * 这里的代码参考的是左神算法初级班视频02
 * 当前"结点"的下标为i,则其左右子结点的下标分别为2*i+1、2*i+2,其直接父结点的下标为(i-1)/2 .
 * 这里的下标是从0开始,而《大话数据结构》上的下标是从1开始,有些区别,以这里的为准.
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:52
 **/
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 2, 9, 18, 20};
        //输出排序前数组
        SortUtil.display(arr);
        heapSort(arr);
        //输出排序后数组
        SortUtil.display(arr);
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        SortUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapAdjust(arr, 0, heapSize);
            SortUtil.swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        int parentIndex = (index - 1) / 2;
        while (arr[index] > arr[parentIndex]) {
            SortUtil.swap(arr, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private static void heapAdjust(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = ((left + 1 < heapSize && arr[left + 1] > arr[left]) ? left + 1 : left);
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            SortUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
