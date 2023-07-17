package chapter;

import java.io.Serializable;

/**
 * @author yangz
 * @date 2022/4/23 - 10:26
 * 测试序列化
 */
public class MyUser implements Serializable {
    private final int id;
    private final String name;
    private final int age;

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
