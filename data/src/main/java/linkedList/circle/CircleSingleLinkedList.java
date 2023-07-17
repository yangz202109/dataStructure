package linkedList.circle;

/**
 * @author yangz
 * @date 2022/4/8 - 9:39
 * 单向环形链表：链表的最后一个节点指向头节点,形成一个循环.
 */
public class CircleSingleLinkedList {
    /*创建一个first节点*/
    private Boy first;

    /*添加*/
    public void add(Boy boy) {
        Boy temp = first; //辅助指针

        /*
         * first为空,该链表为空
         * 添加的节点就为第一个
         * */
        if (first == null) {
            first = boy;
            boy.setNext(boy);//自己指向自己,构成环形
            return;
        }

        //temp已经指向链表最后节点,退出循环
        while (temp.getNext() != first) {
            temp = temp.getNext(); //向后移动
        }
        temp.setNext(boy);
        boy.setNext(first);
    }

    /*遍历*/
    public void show() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true) {
            System.out.println(cur.getNumber() + " " + cur.getName());
            if (cur.getNext() == first) {
                break; //链表已经到最后,填充销毁
            }
            cur = cur.getNext();//向后移动
        }
    }

}
