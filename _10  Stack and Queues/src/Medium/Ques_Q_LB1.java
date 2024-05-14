package Medium;

import java.util.Queue;
import java.util.Stack;

public class Ques_Q_LB1 {

    //Ques : Interleave the first half of the queue with second half.........                (GFG Ques.)


    //Approach 1 : By using Stack......                                                      T.C. = O(n),  S.C. = O(n)
    /*  # By Using Stack :

        * Following are the steps to solve the problem :

            1. Push the first half elements of the queue to stack.
            2. Enqueue back the stack elements.
            3. Dequeue the first half elements of the queue and enqueue them back.
            4. Again push the first half elements into the stack.
            5. Interleave the elements of queue and stack.

    * */
    // Java program to interleave the first half of the queue with the second half
    class GFG_1 {

        // Function to interleave the queue
        static void interLeaveQueue(Queue<Integer> q)
        {
            // To check the even number of elements
            if (q.size() % 2 != 0)
                System.out.println("Input even number of integers. ");

            // Initialize an empty stack of int type
            Stack<Integer> s = new Stack<>();
            int halfSize = q.size() / 2;

            // Push first half elements into the stack
            // Queue : 16 17 18 19 20,
            // Stack : 15(T) 14 13 12 11
            for (int i = 0; i < halfSize; i++) {
                s.push(q.peek());
                q.poll();
            }

            // enqueue back the stack elements
            // Queue : 16 17 18 19 20 15 14 13 12 11
            while (!s.empty()) {
                q.add(s.peek());
                s.pop();
            }

            // dequeue the first half elements of queue and enqueue them back
            // Queue : 15 14 13 12 11 16 17 18 19 20
            for (int i = 0; i < halfSize; i++) {
                q.add(q.peek());
                q.poll();
            }

            // Again push the first half elements into the stack
            // Queue : 16 17 18 19 20, stack: 11(T) 12 13 14 15
            for (int i = 0; i < halfSize; i++) {
                s.push(q.peek());
                q.poll();
            }

            // interleave the elements of queue and stack
            // Queue : 11 16 12 17 13 18 14 19 15 20
            while (!s.empty()) {
                q.add(s.peek());
                s.pop();
                q.add(q.peek());
                q.poll();
            }
        }

        // Driver code
        public static void main_1(String[] args)
        {
            Queue<Integer> q = new java.util.LinkedList<>();
            q.add(11);
            q.add(12);
            q.add(13);
            q.add(14);
            q.add(15);
            q.add(16);
            q.add(17);
            q.add(18);
            q.add(19);
            q.add(20);
            interLeaveQueue(q);
            int length = q.size();
            for (int i = 0; i < length; i++) {
                System.out.print(q.peek() + " ");
                q.poll();
            }
        }
    }



    //Approach 2 : By using Queue.......
    /*  By Using Queue :

            We can also solve the given problem by using a queue instead of a stack. The idea is to move
            the first half to another queue, and then push values from the temporary queue and original
            queue into the original queue. The original queue will get converted to the interleaved queue
            after the operations.

        * Steps to solve :
            1. Make a temporary queue and push the first half of the original queue into the temp queue.
            2. Till the temp queue is empty
                - Pop the front of the temp queue and push it to the original queue
                - Pop the front of the original queue and push it to the original queue
            3. The original queue is converted to the interleaved queue.

    * */
    //C++ Code......
    /*  C++ program to interleave the first half of the queue with the second half using queue
            #include <bits/stdc++.h>
            using namespace std;

            // Function to interleave the queue
            void interLeaveQueue(queue<int>& q)
            {
                // To check the even number of elements
                if (q.size() % 2 != 0)
                    cout << "Input even number of integers." << endl;

                // Initialize an empty queue of int type
                queue<int> temp;
                int halfSize = q.size() / 2;

                // Push first half elements into the stack
                // queue:16 17 18 19 20, queue: 11 12 13 14 15
                for (int i = 0; i < halfSize; i++) {
                    temp.push(q.front());
                    q.pop();
                }

                // enqueue back the queue elements alternatively
                // queue: 11 16 12 17 13 18 14 19 15 20
                while (!temp.empty()) {
                    q.push(temp.front());
                    q.push(q.front());
                    q.pop();
                    temp.pop();
                }
            }

            // Driver program to test above function
            int main()
            {
                queue<int> q;
                q.push(11);
                q.push(12);
                q.push(13);
                q.push(14);
                q.push(15);
                q.push(16);
                q.push(17);
                q.push(18);
                q.push(19);
                q.push(20);
                interLeaveQueue(q);
                int length = q.size();
                for (int i = 0; i < length; i++) {
                    cout << q.front() << " ";
                    q.pop();
                }
                return 0;
            }

    * */






    public static void main(String[] args) {

        /*Ques : Given a queue of integers of even length, rearrange the elements by interleaving
                 the first half of the queue with the second half of the queue.


            Example : 1
            Input   :  1 2 3 4
            Output  : 1 3 2 4

            Example : 2
            Input   : 11 12 13 14 15 16 17 18 19 20
            Output  : 11 16 12 17 13 18 14 19 15 20

        * */
    }


}
