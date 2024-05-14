package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class Ques_9 {

    //Ques : Count distinct elements in every window of size k.............                   (GFG Ques.)


    //Approach 1 : Naive Approach........                                                     T.C. = O(N*(k^2)),  S.C. = O(1)
    /*  Naive Approach for finding the count of distinct numbers in all windows of size K :

            Traverse the given array considering every window of size K in it and keeping a count on
            the distinct elements of the window

        * Follow the given steps to solve the problem:
             1. For every index, i from 0 to N – K, traverse the array from i to i + k using another loop.
                This is the window.
             2. Traverse the window, from i to that index and check if the element is present or not
             3. If the element is not present in the prefix of the array,
                i.e. no duplicate element is present from i to index-1, then increase the count, else ignore it.
             4. Print the count
    *
    * */
    // Java program to count distinct elements in every window of size K
    class Test {

        // Counts distinct elements in window of size K
        static int countWindowDistinct(int win[], int K)
        {
            int dist_count = 0;

            // Traverse the window
            for (int i = 0; i < K; i++)
            {
                // Check if element arr[i] exists in arr[0..i-1]
                int j;
                for (j = 0; j < i; j++)
                    if (win[i] == win[j])
                        break;
                if (j == i)
                    dist_count++;
            }
            return dist_count;
        }

        // Counts distinct elements in all windows of size K
        static void countDistinct(int arr[], int N, int K)
        {
            // Traverse through every window
            for (int i = 0; i <= N - K; i++)
                System.out.println(countWindowDistinct(Arrays.copyOfRange(arr, i, arr.length), K));
        }

        // Driver's code
        public static void main_1(String args[])
        {
            int arr[] = {1, 2, 1, 3, 4, 2, 3}, K = 4;

            // Function call
            countDistinct(arr, arr.length, K);
        }
    }




    //Approach 2 : By using hashMap.........                                                 T.C. = O(n),  S.C. = O(n)
    /*  Count distinct numbers in all windows of size K using hashing :
            So, there is an efficient solution using hashing, though hashing requires extra O(n) space but
            the time complexity will improve. The trick is to use the count of the previous window while
            sliding the window. To do this a hash map can be used that stores elements of the current window.
            The hash-map is also operated on by simultaneous addition and removal of an element while keeping
            track of distinct elements. The problem deals with finding the count of distinct elements in
            a window of length k, at any step while shifting the window and discarding all the computation done
            in the previous step, even though k – 1 elements are same from the previous adjacent window.

            For example : Assume that elements from index i to i + k – 1 are stored in a Hash Map as an element-frequency
                          pair. So, while updating the Hash Map in range i + 1 to i + k, reduce the frequency of
                          the i-th element by 1 and increase the frequency of (i + k)-th element by 1.

                          Insertion and deletion from the HashMap takes constant time.


            * Follow the given steps to solve the problem :
                1. Create an empty hash map. Let the hash map be hm.
                2. Initialize the count of distinct elements as dist_count to 0.
                3. Traverse through the first window and insert elements of the first window to hM.
                   The elements are used as key and their counts as the value in hm. Also, keep updating dist_count
                4. Print distinct count for the first window.
                5. Traverse through the remaining array (or other windows).
                6. Remove the first element of the previous window.
                     a. If the removed element appeared only once, remove it from hM and decrease the distinct count,
                        i.e. do “dist_count–“
                     b. else (appeared multiple times in hM), then decrement its count in hM
                7. Add the current element (last element of the new window)
                     a. If the added element is not present in hM, add it to hM and increase the distinct count,
                        i.e. do “dist_count++”
                     b. Else (the added element appeared multiple times), increment its count in hM

    *
    *
    *
    * */
    // Java program for the above approach
    class CountDistinctWindow {
        static void countDistinct(int arr[], int K)
        {
            // Creates an empty hashMap hM
            HashMap<Integer, Integer> h_map =  new HashMap<Integer, Integer>();

            // Traverse the first window and store count of every element in hash map
            for (int i = 0; i < K; i++)
                h_map.put(arr[i], h_map.getOrDefault(arr[i], 0) + 1);

            // Print count of first window
            System.out.println(h_map.size());

            // Traverse through the remaining array
            for (int i = K; i < arr.length; i++) {

                // Remove first element of previous window If there was only one occurrence
                if (h_map.get(arr[i - K]) == 1)
                {
                    h_map.remove(arr[i - K]);
                }

                else // reduce count of the removed element
                    h_map.put(arr[i - K], h_map.get(arr[i - K]) - 1);

                // Add new element of current window
                // If this element appears first time, set its count as 1,
                h_map.put(arr[i], h_map.getOrDefault(arr[i], 0) + 1);

                // Print count of current window
                System.out.println(h_map.size());
            }
        }

        // Driver's code
        public static void main_2(String arg[])
        {
            int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
            int K = 4;

            // Function call
            countDistinct(arr, K);
        }
    }






    public static void main(String[] args) {

        /*Ques : Given an array of size N and an integer K, return the count of distinct numbers in all
                 windows of size K.


            Example : 1
            Input   : arr[] = {1, 2, 1, 3, 4, 2, 3}, K = 4
            Output  : 3 4 4 3
            Explanation : First window is  {1, 2, 1, 3} count of distinct numbers is 3.
                          Second window is {2, 1, 3, 4} count of distinct numbers is 4.
                          Third window is  {1, 3, 4, 2} count of distinct numbers is 4.
                          Fourth window is {3, 4, 2, 3} count of distinct numbers is 3.

            Example : 2
            Input   : arr[] = {1, 2, 4, 4}, K = 2
            Output  : 2 2 1
            Explanation : First window is {1, 2}, count of distinct numbers is 2.
                          First window is {2, 4}, count of distinct numbers is 2.
                          First window is {4, 4}, count of distinct numbers is 1.


        *
        * */
    }





}
