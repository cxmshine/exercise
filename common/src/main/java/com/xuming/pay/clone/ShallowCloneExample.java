package com.xuming.pay.clone;

/**
 * 浅克隆
 * 拷贝对象和原始对象的引用类型引用同一个对象
 *
 * @author xuming.chen
 * @create 2021/12/17 8:59 下午
 **/
public class ShallowCloneExample implements Cloneable {
    private int[] arr;

    public ShallowCloneExample() {
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
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }


    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        // 针对原始对象进行修改
        e1.set(2, 222);
        // 输出222
        // 由于拷贝对象和原始对象的引用指向同一对象，对任一对象的修改，会影响另一对象
        System.out.println(e2.get(2));
    }
}
