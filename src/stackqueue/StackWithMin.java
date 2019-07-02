package stackqueue;

import java.util.Stack;

/**
 * @Classname StackWithMin
 * @Description TODO
 * @Date 2019/7/2 21:43
 * @Created by xww
 */
public class StackWithMin<T extends  Comparable> {

    private Stack<T> stackData = new Stack<>();
    private Stack<T> stackMin = new Stack<>();

    public void push(T data){
        stackData.push(data);
        if(stackMin.isEmpty()){
            stackMin.push(data);
        }else {
            T temp = stackMin.peek();
            if(temp.compareTo(data) > 0){
                stackMin.push(data);
            }else{
                stackMin.push(temp);
            }
        }
    }

    public T pop(){
        if(stackData.isEmpty())
            return null;
        stackMin.pop();
        return stackData.pop();
    }
    public T min(){
        if(stackMin.isEmpty())
            return null;
        return stackMin.peek();
    }


    public static void main(String[] args) {
        StackWithMin<Integer> stack = new StackWithMin<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

}
