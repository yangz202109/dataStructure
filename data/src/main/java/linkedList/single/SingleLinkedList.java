package linkedList.single;

/**
 * @author yangz
 * @date 2022/3/23 - 17:02
 * 带头节点的单链表
 */
public class SingleLinkedList {
    /* 1.创建一个头节点,并不会存放数据*/
    private HeroNode head = new HeroNode(0, "", "");

    public SingleLinkedList() {
    }

    /**
     * 添加节点 不考虑编号顺序
     * */
    public void add(HeroNode heroNode) {
        //head节点不能动,需要使用一个辅助变量temp
        HeroNode temp = head;
        //遍历链表,找到最后
        while (true) {
            if (temp.getNext() == null) {
                break; //已经到了链表的最后,退出循环
            }
            temp = temp.getNext(); //没有到了链表的最后,让temp指向下一个
        }

        //将节点添加到链表最后
        temp.setNext(heroNode);
    }

    /**
     * 添加节点 根据编号添加到指定位置
     * */
    public void addByOrder(HeroNode heroNode) {
       /* head节点不能动,需要使用一个辅助变量temp */
        HeroNode temp = head;

        boolean flag = false; //标识添加的编号是否已经存在,默认为false

        while (true) {
            /*
             找到添加节点的位置(添加到链表的)
             退出循环条件：在链表最后或找到找到位置
            */
            if (temp.getNext() == null) {
                break; //该节点没有没有下一个(已经到了链表的最后),退出循环
            }
            if (temp.getNext().getNumber() > heroNode.getNumber()) {
                break; //找到了指定位置
            } else if (temp.getNext().getNumber() == heroNode.getNumber()) {
                flag = true; //添加的编号已存在
            }
            //temp后移
            temp = temp.getNext();
        }

        //将节点添加到指定位置
        if (flag) {
            System.out.println(heroNode.getNumber() + " 节点编号已存在,无法添加");
        } else {
            /* 让新节点插入链表 */
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    /**
     * 修改节点信息,根据编号
     * 思路:遍历链表找到修改的节点,再进行修改
     * */
    public void update(HeroNode newHerNode) {

        //先判断是否为空
        if (head.getNext() == null) {
            System.out.println("该链表为空");
            return; //退出方法
        }

        //创建一个辅助节点,让其指向要修改的节点
        HeroNode temp = head.getNext();
        boolean flag = false; //表示是否找到需要修改的节点编号

        //遍历该链表
        while (true) {
            if (temp == null) {
                break; //没有找到,已经到达链表最后
            }
            if (temp.getNumber() == newHerNode.getNumber()) {
                flag = true;
                break; //找到该节点
            }
            //后移temp
            temp = temp.getNext();
        }

        if (flag) { //找到,修改节点信息
            temp.setName(newHerNode.getName());
            temp.setNickName(newHerNode.getNickName());
        } else {
            System.out.println("修改失败,没有该编号的节点");
        }
    }

    /**
     * 删除节点
     * 思路:遍历链表找到删除的节点,再进行删除
     * */
    public void delete(int number) {
        //先判断是否为空
        if (head.getNext() == null) {
            System.out.println("该链表为空");
            return; //退出方法
        }

        //创建一个辅助节点,让其指向要删除节点的上一个
        HeroNode temp = head;
        boolean flag = false; //表示是否找到需要删除的节点

        //遍历该链表
        while (true) {
            if (temp.getNext() == null) {
                break; //没有找到,已经到达链表最后
            }
            if (temp.getNext().getNumber() == number) {
                flag = true;
                break; //找到该节点
            }
            //后移temp
            temp = temp.getNext();
        }
        if (flag) { //找到,删除节点
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("删除失败,没有该编号的节点");
        }

    }

    /**
     * 打印整个单链表(遍历)
     * */
    public void showSingleLinkList() {
        //head节点不能动,需要使用一个辅助变量temp
        HeroNode temp = head.getNext();

        if (temp == null) {
            System.out.println("链表为空");
            return;
        }

        //遍历该链表
        while (true) {
            if (temp == null) {
                // System.out.println("链表已经在最后");
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //temp向后移动
            temp = temp.getNext();
        }

    }

    /**
     * 返回节点个数(不包含头节点)
     * */
    public int count() {
        HeroNode temp = head.getNext();
        int num = 0; //节点个数

        while (true) {
            if (temp == null) {
                break;
            }
            num++;
            temp = temp.getNext();
        }

        return num;
    }
}
