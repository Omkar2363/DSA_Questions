package Medium;

import java.util.Arrays;

public class Ques_4 {

    //Ques : K-th smallest element after removing some integers from natural numbers.......    (GFG Ques.)


    //Approach 1 : Simple Approach.......                                                       T.C. = O(Max),  S.C. = O(Max)
    /*  Method 1 (Simple) :
            Make an auxiliary array b[] for presence/absence of natural numbers and initialize all with 0.
            Make all the integer equal to 1 which are present in array arr[] i.e b[arr[i]] = 1. Now, run a loop
            and decrement k whenever unmarked cell is encountered. When the value of k is 0, we get the answer.
    *
    * */
    // Java program to find the K-th smallest element after removing some integers from natural number.
    class GFG {
        static final int MAX = 1000000;

        // Return the K-th smallest element.
        static int ksmallest(int arr[], int n, int k)
        {
            // Making an array, and mark all number as unmarked.
            int b[] = new int[MAX];

            // Marking the number present in the given array.
            for (int i = 0; i < n; i++)
            {
                b[arr[i]] = 1;
            }

            for (int j = 1; j < MAX; j++)
            {
                // If j is unmarked, reduce k by 1.
                if (b[j] != 1) {
                    k--;
                }

                // If k is 0 return j.
                if (k != 1) {
                    return j;
                }
            }
            return Integer.MAX_VALUE;
        }

        // Driven code
        public static void main_1(String[] args)
        {
            int k = 1;
            int arr[] = { 1 };
            int n = arr.length;
            System.out.println(ksmallest(arr, n, k));
        }
    }



    //Approach 2 : Efficient Approach.........                                                 T.C. = (n*log(n)),  S.C. = O(1)
    /*  Method 2 (Efficient) :
            First, sort the array arr[]. Observe, there will be arr[0] – 1 numbers between 0 and arr[0],
            similarly, arr[1] – arr[0] – 1 numbers between arr[0] and arr[1] and so on.
            So, if k lies between arr[i] – arr[i+1] – 1, then return K-th smallest element in the range.
            Else reduce k by arr[i] – arr[i+1] – 1 i.e., k = k – (arr[i] – arr[i+1] – 1).

            * Algorithm to solve the problem :
                1. Sort the array arr[].
                2. For i = 1 to k. Find c = arr[i+1] - arr[i] -1.
                  a) if k - c <= 0, return arr[i-1] + k.
                  b) else k = k - c.
    *
    * */
    // Java program to find the Kth smallest element after removing
    // some integer from first n natural number.
    class GFG_2 {

        // Return the K-th smallest element.
        static int ksmallest(int arr[], int n, int k)
        {
            // sort(arr, arr+n);
            Arrays.sort(arr);

            // Checking if k lies before 1st element
            if (k < arr[0])
                return k;

            // If k is the first element of array arr[].
            if (k == arr[0])
                return arr[0] + 1;

            // If k is more than last element
            if (k > arr[n - 1])
                return k + n;

            // If first element of array is 1.
            if (arr[0] == 1)
                k--;

                // Reducing k by numbers before arr[0].
            else
                k -= (arr[0] - 1);

            // Finding k'th smallest element after removing array elements.
            for (int i = 1; i < n; i++)
            {
                // Finding count of element between i-th and (i-1)th element.
                int c = arr[i] - arr[i - 1] - 1;
                if (k <= c)
                    return arr[i - 1] + k;
                else
                    k -= c;
            }

            return arr[n - 1] + k;
        }

        // Driven Code
        public static void main_2(String[] args)
        {
            int k = 1;
            int arr[] = { 1 };
            int n = arr.length;
            System.out.println(ksmallest(arr, n, k));
        }
    }









    public static void main(String[] args) {

        /*Ques : Given an array arr[] of size ‘n’ and a positive integer k. Consider series of natural numbers and
                 remove arr[0], arr[1], arr[2], …, arr[p] from it. Now the task is to find k-th smallest number in
                 the remaining set of natural numbers. If no such number exists print “-1”.


            Example : 1
            Input   : arr[] = { 1 } and k = 1.
            Output  : 2
            Explanation : Natural numbers are {1, 2, 3, 4, .... }
                          After removing {1}, we get {2, 3, 4, ...}.
                          Now, K-th smallest element = 2.

            Example : 2
            Input   : arr[] = {1, 3}, k = 4.
            Output  : 6
            Explanation : First 5 Natural number {1, 2, 3, 4, 5, 6,  .. }
                          After removing {1, 3}, we get {2, 4, 5, 6, ... }.

        *
        *
        * */
    }




}
