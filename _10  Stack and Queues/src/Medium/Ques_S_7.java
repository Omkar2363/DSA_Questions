package Medium;

import java.util.Stack;

public class Ques_S_7 {

    //Ques : Count natural numbers whose all permutation are greater than that number.......     (GFG Ques.)


    //Approach 1 : Simple Approach......
    /*  A simple solution is to run a loop from 1 to n and for every number check if its digits are in
        non-decreasing order or not.

     * */



    //Approach 2 : Efficient Approach......
    /*  An efficient solution is based on below observations :
           *  Observation 1 : From 1 to 9, all number have this property. So, for n <= 9, output n.
           *  Observation 2 : The number whose all permutation is greater than or equal to that number
                              have all their digits in increasing order.

            The idea is to push all the number from 1 to 9. Now, pop the top element, say topel and try to make number
            whose digits are in increasing order and the first digit is topel. To make such numbers, the second  digit
            can be from topel%10 to 9. If this number is less than n, increment the count and push the number in
            the stack, else ignore.
    * */
    // Java program to count the number less than N, whose all permutation is greater
    // than or equal to the number.
    class GFG {

        // Return the count of the number having all permutation greater than or equal to the number.
        static int countNumber(int n)
        {
            int result = 0;

            // Pushing 1 to 9 because all number from 1 to 9 have this property.
            Stack<Integer> s = new Stack<>();
            for (int i = 1; i <= 9; i++)
            {

                if (i <= n)
                {
                    s.push(i);
                    result++;
                }

                // take a number from stack and add a digit smaller than or equal to last digit of it.
                while (!s.empty())
                {
                    int tp = s.pop();

                    for (int j = tp % 10; j <= 9; j++)
                    {
                        int x = tp * 10 + j;
                        if (x <= n) {
                            s.push(x);
                            result++;
                        }
                    }
                }
            }

            return result;
        }

        // Driven Code
        public static void main_2(String[] args)
        {
            int n = 15;
            System.out.println(countNumber(n));
        }
    }

    /*  Time Complexity : O(x) where x is number of elements printed in output.

        Auxiliary Space : O(x) as it is using stack


    * */





    public static void main(String[] args) {

        /*Ques : There are some natural number whose all permutation is greater than or equal to that number e.g. 123,
                 whose all the permutation (123, 231, 321) are greater than or equal to 123.

                 Given a natural number n, the task is to count all such number from 1 to n.


            Example : 1
            Input   : n = 15.
            Output  : 14
            Explanation :  1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15
                           are the numbers whose all  permutation is greater
                           than the number itself. So, output 14.

            Example : 2
            Input   : n = 100.
            Output  : 54


        * */
    }


}
