package tree;

/**
 * @author yangz
 * @date 2022/4/20 - 14:32
 * 使用数组实现顺序二叉树
 */
public class ArrayBinaryTree {
    /*存放节点的数组*/
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /*对顺序二叉树(数组)进行遍历*/

    /**
     * 前序遍历
     * @param index 数组下标
     */
    public void preOrder(int index){
        /*如果数组为空,或数组大小为0*/
        if (arr == null || arr.length == 0){
            return;
        }
        /*输出当前元素*/
        System.out.println(arr[index]);

        /*向左递归*/
        if (index * 2 +1 < arr.length) {
            preOrder(index * 2 +1);
        }

        /*向右递归*/
        if (index * 2 + 2 < arr.length){
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 中序遍历
     * @param index 数组下标
     */
    public void midOrder(int index){
        /*如果数组为空,或数组大小为0*/
        if (arr == null || arr.length == 0){
            return;
        }

        /*向左递归*/
        if (index * 2 +1 < arr.length) {
            midOrder(index * 2 +1);
        }

        /*输出当前元素*/
        System.out.println(arr[index]);

        /*向右递归*/
        if (index * 2 + 2 < arr.length){
            midOrder(index * 2 + 2);
        }

    }

    /**
     * 后序遍历
     * @param index 数组下标
     */
    public void backOrder(int index){
        /*如果数组为空,或数组大小为0*/
        if (arr == null || arr.length == 0){
            return;
        }

        /*向左递归*/
        if (index * 2 +1 < arr.length) {
            backOrder(index * 2 +1);
        }

        /*向右递归*/
        if (index * 2 + 2 < arr.length){
            backOrder(index * 2 + 2);
        }

        /*输出当前元素*/
        System.out.println(arr[index]);
    }


}
