package Medium;

public class Ques_10 {

    //Ques :  Given Sum Pair......                                                           (GFG Ques)
    //        Find if there is a pair with a given sum in the rotated sorted Array


    // This function returns true if arr[0...n-1] has a pair with sum equals to x.
    static boolean pairInSortedRotated(int arr[], int n, int x)                              //T.C. = O(n), S.C. = O()
    {
        // Find the pivot element
        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;                               //pivot element found.

        // low is now index of smallest element
        int low = (i + 1) % n;

        // high is now index of largest element
        int high = i;

        // Keep moving either l or r till they meet
        while (low != high) {

            // If we find a pair with sum x, we return true
            if (arr[low] + arr[high] == x)
                return true;

            // If current pair sum is less, move to the higher sum
            if (arr[low] + arr[high] < x)
                low = (low + 1) % n;

                // Move to the lower sum side
            else
                high = (n + high - 1) % n;
        }
        return false;
    }



    public static void main(String[] args) {

        /*Ques : Given an array arr[] of distinct elements size N that is sorted and
                 then around an unknown point, the task is to check if the array has a pair with a given sum X.


            Examples : 1
            Input    : arr[] = {11, 15, 6, 8, 9, 10}, X = 16
            Output   : true
            Explanation : There is a pair (6, 10) with sum 16

            Examples : 2
            Input    : arr[] = {11, 15, 26, 38, 9, 10}, X = 35
            Output   : true
            Explanation : There is a pair (26, 9) with sum 35

            Examples : 3
            Input    : arr[] = {11, 15, 26, 38, 9, 10}, X = 45
            Output   : false
            Explanation : There is no pair with sum 45.
        * */
    }
}
