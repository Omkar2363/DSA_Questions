package Medium;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

import java.io.*;
import java.util.PriorityQueue;

public class Ques_LB7 {

    //Ques : Longest consecutive subsequence....                                        (GFG Ques.)

    //Approach 1 : Naive approach....                                                   T.C. = O(nlog(n)), S.C. = O(n)
    /*Naive Approach :
            The idea is to first sort the array and find the longest subarray with consecutive elements.
            After sorting the array and removing the multiple occurrences of elements, run a loop and keep a count
            and max (both initially zero). Run a loop from start to end and if the current element is not equal to the
            previous (element+1) then set the count to 1 else increase the count. Update max with a maximum of count and max.

    Follow link for illustration :
    Link : https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
    * */
    static int findLongestConsecSubseq_1(int arr[], int n) {

        // Sort the array
        Arrays.sort(arr);

        int ans = 0, count = 0;

        ArrayList<Integer> v = new ArrayList<Integer>();
        v.add(10);

        // Insert repeated elements only once in the vector
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1])
                v.add(arr[i]);
        }

        // Find the maximum length by traversing the array
        for (int i = 0; i < v.size(); i++) {

            // Check if the current element is equal to previous element +1
            if (i > 0 && v.get(i) == v.get(i - 1) + 1)
                count++;
            else
                count = 1;

            // Update the maximum
            ans = Math.max(ans, count);
        }
        return ans;

    /* Driver code
    public static void main(String[] args)
    {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;

        System.out.println("Length of the Longest " + "contiguous subsequence is "
                        + findLongestConsecSubseq(arr, n));
    }*/
    }


    //Approach 2 : Using Hashing....                                                   T.C. = O(n), S.C. = O(n)
    static int findLongestConsecSubseq_2(int arr[], int n){

        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start then update optimal length
        for (int i = 0; i < n; ++i) {

            // if current element is the starting element of a sequence
            if (!S.contains(arr[i] - 1)) {

                // Then check for next elements in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }



    //Approach 3 : Priority Queue....                                                 T.C. = O(nlog(n)), S.C. = O(n)
    //Complete Java Program.
    public class Longset_Sub {

        // return the length of the longest subsequence of consecutive integers
        static int findLongestConseqSubseq(int arr[], int N)
        {

            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for (int i = 0; i < N; i++){

                // adding element from array to PriorityQueue
                pq.add(arr[i]);
            }

            // Storing the first element of the Priority Queue
            // This first element is also the smallest element
            int prev = pq.poll();

            // Taking a counter variable with value 1
            int c = 1;

            // Storing value of max as 1 as there will always be one element
            int max = 1;

            for (int i = 1; i < N; i++) {

                // check if current peek element minus previous element is greater than
                // 1 This is done because if it's greater than 1 then the sequence
                // doesn't start or is broken here
                if (pq.peek() - prev > 1) {

                    // Store the value of counter to 1
                    // As new sequence may begin
                    c = 1;

                    // Update the previous position with the
                    // current peek And remove it
                    prev = pq.poll();
                }

                // Check if the previous element and peek are same
                else if (pq.peek() - prev == 0) {

                    // Update the previous position with the current peek And remove it
                    prev = pq.poll();
                }

                // if the difference between previous element and peek is 1
                else {

                    // Update the counter
                    // These are consecutive elements
                    c++;

                    // Update the previous position
                    //  with the current peek And remove it
                    prev = pq.poll();
                }

                // Check if current longest subsequence is the greatest
                if (max < c) {

                    // Store the current subsequence count as max
                    max = c;
                }
            }

            return max;
        }

        /* Driver Code
        public static void main(String args[])
                throws IOException
        {
            int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
            int n = arr.length;
            System.out.println("Length of the Longest consecutive subsequence is "
                            + findLongestConseqSubseq(arr, n));
        }*/
    }




    public static void main(String[] args) {

        /*Ques : Given an array of positive integers. Find the length of the longest sub-sequence such that
                 elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.


                Example : 1
                Input   : N = 7
                          a[] = {2,6,1,9,4,5,3}
                Output  : 6
                Explanation : The consecutive numbers here are 1, 2, 3, 4, 5, 6.
                              These 6 numbers form the longest consecutive subsquence.

                Example : 2
                Input   : N = 7
                          a[] = {1,9,3,10,4,20,2}
                Output  : 4
                Explanation : 1, 2, 3, 4 is the longest consecutive subsequence.

                Your Task:
                You don't need to read input or print anything. Your task is to complete the
                function findLongestConseqSubseq() which takes the array arr[] and the size of
                the array as inputs and returns the length of the longest subsequence of consecutive integers.


                Expected Time Complexity: O(N).
                Expected Auxiliary Space: O(N).

        * */
    }

}
