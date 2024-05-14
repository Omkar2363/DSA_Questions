package Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ques_Q_1 {

    //Ques : Queue Reversal.........                                                   (GFG Ques.)
    //            (Reversing a Queue)


    //Approach 1 : By using Stack......                                                T.C. = O(n),  S.C. = O(n)
    /*  Reversing a Queue using stack :
            For reversing the queue one approach could be to store the elements of the queue in a
            temporary data structure in a manner such that if we re-insert the elements in the queue
            they would get inserted in reverse order. So now our task is to choose such a data structure
            that can serve the purpose. According to the approach, the data structure should have
            the property of ‘LIFO’ as the last element to be inserted in the data structure should actually be
            the first element of the reversed queue.

        Follow the below steps to implement the idea:

          * Pop the elements from the queue and insert into the stack now topmost element of
            the stack is the last element of the queue.
          * Pop the elements of the stack to insert back into the queue the last element is the
            first one to be inserted into the queue.

    * */
    // Java program to reverse a queue
    public class Queue_reverse {

        static Queue<Integer> queue;

        // Utility function to print the queue
        static void Print()
        {
            while (!queue.isEmpty()) {
                System.out.print(queue.peek() + ", ");
                queue.remove();
            }
        }

        // Function to reverse the queue
        static void reversequeue()
        {
            Stack<Integer> stack = new Stack<>();
            while (!queue.isEmpty()) {
                stack.add(queue.peek());
                queue.remove();
            }
            while (!stack.isEmpty()) {
                queue.add(stack.peek());
                stack.pop();
            }
        }

        // Driver code
        public static void main_1(String args[])
        {
            queue = new LinkedList<Integer>();
            queue.add(10);
            queue.add(20);
            queue.add(30);
            queue.add(40);
            queue.add(50);
            queue.add(60);
            queue.add(70);
            queue.add(80);
            queue.add(90);
            queue.add(100);

            reversequeue();
            Print();
        }
    }



    //Approach 2 : By using Recursion........                                         T.C. = O(n),  S.C. = O(n)
    /*  Reversing a Queue using recursion:
            Instead of explicitly using stack goal can be achieved using recursion
            (recursion at backend will itself maintain stack).

        Follow the below steps to implement the idea :
            * Recursively perform the following steps :
                - If the queue size is 0 return.
                - Else pop and store the front element and recur for remaining queue.
                - push the current element in the queue.

    * */
    //C++ Code :
    /* **** CPP program to reverse a Queue ******
            #include <bits/stdc++.h>
            using namespace std;

            // Utility function to print the queue
            void Print(queue<int>& Queue)
            {
                while (!Queue.empty()) {
                    cout << Queue.front() << " ";
                    Queue.pop();
                }
            }

            // Function to reverse the queue
            void reverseQueue(queue<int>& q)
            {
                // base case
                if (q.size() == 0)
                    return;
                // storing front(first element) of queue
                int fr = q.front();

                // removing front
                q.pop();

                // asking recursion to reverse the
                // leftover queue
                reverseQueue(q);

                // placing first element
                // at its correct position
                q.push(fr);
            }

            // Driver code
            int main()
            {
                queue<int> Queue;
                Queue.push(10);
                Queue.push(20);
                Queue.push(30);
                Queue.push(40);
                Queue.push(50);
                Queue.push(60);
                Queue.push(70);
                Queue.push(80);
                Queue.push(90);
                Queue.push(100);

                reverseQueue(Queue);
                Print(Queue);
            }
    * */
    //Write Java code....




    public static void main(String[] args) {

        /*Ques : Given a Queue Q containing N elements. The task is to reverse the Queue.
                 Your task is to complete the function rev(), that reverses the N elements of the queue.


            Example : 1
            Input   : 6
                      4 3 1 10 2 6
            Output  : 6 2 10 1 3 4
            Explanation : After reversing the given elements of the queue , the resultant
                          queue will be 6 2 10 1 3 4.


            Example : 2
            Input   : 4
                      4 3 2 1
            Output  : 1 2 3 4
            Explanation : After reversing the given elements of the queue , the resultant
                          queue will be 1 2 3 4.


            Your Task :
            You only need to complete the function rev that takes a queue as parameter and returns the reversed queue.
            The printing is done automatically by the driver code.

            Expected Time Complexity   : O(n)
            Expected Auxilliary Space  : O(n)


        *
        * */
    }


}
