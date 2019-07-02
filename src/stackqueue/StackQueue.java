package stackqueue;

import java.util.Stack;

/**
 * @Classname StackQueue
 * @Description 用两个栈，实现队列的从队尾插入元素offer()
 *                  和从队头抛出元素poll()
 * @Date 2019/7/2 21:26
 * @Created by xww
 */
public class StackQueue<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void offer(T data){
        stack1.push(data);
    }

    public T poll(){
        if(!stack2.isEmpty()){
           return stack2.pop();
        }else if(!stack1.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return null;
    }


        public static void main(String[] args){
            StackQueue<Integer> myQueue = new StackQueue<>();
            System.out.println(myQueue.poll());
            myQueue.offer(1);
            myQueue.offer(2);
            myQueue.offer(3);
            System.out.println(myQueue.poll());
            System.out.println(myQueue.poll());
            myQueue.offer(4);
            System.out.println(myQueue.poll());
            System.out.println(myQueue.poll());
            System.out.println(myQueue.poll());
        }

}
