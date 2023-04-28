package linkedList.circle;

import lombok.Data;

/**
 * @author yangz
 * @date 2022/4/8 - 9:33
 */
@Data
public class Boy {
    private int number;
    private  String name;

    /*指向下一个节点,默认为空*/
    private Boy  next;

    public Boy(int number, String name) {
        this.number = number;
        this.name = name;
    }

}
