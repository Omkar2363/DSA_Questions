package Medium;

import java.util.Arrays;

public class Ques_LB5 {

    //Ques : Edit Distance......                                                       (GFG Ques.)


    //Approach 1 : Recursive Solution
    /*   A Naive recursive Java program to find minimum number
         operations to convert str1 to str2 */
    class EDIST {
        static int min(int x, int y, int z) {
            if (x <= y && x <= z)
                return x;
            if (y <= x && y <= z)
                return y;
            else
                return z;
        }
        static int editDist(String str1, String str2, int m, int n){
            /*
             If first string is empty, the only option is to
             insert all characters of second string into first
            */
            if (m == 0)
                return n;

            /*
             If second string is empty, the only option is to
             remove all characters of first string
            */
            if (n == 0)
                return m;

            /*
             If last characters of two strings are same, nothing much to do.
             Ignore last characters and get count for remaining strings.
            */
            if (str1.charAt(m - 1) == str2.charAt(n - 1))
                return editDist(str1, str2, m - 1, n - 1);

            /*
             If last characters are not same, consider all three operations on last character of first
             string, recursively compute minimum cost for all three operations and take minimum of three
             values.
            */
            return 1
                      + min(editDist(str1, str2, m, n - 1),         // Insert
                            editDist(str1, str2, m - 1, n),        //  Remove
                            editDist(str1, str2, m - 1,n - 1)   //  Replace
            );
        }

        // Driver Code
        public static void main(String args[])
        {
            String str1 = "sunday";
            String str2 = "saturday";

            System.out.println(editDist(str1, str2, str1.length(), str2.length()));
        }
    }


    //Approach 2 : Dynamic Programming......                                           T.C. = O(m*n),  S.C. = O(m*n)
    /*   A Dynamic Programming based Java program to find minimum
         number operations to convert str1 to str2   */
    class EDIST_2 {
        static int min(int x, int y, int z)
        {
            if (x <= y && x <= z)
                return x;
            if (y <= x && y <= z)
                return y;
            else
                return z;
        }

        static int editDistDP(String str1, String str2, int m, int n)
        {
            // Create a table to store results of subproblems
            int dp[][] = new int[m + 1][n + 1];

            // Fill d[][] in bottom up manner
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {

                    /*
                     If first string is empty, only option is
                     to insert all characters of second string
                    */
                    if (i == 0)
                        dp[i][j] = j;                          // Min. operations = j

                        /*
                         If second string is empty, only option is
                         to remove all characters of second string
                        */
                    else if (j == 0)
                        dp[i][j] = i;                        // Min. operations = i

                        /*
                         If last characters are same, ignore last
                         char and recur for remaining string
                        */
                    else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];

                        /*
                         If the last character is different,
                         consider all possibilities and find the minimum
                        */
                    else
                        dp[i][j] = 1
                                        + min(dp[i][j - 1],                   // Insert
                                              dp[i - 1][j],                   // Remove
                                              dp[i - 1][j - 1]);              // Replace
                }
            }

            return dp[m][n];
        }

        // Driver Code
        public static void main(String args[])
        {
            String str1 = "sunday";
            String str2 = "saturday";
            System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));
        }
    }



    //Approach 3 : Dynamic Programming......(Space efficient solution)                T.C. = O(m*n),  S.C. = O(m)
    /*   A Space efficient Dynamic Programming based Java program to find minimum
         number operations to convert str1 to str2   */
    class GFG{
        static void EditDistDP(String str1, String str2)
        {
            int len1 = str1.length();
            int len2 = str2.length();

            // Create a DP array to memoize result of previous computations
            int [][]DP = new int[2][len1 + 1];


            // Base condition when second String is empty then we remove all characters
            for (int i = 0; i <= len1; i++)
                DP[0][i] = i;

            // Start filling the DP This loop run for every character in second String
            for (int i = 1; i <= len2; i++)
            {
                // This loop compares the char from second String with first String characters
                for (int j = 0; j <= len1; j++)
                {

                    /*
                     if first String is empty then we have to perform add character
                     operation to get second String
                    */
                    if (j == 0)
                        DP[i % 2][j] = i;

                        /*
                         if character from both String is same then we do not perform any operation .
                         here i % 2 is for bound the row number.
                        */
                    else if (str1.charAt(j - 1) == str2.charAt(i - 1)) {
                        DP[i % 2][j] = DP[(i - 1) % 2][j - 1];
                    }

                    /*
                     if character from both String is not same then we take the minimum
                     from three specified operation
                    */
                    else {
                        DP[i % 2][j] = 1 + Math.min(DP[(i - 1) % 2][j], Math.min(DP[i % 2][j - 1], DP[(i - 1) % 2][j - 1]));
                    }
                }
            }

            /*
             after complete fill the DP array if the len2 is even then we end up in the 0th row else we end up
             in the 1th row so we take len2 % 2 to get row
            */
            System.out.print(DP[len2 % 2][len1] +"\n");
        }

        // Driver program
        public static void main(String[] args)
        {
            String str1 = "food";
            String str2 = "money";
            EditDistDP(str1, str2);
        }
    }




    //Approach 4 : Dynamic Programming......(Top-Down Approach)                      T.C. = O(m*n),  S.C. = O(m*n) + O(m+n)
    class GFG_2{
        static int minDis(String s1, String s2, int n, int m, int[][] dp)
        {
            // If any String is empty, return the remaining characters of other String
            if (n == 0)
                return m;
            if (m == 0)
                return n;

            // To check if the recursive tree for given n & m has already been executed
            if (dp[n][m] != -1)
                return dp[n][m];

            // If characters are equal, execute recursive function for n-1, m-1
            if (s1.charAt(n - 1) == s2.charAt(m - 1))
            {
                return dp[n][m] = minDis(s1, s2, n - 1, m - 1, dp);
            }

            // If characters are nt equal, we need to find the minimum cost out of all 3 operations.
            else {

                int insert, del, replace;                      // temp variables

                insert = minDis(s1, s2, n, m - 1, dp);
                del = minDis(s1, s2, n - 1, m, dp);
                replace = minDis(s1, s2, n - 1, m - 1, dp);

                return dp[n][m] = 1 + Math.min(insert, Math.min(del, replace));
            }
        }
        // Driver program
        public static void main(String[] args)
        {

            String str1 = "voldemort";
            String str2 = "dumbledore";

            int n = str1.length(), m = str2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0 ; i < n + 1 ; i++)
                Arrays.fill(dp[i], -1);

            System.out.print(minDis(str1, str2, n, m, dp));
        }
    }




    public static void main(String[] args) {

        /*Ques : Given two strings s and t. Return the minimum number of operations required to convert s to t.

                 The possible operations are permitted:
                  *  Insert a character at any position of the string.
                  *  Remove any character from the string.
                  *  Replace any character from the string with any other character.


            Example : 1
            Input   : s = "geek", t = "gesek"
            Output  : 1
            Explanation : One operation is required inserting 's' between two 'e's of str1.


            Example : 2
            Input   : s = "gfg", t = "gfg"
            Output  : 0
            Explanation : Both strings are same.


            Your Task :
            You don't need to read or print anything. Your task is to complete
            the function editDistance() which takes strings s and t as input parameters and
            returns the minimum number of operation to convert the string s to string t.


            Expected Time Complexity: O(|s|*|t|)
            Expected Space Complexity: O(|s|*|t|)

        * */
    }


}
