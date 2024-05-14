package Medium;

public class Ques_LB10 {

    //Ques : Longest Repeating Subsequence.....                                            (GFG Ques.)
                    //Modification of  longest common subsequences

    //Approach 1 :                                                                         T.C. = O(n^2), S.C. = O(n^2)
    /*  Algorithm :
        Step 1: Initialize the input string, which is to be checked.

        Step 2: Initialize the length of string to the variable.

        Step 3: Create a DP table using 2D matrix and set each element to 0.

        Step 4: Fill the table if  characters are same and indexes are different.

        Step 5: Return the values inside the table

        Step 6: Print the String.
    * */
    // Function to find the longest repeating subsequence
    static int findLongestRepeatingSubSeq(String str) {
        int n = str.length();

        // Create and initialize DP table
        int[][] dp = new int[n + 1][n + 1];

        // Fill dp table (similar to LCS loops)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match and indexes are not same
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    // If characters do not match
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][n];


        /* driver program to check above function
        public static void main (String[]args)
        {
            String str = "aabb";
            System.out.println("The length of the largest subsequence that"
                    + " repeats itself is : " + findLongestRepeatingSubSeq(str));
        }*/
    }




    //Approach 2 : Using Recursion.....                                                   T.C. = O(n^2), S.C. = O(n^2)
    static int dp[][] = new int[1000][1000];
    /*
     This function mainly returns LCS(str, str) with a condition that same characters at
     same index are not considered.
    */
    static int findLongestRepeatingSubSeq(char X[], int m, int n) {

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        // return if we have reached the end of either string
        if (m == 0 || n == 0) {
            return dp[m][n] = 0;
        }

        // if characters at index m and n matches
        // and index is different
        if (X[m - 1] == X[n - 1] && m != n) {
            return dp[m][n] = findLongestRepeatingSubSeq(X, m - 1, n - 1) + 1;
        }

        // else if characters at index m and n don't match
        return dp[m][n] = Math.max(findLongestRepeatingSubSeq(X, m, n - 1),
                findLongestRepeatingSubSeq(X, m - 1, n));


        /* Driver code
           The Longest Repeated Subsequence Problem

           static public void main_2(String[] args) {
                String str = "aabb";
                int m = str.length();
                for (int[] row : dp) {
                    Arrays.fill(row, -1);
                }
                 System.out.println("The length of the largest subsequence that" + " repeats itself is : "
                                        + findLongestRepeatingSubSeq(str.toCharArray(), m, m));

    }*/
    }




    //Approach  3 : D.P (Top- down approach).....                                        T.C. = O(n^2), S.C. = O(n)
    static int lrs(StringBuilder s1, int i, int j, int[][] dp) {
        if (i >= s1.length() || j >= s1.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (dp[i][j] == -1) {
            if (s1.charAt(i) == s1.charAt(j) && i != j) {
                dp[i][j] = 1 + lrs(s1, i + 1, j + 1, dp);
            } else {
                dp[i][j] = Math.max(lrs(s1, i, j + 1, dp), lrs(s1, i + 1, j, dp));
            }
        }
        return dp[i][j];


    /* Driver code
    public static void main (String[] args)
    {
        String s1 = "aabb";
        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(s1);

        // reverse StringBuilder input1
        input1.reverse();
        int[][] dp = new int[1000][1000];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        System.out.println("LENGTH OF LONGEST REPEATING SUBSEQUENCE IS :" +
                lrs(input1, 0, 0, dp));
    }*/
    }



    public static void main(String[] args) {

        /*Ques : Given string str, find the length of the longest repeating subsequence such that it can be
                 found twice in the given string.

                 The two identified subsequences A and B can use the same ith character from string str if
                 and only if that ith character has different indices in A and B. For example, A = "xax" and
                 B = "xax" then the index of first "x" must be different in the original string for A and B.


                Example : 1
                Input   : str = "axxzxy"
                Output  : 2
                Explanation : The given array with indexes looks like
                                a x x z x y
                                0 1 2 3 4 5

                The longest subsequence is "xx".
                It appears twice as explained below.
                subsequence A
                x x
                0 1  <-- index of subsequence A
                ------
                1 2  <-- index of str

                subsequence B
                x x
                0 1  <-- index of subsequence B
                ------
                2 4  <-- index of str

                We are able to use character 'x' (at index 2 in str) in both subsequences
                as it appears on index 1 in subsequence A
                and index 0 in subsequence B.


                Example : 2
                Input   : str = "axxxy"
                Output  : 2
                Explanation : The given array with indexes looks like
                                a x x x y
                                0 1 2 3 4

                The longest subsequence is "xx".
                It appears twice as explained below.
                subsequence A
                x x
                0 1  <-- index of subsequence A
                ------
                1 2  <-- index of str

                subsequence B
                x x
                0 1  <-- index of subsequence B
                ------
                2 3  <-- index of str

                We are able to use character 'x' (at index 2 in str) in both subsequences
                as it appears on index 1 in subsequence A and index 0 in subsequence B.

                Your Task:
                You don't need to read or print anything. Your task is to complete the
                LongestRepeatingSubsequence() which takes str as input parameter and returns
                the length of the longest repeating subsequnece.


                Expected Time Complexity: O(n2)
                Expected Space Complexity: O(n2)
        *
        * */
    }

}
