package chapter;

import java.util.Arrays;

/**
 * @author yangz
 * @date 2022/4/13 - 11:41
 */
public class Sort2 {
    public static void main(String[] args) {
        int[] array;
        array = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0, -1};

        //shellSort(array);
        shellSort2(array);
        System.out.println(Arrays.toString(array));
    }

    /*希尔排序--交换式(更加高效的插入排序)*/
    public static void shellSort(int[] a) {
        int temp;

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (a[j] > a[j + gap]) {
                        temp = a[j + gap];
                        a[j + gap] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
    }

    /*希尔排序--移动式*/
    public static void shellSort2(int[] a) {

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int j = i;
                int temp = a[j];
                if (a[j] < a[j - gap]) {
                    while (j - gap >= 0 && temp < a[j - gap]) {
                        a[j] = a[j - gap];
                        j -= gap;
                    }
                    a[j] = temp;
                }
            }
        }
    }
}
