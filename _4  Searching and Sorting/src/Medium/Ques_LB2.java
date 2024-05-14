package Medium;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.math.BigInteger;

public class Ques_LB2 {

    //Ques : Find Missing And Repeating.......                                          (GFG Ques.)


    //Approach 1 :
    /*  Method 1 : (Use Sorting)
        Approach :  Sort the input array.
                    Traverse the array and check for missing and repeating.
        Time Complexity : O(nLog(n))


        Method 2 : (Use count array)
        Approach : Create a temp array temp[] of size n with all initial values as 0.
                   Traverse the input array arr[], and do following for each arr[i]
                        if(temp[arr[i]] == 0) temp[arr[i]] = 1;
                        if(temp[arr[i]] == 1) output "arr[i]" //repeating
                        Traverse temp[] and output the array element having value as 0 (This is the missing element)
        Time Complexity : O(n)
        Auxiliary Space : O(n)
    *
    * */


    //Approach 2 : Use elements as Index and mark the visited places....               T.C. = O(n),  S.C. = O(1)
    /*      Approach :
            Traverse the array. While traversing, use the absolute value of every element
            as an index and make the value at this index as negative to mark it visited.
            If something is already marked negative then this is the repeating  element.
            To find missing, traverse the array again and look for a positive value.
    *
    * */
    // Java program to Find the repeating and missing elements
    class GFG_2{
        static void printTwoElements(int arr[], int size)
        {
            int i;
            System.out.print("The repeating element is ");

            for (i = 0; i < size; i++) {
                int abs_val = Math.abs(arr[i]);
                if (arr[abs_val - 1] > 0)
                    arr[abs_val - 1] = -arr[abs_val - 1];
                else
                    System.out.println(abs_val);
            }

            System.out.print("and the missing element is ");
            for (i = 0; i < size; i++) {
                if (arr[i] > 0)
                    System.out.println(i + 1);
            }
        }

        // Driver code
        public static void main_2(String[] args)
        {
            int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
            int n = arr.length;
            printTwoElements(arr, n);
        }
    }



    //Approach 3 : Make two equations.......                                          T.C. = O(n),  S.C. = O(1)
    /*      Approach :
            Let x be the missing and y be the repeating element.
            Get the sum of all numbers using formula S = n(n+1)/2 - x + y
            Get product of all numbers using formula P = 1*2*3*...*n * y / x
            The above two steps give us two equations, we can solve the equations and get the values of x and y.

            Time Complexity : O(n)
            Note : This method can cause arithmetic overflow as we calculate product and sum of all array elements.
    *
    * */


    //Approach 4 : Use XOR....                                                        T.C. = O(n),  S.C. = O(1)
    /*      Approach :
            Let x and y be the desired output elements.
            Calculate XOR of all the array elements.
            xor1 = arr[0]^arr[1]^arr[2].....arr[n-1]

            XOR the result with all numbers from 1 to n
            xor1 = xor1^1^2^.....^n

            In the result xor1, all elements would nullify each other except x and y.
            All the bits that are set in xor1 will be set in either x or y. So if we take any
            set bit (We have chosen the rightmost set bit in code) of xor1 and divide the
            elements of the array in two sets – one set of elements with the same bit set and
            other set with same bit not set. By doing so, we will get x in one set and y in another set.
            Now if we do XOR of all the elements in first set, we will get x, and by doing same in other
            set we will get y.
    * */
    // Java program to Find the repeating and missing elements
    class GFG_4{
        static int x, y;
        static void getTwoElements(int arr[], int n)
        {
            /* Will hold xor of all elements and numbers from 1 to n  */
            int xor1;

            /* Will have only single set bit of xor1 */
            int set_bit_no;

            int i;
            x = 0;
            y = 0;

            xor1 = arr[0];

            /* Get the xor of all array elements  */
            for (i = 1; i < n; i++)
                xor1 = xor1 ^ arr[i];

            /* XOR the previous result with numbers from 1 to n   */
            for (i = 1; i <= n; i++)
                xor1 = xor1 ^ i;

            /* Get the rightmost set bit in set_bit_no */
            set_bit_no = xor1 & ~(xor1 - 1);

            /* Now divide elements into two sets by comparing rightmost set-bit of xor1 with the bit at the same
               position in each element. Also, get XORs of two sets. The two XORs are the output elements. The
               following two for loops serve the purpose */
            for (i = 0; i < n; i++) {

                if ((arr[i] & set_bit_no) != 0)
                    /* arr[i] belongs to first set */
                    x = x ^ arr[i];

                else
                    /* arr[i] belongs to second set*/
                    y = y ^ arr[i];
            }
            for (i = 1; i <= n; i++) {
                if ((i & set_bit_no) != 0)
                    /* i belong to first set */
                    x = x ^ i;

                else
                    /* i belong to second set*/
                    y = y ^ i;
            }

            /* *x and *y hold the desired output elements */
        }
        /* Driver program to test above function */
        public static void main_4(String[] args)
        {
            int arr[] = { 1, 3, 4, 5, 1, 6, 2 };

            int n = arr.length;
            getTwoElements(arr, n);
            System.out.println(" The missing element is  " + x + "and the " + "repeating number is " + y);
        }
    }



