package Medium;

public class Ques_LB9 {

    //Ques : Longest common subsequences......  (DP Problem)                                   (GFG Ques.)
    //              (Visit the link for other related problems every time.)


    //Approach 1 : A Naive recursive implementation of LCS problem                              T.C. = O(2^n)
    /*  Time complexity of the above naive recursive approach is O(2^n) in worst case and
        worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.
    */
    static public class LongestCommonSubsequence{
        /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
        int lcs( char[] X, char[] Y, int m, int n )
        {
            if (m == 0 || n == 0)
                return 0;
            if (X[m-1] == Y[n-1])
                return 1 + lcs(X, Y, m-1, n-1);
            else
                return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
        }

        /* Utility function to get max of 2 integers */
        int max(int a, int b)
        {
            return (a > b)? a : b;
        }

        public static void main_1(String[] args)
        {
            LongestCommonSubsequence lcs = new LongestCommonSubsequence();
            String s1 = "AGGTAB";
            String s2 = "GXTXAYB";

            char[] X = s1.toCharArray();
            char[] Y = s2.toCharArray();
            int m = X.length;
            int n = Y.length;

            System.out.println("Length of LCS is" + " " + lcs.lcs( X, Y, m, n ) );
        }

    }



    //Approach 2 : Memoization (Top - Down approach).........                                  T.C. = O(m*n)
    class GFG_2{

        // A Top-Down DP implementation of LCS problem

        // Returns length of LCS for X[0...m-1], Y[0...n-1]
        static int lcs(String X,String Y,int m,int n,int[][] dp){

            if (m == 0 || n == 0)
                return 0;

            if (dp[m][n] != -1)
                return dp[m][n];

            if(X.charAt(m - 1) == Y.charAt(n - 1)){
                dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
                return dp[m][n];
            }

            dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),lcs(X, Y, m - 1, n, dp));
            return dp[m][n];
        }

        // Drivers code
        public static void main_2(String args[]){

            String X = "AGGTAB";
            String Y = "GXTXAYB";

            int m = X.length();
            int n = Y.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int i=0;i<m + 1;i++){
                for(int j=0;j<n + 1;j++){
                    dp[i][j] = -1;
                }
            }

            System.out.println("Length of LCS is "+lcs(X, Y, m, n, dp));

        }
    }



    //Approach 3 : Tabulation (Bottom - Up approach).........
    static public class LongestCommonSubsequence_3{

        /* Returns length of LCS for X[0...m-1], Y[0...n-1] */
        int lcs( char[] X, char[] Y, int m, int n )
        {
            int L[][] = new int[m+1][n+1];

        /* Following steps build L[m+1][n+1] in bottom up fashion.
           Note that L[i][j] contains length of LCS of X[0...i-1] and Y[0...j-1] */
            for (int i=0; i<=m; i++)
            {
                for (int j=0; j<=n; j++)
                {
                    if (i == 0 || j == 0)
                        L[i][j] = 0;
                    else if (X[i-1] == Y[j-1])
                        L[i][j] = L[i-1][j-1] + 1;
                    else
                        L[i][j] = max(L[i-1][j], L[i][j-1]);
                }
            }
            return L[m][n];
        }

        /* Utility function to get max of 2 integers */
        int max(int a, int b)
        {
            return (a > b)? a : b;
        }

        public static void main_3(String[] args)
        {
            LongestCommonSubsequence lcs = new LongestCommonSubsequence();
            String s1 = "AGGTAB";
            String s2 = "GXTXAYB";

            char[] X = s1.toCharArray();
            char[] Y = s2.toCharArray();
            int m = X.length;
            int n = Y.length;

            System.out.println("Length of LCS is" + " " + lcs.lcs( X, Y, m, n ) );
        }

    }



    //Approach 4 : Space optimization
    //pura karo: follow the link :
    //https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
    //https://www.geeksforgeeks.org/space-optimized-solution-lcs/




    public static void main(String[] args) {

        /*Ques : Given two sequences, find the length of longest subsequence present in both of them.
                 Both the strings are of uppercase.


            Example : 1
            Input   : A = 6, B = 6
                      str1 = ABCDGH
                      str2 = AEDFHR
            Output  : 3
            Explanation : LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.


            Example : 2
            Input   : A = 3, B = 2
                      str1 = ABC
                      str2 = AC
            Output  : 2
            Explanation : LCS of "ABC" and "AC" is "AC" of length 2.


            Your Task :
            Complete the function lcs() which takes the length of two strings respectively and
            two strings as input parameters and returns the length of the longest subsequence present in both of them.

            Expected Time Complexity  : O(|str1|*|str2|)
            Expected Auxiliary Space  : O(|str1|*|str2|)

        *
        * */
    }


}
