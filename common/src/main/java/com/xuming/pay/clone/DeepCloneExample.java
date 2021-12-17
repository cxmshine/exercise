package com.xuming.pay.clone;

/**
 * 深拷贝
 * 拷贝对象和原始对象的引用类型引用不同对象
 *
 * @author xuming.chen
 * @create 2021/12/17 9:02 下午
 **/
public class DeepCloneExample implements Cloneable{
    private int[] arr;

    public DeepCloneExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample result = (DeepCloneExample) super.clone();
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 针对原始对象进行修改
        e1.set(2, 222);
        // 输出2
        // 由于拷贝对象和原始对象的引用指向的不是同一对象，对任一对象的修改，不会影响另一对象
        System.out.println(e2.get(2));
    }
}
