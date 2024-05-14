package Easy;

import java.util.EmptyStackException;
import java.util.Stack;

public class Ques_S_LB1 {

    //Ques : Implement Stack form Scratch.........                                       (GFG Ques.)


    //Approach 1 :
    /*  Following example shows how to implement stack by creating user defined push() method for entering elements
        and pop() method for retrieving elements from the stack.
    * */
    public static class MyStack {
        private int maxSize;
        private long[] stackArray;
        private int top;

        public MyStack(int s) {
            maxSize = s;
            stackArray = new long[maxSize];
            top = -1;
        }
        public void push(long j) {
            stackArray[++top] = j;
        }
        public long pop() {
            return stackArray[top--];
        }
        public long peek() {
            return stackArray[top];
        }
        public boolean isEmpty() {
            return (top == -1);
        }
        public boolean isFull() {
            return (top == maxSize - 1);
        }
        public static void main(String[] args) {
            MyStack theStack = new MyStack(10);
            theStack.push(10);
            theStack.push(20);
            theStack.push(30);
            theStack.push(40);
            theStack.push(50);

            while (!theStack.isEmpty()) {
                long value = theStack.pop();
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }



    //Approach 2 :
    /*  The following is another sample to implement stack by creating user defined push() method for
        entering elements and pop() method for retrieving elements from the stack.

    * */
    public class Demo {
        static void showpush(Stack stack1, int a) {
            stack1.push(new Integer(a));
            System.out.println("push(" + a + ")");
            System.out.println("stack: " + stack1);
        }
        static void showpop(Stack stack1) {
            Integer a = (Integer) stack1.pop();
            System.out.println(a);
            System.out.println("stack: " + stack1);
        }
        public static void main(String args[]) {
            Stack stack1 = new Stack();
            System.out.println("stack: " + stack1);
            showpush(stack1, 40);
            showpush(stack1, 50);
            showpush(stack1, 60);
            showpop(stack1);
            showpop(stack1);
            showpop(stack1);
            try {
                showpop(stack1);
            } catch (EmptyStackException e) {
                System.out.println("it Is Empty Stack");
            }
        }
    }





    public static void main(String[] args) {

        /*Ques :  Stack implementation from Scratch......
        * */
    }
}
