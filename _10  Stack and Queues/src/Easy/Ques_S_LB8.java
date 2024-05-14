package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_S_LB8 {

    //Ques : Stack using two queues.........                                              (GFG Ques.)
    //         (Implement Stack using Queue.......)



    //Approach 1 : By making push operation costly.......
    /*  Method 1 (By making push operation costly) :
            This method ensures that the newly entered element is always at the front of 'q1' so that pop operation
            dequeues from 'q1'. 'q2' is used to put every new element in front of 'q1'.

           * push(s, x) operation's steps are described below:
               - Enqueue x to q2
               - One by one dequeue everything from q1 and enqueue to q2.
               - Swap the names of q1 and q2
           * pop(s) operation's function is described below:
               - Dequeue an item from q1 and return it.

    * */
    /* Java Program to implement a stack using two queue */
    class GfG {
        static class Stack {
            // Two inbuilt queues
            static Queue<Integer> q1 = new LinkedList<Integer>();
            static Queue<Integer> q2 = new LinkedList<Integer>();

            // To maintain current number of elements
            static int curr_size;

            static void push(int x)
            {
                // Push x first in empty q2
                q2.add(x);

                // Push all the remaining elements in q1 to q2.
                while (!q1.isEmpty()) {
                    q2.add(q1.peek());
                    q1.remove();
                }

                // swap the names of two queues
                Queue<Integer> q = q1;
                q1 = q2;
                q2 = q;
            }

            static void pop()
            {

                // if no elements are there in q1
                if (q1.isEmpty())
                    return;
                q1.remove();
            }

            static int top()
            {
                if (q1.isEmpty())
                    return -1;
                return q1.peek();
            }

            static int size()
            {
                return q1.size();
            }
        }

        // driver code
        public static void main_1(String[] args)
        {
            Stack s = new Stack();
            s.push(1);
            s.push(2);
            s.push(3);

            System.out.println("current size: " + s.size());
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());
            s.pop();
            System.out.println(s.top());

            System.out.println("current size: " + s.size());
        }
    }
    /* Complexity Analysis :
         * Time Complexity :
                Push operation :  O(N), As all the elements need to be popped out from the Queue (q1) and
                                        push them back to Queue (q2).
                Pop operation  :  O(1), As we need to remove the front element from the Queue.
         * Auxiliary Space     :  O(N), As we use two queues for the implementation of a stack.
    * */



    //Approach 2 : By making pop operation costly........
    /* Method 2 : (By making pop operation costly) :
            In a push operation, the new element is always enqueued to q1. In pop() operation, if q2 is empty
            then all the elements except the last, are moved to q2. Finally, the last element is dequeued from
            q1 and returned.

            * push(s, x) operation :
                 - Enqueue x to q1 (assuming size of q1 is unlimited).
            * pop(s) operation :
                 - One by one dequeue everything except the last element from q1 and enqueue to q2.
                 - Dequeue the last item of q1, the dequeued item is result, store it.
                 - Swap the names of q1 and q2
                 - Return the item stored in step 2.
    * */
    /* Java Program to implement a stack using two queue */
    static class Stack {

        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        void remove()
        {
            if (q1.isEmpty())
                return;

            // Leave one element in q1 and push others in q2.
            while (q1.size() != 1) {
                q2.add(q1.peek());
                q1.remove();
            }

            // Pop the only left element from q1
            q1.remove();

            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }

        void add(int x)
        {
            q1.add(x);
        }

        int top()
        {
            if (q1.isEmpty())
                return -1;

            while (q1.size() != 1) {
                q2.add(q1.peek());
                q1.remove();
            }

            // last pushed element
            int temp = q1.peek();

            // to empty the auxiliary queue after last operation
            q1.remove();

            // push last element to q2
            q2.add(temp);

            // swap the two queues names
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
            return temp;
        }

        int size()
        {
            return q1.size();
        }

        // Driver code
        public static void main_2(String[] args)
        {
            Stack s = new Stack();
            s.add(1);
            s.add(2);
            s.add(3);
            s.add(4);

            System.out.println("current size: " + s.size());
            System.out.println(s.top());
            s.remove();
            System.out.println(s.top());
            s.remove();
            System.out.println(s.top());
            System.out.println("current size: " + s.size());
        }
    }
    /*  Complexity Analysis :
           * Time Complexity :
               - Push operation :  O(1),  As, on each push operation the new element is added at the end of the Queue.
               - Pop operation  :  O(N),  As, on each pop operation, all the elements are popped out from the Queue (q1)
                                          except the last element and pushed into the Queue (q2).
           * Auxiliary Space    :  O(N)   since 2 queues are used.
    * */




    //Approach 3 : Implement Stack using only 1 queue.......
    /*  Method 3 : (Implement Stack using only 1 queue) :
            In this method, we will be using only one queue and make the queue act as a stack by using following steps:
              1. The idea behind this approach is to make one queue and push the first element in it.
              2. After the first element, we push the next element and then push the first element again and
                 finally pop the first element.
              3. So, according to the FIFO rule of the queue, the second element that was inserted will be at
                 the front and then the first element as it was pushed again later and its first copy was popped out.
              4. So, this acts as a stack, and we do this at every step i.e. from the initial element to the second
                 last element, and the last element will be the one which we are inserting and since we will be pushing the initial elements after pushing the last element, our last element becomes the first element.
    * */
    //C++ Code :
    /*  #include <bits/stdc++.h>
        using namespace std;

        // Stack Class that acts as a queue
        class Stack {

            queue<int> q;

        public:
            void push(int data);
            void pop();
            int top();
            int size();
            bool empty();
        };

        // Push operation
        void Stack::push(int data)
        {
            //  Get previous size of queue
            int s = q.size();

            // Push the current element
            q.push(data);

            // Pop all the previous elements and put them after
            // current element

            for (int i = 0; i < s; i++) {
                // Add the front element again
                q.push(q.front());

                // Delete front element
                q.pop();
            }
        }

        // Removes the top element
        void Stack::pop()
        {
            if (q.empty())
                cout << "No elements\n";
            else
                q.pop();
        }

        // Returns top of stack
        int Stack::top() { return (q.empty()) ? -1 : q.front(); }

        // Returns true if Stack is empty else false
        bool Stack::empty() { return (q.empty()); }

        int Stack::size() { return q.size(); }

        int main()
        {
            Stack st;
            st.push(1);
            st.push(2);
            st.push(3);
            cout << "current size: " << st.size() << "\n";
            cout << st.top() << "\n";
            st.pop();
            cout << st.top() << "\n";
            st.pop();
            cout << st.top() << "\n";
            cout << "current size: " << st.size();
            return 0;
        }
    * */
    /*  Time Complexity :
           - Push operation : O(N)
           - Pop operation  : O(1)
        Auxiliary Space     : O(N) since 1 queue is used.
    * */





    public static void main(String[] args) {

        /*Ques : Implement a Stack using two queues q1 and q2 :


            Example : 1
            Input   : push(2)
                      push(3)
                      pop()
                      push(4)
                      pop()
            Output  : 3 4
            Explanation :  push(2) the stack will be {2}
                           push(3) the stack will be {2 3}
                           pop()   popped element will be 3 the
                                   stack will be {2}
                           push(4) the stack will be {2 4}
                           pop()   popped element will be 4


            Example : 2
            Input   : push(2)
                      pop()
                      pop()
                      push(3)
            Output  : 2 -1


            Your Task  :
            Since this is a function problem, you don't need to take inputs. You are required to complete the two
            methods push() which takes an integer 'x' as input denoting the element to be pushed into the stack and
            pop() which returns the integer popped out from the stack(-1 if the stack is empty).


            Expected Time Complexity  :  O(1) for push() and O(N) for pop() (or vice-versa).
            Expected Auxiliary Space  :  O(1) for both push() and pop().


        * */
    }




}
