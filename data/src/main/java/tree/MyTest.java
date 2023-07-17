package tree;

import org.junit.Test;

/**
 * @author yangz
 * @date 2022/4/16 - 9:50
 */
public class MyTest {
    @Test
    public void t1() {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "晁盖");
        HeroNode node5 = new HeroNode(5, "林冲");

        binaryTree.setRoot(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node5);

        binaryTree.preOrder();
        // System.out.println(binaryTree.backOrderSearch(6));
        System.out.println("=======删除后=========");
        binaryTree.delete(4);
        binaryTree.preOrder();

    }

    @Test
    public void t2() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(a);
        arrayBinaryTree.backOrder(0);

    }

    @Test
    public void t3() {
        ThreaderBinaryTree tree = new ThreaderBinaryTree();

        Role root = new Role(1, "tom");
        Role role2 = new Role(2, "rick");
        Role role3 = new Role(3, "marry");
        Role role4 = new Role(4, "summer");
        Role role5 = new Role(5, "morty");
        Role role6 = new Role(6, "jack");

        tree.setRoot(root);
        root.setLeft(role2);
        root.setRight(role3);
        role2.setLeft(role4);
        role2.setRight(role5);
        role3.setLeft(role6);

        //tree.midOrder();
        //tree.threadRoles();

        tree.preOrder();
        tree.threadPreRoles(root);

        Role leftRole = role5.getLeft();
        System.out.println("5号节点的前驱节点是 " + leftRole);
        Role rightRole = role5.getRight();
        System.out.println("5号节点的后继节点是  " + rightRole);

        /*线索化后的二叉树不能使用二叉树的遍历方式*/
        System.out.println("========线索化遍历后结果==========");
        // tree.threadMindList();
        tree.threadPreRolesList();
    }

}
