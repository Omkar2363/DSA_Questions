package Medium;

public class Ques_LB5 {

    //Ques : Find Subarray with given sum | Set 1 (Non-negative Numbers) ....(GFG Ques.)         (Supportive question : Easy / Ques_LB8)


    //Approach 1 : Find subarray with given sum using Nested loop                                T.C. = O(n^2), S.C. = O(1)
    void subArraySum_1(int arr[], int n, int sum) {

        // Pick a starting point
        for (int i = 0; i < n; i++) {
            int currentSum = arr[i];

            if (currentSum == sum) {
                System.out.println("Sum found at indexe " + i);
                return;
            }
            else {
                // Try all subarrays starting with 'i'
                for (int j = i + 1; j < n; j++) {
                    currentSum += arr[j];

                    if (currentSum == sum) {
                        System.out.println(
                                "Sum found between indexes " + i + " and " + j);
                        return;
                    }
                }
            }
        }
        System.out.println("No subarray found");
        return;
    }


    //Approach 2 : Find subarray with given sum using Sliding Window                             T.C. = O(n), S.C. = O(1)
    int subArraySum_2(int arr[], int n, int sum){
        int currentSum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum, then remove the starting elements
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            // If currentSum becomes equal to sum, then return true
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " + start
                                + " and " + p);
                return 1;
            }

            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }



    public static void main(String[] args) {

        /*Ques : Given an array arr[] of non-negative integers and an integer sum,
                 find a subarray that adds to a given sum.

                 Note : There may be more than one subarray with sum as the given sum, print first such subarray.


            Example : 1
            Input   : arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
            Output  : Sum found between indexes 2 and 4
            Explanation : Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33

            Example : 2
            Input   : arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
            Output  : Sum found between indexes 1 and 4
            Explanation : Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7

            Example : 3
            Input   : arr[] = {1, 4}, sum = 0
            Output  : No subarray found
            Explanation : There is no subarray with 0 sum


        * */
    }


}
