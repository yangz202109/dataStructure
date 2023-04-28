package recursion;

/**
 * @author yangz
 * @date 2022/4/9 - 10:09
 */
public class Practice {
    public static void main(String[] args) {
        Practice practice = new Practice();
        practice.t(5);


    }

    public void t(int n){
        if (n > 2){
            t(n-1);
        }
        System.out.println(n);
    }
}
