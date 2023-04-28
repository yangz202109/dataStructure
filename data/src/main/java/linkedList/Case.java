package linkedList;

import linkedList.doble.DoubleLinkedList;
import linkedList.doble.HeroNode2;
import linkedList.single.HeroNode;
import linkedList.single.SingleLinkedList;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangz
 * @date 2022/3/24 - 15:17
 * 案例测试
 */
public class Case {

    @Test
    public void t1(){
        SingleLinkedList list=new SingleLinkedList();

        list.showSingleLinkList();
        System.out.println("================================");

        list.addByOrder(new HeroNode(1,"宋江","及时雨"));
        list.addByOrder(new HeroNode(2,"吴用","智多星"));
        list.addByOrder(new HeroNode(6,"公孙胜","入云龙"));

        list.showSingleLinkList();

        System.out.println("================================");
        list.addByOrder(new HeroNode(4,"卢俊义","玉麒麟"));
        list.addByOrder(new HeroNode(3,"林冲","豹子头"));
        list.showSingleLinkList();

        System.out.println("================================");
        list.addByOrder(new HeroNode(4,"杨志","青面兽"));

       /* System.out.println("================================");
        list.update(new HeroNode(7,"武松","武二郎"));
        list.showSingleLinkList();*/

        System.out.println("================================");
        list.delete(1);
        list.delete(2);
        list.delete(3);

        System.out.println("节点个数："+list.count());
        list.showSingleLinkList();
    }

    @Test
    public void t2(){
        String str="39029672213807104.52477906223431680.52477972648624128.";
        String[] strings = str.split("\\.");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void t3(){
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.show();
        System.out.println("===============");

        doubleLinkedList.add(new HeroNode2(1,"tom","tt"));
        doubleLinkedList.add(new HeroNode2(2,"marry","mm"));
        doubleLinkedList.add(new HeroNode2(3,"rick","rr"));
        doubleLinkedList.show();
        System.out.println("===============");

        doubleLinkedList.delete(2);
        doubleLinkedList.show();
        System.out.println("===============");

        doubleLinkedList.update(new HeroNode2(3,"summer","ss") );
        doubleLinkedList.show();
        System.out.println("===============");

        doubleLinkedList.addByOrder(new HeroNode2(2,"long","ll"));
        doubleLinkedList.show();
        System.out.println("===============");
    }

    @Test
    public void t4(){
        String a="第100批0次";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(a);
        System.out.println( m.replaceAll("").trim());
    }
}
