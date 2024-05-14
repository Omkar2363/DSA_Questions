package Medium;

public class Ques_8 {

    //Ques : Longest Prefix Suffix.....                                               (GFG Ques.)


    //Approach 1 : Simple Solution......
    /*   Simple Solution: Since overlapping prefixes and suffixes is not allowed, we break the string from
                          the middle and start matching left and right strings.
                          If they are equal return size of one string, else they try for shorter lengths on both sides.

    * */
    // Function to find the largest prefix which is also a suffix
    static int longestPrefixSuffix_1(String s) {
        int n = s.length();

        // If n is less than 2
        if (n < 2) {
            return 0;
        }

        int len = 0;
        int i = (n + 1) / 2;

        // Iterate i till n
        while (i < n) {

            // If s.charAt(i) is equal to s.charAt(len)
            if (s.charAt(i) == s.charAt(len)) {
                ++len;
                ++i;
            } else {
                i = i - len + 1;
                len = 0;
            }
        }

        // Return len
        return len;


    /* Driver code
    public static void main (String[] args)
    {
        String s = "abcaabc";
        System.out.println(longestPrefixSuffix(s));
    }*/
    }



    //Approach 2 : Efficient solution....                                            T.C. = O(n),  S.C. = O(n)
    /*  Efficient Solution: The idea is to use the preprocessing algorithm KMP search.
                            In the preprocessing algorithm, we build lps array which stores the following values.

                        lps[i] = the longest proper prefix of pat[0..i]
                        which is also a suffix of pat[0..i].
    * */
    /*
     Returns length of the longest prefix which is also suffix and the two do
     not overlap. This function mainly is copy computeLPSArray() of in below post
     https://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
    */
    static int longestPrefixSuffix_2(String s) {

        int n = s.length();

        int lps[] = new int[n];

        // lps[0] is always 0
        lps[0] = 0;

        // length of the previous longest prefix suffix
        int len = 0;

        // the loop calculates lps[i] for i = 1 to n-1
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }

            // (pat[i] != pat[len])
            else {
                // This is tricky. Consider the example. AAACAAAA and i = 7.
                // The idea is similar to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment i here
                }

                // if (len == 0)
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int res = lps[n - 1];

        // Since we are looking for non overlapping parts.
        return (res > n / 2) ? n / 2 : res;


    /* Driver program
    public static void main (String[] args)
    {
        String s = "abcab";
        System.out.println(longestPrefixSuffix(s));
    }*/
    }





    public static void main(String[] args) {

        /*Ques : Given a string of characters, find the length of the longest proper prefix
                 which is also a proper suffix.

                 NOTE : Prefix and suffix can be overlapping, but they should not be equal to the entire string.

            Example : 1
            Input   : s = "abab"
            Output  : 2
            Explanation : "ab" is the longest proper prefix and suffix.

            Example : 2
            Input   : s = "aaaa"
            Output  : 3
            Explanation : "aaa" is the longest proper prefix and suffix.

            Example : 3
            Input   : aabcdaabc
            Output  : 4
            Explanation : The string "aabc" is the longest prefix which is also suffix.

            Example : 4
            Input   : abcab
            Output  : 2

            Example : 5
            Input   : aaaa
            Output  : 2

            Your task:
            You do not need to read any input or print anything. The task is to complete
            the function lps(), which takes a string as input and returns an integer.

            Expected Time Complexity : O(|s|)
            Expected Auxiliary Space : O(|s|)

        * */
    }


}
