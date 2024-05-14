package Medium;

public class Ques_LB10 {

    //Ques : Minimum swaps required to bring all elements less than or equal to k together           (GFG Ques.)


    //Approach 1 : Naive approach....                                                                T.C. = O(n^2), S.C. = O(1)
    /*  A simple solution is to first count all elements less than or equal to k(say ‘good’). Now traverse for
        every sub-array and swap those elements whose value is greater than k.
        The time complexity of this approach is O(n2)
    * */



    //Approach 2 : Two pointer approach.....                                                        T.C. = O(n), S.C. = O(1)
    /*  Utility function to find minimum swaps required to club all elements less than
         or equals to k together. */
    static int minSwap_1(int arr[], int n, int k) {

        // Find count of elements which are less than equals to k
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (arr[i] <= k)
                ++count;

        // Find unwanted elements in current window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i)
            if (arr[i] > k)
                ++bad;

        // Initialize answer with 'bad' value of current window
        int ans = bad;
        for (int i = 0, j = count; j < n; ++i, ++j) {

            // Decrement count of previous window
            if (arr[i] > k)
                --bad;

            // Increment count of current window
            if (arr[j] > k)
                ++bad;

            // Update ans if count of 'bad' is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;

    /*Driver code
    public static void main(String[] args)
    {
        int arr[] = {2, 1, 5, 6, 3};
        int n = arr.length;
        int k = 3;
        System.out.print(minSwap(arr, n, k) + "\n");

        int arr1[] = {2, 7, 9, 5, 8, 7, 4};
        n = arr1.length;
        k = 5;
        System.out.print(minSwap(arr1, n, k));
    }*/
    }



    //Approach 3 : By using sliding window technique.....                                           T.C. = O(n), S.C. = O(1)
    /*   Function for finding the minimum number of swaps
         required to bring all the numbers less
         than or equal to k together.  */
    static int minSwap_2(int arr[], int n, int k) {

        // Initially snowBallsize is 0
        int snowBallSize = 0;

        for (int i = 0; i < n; i++) {

            // Calculating the size of window required
            if (arr[i] <= k) {
                snowBallSize++;
            }
        }

        int swap = 0, ans_swaps = Integer.MAX_VALUE;

        for (int i = 0; i < snowBallSize; i++) {
            if (arr[i] > k)
                swap++;
        }

        ans_swaps = Math.min(ans_swaps, swap);

        for (int i = snowBallSize; i < n; i++) {

            // Checking in every window no. of swaps
            // required and storing its minimum
            if (arr[i - snowBallSize] <= k && arr[i] > k)
                swap++;
            else if (arr[i - snowBallSize] > k
                    && arr[i] <= k)
                swap--;
            ans_swaps = Math.min(ans_swaps, swap);
        }
        return ans_swaps;


    /* Driver code
    public static void main(String[] args)
    {
        int arr1[] = { 2, 7, 9, 5, 8, 7, 4 };
        int n = arr1.length;
        int k = 5;

        System.out.println(minSwap(arr1, n, k));
    }*/
    }




    public static void main(String[] args) {

        /*Ques : Given an array of n positive integers and a number k.
                 Find the minimum number of swaps required to bring all the numbers less than or equal to k together.


            Example : 1
            Input   : arr[] = {2, 1, 5, 6, 3}, k = 3
            Output  : 1
            Explanation : To bring elements 2, 1, 3 together, swap element ‘5’ with ‘3’ such that
                          final array will be arr[] = {2, 1, 3, 6, 5}


            Example : 2
            Input   : arr[] = {2, 7, 9, 5, 8, 7, 4}, k = 5
            Output  : 2


        * */
    }


}
