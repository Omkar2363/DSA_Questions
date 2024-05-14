package Medium;

import java.util.Arrays;

public class Ques_5 {

    //Ques : Count Inversions.......                                                     (GFG Ques.)


    //Approach 1 : Simple Method.........                                                T.C. = O(n^2),  S.C. = O(1)
    /*  Approach :
        * Traverse through the array, and for every index, find the number of smaller elements
          on its right side of the array. This can be done using a nested loop.
          Sum up the counts for all index in the array and print the sum.

        * Algorithm:
          1. Traverse through the array from start to end
          2. For every element, find the count of elements smaller than the current number
             up to that index using another loop.
          3. Sum up the count of inversion for every index.
          4. Print the count of inversions.
    *
    * */
    // Java program to count inversions in an array
    class Test {
        static int arr[] = new int[] { 1, 20, 6, 4, 5 };
        static int getInvCount(int n){
            int inv_count = 0;
            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++)
                    if (arr[i] > arr[j])
                        inv_count++;

            return inv_count;
        }
        // Driver method to test the above function
        public static void main_1(String[] args){
            System.out.println("Number of inversions are " + getInvCount(arr.length));
        }

    }



    //Approach 2 : Enhanced Merge Sort.......                                           T.C. = O(nLog(n)),  S.C. = O(n)
    // Java implementation of the approach
    public class GFG {

        // Function to count the number of inversions during the merge process
        private static int mergeAndCount(int[] arr, int l, int m, int r)
        {
            // Left subarray
            int[] left = Arrays.copyOfRange(arr, l, m + 1);

            // Right subarray
            int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

            int i = 0;
            int j = 0;
            int k = l;
            int swaps = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j])
                    arr[k++] = left[i++];
                else {
                    arr[k++] = right[j++];
                    swaps += (m + 1) - (l + i);
                }
            }
            while (i < left.length)
                arr[k++] = left[i++];
            while (j < right.length)
                arr[k++] = right[j++];
            return swaps;
        }

        // Merge sort function
        private static int mergeSortAndCount(int[] arr, int l, int r)
        {
            // Keeps track of the inversion count at a particular node of the recursion tree
            int count = 0;
            if (l < r) {
                int m = (l + r) / 2;

                // Total inversion count = left subarray count + right subarray count + merge count

                // Left subarray count
                count += mergeSortAndCount(arr, l, m);

                // Right subarray count
                count += mergeSortAndCount(arr, m + 1, r);

                // Merge count
                count += mergeAndCount(arr, l, m, r);
            }

            return count;
        }

        // Driver code
        public static void main_2(String[] args)
        {
            int[] arr = { 1, 20, 6, 4, 5 };

            System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
        }

    }
    /*
    *   Follow the link for visual representation of the approach.....
    *
    *   Link : https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
    * */




    public static void main(String[] args) {

        /*Ques : Given an array of integers. Find the Inversion Count in the array.

                 Inversion Count: For an array, inversion count indicates how far (or close)
                 the array is from being sorted. If array is already sorted then the inversion count is 0.
                 If an array is sorted in the reverse order then the inversion count is the maximum.

                 Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.


            Example : 1
            Input   : N = 5, arr[] = {2, 4, 1, 3, 5}
            Output  : 3
            Explanation : The sequence 2, 4, 1, 3, 5  has three inversions
                          (2, 1), (4, 1), (4, 3).


            Example : 2
            Input   : N = 5, arr[] = {2, 3, 4, 5, 6}
            Output  : 0
            Explanation : As the sequence is already sorted so there is no inversion count.


            Example : 3
            Input   : N = 3, arr[] = {10, 10, 10}
            Output  : 0
            Explanation : As all the elements of array are same, so there is no inversion count.


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function inversionCount()
            which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

            Expected Time Complexity : O(NLogN).
            Expected Auxiliary Space : O(N).

                    *
                    * */
    }


}
