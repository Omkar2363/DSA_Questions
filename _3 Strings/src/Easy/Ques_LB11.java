package Easy;

public class Ques_LB11 {

    //Ques : Split the binary string into substrings with equal number of 0s and 1s ........    (GFG Ques.)


    //Approach 1 :                                                                              T.C. = O(n), S.C. = O(1)
    /*  Approach: Initialize count = 0 and traverse the string character by character
                  and keep track of the number of 0s and 1s so far, whenever the count
                  of 0s and 1s become equal increment the count. As in the given question,
                  if it is not possible to split string then on that time count of 0s must
                  not be equal to count of 1s then return -1 else print the value of count
                  after the traversal of the complete string.
    * */
        // Function to return the count of maximum substrings str can be divided into
        static int maxSubStr(String str, int n){

            // To store the count of 0s and 1s
            int count0 = 0, count1 = 0;

            // To store the count of maximum substrings str can be divided into
            int cnt = 0;
            for (int i = 0; i < n; i++)
            {
                if (str.charAt(i) == '0')
                {
                    count0++;
                }
                else
                {
                    count1++;
                }
                if (count0 == count1)
                {
                    cnt++;
                }
            }

            // It is not possible to split the string
            if (count0 != count1)
            {
                return -1;
            }
            return cnt;


        /* Driver code
        public static void main(String []args)
        {
            String str = "0100110101";
            int n = str.length();

            System.out.println(maxSubStr(str, n));
        }*/
    }




    public static void main(String[] args) {

        /*Ques : Given a binary string str of length N, the task is to find the maximum count of
                 consecutive substrings str can be divided into such that all the substrings are balanced
                 i.e. they have equal number of 0s and 1s. If it is not possible to split str satisfying
                      the conditions then print -1.


            Example : 1
            Input   : str = “0100110101”
            Output  : 4
            Explanation : The required substrings are “01”, “0011”, “01” and “01”.


            Example : 2
            Input   : str = “0111100010”
            Output  : 3

            Example : 3
            Input   : str = “0000000000”
            Output  : -1

            * Follow  the link for more clarification :
                Link : https://www.geeksforgeeks.org/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/
        *
        * */
    }


}
