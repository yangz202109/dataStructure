package hashTable;

import java.util.Stack;

/**
 * @author yangz
 * @date 2022/4/14 - 16:22
 * 雇员链表类
 */
public class EmpLinkedList {
    /*头节点(这里的头节点也存数据)*/
    private Emp head;

    /*添加*/
    public void insert(Emp emp) {
        /*如果添加的是第一个节点*/
        if (head == null) {
            head = emp;
            return;
        }

        /*
        添加的不是第一个,则需要遍历链表找到最后的节点
        head节点不能动,需要使用一个辅助变量temp
        */
        Emp temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;//temp已经指向链表最后
            }
            temp = temp.getNext();//将temp后移
        }
        /*将节点添加到链表最后*/
        temp.setNext(emp);

    }

    /*删除*/
    public void delete(int id) {

        /*判断链表是否为空*/
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        /*头节点就是需要删除的节点
         *  情况1: 这条链表只有头节点数据,就让头结点为null
         *  情况2: 头结点后还有数据,就让头结点后移
         * */
        if (head.getId() == id) {
            head = head.getNext() == null ? null : head.getNext();
            return;
        }

        /*head节点不能动,需要使用一个辅助变量temp*/
        Emp temp = head;
        boolean flag = false; //表示是否找到需要删除的节点

        /*遍历链表*/
        while (true) {

            if (temp.getNext() == null) {
                break;//没有找到,已经到达链表最后
            }

            if (temp.getNext().getId() == id) {
                flag = true;
                break;//找到了,需要删除节点的上一个
            }

            temp = temp.getNext();//将temp后移
        }

        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.println("没有该id的数据");
        }


    }

    /*遍历链表*/
    public void print() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }

        /*head节点不能动,需要使用一个辅助变量temp*/
        Emp temp = head;

        /*遍历链表*/
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();//将temp后移
        }
    }

    /*查找*/
    public Emp find(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        /*head节点不能动,需要使用一个辅助变量temp*/
        Emp temp = head;

        while (true) {
            if (temp.getId() == id) {
                break; //找到了
            }

            /*循环退出条件*/
            if (temp.getNext() == null) {
                temp = null;
                break;
            }
            temp = temp.getNext();//后移
        }
        return temp;

    }

    /*反转:基于栈特性实现*/
    public void reserve1() {
        if (head == null) {
            System.out.println("链表为空无法反转");
            return;
        }
        Stack<Emp> stack = new Stack<>();

        /*head节点不能动,需要使用一个辅助变量temp*/
        Emp temp = head;

        /*遍历链表将数据依次入栈*/
        while (temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }

        temp = stack.pop();
        head = temp;
        while (!stack.isEmpty()) {
            temp.setNext(stack.pop());
            temp = temp.getNext();
        }
        temp.setNext(null);
    }

    /*反转*/
    public void reserve2() {
        /*pre指针：用来指向反转后的节点，初始化为null*/
        Emp pre = null;
        /*当前节点*/
        Emp cur = head;

        /*遍历链表*/
        while (cur != null) {
            /*指向当前节点cur的下一个节点*/
            Emp cur_next = cur.getNext();
            /*反转的关键：当前的节点指向其前一个节点(注意这不是双向链表，没有前驱指针)*/
            cur.setNext(pre);
            /*更新pre*/
            pre = cur;
            /*更新当前节点*/
            cur = cur_next;
        }
        head = pre;
    }

}