    //Approach 5 : Use a Map.....                                                    T.C. = O(n),  S.C. = O(n)
    /*      Approach :
            This method involves creating a Hashtable with the help of Map. In this, the elements are
            mapped to their natural index. In this process, if an element is mapped twice,
            then it is the repeating element. And if an element's mapping is not there, then it is the missing element.
    * */
    // Java program to find the repeating and missing elements using Maps
    public class Test1 {

        public static void main(String[] args)
        {
            int[] arr = { 4, 3, 6, 2, 1, 1 };

            Map<Integer, Boolean> numberMap = new HashMap<>();

            int max = arr.length;

            for (Integer i : arr) {

                if (numberMap.get(i) == null) {
                    numberMap.put(i, true);
                }
                else {
                    System.out.println("Repeating = " + i);
                }
            }
            for (int i = 1; i <= max; i++) {
                if (numberMap.get(i) == null) {
                    System.out.println("Missing = " + i);
                }
            }
        }
    }



    //Approach 6 : Make two equations using sum and sum of squares....               T.C. = O(n),  S.C. = O(1)
    /*      Approach :
            Let x be the missing and y be the repeating element.
            Let N is the size of array.
            Get the sum of all numbers using formula S = N(N+1)/2
            Get the sum of square of all numbers using formula Sum_Sq = N(N+1)(2N+1)/6
            Iterate through a loop from i=1....N
            S -= A[i]
            Sum_Sq -= (A[i]*A[i])
            It will give two equations
            x-y = S - (1)
            x^2 - y^2 = Sum_sq
            x+ y = (Sum_sq/S) - (2)
     *
     */
    class GFG_6 {
        static Vector<Integer> repeatedNumber(int[] a)
        {
            BigInteger n = BigInteger.valueOf(a.length);

            BigInteger s = BigInteger.valueOf(0);
            BigInteger ss = BigInteger.valueOf(0);

            for(int x : a)
            {
                s =  s.add(BigInteger.valueOf(x));
                ss = ss.add(BigInteger.valueOf(x).multiply(BigInteger.valueOf(x)));
            }

            BigInteger as = n.multiply(n.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
            BigInteger ass = as.multiply(BigInteger.valueOf(2).multiply(n).add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(3));

            BigInteger sub = as.subtract(s);
            BigInteger add = (ass.subtract(ss)).divide(sub);
            //(ass-ss)/sub;

            int b = sub.add(add).divide(BigInteger.valueOf(2)).intValue();
            //(sub+add)/2;
            int A = BigInteger.valueOf(b).subtract(sub).intValue();
            Vector<Integer> ans = new Vector<>();
            ans.add(A);
            ans.add(b);
            return ans;
        }

        // Driver Code
        public static void main_6(String[] args)
        {
            int[] v = { 4, 3, 6, 2, 1, 6, 7 };
            Vector<Integer> res = repeatedNumber(v);
            for (int x : res)
            {
                System.out.print(x + " ");
            }
        }
    }



