package tree;

/**
 * @author yangz
 * @date 2022/4/22 - 17ObjectOutputStream:15
 * 线索化二叉树
 */
public class ThreaderBinaryTree {
    private Role root;

    /**
     * 帮助进行线索化,用于指向当前节点的前驱节点的指针
     */
    private Role pre = null;

    public void setRoot(Role root) {
        this.root = root;
    }

    public void threadRoles() {
        threadRoles(root);
    }

    /**
     * 对二叉树进行中序线索化
     *
     * @param role 当前需要线索化的节点
     */
    public void threadRoles(Role role) {
        /*当前节点为null,无法线索化*/
        if (role == null) {
            return;
        }

        /*1.线索化左子树*/
        threadRoles(role.getLeft());

        /*2.线索化当前节点(重点)*/
        /*处理前驱节点(让左节点为空的节点的左节点指向前一个)*/
        if (role.getLeft() == null) {
            /*当前节点的左指针指向前驱节点*/
            role.setLeft(pre);
            /*修改当前节点的左指针类型*/
            role.setLeftType(1);
        }
        /*处理后继节点*/
        if (pre != null && pre.getRight() == null) {
            /*让前驱节点的右指针指向当前节点*/
            pre.setRight(role);
            pre.setRightType(1);
        }
        /*每处理一个节点后,让当前节点是下一个节点的前驱节点*/
        pre = role;


        /*3.线索化右子树*/
        threadRoles(role.getRight());
    }

    public void threadPreRoles(Role role) {
        /*当前节点为null,无法线索化*/
        if (role == null) {
            return;
        }

        /*1.线索化当前节点*/
        /*处理前驱节点*/
        if (role.getLeft() == null) {
            /*当前节点的左指针指向前驱节点*/
            role.setLeft(pre);
            /*修改当前节点的左指针类型*/
            role.setLeftType(1);
        }

        /*处理后继节点*/
        if (pre != null && pre.getRight() == null) {
            /*让前驱节点的右指针指向当前节点*/
            pre.setRight(role);
            pre.setRightType(1);
        }

        /*每处理一个节点后,让当前节点是下一个节点的前驱节点*/
        pre = role;

        /*2.线索化左子树*/
        if (role.getLeftType() == 0) {
            threadPreRoles(role.getLeft());
        }

        /*3.线索化右子树*/
        if (role.getRightType() == 0) {
            threadPreRoles(role.getRight());
        }

    }

    /**
     * 遍历中序线索化后二叉树的方法
     */
    public void threadMindList() {
        //储存当前遍历的节点
        Role temp = root;

        while (temp != null) {
            /*循环找到leftType == 1 的节点*/
            while (temp.getLeftType() == 0) {
                temp = temp.getLeft();
            }

            /*打印当前节点*/
            System.out.println(temp);

            /*如果当前节点的右指针指向的是后继节点,就一直输出*/
            while (temp.getRightType() == 1) {
                temp = temp.getRight();
                System.out.println(temp);
            }

            temp = temp.getRight();
        }
    }

    public void threadPreRolesList() {
        //储存当前遍历的节点
        Role temp = root;

        while (temp.getLeftType() == 0) {
            System.out.println(temp);
            temp = temp.getLeft();
        }

        while (temp.getRightType() == 1) {
            System.out.println(temp);
            temp = temp.getRight();
        }

        System.out.println(temp);
    }

    public void midOrder() {
        if (root == null) {
            System.out.println("该树为空");
            return;
        }

        root.midOrder();

    }

    public void preOrder() {
        if (root == null) {
            System.out.println("该树为空");
            return;
        }

        root.preOrder();
    }

    /**
     * 删除节点
     */
    public void delete(int id) {
        if (root == null) {
            System.out.println("该二叉树为空");
            return;
        }

        /*要删除的节点就是根节点*/
        if (root.getId() == id) {
            root = null;
        } else {
            /*递归删除*/
            root.delete(id);
        }
    }
}
