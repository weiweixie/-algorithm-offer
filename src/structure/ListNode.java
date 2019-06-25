package structure;

/**
 *   create by xww 
 *   2019/06/25
 * @param <T>
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode(T val){
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "structure.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
