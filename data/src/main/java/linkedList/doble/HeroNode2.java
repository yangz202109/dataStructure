package linkedList.doble;

import lombok.Data;

/**
 * @author yangz
 * @date 2022/3/23 - 17:02
 * 节点对象类
 */
@Data
public class HeroNode2 {

    /*data域,存放信息*/
    private int number;
    private String name;
    private String nickName;

    /* next域,指向下一个节点(对象) */
    private HeroNode2 next;

    /* pre域,指向上一个节点(对象) */
    private HeroNode2 pre;

    public HeroNode2(int number, String name, String nickName) {
        this.number = number;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
