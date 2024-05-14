package Easy;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Ques_LB3 {

    //Ques : Check if given strings are rotations of each other or not                          (GFG Ques.)

    //Approach 1 : Naive approach....                                                           T.C. = O(n^2), S.C. = O(1)
    /*  Naive Approach: Follow the given steps to solve the problem

            * Find all the positions of the first character of the original string in the string to be checked.
            * For every position found, consider it to be the starting index of the string to be checked.
            * Beginning from the new starting index, compare both strings and check whether they are equal or not.
            * (Suppose the original string to is s1, string to be checked to be s2,n is the length of strings and
              j is the position of the first character of s1 in s2, then for i < (length of original string) ,
              check if s1[i]==s2[(j+1)%n). Return false if any character mismatch is found, else return true.
            * Repeat 3rd step for all positions found.
    * */
    static boolean checkString(String s1, String s2, int indexFound, int Size) {
        for (int i = 0; i < Size; i++) {

            // check whether the character is equal or not
            if (s1.charAt(i) != s2.charAt((indexFound + i) % Size))
                return false;

            // %Size keeps (indexFound+i) in bounds,since it ensures
            // its value remains always less than Size
        }

        return true;


    /* Driver code
    public static void main(String args[])
    {
        String s1 = "abcd";
        String s2 = "cdab";

        if (s1.length() != s2.length()) {
            System.out.println(
                    "s2 is not a rotation on s1");
        }
        else {

            ArrayList<Integer> indexes = new ArrayList<Integer>();          // store occurrences of the
                                                                            // first character of s1

            int Size = s1.length();

            char firstChar = s1.charAt(0);

            for (int i = 0; i < Size; i++) {
                if (s2.charAt(i) == firstChar) {
                    indexes.add(i);
                }
            }

            boolean isRotation = false;

            // check if the strings are rotation of each
            // other for every occurrence of firstChar in s2
            for (int idx : indexes) {
                isRotation = checkString(s1, s2, idx, Size);

                if (isRotation)
                    break;
            }

            if (isRotation)
                System.out.println("Strings are rotations of each other");
            else
                System.out.println("Strings are not rotations of each other");
        }
    }*/
    }


    //Approach 2 : By using queue.......                                                        T.C. = O(n1 * n2), S.C. = O(n)
    /*  Follow the given steps to solve the problem :

        * If the size of both strings is not equal, then it can never be possible.
        * Push the original string into a queue q1.
        * Push the string to be checked inside another queue q2.
        * Keep popping q2‘s and pushing it back into it till the number of such operations is less
          than the size of the string.
        * If q2 becomes equal to q1 at any point during these operations, it is possible. Else not.
    * */
    static boolean check_rotation(String s, String goal) {

        if (s.length() != goal.length())
            return false;

        Queue<Character> q1 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            q1.add(s.charAt(i));
        }

        Queue<Character> q2 = new LinkedList<>();
        for (int i = 0; i < goal.length(); i++) {
            q2.add(goal.charAt(i));
        }

        int k = goal.length();
        while (k > 0) {
            k--;
            char ch = q2.peek();
            q2.remove();
            q2.add(ch);
            if (q2.equals(q1))
                return true;
        }

        return false;


    /* Driver code
    public static void main(String[] args)
    {
        String str1 = "AACD";
        String str2 = "ACDA";

        // Function call
        if (check_rotation(str1, str2))
            System.out.println("Strings are rotations of each other");
        else
            System.out.printf("Strings are not rotations of each other");
    }*/
    }


    //Approach 3 : Efficient approach.......By uisng inbuilt method indexOf();                  T.C. = O(n), S.C. = O(n)
    /*  Follow the given steps to solve the problem :

        * Create a temp string and store concatenation of str1 to str1 in temp,
            i.e. temp = str1.str1
        * If str2 is a substring of temp then str1 and str2 are rotations of each other.

        Example :   str1 = “ABACD”, str2 = “CDABA”
                    temp = str1.str1 = “ABACDABACD”

                    Since str2 is a substring of temp, str1 and str2 are rotations of each other.
    * */
    static boolean areRotations(String str1, String str2) {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        return (str1.length() == str2.length()) && ((str1 + str1).indexOf(str2) != -1);

                                                        /*Visit the link for indexOf function :
                                                          Link : https://www.javatpoint.com/java-string-indexof#:~:text=The%20signature%20of%20indexOf%20%28%29%20methods%20are%20given,the%20index%20position%20for%20the%20gi%20...%20
                                                        * */
    /* Driver code
    public static void main(String[] args)
    {
        String str1 = "AACD";
        String str2 = "ACDA";

        // Fuinction call
        if (areRotations(str1, str2))
            System.out.println("Strings are rotations of each other");
        else
            System.out.printf(
                    "Strings are not rotations of each other");
    }*/
    }




    public static void main(String[] args) {

        /*Ques : Given a string s1 and a string s2, write a function to check whether s2 is a rotation of s1.

            Example : 1
            Input   : S1 = ABCD, S2 = CDAB
            Output  : Strings are rotations of each other

            Example : 2
            Input   : S1 = ABCD, S2 = ACBD
            Output  : Strings are not rotations of each other
        * */
    }
}
