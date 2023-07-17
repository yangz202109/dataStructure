package tree;

/**
 * @author yangz
 * @date 2022/4/16 - 9:41
 * 二叉树
 */
public class BinaryTree {
    /*根节点*/
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**前序遍历*/
    public void preOrder(){
        if (root !=null){
            root.preOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    /**中序遍历*/
    public void midOrder(){
        if (root !=null){
            root.midOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    /**后序遍历*/
    public void backOrder(){
        if (root !=null){
            root.backOrder();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    /**前序遍历查找*/
    public HeroNode preOrderSearch(int num){
        if (root != null) {
            return root.preOrderSearch(num);
        }else {
            return null;
        }
    }

    /**中序遍历查找*/
    public HeroNode midOrderSearch(int num){
        if (root != null) {
            return root.midOrderSearch(num);
        }else {
            return null;
        }
    }

    /**后序遍历查找*/
    public HeroNode backOrderSearch(int num){
        if (root != null) {
            return root.backOrderSearch(num);
        }else {
            return null;
        }
    }

    /**删除节点*/
    public void delete(int num){
        if (root == null){
            System.out.println("该二叉树为空");
            return;
        }

        if (root.getNum() == num){
            root = null;
        }else {
            /*递归删除*/
            root.delete(num);
        }
    }
}
