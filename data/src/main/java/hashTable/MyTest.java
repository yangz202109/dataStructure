package hashTable;

import org.junit.Test;

/**
 * @author yangz
 * @date 2022/4/14 - 16:59
 */
public class MyTest {
    @Test
    public void t1() {
        EmpLinkedList linkedList = new EmpLinkedList();
        linkedList.print();
        linkedList.insert(new Emp(1, "tome", 5));
        linkedList.insert(new Emp(2, "rick", 34));
        linkedList.insert(new Emp(3, "summer", 55));
        linkedList.insert(new Emp(4, "lin", 21));

        linkedList.print();

        System.out.println("============");

        linkedList.delete(2);
        linkedList.delete(3);
        linkedList.print();
    }

    @Test
    public void t2() {
        HashTable hashTable = new HashTable(4);
        hashTable.add(new Emp(1, "tome", 7));
        hashTable.add(new Emp(2, "rick", 15));
        hashTable.add(new Emp(3, "summer", 21));
        hashTable.add(new Emp(4, "lin", 33));

        hashTable.showHash();
        System.out.println("================");
/*        Emp emp = hashTable.find(10);
        System.out.println(emp);*/

        System.out.println("================");
        hashTable.delete(1);
        hashTable.showHash();

    }

    @Test
    public void t3() {
        EmpLinkedList linkedList = new EmpLinkedList();
        linkedList.insert(new Emp(1, "tome", 5));
        linkedList.insert(new Emp(2, "rick", 34));
        linkedList.insert(new Emp(3, "summer", 55));
        linkedList.insert(new Emp(4, "lin", 21));
        linkedList.print();

        System.out.println("=======反转单向链表=====");
        linkedList.reserve2();
        linkedList.print();


    }
}
