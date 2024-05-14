package Medium;

import java.util.Arrays;

public class Ques_LB1 {

    //Ques : Minimize the Heights II......                                            (GFG Ques)

    //Approach 1 :                                                                    T.C. = O(n*log(n)), S.C. = O(1)
    int getMinDiff(int[] arr, int n, int k) {

        Arrays.sort(arr);

        // Maximum possible height difference
        int ans = arr[n - 1] - arr[0];

        int tempMin, tempMax;
        tempMin = arr[0];
        tempMax = arr[n - 1];

        for (int i = 1; i < n; i++) {

            // if on subtracting k we got negative then continue
            if (arr[i] - k < 0)
                continue;

            // Minimum element when we add k to whole array
            tempMin = Math.min(arr[0] + k, arr[i] - k);

            // Maximum element when we subtract k from whole array
            tempMax = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            ans = Math.min(ans, tempMax - tempMin);
        }
        return ans;

    }

    public static void main(String[] args) {

        /*Ques : Given an array arr[] denoting heights of N towers and a positive integer K.

                 *For each tower, you must perform exactly one of the following operations exactly once.
                  Increase the height of the tower by K
                  Decrease the height of the tower by K

                Find out the minimum possible difference between the height of the shortest and tallest towers
                after you have modified each tower.

                NOTE : It is compulsory to increase or decrease the height by K for each tower.
                       After the operation, the resultant array should not contain any negative integers.


                Example : 1
                Input   : K = 2, N = 4
                          Arr[] = {1, 5, 8, 10}
                Output  : 5
                Explanation : The array can be modified as {3, 3, 6, 8}. The difference between
                              the largest and the smallest is 8-3 = 5.

                Example : 2
                Input   : K = 3, N = 5
                          Arr[] = {3, 9, 12, 16, 20}
                Output  : 11
                Explanation : The array can be modified as {6, 12, 9, 13, 17}. The difference between
                              the largest and the smallest is 17-6 = 11.




        NOTE : Follow the steps below to solve the given problem:

               1. Sort the array
               2. Try to make each height of the tower maximum by decreasing the height of all the towers to the
                  right by k and increasing all the height of the towers to the left by k.
               3. Check whether the current index tower has the maximum height or not by comparing it with a[n]-k.
                  If the tower's height is greater than the a[n]-k then it's the tallest tower available.

                  Similarly, find the shortest tower and minimize the difference between these two towers.
        * */
    }
}
