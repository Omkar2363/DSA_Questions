package Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ques_S_6 {

    //Ques : Stack Permutations (Check if an array is stack permutation of other)........     (GFG Ques.)


    //Approach 1 : By Using Stack.......                                                      T.C. = O(n),  S.C. = O(n)
    /*  Stack Permutation Using Stack :
            The idea is to try to convert the input queue to the output queue using a stack,
            if we are able to do so then the queue is permutable otherwise not.


        # Follow the steps mentioned below to implement the approach :
           1). Continuously pop elements from the input queue and check if it is equal to the top of output queue or not,
               if it is not equal to the top of output queue then we will push the element to stack.
           2). Once we find an element in input queue such the top of input queue is equal to top of output queue,
               we will pop a single element from both input and output queues, and compare the top of stack and top
               of output queue now. If top of both stack and output queue are equal then pop element from both stack
               and output queue. If not equal, go to step 1.
           3). Repeat above two steps until the input queue becomes empty. At the end if both of the input queue and
               stack are empty then the input queue is permutable otherwise not.
    * */
    // Given two arrays, check if one array is stack permutation of the other.
    class Gfg {

        // function to check if input queue is permutable to output queue
        static boolean checkStackPermutation(int ip[], int op[], int n)
        {
            Queue<Integer> input = new LinkedList<>();

            // Input queue
            for (int i = 0; i < n; i++)
            {
                input.add(ip[i]);
            }

            // Output queue
            Queue<Integer> output = new LinkedList<>();
            for (int i = 0; i < n; i++)
            {
                output.add(op[i]);
            }

            // stack to be used for permutation
            Stack<Integer> tempStack = new Stack<>();
            while (!input.isEmpty())
            {
                int ele = input.poll();

                if (ele == output.peek())
                {
                    output.poll();
                    while (!tempStack.isEmpty())
                    {
                        if (tempStack.peek() == output.peek())
                        {
                            tempStack.pop();
                            output.poll();
                        }
                        else
                            break;
                    }
                }
                else
                {
                    tempStack.push(ele);
                }
            }

            // If after processing, both input queue and stack are empty then
            // the input queue is permutable otherwise not.
            return (input.isEmpty() && tempStack.isEmpty());
        }

        // Driver code
        public static void main_1(String[] args)
        {
            // Input Queue
            int input[] = { 1, 2, 3 };

            // Output Queue
            int output[] = { 2, 1, 3 };
            int n = 3;
            if (checkStackPermutation(input, output, n))
                System.out.println("Yes");
            else
                System.out.println("Not Possible");
        }
    }




    //Approach 2 : Optimized Approach.....                                                   T.C. = O(n),  S.C. = O(n)
    /*  Optimized Approach :
            The idea to start iterating on the input array and storing its element one by one in a stack
            and if the top of our stack matches with an element in the output array we will pop that element
            from the stack and compare the next element of the output array with the top of our stack if again
            it matches then again pop until our stack isn’t empty
    * */
    // Java program to check if one array is stack permutation of the other.
    class Rextester {
        // function to check if input array is permutable to output array
        static Boolean checkStackPermutation(int ip[], int op[], int n)
        {
            // we will be pushing elements from input array to stack un-till top of our stack matches with first
            // element of output array
            Stack<Integer> s = new Stack<Integer>();

            // will maintain a variable j to iterate on output array
            int j = 0;

            // will iterate one by one in input array
            for (int i = 0; i < n; i++) {

                // pushed an element from input array to stack
                s.push(ip[i]);
                // if our stack isn't empty and top matches with output array then we will keep popping out
                // from stack un-till top matches with output array
                while (!s.isEmpty() && s.peek() == op[j]) {

                    s.pop();
                    // increasing j so next time we can compare next element in output array
                    j++;
                }
            }

            // if output array was a correct permutation of input array then by now our stack should be empty
            if (s.isEmpty()) {
                return true;
            }
            return false;
        }

        // Driver program to test above function
        public static void main_2(String args[])
        {
            // Input Array
            int input[] = { 4, 5, 6, 7, 8 };

            // Output Array
            int output[] = { 8, 7, 6, 5, 4 };

            int n = 5;

            if (checkStackPermutation(input, output, n))
                System.out.println("Yes");
            else
                System.out.println("Not Possible");
        }
    }




    public static void main(String[] args) {

        /*Ques : A stack permutation is a permutation of objects in the given input queue which is done
                 by transferring elements from the input queue to the output queue with the help of a stack
                 and the built-in push and pop functions.

           # The rules are :
               * Only dequeue from the input queue.
               * Use inbuilt push, and pop functions in the single stack.
               * Stack and input queue must be empty at the end.
               * Only enqueue to the output queue.

        There are a huge number of permutations possible using a stack for a single input queue.
        Given two arrays, both of unique elements. One represents the input queue and the other represents the output queue. Our task is to check if the given output is possible through stack permutation.


            Example : 1
            Input   : arr1[] = [ 1, 2, 3 ] , arr2[] = [ 2, 1, 3 ]
            Output  : YES
            Explanation :   push 1 from input to stack
                            push 2 from input to stack
                            pop  2 from stack to output
                            pop  1 from stack to output
                            push 3 from input to stack
                            pop  3 from stack to output

            Example : 2
            Input   : arr1[] = [ 1, 2, 3 ] , arr2[] = [ 3, 1, 2 ]
            Output  : Not Possible


        * */
    }




}
