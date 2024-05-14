package Easy;

import java.util.Arrays;
import java.util.HashMap;

public class Ques_LB10 {

    //Ques : Isomorphic Strings.......                                                   (GFG Ques.)


    //Approach 1 : Naive approach...                                                     T.C. = O(n^2), S.C. = O(1)
    /*Naive approach :
        A Simple Solution is to consider every character of 'str1' and check if all occurrences
        of it map to the same character in 'str2'. The time complexity of this solution is O(n*n).
    * */


    //Approach 2 :                                                                       T.C. = O(n), S.C. = O(1)
    static int size = 256;
    // Function returns true if str1 and str2 are isomorphic
    static boolean areIsomorphic(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        // Length of both strings must be same for one to one correspondence
        if (m != n)
            return false;

        // To mark visited characters in str2
        Boolean[] marked = new Boolean[size];
        Arrays.fill(marked, Boolean.FALSE);

        // To store mapping of every character from str1 to
        // that of str2. Initialize all entries of map as -1.
        int[] map = new int[size];
        Arrays.fill(map, -1);

        // Process all characters one by on
        for (int i = 0; i < n; i++) {

            // If current character of str1 is seen first time in it.
            if (map[str1.charAt(i)] == -1) {

                // If current character of str2 is already seen, one to one mapping not possible
                if (marked[str2.charAt(i)] == true)
                    return false;

                // Mark current character of str2 as visited
                marked[str2.charAt(i)] = true;

                // Store mapping of current characters
                map[str1.charAt(i)] = str2.charAt(i);
            }

            // If this is not first appearance of current character in str1, then check if previous
            // appearance mapped to same character of str2
            else if (map[str1.charAt(i)] != str2.charAt(i))
                return false;
        }

        return true;

    /* driver program
    public static void main(String[] args)
    {
        boolean res = areIsomorphic("aab", "xxy");
        System.out.println(res);

        res = areIsomorphic("aab", "xyz");
        System.out.println(res);
    }*/
    }



    //approach 3 :                                                                      T.C. = O(n), S.C. = O(1)
    static final int CHAR = 26;
    // This function returns true if str1 and str2 are isomorphic
    static boolean isoMorphic(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Length of both strings must be same for one to one correspondence
        if (n != m)
            return false;

        // For counting the previous appearances of character in both the strings
        int[] countChars1 = new int[CHAR];
        int[] countChars2 = new int[CHAR];

        // Process all characters one by one
        for (int i = 0; i < n; i++) {
            countChars1[str1.charAt(i) - 'a']++;
            countChars2[str2.charAt(i) - 'a']++;
        }

        // For string to be isomorphic the previous counts of appearances of
        // current character in both string must be same if it is not same we
        // return false.

        //before it was not working for the test case mentioned below(wrong output)
        // str1 = "aba" , str2 = "xyy"
        for (int i = 0; i < n; i++) {
            if (countChars1[str1.charAt(i) - 'a']
                    != countChars2[str2.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;


    /* Driver Code
    public static void main(String[] args)
    {
        System.out.println(isoMorphic("aab", "xxy") ? 1 : 0);
        System.out.println(isoMorphic("aba", "xyy") ? 1 : 0);
    }*/
    }



    //Approach 4 :                                                                      T.C. = O(n), S.C. = O(n)
    static boolean areIsomorphic(char[] str1, char[] str2) {

        HashMap<Character, Character> charCount = new HashMap();
        char c = 'a';

        for (int i = 0; i < str1.length; i++) {
            if (charCount.containsKey(str1[i])) {
                c = charCount.get(str1[i]);

                if (c != str2[i])
                    return false;
            }
            else if (!charCount.containsValue(str2[i])) {
                charCount.put(str1[i], str2[i]);
            }
            else {
                return false;
            }
        }
        return true;


    /* Driver code
    public static void main(String[] args)
    {

        String str1 = "aac";
        String str2 = "xxy";

        // Function Call
        if (str1.length() == str2.length()
                && areIsomorphic(str1.toCharArray(),
                str2.toCharArray()))
            System.out.println(1);
        else
            System.out.println(0);
    }*/
    }



    public static void main(String[] args) {

        /*Ques : Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
                 Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for
                 every character of str1 to every character of str2 while preserving the order.

                 Note: All occurrences of every character in str1 should map to the same character in str2


            Example : 1
            Input   : str1 = aab
                      str2 = xxy
            Output  : 1
            Explanation : There are two different characters in aab and xxy, i.e a and b
                          with frequency 2and 1 respectively.


            Example : 2
            Input   : str1 = aab
                      str2 = xyz
            Output  : 0
            Explanation : There are two different characters in aab but there are three different characters
                          in xyz. So there won't be one to one mapping between str1 and str2.


            Your Task :
            You don't need to read input or print anything.Your task is to complete the function areIsomorphic()
            which takes the string str1 and string str2 as input parameter and  check if two strings are isomorphic.
            The function returns true if strings are isomorphic else it returns false.

            Expected Time Complexity :  O(|str1|+|str2|).
            Expected Auxiliary Space :  O(Number of different characters).

            Note: |s| represents the length of string s.
        *
        * */
    }

}
