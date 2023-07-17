package queue;

/**
 * @author yangz
 * @date 2022/3/23 - 14:03
 * 使用数组模拟环形队列
 *   :当队头或队尾指向的下标到达数组最大时,可以移动到数组前面
 *   队头向后移动(取出数据),数组前面的数据就已经没有用了,可以让队尾移动到数组前面(添加数据到队列),重复使用该数组
 *   这就构成一个环形队列
 */
public class MyQueue2 {

    private final int maxSize; //数组最大容量
    private int front;  //队列头(下标)
    private int rear;  //队列尾(下标)
    private final int[] array;  //数组

    //创建队列的构造器
    public MyQueue2(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) { //判断队列是否已满
            System.out.println("队列已满,n=" + n + " 添加失败");
        } else {
            array[rear] = n;
            rear = (rear + 1) % maxSize; //让队尾后移,必须考虑取模(移动到前面)
        }
    }

    //获取队列的数据(出队列)
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            int temp = array[front];
            front = (front + 1) % maxSize;
            return temp;
        }
    }

    //查看队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        } else {
            for (int i = front; i < front + size(); i++) {
                System.out.print(array[i % maxSize] + " ");
            }
        }

    }

    //求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

}
