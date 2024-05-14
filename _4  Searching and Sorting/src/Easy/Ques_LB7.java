package Easy;

public class Ques_LB7 {

    //Ques : Product array puzzle......                                                 (GFG Ques.)


    //Approach 1 : Naive Approach.....                                                  T.C. = (n),  S.C. = O(n)
    /*  Approach : Create two extra space, i.e. two extra arrays to store the product
                   of all the array elements from start, up to that index and another
                   array to store the product of all the array elements from the end of the array to that index.

                   To get the product excluding that index, multiply the prefix product up to index i-1 with the
                   suffix product up to index i+1.

        Algorithm:

        1. Create two array prefix and suffix of length n,
                i.e. length of the original array, initialize prefix[0] = 1 and suffix[n-1] = 1
                     and also another array to store the product.

        2. Traverse the array from second index to end.
        3. For every index ith update prefix[i] as prefix[i] = prefix[i-1] * array[i-1],
                i.e store the product up-to i-1 index from the start of array.

        4. Traverse the array from second last index to start.
        5. For every index ith update suffix[i] as suffix[i] = suffix[i+1] * array[i+1],
                i.e. store the product up-to i+1 index from the end of array

        6. Traverse the array from start to end.
        7. For every index i the output will be prefix[i] * suffix[i], the product of the array element except that element.

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



    //Approach 2 : Efficient approach.....                                             T.C. = (n),  S.C. = O(n)
    /*  Approach: In the previous solution, two extra arrays were created to store the prefix
                  and suffix, in this solution store the prefix and suffix product in the
                  output array (or product array) itself. Thus reducing the space required.

        Algorithm:

        1. Create an array product and initialize its value to 1 and a variable temp = 1.
        2. Traverse the array from start to end.
        3. For every index ith update product[i] as product[i] = temp and temp = temp * array[i],
                i.e. store the product up-to i-1 index from the start of array.

        4. initialize temp = 1 and traverse the array from last index to start.
        5. For every index i update product[i] as product[i] = product[i] * temp and temp = temp * array[i],
                i.e. multiply with the product up-to i+1 index from the end of array.

        6. Print the product array.
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



    //Approach 3 : Another efficient approach.......                                  T.C. = (n),  S.C. = O(1)
    /*      Store the product of all the elements is a variable and then iterate the array
            and add product/current_index_value in a new array. and then return this new array.
    *
    * */
    // Java program for the above approach
    class Solution_3{

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

                // if number of elements in array with value 0 is more than 1 than each
                // value in new array will be equal to 0
                if (flag > 1) {
                    arr[i] = 0;
                }

                // if no element having value 0 than we will
                // insert product/a[i] in new array
                else if (flag == 0)
                    arr[i] = (prod / a[i]);

                    // if 1 element of array having value 0 than all the elements except that index
                    // value , will be equal to 0
                else if (flag == 1 && a[i] != 0) {
                    arr[i] = 0;
                }

                // if(flag == 1 && a[i] == 0)
                else
                    arr[i] = prod;
            }
            return arr;
        }

        /* Driver Code
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
        }*/

    }




    public static void main(String[] args) {

        /*Ques : Given an array nums[] of size n, construct a Product Array P (of same size n)
                 such that P[i] is equal to the product of all the elements of nums except nums[i].


                Example : 1
                Input   : n = 5
                          nums[] = {10, 3, 5, 6, 2}
                Output  : 180 600 360 300 900
                Explanation :   For i=0, P[i] = 3*5*6*2 = 180.
                                For i=1, P[i] = 10*5*6*2 = 600.
                                For i=2, P[i] = 10*3*6*2 = 360.
                                For i=3, P[i] = 10*3*5*2 = 300.
                                For i=4, P[i] = 10*3*5*6 = 900.

                Example : 2
                Input   : n = 2
                          nums[] = {12,0}
                Output  : 0 12


                Your Task :
                You do not have to read input. Your task is to complete the function productExceptSelf()
                that takes array nums[] and n as input parameters and returns a list of n integers denoting
                the product array P. If the array has only one element the returned list should contain one value i.e. { 1 }.

                Note : Try to solve this problem without using the division operation.


                Expected Time Complexity : O(n)
                Expected Auxiliary Space : O(n)


        * */

    }


}
