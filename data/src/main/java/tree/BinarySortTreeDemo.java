package tree;

/**
 * @author yangz
 * @date 2022/8/17 - 11:01
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree sortTree = new BinarySortTree();

        int[] arr = {7, 3, 10, 13, 1, 3, 2, 9};

        for (int a : arr) {
            sortTree.add(new SortNode(a));
        }
        sortTree.midPre();

    }
}

/*排序树*/
class BinarySortTree {
    private SortNode root;


    public void add(SortNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void midPre() {
        if (root != null) {
            root.midPre();
        } else {
            System.out.println("该二叉排序树为空,无法遍历");
        }
    }
}

/*节点类*/
class SortNode {
    int value;
    SortNode left;
    SortNode right;

    public SortNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "SortNode{" +
                "value=" + value +
                '}';
    }

    public void add(SortNode node) {
        if (node == null) {
            return;
        }

        /*比较节点的值,当添加节点的值小于叶子节点则放在其左子节点*/
        if (node.value < this.value) {
            //当前节点的左子节点为空
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }


    }

    /*中序遍历*/
    public void midPre() {
        if (this.left != null) {
            this.left.midPre();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midPre();
        }
    }

}