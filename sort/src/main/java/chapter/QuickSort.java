package chapter;

import java.util.Arrays;

/**
 * @author yangz
 * @date 2022/4/14 - 9:06
 * 快速排序：一种常用的基于分治思想的排序算法.
 * 选择一个"基准"元素,将数组分成两个子数组,其中一个子数组中的所有元素都小于等于基准元素,
 * 另一个子数组中的所有元素都大于基准元素,然后对这两个子数组递归地进行排序.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array;
        array = new int[]{1,5,0,8,-1,11};
        quickSort(array,0,array.length-1);

        System.out.println(Arrays.toString(array));
    }

    /*快速排序方法
    * ↓   ↓p    ↓
    * 8 9 1 7 2 3
    * */
    public static void quickSort(int[] a,int left,int right){
        int l = left; //左下标
        int r = right; //右下标

        /*中轴值*/
        int pivot = a[(left + right) / 2];
        int temp;

        /* 将数组的元素,比pivot小 放到左边,大 放到右边 */
        while (l < r){

            /*在pivot左边一直找,找到大于pivot的值,才退出*/
            while (a[l] < pivot){
                l++;//左边的值小于pivot,将左下标向后移
            }

            /*在pivot右边一直找,找到小于pivot的值,才退出*/
            while (a[r] > pivot){
                r--;//右边的值大于pivot,将右下标向前移
            }

            /*当下面↓条件满足,说明已经将小于pivot的值放到左边,大于的值放到右边*/
            if (l >= r){ break;}
            /*不满足↑条件,此时l为左边大于pivot的下标,r为右边小于pivot的下标,则交换*/
            temp = a[l];
            a[l] = a[r];
            a[r] = temp;

            /*当交换完后, a[l] == pivot值 r前移*/
            if (a[l] == pivot){r--;}
            /*当交换完后, a[r] == pivot值 l后移*/
            if (a[r] == pivot){l++;}
        }

        if (l == r){
            l++;
            r--;
        }

        /*向左递归*/
        if (left < r){
            quickSort(a,left,r);
        }
        /*向右递归*/
        if (right > l){
            quickSort(a,l,right);
        }
    }

}
