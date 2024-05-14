package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_S_3 {

    //Ques :  Implement Stack using Queues..........                                      (Leet code Ques no. - 224)

    //Approach 1 : By using Queue.....
    class MyStack {
        private Queue<Integer> queue = new LinkedList<>();

        public void push(int x) {
            queue.add(x);

            for(int i=1; i<queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
    /*
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */



    //Approach 2 : By using LinkedList........
    class MyStack_2 {

        final LinkedList<Integer> nums;

        public MyStack_2() {
            nums = new LinkedList<>();
        }

        public void push(int x) {
            nums.push(x);
        }

        public int pop() {
            return nums.pop();
        }

        public int top() {
            return nums.getFirst();
        }

        public boolean empty() {
            return nums.isEmpty();
        }
    }
    /*
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */



    //Approach 3 : By using Two Queues..........
    class MyStack_3 {
        public static Queue<Integer> q1;
        public static Queue<Integer> q2;

        public MyStack_3() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            // Swapping the two queues to keep the last inserted number on q2 front
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        public int pop() {
            return q1.remove();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            if (q1.isEmpty()) {
                return true;
            }
            return false;
        }
    }
    /*
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */





    public static void main(String[] args) {

        /*Ques : Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack
                 should support all the functions of a normal stack (push, top, pop, and empty).

            Implement the MyStack class :
              * void push(int x) Pushes element x to the top of the stack.
              * int pop() Removes the element on the top of the stack and returns it.
              * int top() Returns the element on the top of the stack.
              * boolean empty() Returns true if the stack is empty, false otherwise.


            Notes :
              * You must use only standard operations of a queue, which means that only push to back, peek/pop from front,
                size and is empty operations are valid.
              * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list
                or deque (double-ended queue) as long as you use only a queue's standard operations.


            Example : 1
            Input   : ["MyStack", "push", "push", "top", "pop", "empty"]
                      [[], [1], [2], [], [], []]
            Output  : [null, null, null, 2, 2, false]
            Explanation :  MyStack myStack = new MyStack();
                              myStack.push(1);
                              myStack.push(2);
                              myStack.top();                       // return 2
                              myStack.pop();                       // return 2
                              myStack.empty();                     // return False

        *
        * */
    }


}
