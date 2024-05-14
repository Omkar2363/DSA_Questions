package Medium;

public class Ques_LB4 {

    //Ques : Stickler Thief......                                                     (GFG Ques.)
    //        (Maximum sum such that no two elements are adjacent)


    //Approach 1 : Naive approach...                                                  T.C. = O(2^n), S.C. = O(n)
    /*  Naive Approach :
        Each element has two choices: either it can be the part of the subsequence with the highest sum,
        or it cannot be part of the subsequence. So to solve the problem, build all the subsequences of
        the array and find the subsequence with the maximum sum such that no two adjacent elements are present
        in the subsequence.

        Time Complexity : O(2^N)
        Auxiliary Space : O(N)
    * */


    //Approach 2 : Efficient approach.....By using Dynamic Programming......         T.C. = O(n),  S.C. = O(n)
    class GFG {

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
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
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



    //Approach 3 : Space Optimization......                                          T.C. = O(n),  S.C. = O(1)
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
        public static void main(String[] args)
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

        /*Ques : Stickler the thief wants to loot money from a society having n houses in a single line.
                 He is a weird person and follows a certain rule when looting the houses.
                 According to the rule, he will never loot two consecutive houses. At the same time,
                 he wants to maximize the amount he loots. The thief knows which house has what amount
                 of money but is unable to come up with an optimal looting strategy. He asks for your help
                 to find the maximum money he can get if he strictly follows the rule.
                 Each house has a[i]amount of money present in it.


            Example : 1
            Input   : n = 6
                      a[] = {5,5,10,100,10,5}
            Output  : 110
            Explanation : 5+100+5=110


            Example : 2
            Input   : n = 3
                      a[] = {1,2,3}
            Output  : 4
            Explanation : 1+3=4

            Your Task :
            Complete the functionFindMaxSum()which takes an array arr[] and n as input which
            returns the maximum money he can get following the rules

            Expected Time Complexity  : O(N).
            Expected Space Complexity : O(N).

        *
        * */
    }


}
