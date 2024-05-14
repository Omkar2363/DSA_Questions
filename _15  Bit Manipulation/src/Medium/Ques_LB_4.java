package Medium;

public class Ques_LB_4 {

    //Ques : Count total set bits in all numbers from 1 to n | Set 2...............         (GFG Ques)


    //Approach 1 :                                                                          T.C. = O(log(n)),   S.C. = O(1)
    // Java implementation of the approach
    class GFG {

        // Function to return the sum of the count of set bits in the integers from 1 to n
        static int countSetBits(int n)
        {

            // Ignore 0 as all the bits are unset
            n++;

            // To store the powers of 2
            int powerOf2 = 2;

            // To store the result, it is initialized with n/2 because the count of set
            // the least significant bits in the integers from 1 to n is n/2
            int cnt = n / 2;

            // Loop for every bit required to represent n
            while (powerOf2 <= n)
            {

                // Total count of pairs of 0s and 1s
                int totalPairs = n / powerOf2;

                // totalPairs/2 gives the complete count of the pairs of 1s
                // Multiplying it with the current power of 2 will give the count of
                // 1s in the current bit
                cnt += (totalPairs / 2) * powerOf2;

                // If the count of pairs was odd then add the remaining 1s which could
                // not be grouped together
                cnt += (totalPairs % 2 == 1)  ?  (n % powerOf2)  :  0;

                // Next power of 2
                powerOf2 <<= 1;
            }

            // Return the result
            return cnt;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            int n = 14;

            System.out.println(countSetBits(n));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a positive integer N, the task is to count the sum of the number of set bits in
                 the binary representation of all the numbers from 1 to N.

            Example : 1
            Input   : N = 3
            Output  : 4
            Explanation :  Decimal	 Binary	  Set Bit Count
                             1	       01	      1
                             2	       10	      1
                             3	       11	      2
                             1 + 1 + 2 = 4

            Example : 2
            Input   : N = 16
            Output  : 33
        *
        *
        *
        * */
    }




}
