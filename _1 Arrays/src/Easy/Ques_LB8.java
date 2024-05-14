package Easy;

import java.util.HashSet;
import java.util.Set;

public class Ques_LB8 {

    //Ques : Subarray with 0 sum....                                                  (GFG Ques)

    //Approach 1 : Naive approach....                                                 T.C. = O(n^2),  S.C. = O(1)
    /*Naive approach:
            Consider all subarrays one by one and check the sum of every subarray.
            Run two loops: the outer loop picks a starting point i and the inner loop tries all subarrays
            starting from i (See this for implementation).

            Time Complexity : O(N2)
            Auxiliary Space : O(1)

            Similar Ques : Medium / Ques_LB5
    */

    //Approach 2 : Find if there is a subarray with 0 sum Using hashing....           T.C. = O(n),  S.C. = O(n)

    // Returns true if arr[] has a subarray with zero sum
    static Boolean subArrayExists(int arr[]) {

        // Creates an empty hashset hs
        Set<Integer> hs = new HashSet<Integer>();

        // Initialize sum of elements
        int sum = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {

            // Add current element to sum
            sum += arr[i];

            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash set
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
                return true;

            // Add sum to hash set
            hs.add(sum);
        }

        // We reach here only when there is no subarray with 0 sum
        return false;


    /* Driver's code
    public static void main(String arg[])
    {
        int arr[] = {-3, 2, 3, 1, 6};

        // Function call
        if (subArrayExists(arr))
            System.out.println(
                    "Found a subarray with 0 sum");
        else
            System.out.println("No Such Sub Array Exists!");
    }*/
    }


    public static void main(String[] args) {

        /*Ques : Given an array of positive and negative numbers.
                 Find if there is a subarray (of size at-least one) with 0 sum.


                Example : 1
                Input   : 5
                          4 2 -3 1 6
                Output  : Yes
                Explanation : 2, -3, 1 is the subarray with sum 0.


                Example : 2
                Input   : 5
                          4 2 0 1 6
                Output  : Yes
                Explanation : 0 is one of the element in the array so there exist a  subarray with sum 0.


                Your Task:
                You only need to complete the function subArrayExists() that takes array and n as parameters and returns
                true or false depending upon whether there is a subarray present with 0-sum or not.
                Printing will be taken care by the drivers code.

                Expected Time Complexity : O(n).
                Expected Auxiliary Space : O(n).

        * */

    }


}


