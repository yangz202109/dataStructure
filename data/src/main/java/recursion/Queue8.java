package recursion;

/**
 * @author yangz
 * @date 2022/4/12 - 10:20
 * 8皇后问题
 */
public class Queue8{
    /*皇后个数*/
    int max=8;
    /*保存皇后摆放位置的结果*/
    int[] array=new int[max];

    public static void main(String[] args) {


    }

  /*public boolean judge(int n){
        for (int i = 0; i < n; i++) {

        }
    }*/

    /*打印皇后摆放的位置*/
    public void print(){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }
}
