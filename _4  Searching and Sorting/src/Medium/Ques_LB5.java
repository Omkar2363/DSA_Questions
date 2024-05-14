package Medium;

import java.util.Arrays;

public class Ques_LB5 {

    //Ques : Count triplets with sum smaller than X..........                              (GFG Ques.)


    //Approach 1 : Simple approach....                                                     T.C. = O(n^3),  S.C. = O(1)
    /*      A Simple Solution is to run three loops to consider all triplets one by one.
            For every triplet, compare the sums and increment count if the triplet sum is smaller than the given sum.
    * */
    // A Simple Java program to count triplets with sum smaller than a given value
    class Test {
        static int arr[] = new int[]{5, 1, 3, 4, 7};
        static int countTriplets(int n, int sum)
        {
            // Initialize result
            int ans = 0;

            // Fix the first element as A[i]
            for (int i = 0; i < n-2; i++)
            {
                // Fix the second element as A[j]
                for (int j = i+1; j < n-1; j++)
                {
                    // Now look for the third number
                    for (int k = j+1; k < n; k++)
                        if (arr[i] + arr[j] + arr[k] < sum)
                            ans++;
                }
            }

            return ans;
        }

        // Driver method to test the above function
        public static void main_1(String[] args)
        {
            int sum = 12;
            System.out.println(countTriplets(arr.length, sum));
        }
    }


    //Approach 2 : Efficient Approach....By using Sorting....                             T.C. = O(n^2),  S.C. = O(1)
    // A Simple Java program to count triplets with sum smaller than a given value
    class Test_2 {
        static int arr[] = new int[]{5, 1, 3, 4, 7};

        static int countTriplets(int n, int sum)
        {
            // Sort input array
            Arrays.sort(arr);

            // Initialize result
            int ans = 0;

            // Every iteration of loop counts triplet with first element as arr[i].
            for (int i = 0; i < n - 2; i++)
            {
                // Initialize other two elements as corner elements
                // of subarray arr[j+1...k]
                int j = i + 1, k = n - 1;

                // Use Meet in the Middle concept
                while (j < k)
                {
                    // If sum of current triplet is more or equal,
                    // move right corner to look for smaller values
                    if (arr[i] + arr[j] + arr[k] >= sum)
                        k--;

                        // Else move left corner
                    else
                    {
                        // This is important. For current i and j, there
                        // can be total k-j third elements.
                        ans += (k - j);
                        j++;
                    }
                }
            }
            return ans;
        }

        // Driver method to test the above function
        public static void main_2(String[] args)
        {
            int sum = 12;
            System.out.println(countTriplets(arr.length, sum));
        }
    }




    public static void main(String[] args) {

        /*Ques : Given an array arr[] of distinct integers of size N and a value sum,
                 the task is to find the count of triplets (i, j, k), having (i<j<k) with
                 the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.


            Example : 1
            Input   : N = 4, sum = 2
                      arr[] = {-2, 0, 1, 3}
            Output  : 2
            Explanation : Below are triplets with sum less than 2
                          (-2, 0, 1) and (-2, 0, 3).


            Example : 2
            Input   : N = 5, sum = 12
                      arr[] = {5, 1, 3, 4, 7}
            Output  : 4
            Explanation : Below are triplets with sum less than 12
                            (1, 3, 4), (1, 3, 5),
                            (1, 3, 7) and (1, 4, 5).

            Your Task :
            This is a function problem. You don't need to take any input, as it is already accomplished
            by the driver code. You just need to complete the function countTriplets() that take array arr[],
            integer N  and integer sum as parameters and returns the count of triplets.


            Expected Time Complexity : O(N2).
            Expected Auxiliary Space : O(1).

*/
    }


}
