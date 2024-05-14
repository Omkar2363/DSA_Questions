package Medium;

public class Ques_3 {

    //Ques : Maximum sum such that no two elements are adjacent.......                        (GFG Ques.)


    //Approach 1 : Naive Approach......                                                       T.C. = O(2^n),  S.C. = O(n)
    /*      Naive Approach : Below is the idea to solve the problem......

            Each element has two choices: either it can be the part of the subsequence with the highest
            sum, or it cannot be part of the subsequence. So to solve the problem, build all the subsequences
            of the array and find the subsequence with the maximum sum such that no two adjacent elements are
            present in the subsequence.
    *
    * */



    //Approach 2 : By using Dynamic Programming......                                        T.C. = O(n),  S.C. = O(n)
    /*   Follow the steps mentioned below to implement the above idea:

          1.  If the size of the array is 1, then the answer is arr[0].
          2.  Initialize the values of dp[0][0] = 0 and dp[0][1] = arr[0].
          3.  Iterate from i = 1 to N-1:
          4.  Fill the dp array as per the relation shown above.
          5.  Return the maximum between dp[N-1][1] and dp[N-1][0] as that will be the answer.
    *
    * */
    class GFG_2 {

        // Function to find the maximum sum
        static int findMaxSum(int[] arr, int N)
        {
            // Declare dp array
            int[][] dp = new int[N][2];
            if (N == 1) {
                return arr[0];
            }

            // Initialize the values in dp array
            dp[0][0] = 0;
            dp[0][1] = arr[0];

            // Loop to find the maximum possible sum
            for (int i = 1; i < N; i++) {
                dp[i][1] = dp[i - 1][0] + arr[i];
                dp[i][0] = Math.max(dp[i - 1][1],
                        dp[i - 1][0]);
            }

            // Return the maximum sum
            return Math.max(dp[N - 1][0], dp[N - 1][1]);
        }


        // Driver Code
        public static void main_2(String args[])
        {

            // Creating the array
            int[] arr = { 5, 5, 10, 100, 10, 5 };
            int N = arr.length;

            // Function call
            System.out.println(findMaxSum(arr, N));
        }
    }



    //Approach 3 : Space Optimized Approach........                                         T.C. = O(n),  S.C. = O(1)
    /*      Follow the steps mentioned below to implement the above approach :

               1. Initialize incl and excl with arr[0] and 0 respectively.
               2. Iterate from i = 1 to N-1:
               3. Update the values of incl and excl as mentioned above.
               4. Return the maximum of incl and excl after the iteration is over as the answer.
    *
    * */
    // Java code to implement the approach
    static class MaximumSum {
        // Function to return max sum such that no two elements are adjacent
        int findMaxSum(int arr[], int n)
        {
            int incl = arr[0];
            int excl = 0;
            int excl_new;
            int i;

            for (i = 1; i < n; i++) {
                // Current max excluding i
                excl_new = Math.max(incl, excl);

                // Current max including i
                incl = excl + arr[i];
                excl = excl_new;
            }

            // Return max of incl and excl
            return Math.max(incl, excl);
        }

        // Driver code
        public static void main_3(String[] args)
        {
            MaximumSum sum = new MaximumSum();
            int arr[] = new int[] { 5, 5, 10, 100,
                    10, 5 };
            int N = arr.length;

            // Function call
            System.out.println(sum.findMaxSum(arr, arr.length));
        }
    }




    public static void main(String[] args) {

        /*Ques : Given an array arr[] of positive numbers, The task is to find the maximum sum
                 of a subsequence such that no 2 numbers in the sequence should be adjacent in the array.


            Example : 1
            Input   : arr[] = {5, 5, 10, 100, 10, 5}
            Output  : 110
            Explanation : Pick the subsequence {5, 100, 5}.
                          The sum is 110 and no two elements are adjacent. This is the highest possible sum.


            Example : 2
            Input   : arr[] = {3, 2, 7, 10}
            Output  : 13
            Explanation : The subsequence is {3, 10}. This gives sum = 13.
                          This is the highest possible sum of a subsequence following the given criteria


            Example : 3
            Input   : arr[] = {3, 2, 5, 10, 7}
            Output  : 15
            Explanation : Pick the subsequence {3, 5, 7}. The sum is 15.
        *
        * */
    }


}
