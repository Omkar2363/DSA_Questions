package Easy;

public class Ques_LB6 {

    //Ques : Min Number of Flips......                                                  (GFG Ques.)


    //Approach 1 :                                                                      T.C. = O(n), S.C. = O(1)
    //Utility method to flip a character
    public static char flip(char ch)
    {
        return (ch == '0') ? '1' : '0';
    }

    //  Utility method to get minimum flips when alternate string starts with expected char
    public static int getFlipWithStartingCharcter(String str,  char expected) {
        int flipCount = 0;
        for (int i = 0; i < str.length(); i++)
        {
            //  if current character is not expected, increase flip count
            if (str.charAt(i) != expected)
                flipCount++;

            //  flip expected character each time
            expected = flip(expected);
        }
        return flipCount;
    }

    // method return minimum flip to make binary string alternate
    public static int minFlipToMakeStringAlternate(String str) {
        /*
          return minimum of following two
          1) flips when alternate string starts with 0
          2) flips when alternate string starts with 1
        */
        return Math.min(getFlipWithStartingCharcter(str, '0'),
                getFlipWithStartingCharcter(str, '1'));


    /*  Driver code to test above method
    public static void main(String args[])
    {
        String str = "0001010111";
        System.out.println(minFlipToMakeStringAlternate(str));
    }*/

    }




    public static void main(String[] args) {

        /*Ques : Given a binary string, that is it contains only 0s and 1s. We need to  make  this string
                 a sequence of alternate characters by flipping some of the bits, our goal is to minimize
                 the number of bits to be flipped.


            Example : 1
            Input   : S = "001"
            Output  : 1
            Explanation : We can flip the 0th bit to 1 to have
                          101.

            Example : 2
            Input   : S = "0001010111"
            Output  : 2
            Explanation : We can flip the 1st and 8th bit to have "0101010101"
                          101.

            Your Task:
            You don't need to read input or print anything. Your task is to complete the function minFlips()
            which takes the string S as input and returns the minimum number of flips required.


            Expected Time Complexity: O(|S|).
            Expected Auxiliary Space: O(1).


        *
        * */
    }

}
