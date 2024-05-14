package Medium;

import java.util.HashMap;

public class Ques_8 {

    //Ques : Find the length of the largest subarray with 0 sum.........                      (GFG Ques.)


    //Approach 1 : Naive Approach......                                                       T.C. = O(n^2),  S.C. = O(1)
    /*  Naive Approach :

        * Follow the steps below to solve the problem using this approach :
            1. Consider all sub-arrays one by one and check the sum of every sub-array.
            2. If the sum of the current subarray is equal to zero then update the maximum length accordingly
    *
    * */
    // Java code for the above approach
    class GFG {

        // Returns length of the largest subarray with 0 sum
        static int maxLen(int arr[], int N)
        {
            int max_len = 0;

            // Pick a starting point
            for (int i = 0; i < N; i++) {

                // Initialize curr_sum for every starting point
                int curr_sum = 0;

                // try all subarrays starting with 'i'
                for (int j = i; j < N; j++) {
                    curr_sum += arr[j];

                    // If curr_sum becomes 0, then update max_len
                    if (curr_sum == 0)
                        max_len = Math.max(max_len, j - i + 1);
                }
            }
            return max_len;
        }

        // Driver's code
        public static void main_1(String args[])
        {
            int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
            int N = arr.length;

            // Function call
            System.out.println("Length of the longest 0 sum " + "subarray is " + maxLen(arr, N));
        }
    }





    //Approach 2 : By using HashMap.........                                                 T.C. = O(n),   S.C. = O(n)
    /*  Follow the steps mentioned below to implement the approach :
           1. Create a variable (sum), length (max_len), and a hash map (hm) to store the sum-index pair as a key-value pair.
           2. Traverse the input array and for every index,
               a. Update the value of sum = sum + array[i].
               b. Check every index, if the current sum is present in the hash map or not.
               c. If present, update the value of max_len to a maximum difference of two indices (current index and index in the hash-map) and max_len.
               d. Else, put the value (sum) in the hash map, with the index as a key-value pair.
           3. Print the maximum length (max_len).

    *
    *
    * */
    // Java program for the above approach
    class MaxLenZeroSumSub {

        // Returns length of the maximum length subarray with 0 sum
        static int maxLen(int arr[])
        {
            // Creates an empty hashMap hM
            HashMap<Integer, Integer> h_map = new HashMap<Integer, Integer>();

            int sum = 0;                               // Initialize sum of elements
            int max_len = 0;                           // Initialize result

            // Traverse through the given array
            for (int i = 0; i < arr.length; i++)
            {
                // Add current element to sum
                sum += arr[i];

                if (sum == 0)
                    max_len = i + 1;

                // Look this sum in hash table
                Integer prev_i = h_map.get(sum);

                // If this sum is seen before, then update max_len if required
                if (prev_i != null)
                    max_len = Math.max(max_len, i - prev_i);

                else
                    // Else put this sum in hash table
                    h_map.put(sum, i);
            }

            return max_len;
        }

        // Drive's code
        public static void main_2(String arg[])
        {
            int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

            // Function call
            System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr));
        }
    }






    public static void main(String[] args) {

        /*Ques : Given an array arr[] of length N, find the length of the longest sub-array with a sum equal to 0.


            Example : 1
            Input   : arr[] = {15, -2, 2, -8, 1, 7, 10, 23}
            Output  : 5
            Explanation : The longest sub-array with elements summing up-to 0 is {-2, 2, -8, 1, 7}

            Example : 2
            Input   : arr[] = {1, 2, 3}
            Output  : 0
            Explanation : There is no subarray with 0 sum


            Example : 3
            Input   :  arr[] = {1, 0, 3}
            Output  :  1
            Explanation : The longest sub-array with elements summing up-to 0 is {0}


        *
        * */
    }




}
