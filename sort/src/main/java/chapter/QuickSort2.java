package chapter;

/**
 * @author yangz
 * @createTime 2023/7/18 - 10:25
 */
public class QuickSort2 {

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right); // 获取枢轴元素的索引
            quickSort(array, left, pivotIndex - 1); // 对枢轴元素的左边进行快速排序
            quickSort(array, pivotIndex + 1, right); // 对枢轴元素的右边进行快速排序
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // 选择最左边的元素为枢轴元素
        int i = left + 1;
        int j = right;

        while (true) {
            while (i <= j && array[i] <= pivot) { // 从左往右找到第一个大于枢轴元素的元素
                i++;
            }
            while (i <= j && array[j] >= pivot) { // 从右往左找到第一个小于枢轴元素的元素
                j--;
            }
            if (i >= j) { // 如果i和j相遇，退出循环
                break;
            }
            // 交换i和j位置的元素
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        // 将枢轴元素放到正确的位置上
        array[left] = array[j];
        array[j] = pivot;

        return j; // 返回枢轴元素的索引
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 9, 1, 3, 7};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
