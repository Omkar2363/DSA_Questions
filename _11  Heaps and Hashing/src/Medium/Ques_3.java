package Medium;

public class Ques_3 {

    //Ques : Find the maximum repeating number in O(n) time and O(1) extra space.........          (GFG Ques.)

    //Approach 1 : Naive Approach.......                                                           T.C. = O(n^2)
    /*  The naive approach is to run two loops, the outer loop picks an element one by one, and
        the inner loop counts a number of occurrences of the picked element.
        Finally, return the element with a maximum count. The time complexity of this approach is O(n^2).
    *
    * */


    //Approach 2 : Efficient Approach.......                                                      T.C. = O(n),  S.C. = O(1)
    // Java program to find the maximum repeating number
    class MaxRepeating {

        // Returns maximum repeating element in arr[0...n-1].
        // The array elements are in range from 0 to k-1
        static int maxRepeating(int arr[], int n, int k)
        {
            // Iterate though input array, for every element arr[i],
            // increment arr[arr[i]%k] by k
            for (int i = 0; i< n; i++)
                arr[(arr[i]%k)] += k;

            // Find index of the maximum repeating element
            int max = arr[0], result = 0;
            for (int i = 1; i < n; i++)
            {
                if (arr[i] > max)
                {
                    max = arr[i];
                    result = i;
                }
            }

            /* Uncomment this code to get the original array back
            for (int i = 0; i< n; i++)
              arr[i] = arr[i]%k;
            */

            // Return index of the maximum element
            return result;
        }

        /*Driver function to check for above function*/
        public static void main_2(String[] args)
        {

            int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
            int n = arr.length;
            int k=8;
            System.out.println("Maximum repeating element is: " + maxRepeating(arr,n,k));
        }
    }



    public static void main(String[] args) {

        /*Ques : Given an array of size n, the array contains numbers in the range from 0 to k-1 where k is a positive integer
                 and k <= n. Find the maximum repeating number in this array.

                 For example, let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3},
                              the maximum repeating number would be 2. The expected time complexity is O(n) and
                              extra space allowed is O(1).
                 Modifications to array are allowed.
        *
        * */
    }



}
