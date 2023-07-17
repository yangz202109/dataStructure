package linkedList.doble;

/**
 * @author yangz
 * @date 2022/3/29 - 14:01
 * 双向环形链表：链表的每个节点不仅有指向下一个节点的引用,还有指向上一个节点的引用,并且最后一个节点指向头节点,形成一个循环.
 */
public class DoubleLinkedList {
    /*1.创建一个头节点,并不会存放数据*/
    private final HeroNode2 head = new HeroNode2(0, "", "");

    public DoubleLinkedList() {
    }

    /**
     * 打印链表
     */
    public void show() {
        //head节点不能动,需要使用一个辅助变量temp
        HeroNode2 temp = head.getNext();

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
     * 添加节点 不考虑编号
     */
    public void add(HeroNode2 heroNode) {
        //head节点不能动,需要使用一个辅助变量temp
        HeroNode2 temp = head;

        //遍历链表,找到最后
        while (true) {
            if (temp.getNext() == null) {
                break; //已经到了链表的最后,退出循环
            }
            temp = temp.getNext(); //没有到了链表的最后,让temp指向下一个
        }

       /*
       将节点添加到链表最后
       让最后的节点指向新添加的节点
       */
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    /**
     * 添加节点 考虑编号
     */
    public void addByOrder(HeroNode2 heroNode) {
        /* head节点不能动,需要使用一个辅助变量temp */
        HeroNode2 temp = head;

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
                break;
            }
            //temp后移
            temp = temp.getNext();
        }

        //将节点添加到指定位置
        if (flag) {
            System.out.println(heroNode.getNumber() + " 节点编号已存在,无法添加");
        } else {
            /*
             * 让新节点插入链表
             * */
            heroNode.setPre(temp);
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    /**
     * 更新节点
     */
    public void update(HeroNode2 newHerNode) {

        //先判断是否为空
        if (head.getNext() == null) {
            System.out.println("该链表为空");
            return; //退出方法
        }

        //创建一个辅助节点,让其指向要修改的节点
        HeroNode2 temp = head.getNext();
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
     **/
    public void delete(int number) {
        //先判断是否为空
        if (head.getNext() == null) {
            System.out.println("该链表为空");
            return; //退出方法
        }

        //创建一个辅助节点,让其指向要删除的节点
        HeroNode2 temp = head.getNext();
        boolean flag = false; //表示是否找到需要删除的节点

        //遍历该链表
        while (true) {
            if (temp == null) {
                break; //没有找到,已经到达链表最后
            }
            if (temp.getNumber() == number) {
                flag = true;
                break; //找到该节点
            }
            //后移temp
            temp = temp.getNext();
        }
        if (flag) { //找到,删除节点
            temp.getPre().setNext(temp.getNext());
            /*
             * 有问题
             * 当要删除的节点是最后一个,就不需要执行(让下一个指向上一个),否则出现空指针异常
             * */
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        } else {
            System.out.println("删除失败,没有该编号的节点");
        }
    }
}
