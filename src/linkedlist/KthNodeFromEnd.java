package linkedlist;

import structure.ListNode;

/**
 * @Classname KthNodeFromEnd
 * @Description 如果先求链表的长度，计算后再从头遍历，
 * 虽然时间复杂度是o(n),但需要两遍扫描。
 * 更好的方式是使用两个距离为k的指针向右移动，这种方式只需扫描一遍
 * @Date 2019/6/26 21:39
 * @Created by xww
 */
public class KthNodeFromEnd {

    public  static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k){

        // verify before
        if(head == null || k< 0){
            return null;
        }

        // 快慢指针
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        // 初始化快慢指针
        for(int i = 0;i<k;i++){
            if (fast.next != null || i==k-1){
                fast = fast.next;
            }else{
                return null;
            }
        }

        // 遍历 the linkedList
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(findKthToTail(head,1).val);
        System.out.println(findKthToTail(head,2).val);
        System.out.println(findKthToTail(head,3).val);
        System.out.println(findKthToTail(head,4));
    }
}
