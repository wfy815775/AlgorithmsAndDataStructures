package wfy.sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    @Test
    public void tests(){
        Integer[] a = {1,7,5,6,3,2,4};
        sort(a,0,a.length-1);
        Arrays.stream(a).forEachOrdered(o -> System.out.println(o+" "));
    }

    public  <T extends Comparable<? super T>> void sort(T[] a, int left, int right) {
        if (left > right)
            return;
        int i, j;
        T temp = a[left]; //哨兵
        T t;  //交换 位置时候临时保存值
        i = left;   //左边界
        j = right;  //右边界
        while (i != j) {
            while (i < j && a[j].compareTo(temp) <= 0) j--;   //从哨兵的对面开始找
            while (i < j && a[i].compareTo(temp) <= 0) i++;
            if (i < j) {
                t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        a[left] = a[i];
        a[i] = temp;      //哨兵值和a[i]交换
        sort(a, left, i - 1);//继续处理左边的，这里是一个递归的过程
        sort(a, i + 1, right);

    }


}

