package Easy;

import java.util.Vector;

public class Ques_LB8 {

    //Ques : Minimum Swaps for Bracket Balancing.....                                        (GFG Ques.)


    //Approach 1 : Naive approach.....                                                       T.C. = O(n^2), S.C. = O(1)
    /*  Naive Approach :
            Initialize sum = 0 where sum stores result. Go through the  string  maintaining a  count of
            the number of ‘[‘ brackets encountered. Reduce this count when we encounter a ‘]’ character.
            If the count hits negative, then we must start balancing the string.

            Let index ‘i’ represent the position we are at. We now move forward to the next ‘[‘ at index j.
            Increase sum by j – i. Move the ‘[‘ at position j, to position i, and shift all other characters
            to the right. Set the count back to 0 and continue traversing the string. In the end, ‘sum’ will
            have the required value.
    */



    //Approach 2 :                                                                          T.C. = O(n), S.C. = O(1)
    // Function to calculate swaps required
    public static long swapCount_2(String s) {

        // Keep track of '['
        Vector<Integer> pos = new Vector<Integer>();
        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '[')
                pos.add(i);

        // To count number of encountered '['
        int count = 0;

        // To track position of next '[' in pos
        int p = 0;

        // To store result
        long sum = 0;

        char[] S = s.toCharArray();

        for (int i = 0; i < s.length(); ++i) {

            // Increment count and move p to next position
            if (S[i] == '[') {
                ++count;
                ++p;
            } else if (S[i] == ']')
                --count;

            // We have encountered an unbalanced part of string
            if (count < 0) {

                // Increment sum by number of swaps required i.e. position
                // of next '[' - current position
                sum += pos.get(p) - i;
                char temp = S[i];
                S[i] = S[pos.get(p)];
                S[pos.get(p)] = temp;
                ++p;

                // Reset count to 1
                count = 1;
            }
        }
        return sum;

    /* Driver code
    public static void main(String[] args)
    {
        String s = "[]][][";
        System.out.println(swapCount(s));

        s = "[[][]]";
        System.out.println(swapCount(s));
    }*/
    }


    //Approach 3 :                                                                         T.C. = O(n), S.C. = O(1)
    static long swapCount_3(String s) {
        char[] chars = s.toCharArray();

        // stores total number of Left and Right brackets encountered
        int countLeft = 0, countRight = 0;

        //swap stores the number of swaps required imbalance maintains the number of imbalance pair
        int swap = 0, imbalance = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                // increment count of Left bracket
                countLeft++;
                if (imbalance > 0) {
                    // swaps count is last swap count + total number imbalanced brackets
                    swap += imbalance;

                    // imbalance decremented by 1 as it solved only one imbalance of Left and Right
                    imbalance--;
                }
            } else if (chars[i] == ']') {
                // increment count of Right bracket
                countRight++;

                // imbalance is reset to current difference between Left and Right brackets
                imbalance = (countRight - countLeft);
            }
        }
        return swap;


    /* Driver code
    public static void main(String args[])
    {
        String s = "[]][][";
        System.out.println(swapCount_3(s) );

        s = "[[][]]";
        System.out.println(swapCount_3(s) );

    }*/

    }



    public static void main(String[] args) {

        /*Ques : You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets.
                 A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2
                 are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters.
                 Calculate the minimum number of swaps necessary to make a string balanced.

                 Note - Strings S1 and S2 can be empty.

                Example : 1

                Input   : []][][
                Output  : 2
                Explanation : First swap: Position 3 and 4
                              [][]][
                              Second swap: Position 5 and 6
                              [][][]

                Example : 2
                Input   : [[][]]
                Output  : 0
                Explanation : String is already balanced.


                Your Task :
                You don't need to read input or print anything. Your task is to complete the function
                minimumNumberOfSwaps() which takes the string S and return minimum number of operations
                required to balance the bracket sequence.

                Expected Time Complexity: O(N).
                Expected Auxiliary Space: O(1).

        *
        * */
    }

}
