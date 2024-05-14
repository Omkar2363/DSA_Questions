package Easy;

public class Ques_LB3 {

    //Ques : Count Squares.......                                                   (GFG Ques.)


    //Approach 1 : Naive approach...
    /*  Naive Approach: To find the floor of the square root, try with all-natural numbers starting from 1.
        Continue incrementing the number until the square of that number is greater than the given number.

        Follow the steps below to implement the above idea

        Create a variable (counter) i and take care of some base cases, (i.e. when the given number is 0 or 1).
        Run a loop until i*i <= n, where n is the given number. Increment i by 1.
        The floor of the square root of the number is i – 1


        Complexity Analysis:

        Time Complexity : O(√X). Only one traversal of the solution is needed, so the time complexity is O(√X).
        Auxiliary Space : O(1).
    * */
    // A Java program to find floor(sqrt(x))
    class GFG {
        // Returns floor of square root of x
        static int floorSqrt(int x)
        {
            // Base cases
            if (x == 0 || x == 1)
                return x;

            // Starting from 1, try all numbers until i*i is greater than or equal to x.
            int i = 1;
            int result = 1;

            while (result <= x) {
                i++;
                result = i * i;
            }
            return i - 1;
        }

        // Driver program
        public static void main_1(String[] args)
        {
            int x = 11;
            System.out.print(floorSqrt(x));
        }
    }



    //Approach 2 : Using Binary Search.........                                    T.C. = O(log(X)),   S.C. = O(1)
    // A Java program to find floor(sqrt(x)
    public class Test {
        public static int floorSqrt(int x)
        {
            // Base Cases
            if (x == 0 || x == 1)
                return x;

            // Do Binary Search for floor(sqrt(x))
            long start = 1;
            long end = x / 2;
            long ans = 0;
            while (start <= end) {
                long mid = (start + end) / 2;

                // If x is a perfect square
                if (mid * mid == x)
                    return (int)mid;

                // Since we need floor, we update answer when mid*mid is smaller than x,
                // and move closer to sqrt(x)
                if (mid * mid < x) {
                    start = mid + 1;
                    ans = mid;
                }
                else                                     // If mid*mid is greater than x
                    end = mid - 1;
            }
            return (int)ans;
        }

        // Driver Method
        public static void main_2(String args[])
        {
            int x = 11;
            System.out.println(floorSqrt(x));
        }
    }



    //Approach 3 : Using STL......                                                T.C. = O(log(X)),   S.C. = O(1)
    class GFG_3 {
        static int countSquares(int x)
        {
            int sqr = (int)Math.sqrt(x);
            int result = (int)(sqr);
            return result;
        }

        public static void main(String[] args)
        {
            int x = 9;
            System.out.print(countSquares(x));
        }
    }



    public static void main(String[] args) {

        /*Ques : Consider a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on.
                 You are given a number N, you have to output the number of integers less than N in the sample space S.


                Example : 1
                Input   : N = 9
                Output  : 2
                Explanation : 1 and 4 are the only Perfect Squares less than 9. So, the Output is 2.


                Example : 2
                Input   : N = 3
                Output  : 1
                Explanation : 1 is the only Perfect Square less than 3. So, the Output is 1.


                Your Task :
                You don't need to read input or print anything. Your task is to complete the function
                countSquares() which takes an Integer N as input and returns the answer.

                Expected Time Complexity: O(sqrt(N))
                Expected Auxiliary Space: O(1)

        * */

    }


}
