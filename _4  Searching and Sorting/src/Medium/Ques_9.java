package Medium;

import java.io.IOException;

public class Ques_9 {

    //Ques : Product of Array except itself.......                                    (GFG Ques.)


    //Approach 1 : Naive approach....                                                 T.C. = O(n),  S.C. = O(n)
    /*  Naive Solution :
        Approach : Create two extra space,
                   i.e. two extra arrays to store the product of all the array elements from start,
                        up to that index and another array to store the product of all the array elements
                        from the end of the array to that index.

                   To get the product excluding that index, multiply the prefix product up to index i-1 with
                   the suffix product up to index i+1.


         Complexity Analysis:
         Time Complexity  : O(n).
                            The array needs to be traversed three times, so the time complexity is O(n).
         Space Complexity : O(n).
                            Two extra arrays and one array to store the output is needed so the space complexity is O(n)


    *
    * */
    static class ProductArray {
        /* Function to print product array for a given array arr[] of size n */
        void productArray(int arr[], int n)
        {
            // Base case
            if (n == 1) {
                System.out.print(0);
                return;
            }
            // Initialize memory to all arrays
            int left[] = new int[n];
            int right[] = new int[n];
            int prod[] = new int[n];

            int i, j;

            /* Left most element of left array is always 1 */
            left[0] = 1;

            /* Right most element of right array is always 1 */
            right[n - 1] = 1;

            /* Construct the left array */
            for (i = 1; i < n; i++)
                left[i] = arr[i - 1] * left[i - 1];

            /* Construct the right array */
            for (j = n - 2; j >= 0; j--)
                right[j] = arr[j + 1] * right[j + 1];

            /* Construct the product array using left[] and right[] */
            for (i = 0; i < n; i++)
                prod[i] = left[i] * right[i];

            /* print the constructed prod array */
            for (i = 0; i < n; i++)
                System.out.print(prod[i] + " ");

            return;
        }

        /* Driver program to test the above function */
        public static void main_1(String[] args)
        {
            ProductArray pa = new ProductArray();
            int arr[] = { 10, 3, 5, 6, 2 };
            int n = arr.length;
            System.out.println("The product array is : ");
            pa.productArray(arr, n);
        }
    }



    //Approach 2 : Space Optimized approach.....                                     T.C. = O(n),  S.C. = O(n)
    /*  Approach : In the previous solution, two extra arrays were created
                   to store the prefix and suffix, in this solution store
                   the prefix and suffix product in the output array (or product array) itself.
                   Thus reducing the space required.


        Complexity Analysis :
        Time Complexity  : O(n).
                           The original array needs to be traversed only once, so the time complexity is constant.
        Space Complexity : O(n).
                           Even though the extra arrays are removed, the space complexity remains O(n),
                           as the product array is still needed.
     *
    * */
    static class ProductArray_2 {
        void productArray(int arr[], int n)
        {
            // Base case
            if (n == 1) {
                System.out.print("0");
                return;
            }

            int i, temp = 1;

            /* Allocate memory for the product array */
            int prod[] = new int[n];

            /* Initialize the product array as 1 */
            for (int j = 0; j < n; j++)
                prod[j] = 1;

            /* In this loop, temp variable contains product of elements on left side excluding arr[i] */
            for (i = 0; i < n; i++) {
                prod[i] = temp;
                temp *= arr[i];
            }

            /* Initialize temp to 1 for product on right side */
            temp = 1;

            /* In this loop, temp variable contains product of elements on right side excluding arr[i] */
            for (i = n - 1; i >= 0; i--) {
                prod[i] *= temp;
                temp *= arr[i];
            }

            /* print the constructed prod array */
            for (i = 0; i < n; i++)
                System.out.print(prod[i] + " ");

            return;
        }

        /* Driver program to test above functions */
        public static void main_2(String[] args)
        {
            ProductArray_2 pa = new ProductArray_2();
            int arr[] = { 10, 3, 5, 6, 2 };
            int n = arr.length;
            System.out.println("The product array is : ");
            pa.productArray(arr, n);
        }
    }



    //Approach 3 : Another approach......                                           T.C. = O(n),  S.C. = O(1)
    /*  Store the product of all the elements is a variable and then iterate the
        array and add product/current_index_value in a new array. and then return this new array.
    *
    * */
    // Java program for the above approach
    static class Solution {
        public static long[] productExceptSelf(int a[], int n)
        {
            long prod = 1;
            long flag = 0;

            // product of all elements
            for (int i = 0; i < n; i++) {

                // counting number of elements which have value 0
                if (a[i] == 0)
                    flag++;
                else
                    prod *= a[i];
            }

            // creating a new array of size n
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {

                // if number of elements in array with value 0 is more than 1
                // than each value in new array will be equal to 0
                if (flag > 1) {
                    arr[i] = 0;
                }

                // if no element having value 0 than we will
                // insert product/a[i] in new array
                else if (flag == 0)
                    arr[i] = (prod / a[i]);

                    // if 1 element of array having value 0 than all
                    // the elements except that index value , will be equal to 0
                else if (flag == 1 && a[i] != 0) {
                    arr[i] = 0;
                }

                // if(flag == 1 && a[i] == 0)
                else
                    arr[i] = prod;
            }
            return arr;
        }

        // Driver Code
        public static void main(String args[])
                throws IOException
        {
            int n = 5;
            int[] array = { 10, 3, 5, 6, 2 };

            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an array arr[] of n integers, construct a Product Array prod[] (of same size)
                 such that prod[i] is equal to the product of all the elements of arr[] except arr[i].
                 Solve it without division operator in O(n) time.


            Example : 1
            Input   : arr[]  = {10, 3, 5, 6, 2}
            Output  : prod[]  = {180, 600, 360, 300, 900}
                        3 * 5 * 6 * 2 product of other array
                        elements except 10 is 180
                        10 * 5 * 6 * 2 product of other array
                        elements except 3 is 600
                        10 * 3 * 6 * 2 product of other array
                        elements except 5 is 360
                        10 * 3 * 5 * 2 product of other array
                        elements except 6 is 300
                        10 * 3 * 6 * 5 product of other array
                        elements except 2 is 900


            Example : 2
            Input   : arr[]  = {1, 2, 3, 4, 5}
            Output  : prod[]  = {120, 60, 40, 30, 24 }
                        2 * 3 * 4 * 5  product of other array
                        elements except 1 is 120
                        1 * 3 * 4 * 5  product of other array
                        elements except 2 is 60
                        1 * 2 * 4 * 5  product of other array
                        elements except 3 is 40
                        1 * 2 * 3 * 5  product of other array
                        elements except 4 is 30
                        1 * 2 * 3 * 4  product of other array
                        elements except 5 is 24

        *
        * */
    }


}
