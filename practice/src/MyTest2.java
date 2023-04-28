import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yangz
 * @date 2022/12/1 - 16:15
 */
public class MyTest2 {
    public static void main(String[] args) throws IllegalAccessException, UnknownHostException {
        /*Student student = new Student(12345L, "小明", "176856998");
        Check.validate(student);*/

        InetAddress address1 = InetAddress.getByName("www.baidu.com");
        System.out.println(address1);
        System.out.println(address1.getHostName());
        System.out.println(address1.getHostAddress());

        InetAddress address2 = InetAddress.getLocalHost();
        System.out.println(address2);
    }
}
