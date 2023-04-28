package chapter;

import java.io.Serializable;

/**
 * @author yangz
 * @date 2022/4/23 - 10:26
 */
public class MyUser implements Serializable {
    private int id;
    private String name;
    private int age;

    public MyUser(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
