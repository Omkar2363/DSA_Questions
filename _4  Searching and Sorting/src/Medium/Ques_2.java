package Medium;

import java.util.Arrays;

public class Ques_2 {

    //Ques : Count triplets with sum smaller than a given value.......                   (GFG Ques.)

    //Approach 1 : Simple approach......                                                 T.C. = O(n^3),  S.C. = O(1)
    /*      A Simple Solution is to run three loops to consider all triplets one by one.
            For every triplet, compare the sums and increment count if the triplet sum is smaller than the given sum.
     *
    * */
    // A Simple Java program to count triplets with sum smaller than a given value
    class Test_1 {
        static int arr[] = new int[]{5, 1, 3, 4, 7};

        static int countTriplets(int n, int sum)
        {
            // Initialize result
            int ans = 0;

            // Fix the first element as A[i]
            for (int i = 0; i < n-2; i++)
            {
                // Fix the second element as A[j]
                for (int j = i+1; j < n-1; j++)
                {
                    // Now look for the third number
                    for (int k = j+1; k < n; k++)
                        if (arr[i] + arr[j] + arr[k] < sum)
                            ans++;
                }
            }

            return ans;
        }

        // Driver method to test the above function
        public static void main_1(String[] args)
        {
            int sum = 12;
            System.out.println(countTriplets(arr.length, sum));
        }
    }




    //Approach 2 : Efficient Approach......                                             T.C. = O(n^2),  S.C. = O(1)
    /*  An Efficient Solution can count triplets in O(n2) by sorting the array first,
        and then using method 1 of this post in a loop.

        1) Sort the input array in increasing order.
        2) Initialize result as 0.
        3) Run a loop from i = 0 to n-2.  An iteration of this loop finds all
           triplets with arr[i] as first element.
             a) Initialize other two elements as corner elements of subarray
                arr[i+1..n-1], i.e., j = i+1 and k = n-1
             b) Move j and k toward each other until they meet, i.e., while (j<k),
                    (i) If arr[i] + arr[j] + arr[k] >= sum
                        then k--
                    // Else for current i and j, there can (k-j) possible third elements
                    // that satisfy the constraint.
                    (ii) Else Do ans += (k - j) followed by j++

    *
    * */
    // A Simple Java program to count triplets with sum smaller than a given value
    class Test_2 {
        static int arr[] = new int[]{5, 1, 3, 4, 7};
        static int countTriplets(int n, int sum)
        {
            // Sort input array
            Arrays.sort(arr);

            // Initialize result
            int ans = 0;

            // Every iteration of loop counts triplet with first element as arr[i].
            for (int i = 0; i < n - 2; i++)
            {
                // Initialize other two elements as corner elements of subarray arr[j+1...k]
                int j = i + 1, k = n - 1;

                // Use Meet in the Middle concept
                while (j < k)
                {
                    // If sum of current triplet is more or equal, move right corner to look for smaller values
                    if (arr[i] + arr[j] + arr[k] >= sum)
                        k--;

                        // Else move left corner
                    else
                    {
                        // This is important. For current i and j, there can be total k-j third elements.
                        ans += (k - j);
                        j++;
                    }
                }
            }
            return ans;
        }

        // Driver method to test the above function
        public static void main_2(String[] args)
        {
            int sum = 12;
            System.out.println(countTriplets(arr.length, sum));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an array of distinct integers and a sum value. Find count of triplets
                 with sum smaller than given sum value. The expected Time Complexity is O(n2).


            Example : 1
            Input   : arr[] = {-2, 0, 1, 3}
                      sum = 2.
            Output  : 2
            Explanation :  Below are triplets with sum less than 2
                           (-2, 0, 1) and (-2, 0, 3)


            Example : 2
            Input   : arr[] = {5, 1, 3, 4, 7}
                      sum = 12.
            Output  : 4
            Explanation :  Below are triplets with sum less than 12
                           (1, 3, 4), (1, 3, 5), (1, 3, 7) and
                           (1, 4, 5)

        * */
    }


}
