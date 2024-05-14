package Easy;

import java.util.Arrays;

public class Ques_1 {

    //Ques : Choose k array elements such that difference of maximum and minimum is minimized........(GFG Ques.)


    //Approach 1 : Simple Approach.........                                                           T.C. = O(nlog(n)),  S.C. = O(1)
    /*  Algorithm to solve the problem :
           1. Sort the Array.
           2. Calculate the maximum(k numbers) – minimum(k numbers) for each group of k consecutive integers.
           3. Return minimum of all values obtained in step 2.
    *
    * */
    // Java program to find minimum difference of maximum and minimum of K number.
    class GFG {

        // Return minimum difference of maximum and minimum of k elements of arr[0..n-1].
        static int minDiff(int arr[], int n, int k)
        {
            int result = Integer.MAX_VALUE;

            // Sorting the array.
            Arrays.sort(arr);

            // Find minimum value among all K size subarray.
            for (int i = 0; i <= n - k; i++)
                result = Math.min(result, arr[i + k - 1] - arr[i]);

            return result;
        }

        // Driver code
        public static void main_1(String[] args) {
            int arr[] = {10, 100, 300, 200, 1000, 20, 30};
            int n = arr.length;
            int k = 3;

            System.out.println(minDiff(arr, n, k));
        }
    }







    public static void main(String[] args) {

        /*Ques : Given an array of n integers and a positive number k. We are allowed to take any k integers
                 from the given array. The task is to find the minimum possible value of the difference between
                 maximum and minimum of K numbers.


            Example : 1
            Input   : arr[] = {10, 100, 300, 200, 1000, 20, 30}
                      k = 3
            Output  : 20
            Explanation : 20 is the minimum possible difference between any maximum and minimum of any k numbers.
                          Given k = 3, we get the result 20 by selecting integers {10, 20, 30}.
                          max(10, 20, 30) - min(10, 20, 30) = 30 - 10 = 20.


            Example : 2
            Input   : arr[] = {1, 2, 3, 4, 10, 20, 30, 40, 100, 200}.
                      k = 4
            Output  : 3

        *
        * */
    }



}
