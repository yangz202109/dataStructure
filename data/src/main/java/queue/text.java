package queue;

import org.junit.Test;

import java.util.Queue;

/**
 * @author yangz
 * @date 2022/3/23 - 11:31
 */
public class text {
    public static void main(String[] args) {
        MyQueue2 queue1 = new MyQueue2(6);
        queue1.addQueue(9);
        queue1.addQueue(3);
        queue1.addQueue(2);
        queue1.addQueue(1);
        queue1.addQueue(45);
        queue1.getQueue();
        queue1.addQueue(22);
        queue1.getQueue();

       // System.out.println("\n============");
        queue1.addQueue(8);
        queue1.showQueue();

    }
    @Test
    public void t(){
        int i= (0 + 5)/2;
        System.out.println(i);
    }
}
