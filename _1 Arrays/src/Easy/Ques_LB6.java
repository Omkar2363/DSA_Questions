package Easy;

import java.util.HashMap;

public class Ques_LB6 {

    //Ques : Print all pairs with given sum...    (2 SUM)                          (GFG Ques)


    //Approach 1 : Brute force...                                                  T.C. = O(n^2), S.C. = O(1)
    // Returns number of pairs in arr[0...n-1] with sum equal to 'sum'
    static void printPairs_1(int arr[], int n, int sum) {

        // int count = 0;

        // Consider all possible pair and check their sums
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] + arr[j] == sum)
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
    }



    //Approach 2 : Using HashMap...                                                T.C. = O(n), S.C. = O(n)
    // Returns number of pairs in arr[0...n-1] with sum equal to 'sum'
    static void printPairs_2(int arr[], int n, int sum) {
        // Store counts of all elements in map m
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();

        // Traverse through all elements
        for(int i = 0; i < n; i++)
        {
            // Search if a pair can be formed with arr[i].
            int rem = sum - arr[i];
            if (mp.containsKey(rem))
            {
                int count = mp.get(rem);

                for(int j = 0; j < count; j++)
                    System.out.print("(" + rem + ", " + arr[i] + ")" + "\n");
            }
            if (mp.containsKey(arr[i]))
            {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else
            {
                mp.put(arr[i], 1);
            }
        }
    }



    //Approach 3 : Using Sort function...                                         T.C. = O(nlog(n)), S.C. = O(1)
    public void pairedElements(int arr[], int sum) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                System.out.println("The pair is : (" + arr[low] + ", " + arr[high] + ")");
            }
            if (arr[low] + arr[high] > sum) {
                high--;
            }
            else {
                low++;
            }
        }
        /*public static void main(String[] args)
          {
            int arr[] = { 2, 3, 4, -2, 6, 8, 9, 11 };
            Arrays.sort(arr);

            SumOfPairs sp = new SumOfPairs();
            sp.pairedElements(arr, 6);
          }
        */
    }



    public static void main(String[] args) {

        /*Ques : Given an array of integers, and a number ‘sum’, print all pairs in the array
                 whose sum is equal to ‘sum’.


            Example : 1
            Input   : arr[] = {1, 5, 7, -1, 5},
                      sum = 6
            Output  : (1, 5) (7, -1) (1, 5)

            Example : 2
            Input   : arr[] = {2, 5, 17, -1},
                      sum = 7
            Output  : (2, 5)
        *
        * */

    }


}