    //Approach 7 : Using OR Operator.....                                           T.C. = O(n),  S.C. = O(1)
    /*  Approach :
        Given an input array

        Performing OR operation on input array.
        At the same time checking if that number has occurred before, by determining if the position
        is already set or not. We will get the repeating number in this step.
        To find missing value we have to check the bit containing 0 using OR again.

    *
    * */
    class GFG_7{
        public static void main(String[] args)
        {
            // Input :
            int[] arr = {4, 3, 6, 2, 1, 1};
            int n = arr.length;

            // Declaring output variables
            // Note : arr[i]-1 is used instead of arr[i] as we want to use all 64 bits
            int bitOr = (1 << (arr[0]-1));
            int repeating = 0, missing = 0;

            // Performing XOR as well as Checking repeating number
            for(int i=1; i<n; i++){
                // If OR operation with 1 gives same output that means, we already have 1 at that position
                if((bitOr | (1 << (arr[i]-1))) == bitOr) {
                    repeating = arr[i];
                    continue;
                }
                bitOr = (bitOr | (1 << (arr[i]-1)));
            }

            // Checking missing number
            for(int i = 0; i < n; i++)
            {

                // property : OR with 0 yield 1 hence value of bitOr changes
                if((bitOr | (1 << i)) != bitOr) {
                    missing = i+1;
                    break;
                }
            }

            System.out.print("Repeating : " +  repeating+ "\nMissing : " +  missing);
        }
    }



    //Approach 8 : Placing every element in its correct position......             T.C. = O(n),  S.C. = O(1)
    /*  Approach : It is clear from the observation that if we sort an array,
                   then arr[i] == i+1. If all elements in an array satisfy this condition,
                   means this is an ideal case. So the idea is to sort the given array and
                   traverse on it and check if arr[i] == i + 1 if so then increment i
                   (because this element is at its correct position), otherwise place this element (arr[i])
                   at its correct position (arr[arr[i] - 1) by swapping the arr[i] and arr[arr[i] -1].
                   This swapping will put the element arr[i] at its correct position (i.e arr[arr[i]-1]).
                   After doing this operation gets over for all elements of given array then again traverse over
                   the array and check if arr[i] != i + 1 if so, then this is the duplicate element and i + 1 is
                   the missing element.

    *
    * */
    // Java program to find the missing and repeating element
    public class Main_8 {
        static void swap(int[] arr, int a, int b)
        {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        // Function to find the repeating and missing element
        static void getTwoElements(int[] arr, int n)
        {
            int repeating = 0;
            int missing = 0;

            int i = 0;

            // Traverse on the array
            while (i < n) {
                // If the element is on its correct position
                if (arr[i] == arr[arr[i] - 1]) {
                    i++;
                }
                // If it is not at its correct position then place it to its correct position.
                else {
                    swap(arr, i, arr[i] - 1);
                }
            }

            // Find repeating and missing element.
            for (i = 0; i < n; i++) {
                // If any element is not in its correct position
                if (arr[i] != i + 1) {
                    repeating = arr[i];
                    missing = i + 1;
                    break;
                }
            }

            // Print answer
            System.out.println("Repeating: " + repeating + "\nMissing: " + missing);
        }
        public static void main_8(String[] args)
        {
            int[] arr = { 2, 3, 1, 5, 1 };
            int n = arr.length;
            getTwoElements(arr, n);
        }
    }






    public static void main(String[] args) {

        /*Ques : Given an unsorted array Arr of size N of positive integers. One number 'A' from
                 set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.


            Example : 1
            Input   : N = 2
                      Arr[] = {2, 2}
            Output  : 2 1
            Explanation : Repeating number is 2 and smallest positive missing number is 1.


            Example : 2
            Input   : N = 3
                      Arr[] = {1, 3, 3}
            Output  : 3 2
            Explanation : Repeating number is 3 and smallest positive missing number is 2.


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function findTwoElement()
            which takes the array of integers arr and n as parameters and returns an array of integers of size 2
            denoting the answer ( The first index contains B and second index contains A.)


            Expected Time Complexity : O(N)
            Expected Auxiliary Space : O(1)


        *
        * */
    }


}
