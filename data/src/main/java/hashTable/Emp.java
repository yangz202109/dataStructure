package hashTable;

import lombok.Data;

/**
 * @author yangz
 * @date 2022/4/14 - 16:20
 * 雇员类
 */
@Data
public class Emp {
    /*数据域*/
    private int id;
    private String name;
    private int age;

    /*next域 默认为null*/
    private Emp next;

    public Emp(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
