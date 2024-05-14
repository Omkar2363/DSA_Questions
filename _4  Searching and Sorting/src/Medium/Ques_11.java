package Medium;

import java.util.Arrays;

public class Ques_11 {

    //Ques : Check if reversing a sub array make the array sorted........               (GFG Ques.)


    //Approach 1 : Brute force......                                                    T.C. = O(n^3),  S.C. = O(n)
    /*      Method 1: Brute force (O(n3))
            Consider every subarray and check if reversing the subarray makes the whole array sorted.
            If yes, return True. If reversing any of the sub-arrays does not make the array sorted, then return False.
            Considering every subarray will take O(n2), and for each subarray, checking whether the whole array will
            get sorted after reversing the subarray in consideration will take O(n). Thus overall complexity would be O(n3).

    * */



    //Approach 2 : Efficient approach....                                              T.C. = O(nlog(n)),  S.C. = O(n)
    /*      Method 2: Sorting ( O(n*log(n) ))
            The idea is to compare the given array with its sorted version. Make a copy of the given array and sort it.
            Now, find the first index and last index in the given array which does not match with the sorted array.
            If no such indices are found (given array was already sorted), return True.
             Else check if the elements between the found indices are in decreasing order,
             if Yes then return True else return False
    *
    * */
    // Java program to check whether reversing a sub array make the array sorted or not
    class GFG {

        // Return true, if reversing the subarray will sort the array, else return false.
        static boolean checkReverse(int arr[], int n)
        {
            // Copying the array.
            int temp[] = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = arr[i];
            }

            // Sort the copied array.
            Arrays.sort(temp);

            // Finding the first mismatch.
            int front;
            for (front = 0; front < n; front++) {
                if (temp[front] != arr[front]) {
                    break;
                }
            }

            // Finding the last mismatch.
            int back;
            for (back = n - 1; back >= 0; back--) {
                if (temp[back] != arr[back]) {
                    break;
                }
            }

            // If whole array is sorted
            if (front >= back) {
                return true;
            }

            // Checking subarray is decreasing or not.
            do {
                front++;
                if (arr[front - 1] < arr[front]) {
                    return false;
                }
            } while (front != back);

            return true;
        }

        // Driven Program
        public static void main_2(String[] args) {

            int arr[] = {1, 2, 5, 4, 3};
            int n = arr.length;

            if (checkReverse(arr, n)) {
                System.out.print("Yes");
            } else {
                System.out.print("No");
            }
        }

    }




    //Approach 3 : Linear time solution Approach.....                                 T.C. = O(n),  S.C. = O(1)
    /*      The idea to solve this problem is based on the observation that if we perform
            one rotation of any subarray in the sorted array (increasing order),
            then we there will be exactly one subarray which will be in decreasing order.
            So, we have to find that rotated subarray and perform one rotation on it.
             Finally check if the array becomes sorted or not.
    *
    * */
    //C++ Code :
    /*  #include <bits/stdc++.h>
        using namespace std;

        bool sortArr(int a[], int n)
        {
            int x = -1;
            int y = -1;

            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    if (x == -1) {
                        x = i;
                    }
                    y = i + 1;
                }
            }

            if (x != -1) {
                reverse(a + x, a + y + 1);
                for (int i = 0; i < n - 1; i++) {
                    if (a[i] > a[i + 1]) {
                        return false;
                        return 0;
                    }
                }
            }

            return true;
        }

        // Driven Program
        int main()
        {
            int arr[] = { 1, 2, 5, 4, 3 };
            int n = sizeof(arr) / sizeof(arr[0]);

            sortArr(arr, n) ? (cout << "Yes" << endl) : (cout << "No" << endl);
            return 0;
        }
    */




    //Approach 4 : Another linear time solution approach......                        T.C. = O(n),  S.C. = O(1)
    /*      Observe, that the answer will be True when the array is already sorted or
            when the array consists of three parts. The first part is increasing subarray,
            then decreasing subarray, and then again increasing subarray.
            So, we need to check that array contains increasing elements then some decreasing elements,
            and then increasing elements if this is the case the answer will be True.
            In all other cases, the answer will be False.

            Note : Simply finding the three parts does not guarantee the answer to be True
                   e.g. :  Consider arr [] = {10,20,30,40,4,3,2,50,60,70}
                           The answer would be False in this case, although we are able to find three parts.
                           We will be handling the validity of the three parts in the code below.
    *
    * */
    // Java program to check whether reversing a sub array make the array sorted or not
    class GFG_4 {

        // Return true, if reversing the subarray will sort the array, else return false.
        static boolean checkReverse(int arr[], int n) {
            if (n == 1) {
                return true;
            }

            // Find first increasing part
            int i;
            for (i = 1; arr[i - 1] < arr[i] && i < n; i++);

            if (i == n) {
                return true;
            }

            // Find reversed part
            int j = i;
            while (j < n && arr[j] < arr[j - 1]) {
                if (i > 1 && arr[j] < arr[i - 2]) {
                    return false;
                }
                j++;
            }

            if (j == n) {
                return true;
            }

            // Find last increasing part
            int k = j;

            // To handle cases like {1,2,3,4,20,9,16,17}
            if (arr[k] < arr[i - 1]) {
                return false;
            }

            while (k > 1 && k < n) {
                if (arr[k] < arr[k - 1]) {
                    return false;
                }
                k++;
            }
            return true;
        }

        // Driven Program
        public static void main(String[] args) {

            int arr[] = {1, 3, 4, 10, 9, 8};
            int n = arr.length;

            if (checkReverse(arr, n)) {
                System.out.print("Yes");
            } else {
                System.out.print("No");
            }
        }

    }





    public static void main(String[] args) {

        /*Ques : Given an array of n distinct integers. The task is to check whether reversing any
                 one sub-array can make the array sorted or not.
                 If the array is already sorted or can be made sorted by reversing any one subarray,
                 print 'Yes', else print 'No'.


            Example : 1
            Input   : arr [] = {1, 2, 5, 4, 3}
            Output  : Yes
            Explanation : By reversing the subarray {5, 4, 3}, the array will be sorted.


            Example : 2
            Input   : arr [] = { 1, 2, 4, 5, 3 }
            Output  : No

        *
        * */
    }
}
