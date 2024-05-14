package Medium;

import java.util.HashSet;

public class Ques_LB13 {

    //Ques : Smallest distinct window........                                                    (GFG Ques.)
    //       (Smallest window that contains all the characters of string itself)



    //Approach 1 : Brute force....
    /*  Intuition :
        Create all the sub-strings and check if there exist all the unique characters.

        Implementation :
        By running a nested loop we can get all the possible sub-strings and
        check if there exist all the unique characters in that particular sub-string

        Complexities :
        Time Complexity  :  O(N*N*60) - Total Number of sub-strings will be N*(N-1).
                                        Each string contains at most 56 unique character as small case and upper case
                                        letters are included.
        Space Complexity :  O(N*N)    - To store all the sub-strings.


    *
    * */


    //Approach 2 : By using sliding window technique                                            T.C. = O(N*256),  S.C. = O(256)
    //             (we can find the minimum window which contains all the unique elements.)
    class Solution{
        static int no_of_chars = 256;
        public int findSubString(String str)
        {
            int len1 = str.length();
            String pat = "";
            HashSet<Character> s = new HashSet<>();
            //set<char> s;
            for (int i = 0 ; i < len1 ; i++)
                s.add(str.charAt(i));

            for(char c : s)
                pat+=c;

            int len2 = pat.length();

            // check if string's length is less than pattern's length. If yes then no such window can exist
            if (len1 < len2) {
                return 0;
            }

            int [] hash_pat = new int[no_of_chars];
            int [] hash_str = new int[no_of_chars];

            // store occurrence ofs characters of pattern
            for (int i = 0 ; i < len2 ; i++)
                hash_pat[pat.charAt(i)]++;

            int start = 0;
            int start_index = -1;
            int min_len = Integer.MAX_VALUE;

            // start traversing the string
            int count = 0;                                         // count of characters
            for (int j = 0; j < len1; j++) {
                // count occurrence of characters of string
                hash_str[str.charAt(j)]++;

                // If string's char matches with pattern's char then increment count
                if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
                    count++;

                // if all the characters are matched
                if (count == len2) {

                    /*
                     Try to minimize the window i.e., check if any character is occurring more no. of times
                     than its occurrence in pattern, if yes then remove it from starting and also remove
                     the useless characters.
                    */
                    while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] ||
                                                                hash_pat[str.charAt(start)] == 0)
                    {
                        if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
                                hash_str[str.charAt(start)]--;
                        start++;
                    }

                    // update window size
                    int len_window = j - start + 1;
                    if (min_len > len_window) {
                        min_len = len_window;
                        start_index = start;
                    }
                }
            }

            // If no window found
            if (start_index == -1) {
                return 0;
            }

            // Return substring starting from start_index and length min_len
            return str.substring(start_index, start_index+min_len).length();
        }
    }



    //Follow the link for more detail.......
    //Link : https://www.geeksforgeeks.org/smallest-window-contains-characters-string/


    public static void main(String[] args) {

        /*Ques : Given a string 's'. The task is to find the smallest window length that contains all
                 the characters of the given string at least one time.

                 For e.g. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.


            Example : 1
            Input   : "AABBBCBBAC"
            Output  : 3
            Explanation : Sub-string -> "BAC"

            Example : 2
            Input   : "aaab"
            Output  : 2
            Explanation : Sub-string -> "ab"

            Example : 3
            Input   : "GEEKSGEEKSFOR"
            Output  : 8
            Explanation : Sub-string -> "GEEKSFOR"


            Your Task:
            You don't need to read input or print anything. Your task is to complete
            the function findSubString() which takes the string  S as input and returns
            the length of the smallest such window of the string.


            Expected Time Complexity  : O(256.N)
            Expected Auxiliary Space  : O(256)

        * */
    }

}
