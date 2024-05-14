package Easy;

import java.util.LinkedList;

public class Ques_Q_LB5 {

    //Ques : First negative integer in every window of size k.........                         (GFG Ques.)


    //Approach 1 : By using two Loops.......
    // Java implementation to find the first negative integer in every window of size k
    class solution_1 {

        // function to find the first negative integer in every window of size k
        static void printFirstNegativeInteger(int arr[], int n, int k)
        {
            // flag to check whether window contains a negative integer or not
            boolean flag;

            // Loop for each subarray(window) of size k
            for (int i = 0; i<(n-k+1); i++)
            {
                flag = false;

                // traverse through the current window
                for (int j = 0; j<k; j++)
                {
                    // if a negative integer is found, then it is the first negative integer for current window.
                    // Print it, set the flag and break
                    if (arr[i+j] < 0)
                    {
                        System.out.print((arr[i+j]) + " ");
                        flag = true;
                        break;
                    }
                }

                // if the current window does not contain a negative integer
                if (!flag)
                    System.out.print("0"+" ");
            }
        }

        // Driver program to test above functions
        public static void main_1(String args[])
        {
            int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
            int n = arr.length;
            int k = 3;
            printFirstNegativeInteger(arr, n, k);

        }
    }

    /*  Time Complexity : The outer loop runs n-k+1 times and the inner loop runs k times for
                          every iteration of outer loop.
                          So, time complexity is        O((n-k+1)*k),
                          which can also be written as  O(nk),         when k is comparatively much smaller than n,
                          otherwise when k tends to reach n, complexity becomes O(k).

        Auxiliary Space : O(1) as it is using constant space for variables


    * */



    //Approach 2 :                                                                            T.C. = O(n),  S.C. = O(k)
    /*  Approach 2 : Efficient Approach
            We create a Dequeue, Di of capacity k, that stores only useful elements of the current window of k elements.
            An element is useful if it is in the current window, and it is a negative integer.
            We process all array elements one by one and maintain Di to contain useful elements of current window
            and these useful elements are all negative integers. For a particular window, if Di is not empty then
            the element at front of the Di is the first negative integer for that window, else that window does not
            contain a negative integer.

          * It is a variation of the problem of Sliding Window Maximum.


    * */
    // Java implementation to find the first negative integer in every window of size k
    class GFG_2 {

        // function to find the first negative integer in every window of size k
        static void printFirstNegativeInteger(int arr[], int n, int k)
        {
            // A Double Ended Queue, Di that will store indexes of useful array elements
            // for the current window of size k. The useful elements are all negative integers.
            LinkedList<Integer> Di = new LinkedList<>();

            // Process first k (or first window) elements of array
            int i;
            for (i = 0; i < k; i++)
                // Add current element at the rear of Di if it is a negative integer
                if (arr[i] < 0)
                    Di.add(i);

            // Process rest of the elements, i.e., from arr[k] to arr[n-1]
            for ( ; i < n; i++)
            {
                // if Di is not empty then the element at the front of the queue is the first
                // negative integer of the previous window
                if (!Di.isEmpty())
                    System.out.print(arr[Di.peek()] + " ");

                    // else the window does not have a negative integer
                else
                    System.out.print("0" + " ");

                // Remove the elements which are out of this window
                while ((!Di.isEmpty())  &&  Di.peek() < (i - k + 1))
                    Di.remove();                                       // Remove from front of queue


                // Add current element at the rear of Di if it is a negative integer
                if (arr[i] < 0)
                    Di.add(i);
            }

            // Print the first negative integer of last window
            if (!Di.isEmpty())
                System.out.print(arr[Di.peek()] + " ");
            else
                System.out.print("0" + " ");
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
            int n = arr.length;
            int k = 3;
            printFirstNegativeInteger(arr, n, k);
        }
    }




    //Approach 3 :
    /*  Optimized Approach  :
               It is also possible to accomplish this with constant space. The idea is to have a variable
               firstNegativeIndex to keep track of the first negative element in the k sized window.
               At every iteration, we skip the elements which no longer fall under the current k size window
               (firstNegativeIndex <= i – k) as well as the non-negative elements(zero or positive).

     * */
    // Java code for First negative integer in every window of size k
    class GFG_3{

        static void printFirstNegativeInteger(int arr[], int k, int n)
        {
            int firstNegativeIndex = 0;
            int firstNegativeElement;

            for(int i = k - 1; i < n; i++)
            {

                // Skip out of window and positive elements
                while ((firstNegativeIndex < i ) && (firstNegativeIndex <= i - k || arr[firstNegativeIndex] >= 0))
                {
                    firstNegativeIndex ++;
                }

                // Check if a negative element is found, otherwise use 0
                if (arr[firstNegativeIndex] < 0)
                {
                    firstNegativeElement = arr[firstNegativeIndex];
                }
                else
                {
                    firstNegativeElement = 0;
                }
                System.out.print(firstNegativeElement + " ");
            }
        }

        // Driver code
        public static void main_3(String[] args)
        {
            int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
            int n = arr.length;
            int k = 3;

            printFirstNegativeInteger(arr, k, n);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an array A[] of size N and a positive integer K, find the first negative integer for
                 each and every window(contiguous subarray) of size K.


            Example : 1
            Input   : N = 5
                      A[] = {-8, 2, 3, -6, 10}
                      K = 2
            Output :  -8 0 -6 -6
            Explanation : First negative integer for each window of size k
                          {-8, 2}  = -8
                          {2, 3}   =  0 (does not contain a negative integer)
                          {3, -6}  = -6
                          {-6, 10} = -6

            Example : 2
            Input   : N = 8
                      A[] = { 12, -1, -7, 8, -15, 30, 16, 28 }
                      K = 3
            Output  : -1 -1 -7 -15 -15 0


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function
            printFirstNegativeInteger() which takes the array A[], its size N and an integer K as
            inputs and returns the first negative number in every window of size K starting from the
            first till the end. If a window does not contain a negative integer , then return 0 for that window.


            Expected Time Complexity  :  O(N)
            Expected Auxiliary Space  :  O(K)
        *
        */
    }


}


