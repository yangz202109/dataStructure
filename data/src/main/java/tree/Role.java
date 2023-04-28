package tree;

import lombok.Data;

/**
 * @author yangz
 * @date 2022/4/22 - 17:41
 */
@Data
public class Role {
    private int id;
    private String name;

    /*
    * leftType/rightType == 0 表示指向的是左/右子树
    * leftType/rightType == 1 表示指向前驱/后继节点
    * */
    private int leftType;
    private int rightType;


    /*左子节点  默认为null*/
    private Role left;

    /*右子节点 默认为null*/
    private Role right;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /*前序遍历*/
    public void preOrder(){
        /*先输出父节点*/
        System.out.println(this);

        /*递归向左子树前序遍历*/
        if (this.getLeft() != null){
            this.left.preOrder();
        }

        /*递归向右子树前序遍历*/
        if (this.getRight() !=null){
            this.right.preOrder();
        }
    }

    /*中序遍历*/
    public void midOrder(){
        /*递归向左子树前序中序遍历*/
        if (this.getLeft() != null){
            this.left.midOrder();
        }

        /*再输出父节点*/
        System.out.println(this);

        /*递归向右子树前序中序遍历*/
        if (this.getRight() !=null){
            this.right.midOrder();
        }
    }

    /*后序遍历*/
    public void backOrder(){
        /*递归向左子树前序后序遍历*/
        if (this.getLeft() != null){
            this.left.backOrder();
        }

        /*递归向右子树前序后序遍历*/
        if (this.getRight() !=null){
            this.right.backOrder();
        }

        /*最后输出父节点*/
        System.out.println(this);
    }

    /*前序遍历查找*/
    public Role preOrderSearch(int id){
        /*比较当前节点是否等于*/
        if (this.getId() == id){
            return this;
        }

        Role role = null;

        /*判断当前节点的左子节点是否为空,如何为空,则递归前序查找
         * 如何左递归前序查找,找到节点,则返回
         * */
        if (this.left != null){
            role = this.left.preOrderSearch(id);
        }

        /*左子树找到了,提前返回*/
        if (role != null){return role;}

        /*判断当前节点的右子节点是否为空,如何为空,则递归前序查找
         * 如何右递归前序查找,找到节点,则返回
         * */
        if (this.right != null){
            role = this.right.preOrderSearch(id);
        }

        return role;
    }

    /*中序遍历查找*/
    public Role midOrderSearch(int id){

        /*判断当前节点的左子节点是否为空,如果不为空,则递归中序查找*/
        Role role = null;
        if (this.left != null){
            role = this.left.midOrderSearch(id);
        }

        /*左递归找到了*/
        if (role != null){
            return role;
        }

        /*判断当前节点是否等于*/
        if (this.getId() == id){
            return this;
        }

        /*判断当前节点的右子节点是否为空,如果不为空,则递归中序查找*/
        if (this.right != null){
            role = this.right.midOrderSearch(id);
        }

        return role;
    }

    /*后序遍历查找*/
    public Role backOrderSearch(int id){

        /*判断当前节点的左子节点是否为空,如果不为空,则递归后序查找*/
      Role role = null;

        if (this.left != null){
            role = this.left.midOrderSearch(id);
        }

        /*左递归找到了*/
        if (role != null){
            return role;
        }

        /*判断当前节点的右子节点是否为空,如果不为空,则递归后序查找*/
        if (this.right != null){
            role = this.right.midOrderSearch(id);
        }

        /*右递归找到了*/
        if (role != null){
            return role;
        }


        /*判断当前节点是否等于*/
        if (this.getId() == id){
            return this;
        }

        return null;
    }

    public void delete(int id){

        /*当前节点的左节点不为空,并且其左节点等于要删除的num,*/
        if (this.getLeft() != null && this.getLeft().getId() == id){
            this.setLeft(null);
            return;
        }

        /*当前节点的右节点不为空,并且其右节点等于要删除的num,*/
        if (this.getRight() != null && this.getRight().getId() == id){
            this.setRight(null);
            return;
        }

        /*上面两个条件都不满足*/

        /*向左递归删除*/
        if (this.getLeft() != null) this.getLeft().delete(id);

        /*向右递归删除*/
        if (this.getRight() != null) this.getRight().delete(id);
    }
}
