package linkedList.circle;

import org.junit.Test;

/**
 * @author yangz
 * @date 2022/4/8 - 10:40
 */
public class Case {
    @Test
    public void t1(){

        CircleSingleLinkedList linkedList=new CircleSingleLinkedList();

        linkedList.show();
        System.out.println("===============");

        linkedList.add(new Boy(1,"tom"));
        linkedList.add(new Boy(2,"rick"));
        linkedList.add(new Boy(3,"summer"));
        linkedList.add(new Boy(4,"john"));
        linkedList.show();
        System.out.println("===============");
    }
}
