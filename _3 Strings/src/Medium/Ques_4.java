package Medium;

public class Ques_4 {

    //Ques : Longest Palindromic subStrings........                                       (Leet code Ques no.- 5)


    //Approach 1 : Simple approach
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int  end = 0;
        if(n<2)
            return s;

        for(int i=0 ; i<s.length() ; i++)
        {
            char ch = s.charAt(i);
            int j=i, k=i;

            while(j>=0 && s.charAt(j) == ch)
                j--;

            while(k<n && s.charAt(k) == ch)
                k++;

            while(j>=0 && k<n)
            {
                if(s.charAt(j)!=s.charAt(k))
                    break;
                j--;
                k++;
            }

            j += 1;
            if(end-start < k-j)
            {
                end = k;
                start = j;
            }
        }

        return s.substring(start,end);
    }


    //Approach 2 : Two pointer approach....With complete class code                       T.C. = O(n^2), S.C. = O()
    class Solution_2{
        int start = 0;         //starting index of longest pallindrome
        int maxLen = 0;        //max length of longest pallindrome

        public String longestPalindrome(String s) {
            int len = s.length();
            if(len < 2)
                return s;

            for(int i=0; i<len; i++) {
                expandFromCenter(i, i, s);
                expandFromCenter(i, i+1, s);
            }

            return s.substring(start, start+maxLen+1);
        }

        //to check for pallindrome string
        public void expandFromCenter(int left, int right, String s) {
            if(left < 0 || right >= s.length()) {
                return;
            }

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            left++;
            right--;

            if(maxLen < right - left) {
                maxLen = right - left;
                start = left;
            }
        }
    }


    //Approach 3 : Brute force and Dynamic Programming.
    /*  PALINDROME in DP->If its first and last elements are same and the substring after excluding the
        first and last character is a palindrome.

        Hence, we can now reduce a bigger problem to smaller problem whose answer may be previously known.

        Use a matrix where dp[ i ] [ j ] represents substring from ith pos to jth pos.

        All single characters are palindromes, thus substring with a length 1 are substring by default.

        substrings of length 2 are palin if both characters are same.

        And for rest of lengths use the sub problem.

        Now we need longest so the palindromic substring with longest length is the substring.
    * */
    //Brute force :
    class Solution_3{
        private int Long, result;

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s;

            for (int i = 0; i < len-1; i++) {
                solve(s, i, i);
                solve(s, i, i+1);
            }
            return s.substring(Long, Long + result);
        }

        private void solve(String s, int j, int k) {

            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k))
            {
                j--;
                k++;
            }
            if (result < k - j - 1)
            {
                Long = j + 1;
                result = k - j - 1;
            }
        }

    }
    //Dynamic Approach : Not a efficient solution
    public String longestPalindrome_32(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }



    //Approach 4 : Not a efficient solution
    public String longestPalindrome_4(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            for(int j = 0 ; j <= i ; j++) {

                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
                if(dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }



    public static void main(String[] args) {

        /*Ques : Given a string s, return the longest palindromic substring in s.

                 A string is called a palindrome string  if  the reverse of  that
                 string is the same as the original string.


            Example : 1
            Input   : s = "babad"
            Output  : "bab"
            Explanation : "aba" is also a valid answer.


            Example : 2
            Input   : s = "cbbd"
            Output  : "bb"
        *
        * */
    }


}
