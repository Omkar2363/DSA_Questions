package Easy;

import java.util.Arrays;

public class Ques_LB2 {

    //Ques : Move all negative numbers to beginning and positive to end with                  (GFG Ques)
    //       constant extra space

    //Approach 1 : Naive approach ... Just sort the array                                     T.C. = O(nlog(n)), S.C. = O(n)
    public static void move(int[] arr)
    {
        Arrays.sort(arr);
    }


    //Approach 2 : Efficient approach... Apply the "Partition Process of Quicksort".         T.C. = O(n),      S.C. = O(1)
    static void rearrange(int arr[], int n) {
        int j = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {             // Java program to put all negative
                                          // numbers before positive numbers
                if (i != j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }



    //Approach 3 : Two pointer approach                                                     T.C. = O(n),      S.C. = O(1)
    // Function to shift all the negative elements on left side
    static void shiftAll(int[] arr, int left, int right) {

        // Loop to iterate over the array from left to the right
        while (left <= right)
        {
            // Condition to check if the left and the right elements are negative
            if (arr[left] < 0 && arr[right] < 0)
                left++;

                // Condition to check if the left pointer element is positive and the right pointer element is negative
            else if (arr[left] > 0 && arr[right] < 0)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            // Condition to check if both the elements are positive
            else if (arr[left] > 0 && arr[right] > 0)
                right--;
            else
            {
                left++;
                right--;
            }
        }
    }



    //Approach 4 :  Dutch National Flag Algorithm (DNF algo)                                T.C. = O(n),      S.C. = O(1)

    // a utility function to swap two elements of an array
    public static void swap(int[] ar, int i, int j) {

        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    /*
     function to shift all negative integers to the left and all positive integers to the right
     using Dutch National Flag Algorithm
    */
    public static void move_2(int[] ar) {

        int low = 0;
        int high = ar.length - 1;
        while (low <= high) {
            if (ar[low] <= 0)
                low++;
            else
                swap(ar, low, high--);
        }
    }




    public static void main(String[] args) {

        /*Ques : An array contains both positive and negative numbers in random order.
                 Rearrange the array elements so that all negative numbers appear before all positive numbers.


            Example :
            Input   : -12, 11, -13, -5, 6, -7, 5, -3, -6
            Output  : -12 -13 -5 -7 -3 -6 11 6 5

            NOTE  :  Order of elements is not important here.

        * */
    }


}
