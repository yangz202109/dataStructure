package chapter;

import java.util.Arrays;

/**
 * @author yangz
 * @date 2022/4/14 - 14:06
 * 归并排序: 一种分治法的经典排序算法.
 * 它将一个未排序的数组分成两个子数组,分别对这两个子数组进行排序,然后将排好序的子数组合并成一个有序的数组.
 * 整个过程可以递归地进行,直到最后数组被分成只剩一个元素,即可认为已经排好序.
 */
public class MergerSort {
    public static void main(String[] args) {
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[array.length];

        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 分解方法
     */
    public static void mergeSort(int[] a, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间下标

            /*向左递归进行分解*/
            mergeSort(a, left, mid, temp);

            /*向右递归进行分解*/
            mergeSort(a, mid + 1, right, temp);

            /*合并*/
            merge(a, left, mid, right, temp);
        }
    }

    /**
     * 合并方法
     *
     * @param a     待排序的原始数组
     * @param left  左边索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void merge(int[] a, int left, int mid, int right, int[] temp) {
        int i = left;    //左边有序数组的初始下标
        int j = mid + 1; //右边有序数组的初始下标
        int t = 0;       //temp数组的当前下标

        /*
         * 先将左右两边(有序)的数据按规则填充到temp数组中
         * 直到左右两边中,有一边处理完毕
         * */
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) { //左边的当前元素小于或等于右边的
                temp[t] = a[i];//放入temp中
                t++;
                i++;
            } else {//反之
                temp[t] = a[j];
                t++;
                j++;
            }
        }

        /* 在将剩余一边的数据按顺序填充到temp中 */
        while (i <= mid) {//左边的数据还有剩余
            temp[t] = a[i];
            t++;
            i++;
        }
        while (j <= right) {//右边的数据还有剩余
            temp[t] = a[j];
            t++;
            j++;
        }

        /*
         * 最后,将temp数组的数据拷贝回a数组
         * 注意：并不是每次都拷贝全部数据
         * */
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            a[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
