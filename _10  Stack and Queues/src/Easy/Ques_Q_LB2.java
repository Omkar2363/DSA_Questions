package Easy;

import java.util.Stack;

public class Ques_Q_LB2 {

    //Ques :  Queue using two Stacks......                                          (GFG Ques.)


    //Approach 1 :
    /*  Method 1 : (By making enQueue operation costly) :

            This method makes sure that oldest entered element is always at the top of stack 1, so that
            deQueue operation just pops from stack1. To put the element at top of stack1, stack2 is used.

            * enQueue(q, x) :
               - While stack1 is not empty, push everything from stack1 to stack2.
               - Push x to stack1 (assuming size of stacks is unlimited).
               - Push everything back to stack1.

                 Here time complexity will be O(n)

            * deQueue(q) :
               - If stack1 is empty then error
               - Pop an item from stack1 and return it

                 Here time complexity will be O(1)


        Complexity Analysis :
            * Time Complexity :
                   Push operation : O(N)   In the worst case we have empty whole of stack 1 into stack 2.
                   Pop operation  : O(1)   Same as pop operation in stack.
            * Auxiliary Space     : O(N)   Use of stack for storing values.

    * */
    // Java program to implement Queue using two stacks with costly enQueue()
    class GFG {
        static class Queue
        {
            static Stack<Integer> s1 = new Stack<Integer>();
            static Stack<Integer> s2 = new Stack<Integer>();

            static void enQueue(int x)
            {
                // Move all elements from s1 to s2
                while (!s1.isEmpty())
                {
                    s2.push(s1.pop());
                    //s1.pop();
                }

                // Push item into s1
                s1.push(x);

                // Push everything back to s1
                while (!s2.isEmpty())
                {
                    s1.push(s2.pop());
                    //s2.pop();
                }
            }

            // Dequeue an item from the queue
            static int deQueue()
            {
                // if first stack is empty
                if (s1.isEmpty())
                {
                    System.out.println("Q is Empty");
                    System.exit(0);
                }

                // Return top of s1
                int x = s1.peek();
                s1.pop();
                return x;
            }
        };

        // Driver code
        public static void main_1(String[] args)
        {
            Queue q = new Queue();
            q.enQueue(1);
            q.enQueue(2);
            q.enQueue(3);

            System.out.println(q.deQueue());
            System.out.println(q.deQueue());
            System.out.println(q.deQueue());
        }
    }




    //Approach 2 :
    /*  Method 2 : (By making deQueue operation costly) :

            In this method, in en-queue operation, the new element is entered at the top of stack1.
            In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and
            finally top of stack2 is returned.

        * enQueue(q,  x)
          1) Push x to stack1 (assuming size of stacks is unlimited).

             Here time complexity will be O(1)

        * deQueue(q)
          1) If both stacks are empty then error.
          2) If stack2 is empty
               While stack1 is not empty, push everything from stack1 to stack2.
          3) Pop the element from stack2 and return it.

             Here time complexity will be O(n)

        Method 2 is definitely better than method 1.

        Method 1 moves all the elements twice in enQueue operation, while method 2 (in deQueue operation)
        moves the elements once and moves elements only if stack2 empty. So, the amortized complexity of
        the dequeue operation becomes \Theta (1)


    * */
    /* Java Program to implement a queue using two stacks */
    // Note that Stack class is used for Stack implementation
    public class GFG_2 {
        /* class of queue having two stacks */
        static class Queue {
            Stack<Integer> stack1;
            Stack<Integer> stack2;
        }

        /* Function to push an item to stack*/
        static void push(Stack<Integer> top_ref, int new_data)
        {
            // Push the data onto the stack
            top_ref.push(new_data);
        }

        /* Function to pop an item from stack*/
        static int pop(Stack<Integer> top_ref)
        {
            /* If stack is empty then error */
            if (top_ref.isEmpty()) {
                System.out.println("Stack Underflow");
                System.exit(0);
            }

            // pop the data from the stack
            return top_ref.pop();
        }

        // Function to enqueue an item to the queue
        static void enQueue(Queue q, int x)
        {
            push(q.stack1, x);
        }

        /* Function to deQueue an item from queue */
        static int deQueue(Queue q)
        {
            int x;

            /* If both stacks are empty then error */
            if (q.stack1.isEmpty() && q.stack2.isEmpty()) {
                System.out.println("Q is empty");
                System.exit(0);
            }

        /* Move elements from stack1 to stack 2 only if stack2 is empty */
            if (q.stack2.isEmpty()) {
                while (!q.stack1.isEmpty()) {
                    x = pop(q.stack1);
                    push(q.stack2, x);
                }
            }
            x = pop(q.stack2);
            return x;
        }

