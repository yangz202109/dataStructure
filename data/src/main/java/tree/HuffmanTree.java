package tree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yangz
 * @date 2022/8/15 - 9:40
 * 赫夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {3, 6, 11, 25, 30};

        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    /**
     * 将数组构建为一棵赫夫曼树
     *
     * @param arr 需要构建的数组
     * @return 最后构建完成的root节点
     */
    public static Node createHuffmanTree(int[] arr) {

        //将数组的数据放入集合
        ArrayList<Node> arrayList = new ArrayList<>();
        for (int a : arr) {
            arrayList.add(new Node(a));
        }

        System.out.println("原始集合==================");
        arrayList.forEach(System.out::println);
        System.out.println("原始集合==================");


        while (arrayList.size() > 1) {
            //排序
            Collections.sort(arrayList);

            //取出根节点权值最小节点
            Node leftNode = arrayList.get(0);
            //取出根节点权值第二小节点
            Node rightNode = arrayList.get(1);

            //构建成一棵二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //删除节点
            arrayList.remove(leftNode);
            arrayList.remove(rightNode);

            //加入新的
            arrayList.add(parent);

        }
        return arrayList.get(0);
    }

    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("树为空,无法遍历");
        }
    }

}

class Node implements Comparable<Node>{
    int value; //权值
    Node left; //左子节点
    Node right; //右子节点

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(@NotNull Node o) {
        //排序--从小到大
        return this.value - o.value;
    }
}