package linkedlist;

import structure.ListNode;

/**
 * @Classname DeleteNodeInList
 * @Description 将欲删节点的后一个节点的值拷贝到欲删节点之上，删除欲删节点的后一个节点，
 * 从而可以在o(1)时间内完成删除。（对于尾节点，删除仍然需要o(n),
 * 其他点为o(1)，因此平均时间复杂度为o(1)，满足要求）
 * @Date 2019/6/25 21:50
 * @Created by xww
 */
public class DeleteNodeInList {

    public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node){
        // if the node is the head
        if (node == head) {
            return head.next;
        }else if(node.next != null){
            node.val = node.next.val;
            node.next = node.next.next;
            return head;
        }else{
            ListNode<Integer> temp = head;
            while(temp.next != node){
                temp= temp.next;
            }
            temp.next = null;
            return head;
        }
    }


    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode(head,node3);
        System.out.println(head);
        head = deleteNode(head,head);
        System.out.println(head);
    }
}