        /* Driver function to test above functions */
        public static void main(String args[])
        {
            /* Create a queue with items 1 2 3 */
            Queue q = new Queue();
            q.stack1 = new Stack<>();
            q.stack2 = new Stack<>();
            enQueue(q, 1);
            enQueue(q, 2);
            enQueue(q, 3);

            /* Dequeue items */
            System.out.print(deQueue(q) + " ");
            System.out.print(deQueue(q) + " ");
            System.out.println(deQueue(q) + " ");
        }
    }
    /*  Complexity Analysis :
           * Time Complexity :
                - Push operation  :  O(1)   Same as pop operation in stack.
                - Pop operation   :  O(N)   in general and O(1) amortized time complexity.
                                            In the worst case we have to empty the whole of stack 1 into stack 2
                                            so its O(N). Amortized time is the way to express the time complexity
                                            when an algorithm has the very bad time complexity only once in a while
                                            besides the time complexity that happens most of the time.
                                            So its O(1) amortized time complexity, since we have to empty whole of
                                            stack 1 only when stack 2 is empty, rest of the times the pop operation
                                            takes O(1) time.

           * Auxiliary Space     :  O(N).   Use of stack for storing values.
    * */




    //Approach 3 :
    // Java Program to implement a queue using one stack
    public class QOneStack {

        // class of queue having two stacks
        static class Queue {
            Stack<Integer> stack1;
        }

        /* Function to push an item to stack */
        static void push(Stack<Integer> top_ref, int new_data)
        {
            /* put in the data */
            top_ref.push(new_data);
        }

        /* Function to pop an item from stack */
        static int pop(Stack<Integer> top_ref)
        {
            /* If stack is empty then error */
            if (top_ref == null) {
                System.out.println("Stack Underflow");
                System.exit(0);
            }
            // return element from stack
            return top_ref.pop();
        }

        /* Function to enqueue an item to queue */
        static void enQueue(Queue q, int x)
        {
            push(q.stack1, x);
        }

        /* Function to deQueue an item from queue */
        static int deQueue(Queue q)
        {
            int x, res = 0;
            /* If the stacks is empty then error */
            if (q.stack1.isEmpty()) {
                System.out.println("Q is Empty");
                System.exit(0);
            }
            // Check if it is a last element of stack
            else if (q.stack1.size() == 1) {
                return pop(q.stack1);
            }
            else {

                /* pop an item from the stack1 */
                x = pop(q.stack1);

                /* store the last deQueued item */
                res = deQueue(q);

                /* push everything back to stack1 */
                push(q.stack1, x);
                return res;
            }
            return 0;
        }

        /* Driver function to test above functions */
        public static void main(String[] args)
        {
            /* Create a queue with items 1 2 3 */
            Queue q = new Queue();
            q.stack1 = new Stack<>();

            enQueue(q, 1);
            enQueue(q, 2);
            enQueue(q, 3);

            /* Dequeue items */
            System.out.print(deQueue(q) + " ");
            System.out.print(deQueue(q) + " ");
            System.out.print(deQueue(q) + " ");
        }
    }
    /*  Complexity Analysis :
           * Time Complexity :
                - Push operation : O(1)   Same as pop operation in stack.
                - Pop operation  : O(N)   The difference from above method is that in this method element is returned
                                          and all elements are restored back in a single call.

           * Auxiliary Space     : O(N)   Use of stack for storing values.
    * */






    public static void main(String[] args) {

        /*Ques : Implement a Queue using 2 stacks s1 and s2 .
                 A Query Q is of 2 Types :
                 (i).  1 x (a query of this type means  pushing 'x' into the queue)
                 (ii). 2   (a query of this type means to pop element from queue and print the popped element)


            Example : 1
            Input   : 5
                      1 2 1 3 2 1 4 2
            Output  : 2 3
            Explanation :  In the first testcase
                            1 2 the queue will be {2}
                            1 3 the queue will be {2 3}
                            2   popped element will be 2 the queue
                                will be {3}
                            1 4 the queue will be {3 4}
                            2   popped element will be 3.

            Example : 2
            Input   : 4
                      1 2 2 2 1 4
            Output  : 2 -1
            Explanation :  In the second testcase
                            1 2 the queue will be {2}
                            2   popped element will be 2 and
                                then the queue will be empty
                            2   the queue is empty and hence -1
                            1 4 the queue will be {4}.

            Your Task  :
            You are required to complete the two methods push which take one argument an integer 'x' to be
            pushed into the queue and pop which returns a integer poped out from other queue (-1 if the queue is empty).
            The printing is done automatically by the driver code.


            Expected Time Complexity   :  O(1)  for push() and O(N) for pop() or O(N) for push() and O(1) for pop()
            Expected Auxilliary Space  :  O(1).


        * */
    }



}
