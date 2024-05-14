package Easy;

import java.util.Arrays;

public class Ques_LB_4 {

    //Ques : Minimum sum of two numbers formed from digits of an array........                   (GFG Ques.)


    //Approach 1 : By using Sorting.......
    /*  Minimum sum of two numbers formed from digits of an array using Sorting :
            A minimum number will be formed from set of digits when smallest digit appears at most significant
            position and next smallest digit appears at next most significant position and so on. The idea is to
            sort the array in increasing order and build two numbers by alternating picking digits from the array.
            So first number is formed by digits present in odd positions in the array and second number is formed
            by digits from even positions in the array.

        * Follow the given steps to solve the problem :
            1. Sort the array in increasing order
            2. Declare two variables a and b, representing the two numbers to be formed
            3. Traverse the array and if the index is odd then add this element into a else add it to b
            4. Return the sum of two variables (a + b)

    *
    * */
    // Java program to find minimum sum of two numbers formed from digits of the array.
    class GFG_1 {

        // Function to find and return minimum sum of two numbers formed from digits of the array.
        static int solve(int arr[], int N)
        {
            // sort the array
            Arrays.sort(arr);

            // let two numbers be a and b
            int a = 0, b = 0;
            for (int i = 0; i < N; i++) {

                // fill a and b with every alternate digit of input array
                if (i % 2 != 0)
                    a = a * 10 + arr[i];
                else
                    b = b * 10 + arr[i];
            }

            // return the sum
            return a + b;
        }

        // driver's code
        public static void main_1(String[] args)
        {
            int arr[] = { 6, 8, 4, 5, 2, 3 };
            int N = arr.length;

            System.out.print("Sum is " + solve(arr, N));
        }
    }

    /*  Time Complexity : O(N*log2N) bacause of arr.sort()........(Base of log is 2).
        Auxiliary Space : O(1)
    *
    * */




    //Approach 2 :
    /*  Minimum sum of two numbers formed from digits of an array for large numbers using Strings :
            The basic idea of approaching the question is the same as above, but instead of using numbers,
            strings will be used to handle sum of two large numbers

        * Follow the given steps to solve the problem :
            1. Sort the array in increasing order
            2. Declare two strings a and b, representing the two numbers to be formed
            3. Traverse the array and if the index is odd then add this element into string a, else add it to the string b
            4. Return the sum of two strings, in the form of a string

    *
    * */
    // Java code for the above approach
    class Main {

        public static String reverseString(String str)
        {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            return sb.toString();
        }

        public static String solve(int[] arr, int N)
        {
            Arrays.sort(arr);

            // Two String for storing our two minimum numbers
            String a = "", b = "";

            for (int i = 0; i < N; i += 2) {
                a += Integer.toString(arr[i]);
            }
            for (int i = 1; i < N; i += 2) {
                b += Integer.toString(arr[i]);
            }

            int j = a.length() - 1;
            int k = b.length() - 1;

            // As initial carry is zero
            int carry = 0;
            String ans = "";
            while (j >= 0 && k >= 0) {

                int sum = 0;
                sum += (a.charAt(j) - '0') + (b.charAt(k) - '0')
                        + carry;
                int x = sum % 10;
                ans += Integer.toString(sum % 10);
                carry = sum / 10;
                j--;
                k--;
            }

            // If string b is over and string a is left here we do not need to put here while condition
            // as it would run at max one time. Because the difference between both the strings could be at max 1.
            while (j >= 0) {
                int sum = 0;
                sum += (a.charAt(j) - '0') + carry;
                ans += Integer.toString(sum % 10);
                carry = sum / 10;
                j--;
            }

            // If string a is over and string b is left
            while (k >= 0) {
                int sum = 0;
                sum += (b.charAt(k) - '0') + carry;
                ans += Integer.toString(sum % 10);
                carry = sum / 10;
                k--;
            }
            // if carry is left
            if (carry != 0) {
                ans += Integer.toString(carry);
            }

            // to remove leading zeroes as they will be ahead of our sum
            while (ans.isEmpty() == false  &&  ans.charAt(ans.length() - 1) == '0')
                ans = ans.substring(0, ans.length() - 1);

            // reverse our final string because we were storing sum from left to right
            ans = reverseString(ans);
            return ans;
        }

        // driver's code
        public static void main_2(String[] args)
        {
            int[] arr = { 6, 8, 4, 5, 2, 3 };
            int N = arr.length;

            // Function call
            System.out.print("Sum is " + solve(arr, N));
        }
    }

    /*  Time complexity : O(Nlog2N) because we are sorting the given array.......(Base of log is 2)
        Auxiliary Space : O(N)
    * */







    public static void main(String[] args) {

        /*Ques : Given an array of digits (values are from 0 to 9), the task is to find the minimum possible
                 sum of two numbers formed from digits of the array. Please note that all digits of the given
                 array must be used to form the two numbers.

            Example : 1
            Input   : {6, 8, 4, 5, 2, 3}
            Output  : 604
            Explanation : The minimum sum is formed by numbers 358 and 246


            Example : 2
            Input   : {5, 3, 0, 7, 4}
            Output  : 82
            Explanation : The minimum sum is formed by numbers 35 and 047


        *
        * */
    }



}
