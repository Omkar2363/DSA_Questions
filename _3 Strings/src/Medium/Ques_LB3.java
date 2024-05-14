package Medium;

import java.util.Scanner;

public class Ques_LB3 {

    //Ques : Permutations of a given string.....                                             (GFG Ques.)


    //Approach 1 :                                                                           T.C. = O(n * n!),  S.C. = O(r-l)
    static class Permutation {
        public static void main_1(String[] args) {
            String str = "ABC";
            int n = str.length();
            Permutation permutation = new Permutation();
            permutation.permute(str, 0, n - 1);
        }
        /**
         * permutation function
         *
         * @param str string to calculate permutation for
         * @param l   starting index
         * @param r   end index
         */
        private void permute(String str, int l, int r) {
            if (l == r)
                System.out.println(str);
            else {
                for (int i = l; i <= r; i++) {
                    str = swap(str, l, i);
                    permute(str, l + 1, r);
                    str = swap(str, l, i);
                }
            }
        }
        /**
         * Swap Characters at position
         *
         * @param a string value
         * @param i position 1
         * @param j position 2
         * @return swapped string
         */
        public String swap(String a, int i, int j) {
            char temp;
            char[] charArray = a.toCharArray();
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            return String.valueOf(charArray);
        }

        /*  NOTE : The above solution prints duplicate permutations if there are repeating characters
                   in the input string. Please see the below link for a solution  that  prints  only
                   distinct permutations even if there are duplicates in input
        * */

}



    //Approach 2 :                                                                          T.C. = O(n * n!),  S.C. = O(|s|)
    class GFG{
        static void permute(String s , String answer){

            if (s.length() == 0)
            {
                System.out.print(answer + "  ");
                return;
            }

            for(int i = 0 ;i < s.length(); i++)
            {
                char ch = s.charAt(i);
                String left_substr = s.substring(0, i);
                String right_substr = s.substring(i + 1);
                String rest = left_substr + right_substr;
                permute(rest, answer + ch);
            }
        }

        // Driver code
        public static void main_2(String args[])
        {
            Scanner scan = new Scanner(System.in);

            String s;
            String answer="";

            System.out.print("Enter the string : ");
            s = scan.next();

            System.out.print("\nAll possible strings are : ");
            permute(s, answer);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a string S. The task is to print all unique permutations of the given string in
                 lexicographically sorted order.


            Example : 1
            Input   : ABC
            Output  : ABC ACB BAC BCA CAB CBA
            Explanation : Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .


            Example : 2
            Input   : ABSG
            Output  : ABGS ABSG AGBS AGSB ASBG ASGB BAGS
                      BASG BGAS BGSA BSAG BSGA GABS GASB
                      GBAS GBSA GSAB GSBA SABG SAGB SBAG
                      SBGA SGAB SGBA
            Explanation : Given string ABSG has 24 permutations.


            Your Task :
            You don't need to read input or print anything.
            Your task is to complete the function find_permutaion() which takes the string S as input parameter
            and returns a vector of string in lexicographical order.


            Expected Time Complexity  : O(n! * n)
            Expected Space Complexity : O(n)

            * Follow the link for visual display of the illustration :

                Link : https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0

            * Note : A permutation also called an "arrangement number" or "order," is a rearrangement of
                     the elements of an ordered list S into a one-to-one correspondence with S itself.
                     A string of length n has n! permutation.
        * */
    }


}
