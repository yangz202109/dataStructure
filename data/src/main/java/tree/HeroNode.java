package tree;

import lombok.Data;

/**
 * @author yangz
 * @date 2022/4/15 - 17:13
 */
@Data
public class HeroNode {
    private int num;
    private String name;

    /*左节点*/
    private HeroNode left;
    /*右节点*/
    private HeroNode right;

    public HeroNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
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
    public HeroNode preOrderSearch(int num){
      /*比较当前节点是否等于*/
      if (this.getNum() == num){
          return this;
      }

      HeroNode node = null;

      /*判断当前节点的左子节点是否为空,如何为空,则递归前序查找
      * 如何左递归前序查找,找到节点,则返回
      * */
      if (this.getLeft() != null){
        node = this.getLeft().preOrderSearch(num);
      }

      /*左子树找到了,提前返回*/
      if (node != null){return node;}

      /*判断当前节点的右子节点是否为空,如何为空,则递归前序查找
      * 如何右递归前序查找,找到节点,则返回
      * */
      if (this.getRight() != null){
         node = this.getRight().preOrderSearch(num);
      }

      return node;
    }

    /*中序遍历查找*/
    public HeroNode midOrderSearch(int num){

        /*判断当前节点的左子节点是否为空,如果不为空,则递归中序查找*/
        HeroNode node = null;
        if (this.getLeft() != null){
            node = this.getLeft().midOrderSearch(num);
        }

        /*左递归找到了*/
        if (node != null){
            return node;
        }

        /*判断当前节点是否等于*/
        if (this.getNum() == num){
            return this;
        }

        /*判断当前节点的右子节点是否为空,如果不为空,则递归中序查找*/
        if (this.getRight() != null){
            node = this.getRight().midOrderSearch(num);
        }

        return node;
    }

    /*后序遍历查找*/
    public HeroNode backOrderSearch(int num){

        /*判断当前节点的左子节点是否为空,如果不为空,则递归后序查找*/
        HeroNode node = null;

        if (this.getLeft() != null){
            node = this.getLeft().midOrderSearch(num);
        }

        /*左递归找到了*/
        if (node != null){
            return node;
        }

        /*判断当前节点的右子节点是否为空,如果不为空,则递归后序查找*/
        if (this.getRight() != null){
            node = this.getRight().midOrderSearch(num);
        }

        /*右递归找到了*/
        if (node != null){
            return node;
        }


        /*判断当前节点是否等于*/
        if (this.getNum() == num){
            return this;
        }

        return null;
    }

    /*
     * 删除节点
     * 1.如果删除的节点为叶子节点,则删除该节点
     * 2.如果删除的节点是非叶子节点,则删除该子树
     * */
    public void delete(int num){

        /*当前节点的左节点不为空,并且其左节点等于要删除的num,*/
       if (this.getLeft() != null && this.getLeft().getNum() == num){
            this.setLeft(null);
            return;
       }

        /*当前节点的右节点不为空,并且其右节点等于要删除的num,*/
       if (this.getRight() != null && this.getRight().getNum() == num){
           this.setRight(null);
           return;
       }

       /*上面两个条件都不满足*/

       /*向左递归删除*/
       if (this.getLeft() != null) this.getLeft().delete(num);

       /*向右递归删除*/
       if (this.getRight() != null) this.getRight().delete(num);
    }
}
