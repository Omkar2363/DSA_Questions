package Easy;

import java.util.Arrays;

public class Ques_2 {

    //Ques : Counting Sort.......                                                           (GFG Ques)


    //Approach 1 :                                                                          T.C. = O(n+k),  S.C. = O(n+k)
    // Java implementation of Counting Sort
    /*      Time Complexity  :  O(n+k)    where, n is the number of elements in the input array and
                                                 k is the range of input.
            Auxiliary Space  : O(n+k)
    * */
    static class CountingSort {
        void sort(char arr[])
        {
            int n = arr.length;

            // The output character array that will have sorted arr
            char output[] = new char[n];

            // Create a count array to store count of individual
            // characters and initialize count array as 0
            int count[] = new int[256];
            for (int i = 0; i < 256; ++i)
                count[i] = 0;

            // store count of each character
            for (int i = 0; i < n; ++i)
                ++count[arr[i]];

            // Change count[i] so that count[i] now contains actual
            // position of this character in output array
            for (int i = 1; i <= 255; ++i)
                count[i] += count[i - 1];

            // Build the output character array
            // To make it stable we are operating in reverse order.
            for (int i = n - 1; i >= 0; i--) {
                output[count[arr[i]] - 1] = arr[i];
                --count[arr[i]];
            }

            // Copy the output array to arr, so that arr now
            // contains sorted characters
            for (int i = 0; i < n; ++i)
                arr[i] = output[i];
        }

        // Driver method
        public static void main_1(String args[])
        {
            CountingSort ob = new CountingSort();
            char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                           'r', 'g', 'e', 'e', 'k', 's'       };

            ob.sort(arr);

            System.out.print("Sorted character array is ");
            for (int i = 0; i < arr.length; ++i)
                System.out.print(arr[i]);
        }
    }



    //Approach 2 :                                                                         T.C. = O(n),  S.C. = O(n)
    /*      The problem with the previous counting sort was that we could not sort
            the elements if we have negative numbers in it. Because there are no negative array indices.
            So what we do is, we find the minimum element, and we will store the count of that
            minimum element at zero index.
    *
    * */
    // Counting sort which takes negative numbers as well
    class GFG {
        static void countSort(int[] arr)
        {
            int max = Arrays.stream(arr).max().getAsInt();
            int min = Arrays.stream(arr).min().getAsInt();
            int range = max - min + 1;
            int count[] = new int[range];
            int output[] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                count[arr[i] - min]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                output[count[arr[i] - min] - 1] = arr[i];
                count[arr[i] - min]--;
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = output[i];
            }
        }

        static void printArray(int[] arr)
        {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
        }

        // Driver code
        public static void main_2(String[] args)
        {
            int[] arr = { -5, -10, 0, -3, 8, 5, -1, 10 };
            countSort(arr);
            printArray(arr);
        }
    }

    //Note  :
    /*  Points to be noted:

          * Counting sort is efficient if the range of input data is not significantly greater
            than the number of objects to be sorted.
            Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.

          * It is not a comparison-based sorting. Its running time complexity is O(n) with space proportional
            to the range of data.

          * Counting sort is able to achieve this because we are making assumptions about the data we are sorting.

          * It is often used as a sub-routine to another sorting algorithm like radix sort.
          * Counting sort uses partial hashing to count the occurrence of the data object in O(1).

          * Counting sort can be extended to work for negative inputs also.
          * Counting sort is not a stable algorithm. But it can be made stable with some code changes.


                 */


    public static void main(String[] args) {

        /*Ques : Counting sort is a sorting technique based on keys between a specific range.
                 It works by counting the number of objects having distinct key values (kind of hashing).
                 Then do some arithmetic to calculate the position of each object in the output sequence.

                * Characteristics of counting sort:

                  1. Counting sort makes assumptions about the data,
                     for example, it assumes that values are going to be in the range of 0 to 10 or 10 – 99 etc.,
                                  Some other assumptions counting sort makes are input data will be all real numbers.
                  2. Like other algorithms this sorting algorithm is not a comparison-based algorithm,
                     it hashes the value in a temporary count array and uses them for sorting.
                  3. It uses a temporary array making it a non_in Place algorithm.

                Let us understand it with the help of an example.

                For simplicity, consider the data in the range 0 to 9.
                Input data: {1, 4, 1, 2, 7, 5, 2}
                Take a count array to store the count of each unique object.


                // Follow the link for visual illustration....
                // Link : https://www.geeksforgeeks.org/counting-sort/


                //Also see for the various other Sorting Techniques....
        *
        *
        *
        * */
    }



}
