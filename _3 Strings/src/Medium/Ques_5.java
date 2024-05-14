package Medium;

public class Ques_5 {

    //Ques : Palindromic Substrings.....                                             (Leet code Ques no.- 647)


    //Approach 1 : Two pointer approach....And (even + odd) sol                      T.C. = O(n^2), S.C. = O(1)
    public int countSubstrings(String s) {

        char[] chArr = s.toCharArray();
        int n = chArr.length;
        int ans = 0;

        for(int i=0 ; i<n ; i++){

            // odd-length strings centered at c[i]
            int left = i;
            int right = i;
            while(left >=0 && right <n && chArr[left] == chArr[right]){
                ans++;
                left--;
                right++;
            }

            //even-length strings centered at c[i] and c[i+1]
            left = i;
            right = i+1;
            while(left >=0 && right <n && chArr[left] == chArr[right]){
                ans++;
                left--;
                right++;
            }
        }

        return ans;
    }


    //Via Recursion....   //Write code next time
    //Approach 2 : Recursion and its optimization

    //Link for the support....    https://leetcode.com/problems/palindromic-substrings/discuss/339383/Java-or-Short-and-Clean-or-3-methods

    public static void main(String[] args) {

        /*Ques : Given a string s, return the number of palindromic substrings in it.

                 A string is a palindrome when it reads the same backward as forward.
                 A substring is a contiguous sequence of characters within the string.


            Example : 1
            Input   : s = "abc"
            Output  : 3
            Explanation : Three palindromic strings: "a", "b", "c".


            Example : 2
            Input   : s = "aaa"
            Output  : 6
            Explanation : Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
        * */
    }

}
