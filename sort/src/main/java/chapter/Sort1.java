package chapter;

import java.util.Arrays;

/**
 * @author yangz
 * @date 2022/4/12 - 13:52
 */
public class Sort1 {

    public static void main(String[] args) {
        int[] array;
        array = new int[]{2,1,0,3,-1};
         bubbleSort(array);
        // electSort(array);
        //insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    /*冒泡排序方法*/
    public static void bubbleSort(int[] a){
       int length = a.length;
       int temp;
       boolean flag=false; //标识变量,表示是否进行过交换

       /*外层循环表示：排序次数(数组元素个数-1)
       * 内层循环：遍历数组(数组下标个数-i),j不能指向数组最后(a[j+1]会数组越界)
       * */
       for (int i = 0; i <length -1; i++) {

           for (int j = 0; j < length-1-i; j++) {
              if (a[j] > a[j+1]){
                  flag=true;
                  temp=a[j];
                  a[j]=a[j+1];
                  a[j+1]=temp;
              }
           }
           if (!flag){
               /*这一趟排序中,没有交换过(表示数组已经是有序了,可以退出循环)*/
               break;
           }else {
               /*将flag改为false,标识下一趟排序*/
               flag = false;
           }

       }
   }

    /*选择排序方法*/
    public static void selectSort(int[] a){
      int length = a.length;
      int minNum;
      int minIndex;
      int temp;

      /*排序传送(数组大小-1)*/
      for (int i = 0; i < length-1; i++) {
          /*设定当前为最小的*/
          minNum=a[i];
          minIndex=i;
          for (int j = i+1; j < length; j++) {
              if (a[j] < minNum){
                  minNum = a[j];
                  minIndex = j;
              }
          }
          temp=a[i];
          a[i]=minNum;
          a[minIndex]=temp;

      }
  }

    /*插入排序方法
    * 将数组假定分成有序和无效两个数组
    * (2),1,0,3,-1  假定的数组
    * (1,2),0,3,-1
    * (0,1,2),3,-1
    * (0,1,2,3),-1
    * 1-,0,1,2,3
    * */
    public static void insertSort(int[] a){
        int length = a.length;
        int insertValue;
        int insertIndex;

        for (int i = 0; i < length-1; i++) {
            insertIndex =i;/*有序数组的最后一个下标*/
            insertValue = a[i+1];/*无效数组的第一个下标(要插入的数)*/

            /*
            * 将要插入的数在有序数组中挨个比较
            * */
            while (insertIndex >=0 && insertValue < a[insertIndex]){
                a[insertIndex + 1] = a[insertIndex];
                insertIndex--;
            }
            /*insertIndex是要插入位置的前一个*/
            a[insertIndex + 1] = insertValue;
        }

    }
}
