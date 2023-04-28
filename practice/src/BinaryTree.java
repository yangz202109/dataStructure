/**
 * @author yangz
 * @date 2022/12/1 - 16:14
 */
public class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        root = null;
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("该树为空,无法遍历");
            return;
        }
        root.preOrder();
    }

    public void invert(){
        if (root == null) {
            System.out.println("该树为空,无法反转");
            return;
        }


        root.invert(root);
    }
}
