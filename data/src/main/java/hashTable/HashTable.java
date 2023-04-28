package hashTable;
import lombok.Data;

/**
 * @author yangz
 * @date 2022/4/14 - 17:10
 * 哈希表类
 */
@Data
public class HashTable {
    private int maxSize; //哈希表大小
    private EmpLinkedList[] linkedLists;

    public HashTable(int maxSize) {
        this.maxSize = maxSize;
        /*初始化链表数组大小*/
        linkedLists=new EmpLinkedList[maxSize];
        /*必须初始化每一条链表*/
        for (int i = 0; i < maxSize; i++) {
            linkedLists[i]=new EmpLinkedList();
        }
    }

    /*添加雇员*/
    public void add(Emp emp){
        /*根据雇员id,决定添加到哪一条链表中*/
        int empLinkedListNum=hashFun(emp.getId());
        /*添加到对应的链表中*/
        linkedLists[empLinkedListNum].insert(emp);
    }

    /*删除雇员*/
    public void delete(int id){
        int empLinkedListNum=hashFun(id);
        /*在对应的链表中删除*/
        linkedLists[empLinkedListNum].delete(id);
    }

    /*遍历哈希表*/
    public void showHash(){
        for (int i = 0; i < maxSize; i++) {
            System.out.println("当前链表是："+(i+1));
            linkedLists[i].print();
        }
    }

    public Emp find(int id){
        int empLinkedListNum=hashFun(id);
        /*在对应的链表中查找*/
       return linkedLists[empLinkedListNum].find(id);
    }

    /*散列函数
    * ：使用取模法
    * */
    public int hashFun(int id){
        return (maxSize-1) % id;
    }

}
