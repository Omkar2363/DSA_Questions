package Medium;

import java.util.HashMap;
import java.util.Stack;

public class Ques_S_11 {

    //Ques : Next Smaller Element.........                                                (GFG Ques.)


    //Approach 1 : By using Loops......                                                   T.C. = O(n^2),  S.C. = O(1)
    /*  Method 1 : (Simple)
            Use two loops : The outer loop picks all the elements one by one. The inner loop looks for
            the first smaller element for the element picked by outer loop. If a smaller element is found
            then that element is printed as next, otherwise, -1 is printed.


    * */
    // Simple Java program to print next smaller elements in a given array
    class Main {

        /* prints element and NSE pair for all elements of arr[] of size n */
        static void printNSE(int arr[], int n)
        {
            int next, i, j;
            for (i = 0; i < n; i++) {
                next = -1;
                for (j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        next = arr[j];
                        break;
                    }
                }
                System.out.println(arr[i] + " -- " + next);
            }
        }
        public static void main_1(String args[])
        {
            int arr[] = { 11, 13, 21, 3 };
            int n = arr.length;
            printNSE(arr, n);
        }
    }




    //Approach 2 : By using Stack......                                                  T.C. = O(n),  S.C. = O(n)
    /*  Method 4 :(Using Stack)....
            This problem is similar to next greater element. Here we maintain items in increasing order in
            the stack (instead of decreasing in next greater element problem).
               1. Push the first element to stack.
               2. Pick rest of the elements one by one and follow the following steps in loop.
                    * Mark the current element as next.
                    * If stack is not empty, then compare next with stack top. If next is smaller than top then next is the NSE for the top. Keep popping from the stack while top is greater than next. next becomes the NSE for all such popped elements
                    * Push next into the stack
               3. After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.

            Note : To achieve the same order, we use a stack of pairs, where first element is the value and
                   second element is index of array element.
    * */
    // A Stack based Java program to find next smaller element for all array elements
    // in same order as input.
    class GFG {
        /* prints element and NSE pair for all elements of arr[] of size n */
        public static void printNSE(int arr[], int n)
        {
            Stack<Integer> s = new Stack<Integer>();
            HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

            /* push the first element to stack */
            s.push(arr[0]);

            // iterate for rest of the elements
            for (int i = 1; i < n; i++) {

                if (s.empty()) {
                    s.push(arr[i]);
                    continue;
                }

                /* if stack is not empty, then pop an element from stack.
                    If the popped element is greater than next, then
                    a) print the pair
                    b) keep popping while elements are greater and stack is not empty  */

                while (s.empty() == false
                        && s.peek() > arr[i]) {
                    mp.put(s.peek(), arr[i]);
                    s.pop();
                }

            /* push next to stack so that we can find next smaller for it */
                s.push(arr[i]);
            }

            /* After iterating over the loop, the remaining elements in stack do not have
               the next smaller element, so print -1 for them */
            while (s.empty() == false) {
                mp.put(s.peek(), -1);
                s.pop();
            }

            for (int i = 0; i < n; i++)
                System.out.println(arr[i] + " ---> " + mp.get(arr[i]));
        }

        /* Driver program to test above functions */
        public static void main_2(String[] args)
        {
            int arr[] = { 11, 13, 21, 3 };
            int n = arr.length;
            printNSE(arr, n);
        }
    }







    public static void main(String[] args) {

        /*Ques : Given an array, print the Next Smaller Element (NSE) for every element. The NSE for an element
                 x is the first smaller element on the right side of x in the array. Elements for which no smaller
                 element exist (on the right side), consider NSE as -1.


            Examples :
                a) For any array, the rightmost element always has NSE as -1.
                b) For an array that is sorted in increasing order, all elements have NSE as -1.
                c) For the input array [4, 8, 5, 2, 25}, the NSE for each element is as follows.
                    Element          NSE
                       4       -->    2
                       8       -->    5
                       5       -->    2
                       2       -->   -1
                       25      -->   -1
                d) For the input array [13, 7, 6, 12}, the next smaller elements for each element are as follows.
                    Element          NSE
                       13      -->    7
                       7       -->    6
                       6       -->   -1
                       12      -->   -1

        * */
    }


}
