package stack;

/**
 * @author yangz
 * @date 2022/4/8 - 13:59
 * 使用数组模拟栈
 */
public class ArrayStack {

    private  int maxSize; //数组大小
    private  int[] stack; //数组(模拟栈)
    private  int top; //栈顶下标

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new  int[maxSize];
        this.top = -1;  //初始化栈没有数据,栈顶指向非法
    }

    /*判断栈是否满*/
    public boolean isFull(){
        return top == maxSize - 1;
    }

    /*判断栈是否为空*/
    public boolean isEmpty(){
      return top == -1;
    }

    /*入栈*/
    public void  push(int value){
        if (isFull()){
            System.out.println("栈已满,无法在添加");
            return;
        }
        top++; //移动栈顶指针
        stack[top]=value;
    }

    /*出栈*/
    public int pop(){
        if (isEmpty()){
           throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /*显示栈数据*/
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
        }
        for (int i =top; i >=0; i--) {
            System.out.print(stack[i] + " ");
        }
    }

}
