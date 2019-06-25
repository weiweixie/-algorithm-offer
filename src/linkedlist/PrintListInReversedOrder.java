package linkedlist;


import structure.ListNode;

import java.util.Stack;

/**
 * @Classname PrintListInReversedOrder
 * @Description   从尾到头打印链表
 * @Date 2019/6/25 21:34
 * @Created by xww
 */
public class PrintListInReversedOrder {

    /**
     *   非递归版本
     * @param node
     */
    public static void printReversingIteratively(ListNode<Integer> node){
        Stack<Integer> stack = new Stack<>();
        for(ListNode<Integer> temp = node ;temp != null ; temp = temp.next){
            stack.add(temp.val);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args){
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println();
        printReversingIteratively(head);
    }
}
