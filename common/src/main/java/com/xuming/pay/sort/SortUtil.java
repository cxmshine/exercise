package com.xuming.pay.sort;

/**
 * 排序工具类
 *
 * @author xuming.chen
 * @create 2022/4/14 下午10:50
 **/
public class SortUtil {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void display(int[] arr){
        for(int i = 0;i < arr.length;i++){
            if (i == arr.length - 1) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }

    }
}
