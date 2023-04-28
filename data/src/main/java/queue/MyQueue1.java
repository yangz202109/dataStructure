package queue;


/**
 * @author yangz
 * @date 2022/3/23 - 11:04
 * 使用数组模拟队列
 * 问题：目前数组只能使用一次就不能用了,没有达到复用的效果
 */
public class MyQueue1 {
    private int maxSize; //数组最大容量
    private int front;  //队列头(下标)
    private int rear;  //队列尾(下标)
    private int[] array;  //数组

    //创建队列的构造器
    public MyQueue1(int maxSize) {
        this.maxSize = maxSize;
        array=new int[maxSize];
        /*
        * 初始化队列中没有参数,让队头和队尾指向非法位置
        * */
        front=-1;
        rear=-1;
    }

    //判断队列是否满
    public  boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){ //判断队列是否已满
            System.out.println("队列已满,n="+n+" 添加失败");
        }else {
            rear++; //让队尾后移
            array[rear]=n;
        }
    }

    //获取队列的数据(出队列)
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }else {
         front++; //让队头后移
         return array[front];
        }
    }

   //查看队列所有数据
   public  void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            for (int j : array) {
                System.out.print(j + " ");
            }
        }
   }
}
