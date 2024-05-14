package Medium;

public class Ques_7 {

    //Ques : Count all Palindromic Subsequences in a String.....                         (GFG Ques.)


    //Approach 1 :                                                                       T.C. = O(n*n),   S.C. = O(n*n)
    final long mod = 1000000007;
    long add(long x, long y) {
        return ((x % mod) + (y % mod)) % mod;
    }
    long sub(long x, long y) {
        return ((x % mod) - (y % mod) + mod) % mod;
    }

    long countPS(String str) {
        int N = str.length();

        // create a 2D array to store the count of palindromic subsequence
        long cps[][] = new long[N+1][N+1];
        for (int i=0; i<N; i++)
            cps[i][i] = 1;
        char str1[] = str.toCharArray();
        // check subsequence of length L is palindrome or not
        for (int L=2; L<=N; L++)
        {
            for (int i=0; i<=N-L; i++)
            {
                int k = L+i-1;
                if (str1[i] == str1[k])
                    cps[i][k] = add(cps[i][k-1] ,cps[i+1][k] + 1)%mod;
                else
                    cps[i][k] = add(cps[i][k-1], sub(cps[i+1][k], cps[i+1][k-1]))%mod;
            }
        }
        return cps[0][N-1];
    }



    public static void main(String[] args) {

        /*Ques : Given a string str of length N, you have to find number of palindromic subsequence
                 (need not necessarily be distinct) present in the string str.

                 Note: You have to return the answer module 109+7;


            Example : 1
            Input   : Str = "abcd"
            Output  : 4
            Explanation : palindromic subsequence are : "a" ,"b", "c" ,"d"


            Example : 2
            Input   : Str = "aab"
            Output  : 4
            Explanation : palindromic subsequence are :"a", "a", "b", "aa"


            Your Task:
            You don't need to read input or print anything. Your task is to complete the function
            countPs() which takes a string str as input parameter and returns the number of palindromic subsequence.


            Expected Time Complexity: O(N*N)
            Expected Auxiliary Space: O(N*N)


        *
        * */
    }


}
