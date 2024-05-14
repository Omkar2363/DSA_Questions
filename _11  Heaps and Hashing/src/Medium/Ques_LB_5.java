package Medium;

import java.util.PriorityQueue;

public class Ques_LB_5 {

    //Ques : K-th Largest Sum Contiguous Subarray..............                            (GFG Ques.)


    //Approach 1 : Brute Force Approach.....
    /*  Brute force Approach : Store all the contiguous sums in another array and sort it and print the Kth largest.
                               But in the case of the number of elements being large, the array in which we store
                               the contiguous sums will run out of memory as the number of contiguous subarrays will
                               be large (quadratic order)
    *
    *
    * */



    //Approach 2 : By using min heap.........
    /*  Kth largest sum contiguous subarray using Min-Heap :
            The key idea is to store the pre-sum of the array in a sum[] array. One can find the sum of contiguous
            subarray from index i to j as sum[j] – sum[i-1]. Now generate all possible contiguous subarray sums and
            push them into the Min-Heap only if the size of Min-Heap is less than K or the current sum is greater
            than the root of the Min-Heap. In the end, the root of the Min-Heap is the required answer

        * Follow the given steps to solve the problem using the above approach :
            1. Create a prefix sum array of the input array
            2. Create a Min-Heap that stores the subarray sum
            3. Iterate over the given array using the variable i such that 1 <= i <= N, here i denotes the starting point
               of the subarray
                * Create a nested loop inside this loop using a variable j such that i <= j <= N, here j denotes the ending
                  point of the subarray
                   a). Calculate the sum of the current subarray represented by i and j, using the prefix sum array
                   b). If the size of the Min-Heap is less than K, then push this sum into the heap
                   c). Otherwise, if the current sum is greater than the root of the Min-Heap, then pop out the root and
                       push the current sum into the Min-Heap
            4. Now the root of the Min-Heap denotes the Kth largest sum, Return it

    *
    * */
    // Java program to find the K-th largest sum of subarray
    class KthLargestSumSubArray {

        // function to calculate Kth largest element in contiguous subarray sum
        static int kthLargestSum(int arr[], int N, int K)
        {
            // array to store prefix sums
            int sum[] = new int[N + 1];
            sum[0] = 0;
            sum[1] = arr[0];

            for (int i = 2; i <= N; i++)
                sum[i] = sum[i - 1] + arr[i - 1];

            // priority_queue of min heap
            PriorityQueue<Integer> Q = new PriorityQueue<Integer>();

            // loop to calculate the contiguous subarray sum position-wise
            for (int i = 1; i <= N; i++) {

                // loop to traverse all positions that form contiguous subarray
                for (int j = i; j <= N; j++) {

                    // calculates the contiguous subarray sum from j to i index
                    int x = sum[j] - sum[i - 1];

                    // if queue has less than k elements, then simply push it
                    if (Q.size() < K)
                        Q.add(x);

                    else {
                        // it the min heap has equal to k elements then just check
                        // if the largest kth element is smaller than x then insert
                        // else it is of no use
                        if (Q.peek() < x)
                        {
                            Q.poll();
                            Q.add(x);
                        }
                    }
                }
            }

            // the top element will be then kth largest element
            return Q.poll();
        }

        // Driver's Code
        public static void main_2(String[] args)
        {
            int a[] = new int[] { 10, -10, 20, -40 };
            int N = a.length;
            int K = 6;

            // Function call
            System.out.println(kthLargestSum(a, N, K));
        }
    }

    /*  Time Complexity : O(N2 * log(K))
        Auxiliary Space : O(N),           but this can be reduced to O(K) for min-heap and we can store
                                          the prefix sum array in the input array itself as it is of no use.

    * */


    public static void main(String[] args) {

        /*Ques : Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray
                 within the array of numbers that has both negative and positive numbers.


            Example : 1
            Input   : a[] = {20, -5, -1}, K = 3
            Output  : 14
            Explanation : All sum of contiguous subarrays are (20, 15, 14, -5, -6, -1)
                          so the 3rd largest sum is 14.


            Example : 2
            Input   : a[] = {10, -10, 20, -40}, k = 6
            Output  : -10
            Explanation : The 6th largest sum among sum of all contiguous subarrays is -10.


        *
        * */
    }




}
