package tree;

import org.jetbrains.annotations.NotNull;
import java.util.*;

/**
 * @author yangz
 * @date 2022/8/15 - 15:25
 * 赫夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like you and you like me";
        byte[] bytes = content.getBytes();
        System.out.println("原始内容的大小:" + bytes.length);

        List<CodeNode> nodes = getNodes(bytes);

        CodeNode root = createHuffmanTree(nodes);
        preOrder(root);
    }

    /**
     * @param bytes 需要转换的字节数组
     * @return 节点集合 [data=97,weight=4],[]
     */
    public static List<CodeNode> getNodes(byte[] bytes) {
        List<CodeNode> nodes = new ArrayList<>();


        Map<Byte, Integer> counts = new HashMap<>();
        //遍历原始内容字节数组,统计 每一个byte出现的次数->map[key,value]
        for (Byte b : bytes) {
            //判断map中是否已经存在相同的
            counts.merge(b, 1, Integer::sum);
        }

        //遍历map 把每一个键值对转成一个Node 对象，并加入到nodes集合
      /*  for (Map.Entry<Byte, Integer> map : counts.entrySet()) {
            nodes.add(new CodeNode(map.getKey(), map.getValue()));
        }*/
        counts.forEach((key, value) -> nodes.add(new CodeNode(key, value)));
        return nodes;
    }

    //生成赫夫曼树
    public static CodeNode createHuffmanTree(List<CodeNode> nodes) {

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            CodeNode leftNode = nodes.get(0);
            CodeNode rightNode = nodes.get(1);

            CodeNode parent = new CodeNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    //前序遍历
    public static void preOrder(CodeNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空,无法遍历");
        }
    }
}

class CodeNode implements Comparable<CodeNode> {
    Byte data; //存放数据 a->97
    Integer weight; //权重,字符出现的次数
    CodeNode left;
    CodeNode right;

    public CodeNode(Byte data, Integer weight) {
        this.data = data;
        this.weight = weight;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(@NotNull CodeNode o) {
        //根据权重从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "CodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}