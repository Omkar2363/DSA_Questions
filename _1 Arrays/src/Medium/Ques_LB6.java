package Medium;

import java.math.BigInteger;
import java.util.Scanner;

public class Ques_LB6 {

    //Ques : Factorials of large numbers....                                              (GFG Ques.)

    //Approach 1 : Find the Factorial of a large number using Basic Mathematics           T.C. =  O(N log (N!)), S.C. = (max(digits in factorial))
    /*The idea is to use basic mathematics for multiplication.
    * Follow the link for illustration of the approach.
    *   link : https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers/0
    * */
    // This function finds factorial of large numbers and prints them
    static void factorial(int n){

        int res[] = new int[500];

        // Initialize result
        res[0] = 1;
        int res_size = 1;

        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        System.out.println("Factorial of given number is ");

        for (int i = res_size - 1; i >= 0; i--)
            System.out.print(res[i]);
    }
    /*
     This function multiplies x with the number represented by res[]. res_size is size of res[] or
     number of digits in the number represented by res[].
     This function uses simple school mathematics for multiplication. This function may value of res_size
     and returns the new value of res_size
    */
    static int multiply(int x, int res[], int res_size){
        int carry = 0;                // Initialize carry

        // One by one multiply n with individual digits of res[]
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;                // Store last digit of
            // 'prod' in res[]
            carry = prod / 10;                 // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }


    //Approach 2 : Find the Factorial of a large number using Basic BigInteger
    // Java program to find large factorials using BigInteger
    public class Example {

        // Returns Factorial of N
        static BigInteger factorial(int N){
            // Initialize result
            BigInteger f = new BigInteger("1"); // Or BigInteger.ONE

            // Multiply f with 2, 3, ...N
            for (int i = 2; i <= N; i++)
                f = f.multiply(BigInteger.valueOf(i));

            return f;
        }

        /* Driver method
        public static void main(String args[]) throws Exception
        {
            int N = 20;
            System.out.println(factorial(N));
        }*/
    }


    //Note : search for BigInteger class and methods in java.

    public static void main(String[] args) {

        /*Ques : Given an integer N, find its factorial.


            Example : 1
            Input   : N = 5
            Output  : 120
            Explanation : 5! = 1*2*3*4*5 = 120


            Example : 2
            Input   : N = 10
            Output  : 3628800
            Explanation :
            10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

            Your Task:
            You don't need to read input or print anything. Complete the function factorial() that takes integer
            N as input parameter and returns a list of integers denoting the digits that make up the factorial of N.


            Expected Time Complexity : O(N2)
            Expected Auxilliary Space : O(1)

            NOTE : Why conventional way of computing factorial fails for large numbers?
                   A factorial of 100 has 158 digits. It is not possible to store these many digits even
                   if we use long long int.

                   Input  : 50
                   Output : 3041409320171337804361260816606476884-
                            4377641568960512000000000000

                   Input  : 100
                   Output : 933262154439441526816992388562667004-
                            907159682643816214685929638952175999-
                            932299156089414639761565182862536979-
                            208272237582511852109168640000000000-
                            00000000000000
        * */
    }
}
