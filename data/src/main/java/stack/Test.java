package stack;

/**
 * @author yangz
 * @date 2022/4/8 - 16:00
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.show();
        System.out.println("==============");

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //stack.push(6);
        stack.show();

        System.out.println(" ");
        System.out.println(stack.pop());
        stack.show();
    }
}
