
/**
 * @author yangz
 * @date 2022/12/1 - 16:09
 */
public class Node {
    private int num;
    private Node left;
    private Node right;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "num=" + num +
                '}';
    }

    public Node(int num) {
        this.num = num;
        this.left = null;
        this.right = null;
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

    public Node invert(Node root) {
        // 叶子结果不能翻转
        if (root == null) {
            return null;
        }
        // 翻转左节点下的左右节点
        Node left = invert(root.left);
        // 翻转右节点下的左右节点
        Node right = invert(root.right);

        // 左右节点下的二叉树翻转好后，翻转根节点的左右节点
        root.right = left;
        root.left = right;
        return root;
    }

    public Node invert2() {
        Node left = null;
        Node right = null;

        if (this.left != null) {
            left = this.left.invert2();
        }
        if (this.right != null) {
            right = this.right.invert2();
        }

        this.right = left;
        this.left = right;
        return this;
    }

}
