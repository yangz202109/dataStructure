import org.junit.Test;
import java.io.*;
import java.nio.file.Files;

import chapter.MyUser;

/**
 * @author yangz
 * @date 2022/4/19 - 11:32
 */
public class MyTest {
    //传统IO递归删除
    @Test
    public void testDeleteFileDir7() {
        File file = new File("D:\\util\\temp");
        deleteDirectoryLegacyIO(file);

    }

    public void deleteDirectoryLegacyIO(File file) {

        File[] list = file.listFiles();  //无法做到list多层文件夹数据
        if (list != null) {
            for (File temp : list) {     //先去递归删除子文件夹及子文件
                deleteDirectoryLegacyIO(temp);   //注意这里是递归调用
            }
        }

        if (file.delete()) {     //再删除自己本身的文件夹
            System.out.printf("删除成功 : %s%n", file);
        } else {
            System.err.printf("删除失败 : %s%n", file);
        }
    }

    @Test
    public void t3() {
        File file = new File("E:\\tmp\\tt.txt");
        MyUser user = new MyUser(1, "aaa", 22);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            oos.writeObject(user);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void t4() throws IOException, ClassNotFoundException {
        File file = new File("E:\\tmp\\tt.txt");

        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file.toPath()));

        MyUser user = (MyUser) ois.readObject();
        ois.close();
        System.out.println(user);
    }
}
