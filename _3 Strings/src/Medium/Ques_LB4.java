package Medium;

import java.util.Arrays;

public class Ques_LB4 {

    //Ques : Next Permutation.........Very-Very Important                             (Leet code Ques no. - 31)


    //Approach 1 :                                                                    T.C. = O(n)  and S.C. = O(1)
    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length <=1){             //If there is 0 or 1 element int the array.
            return;
        }

        // int i;                                       //Works same as while loop
        // for(i=nums.length-2 ; i>=0 ; i--){
        //     if(nums[i] < nums[i+1]){
        //         break;
        //     }
        // }

        int i=nums.length - 2;                          //traversing the array from end position and is finding the first
        while(i >= 0 && nums[i] >= nums[i+1]) {         //element which is smaller than its next element
            i--;                                        //Input  : n = "534976" ---------> 4<9
        }                                               //Output :     "536479"

        if(i>=0) {
            int j = nums.length - 1;
            while(nums[j] <= nums[i]) {                 //Very important loop :
                j--;                                   //Gives the minimum value in rightmost part which is also
            }                                           //greater than nums[i]
            swap(nums, i,j);
        }
        reverse(nums, i+1, nums.length-1);

    }
    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int i,int j) {

        while(i<j){
            swap(nums,i++,j--);
        }
    }




    //Approach 2 : From GFG                                                         T.C. = O(nlog(n))  and S.C. = O(1)
    // Utility function to swap two digit
    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    /*
     Given a number as a char array number[], this function finds the next greater number.
     It modifies the same array to store the result
    */
    static void findNext(char ar[], int n) {
        int i;

        /*
         I) Start from the right most digit and find the first digit that is smaller
            than the digit next to it.
        */
        for (i = n - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        /*
         If no such digit is found, then all digits are in descending order means
         there cannot be a greater number with same set of digits
        */
        if (i == 0) {
            System.out.println("Not possible");
        }
        else {
            int x = ar[i - 1], min = i;

            /*
             II) Find the smallest digit on right side of (i-1)'th digit that is greater
                 than number[i-1]
            */
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }

            // III) Swap the above found the smallest digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1) in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" + " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(ar[i]);
        }

    /* Driver code
    public static void main(String[] args)
    {
        char digits[] = { '5','3','4','9','7','6' };
        int n = digits.length;
        findNext(digits, n);
    }*/
    }


    //Approach 3 : From GFG                                                        T.C. = O(n)  and S.C. = O(1)
    static int[] nextPermutation(int n, int[] arr) {

        // If number of digits is 1 then just return the vector
        if (n == 1)
            return arr;

        /*
         Start from the right most digit and find the first digit that is
         smaller than the digit next to it.
        */
        int i = 0;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1])
                break;
        }

        // If there is a possibility of a next greater element
        if (i != 0) {

            // Find the smallest digit on right side of (i-1)'th digit that is
            // greater than number[i-1]
            for (int j = n - 1; j >= i; j--) {
                if (arr[i - 1] < arr[j]) {

                    // Swap the found smallest digit i.e. arr[j] with arr[i-1]
                    int temp = arr[j];
                    arr[j] = arr[i - 1];
                    arr[i - 1] = temp;
                    break;
                }
            }
        }

        /*
         Reverse the digits after (i-1) because the digits
         after (i-1) are in decreasing order and thus we will
         get the smallest element possible from these digits
        */
        int[] res = new int[arr.length];
        int ind = arr.length - 1;

        // copying the first i elements of arr into res
        for (int j = 0; j < i; j++)
            res[j] = arr[j];

        // copying the rest of the elements in reverse order
        for (int j = i; j < res.length; j++)
            res[j] = arr[ind--];

        /*
         If i, is 0 that means elements are in decreasing order
         Therefore, no greater element possible then we just return the lowest possible
         order/element formed from these digits by just reversing the vector
        */

        return res;


    /* Driver Code
    public static void main(String[] args)
    {
        int n = 6;
        int[] v = { 5,3,4,9,7,6 };
        int[] res;

        // Function Call
        res = nextPermutation(n, v);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }*/
    }




    public static void main(String[] args) {
        /*Following are few observations about the next greater number.

          1. If all digits sorted in descending order, then output is always "Not Possible". For example, 4321.   (Leet Code par ye case alag hai)
          2. If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
          3. For other cases, we need to process the number from rightmost side
                    (why? because we need to find the smallest of all greater numbers)

             You can now try developing an algorithm yourself.

             * Following is the algorithm for finding the next greater number.

            1. Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller
               than the previously traversed digit. For example, if the input number is "534976", we stop at 4 because
               4 is smaller than next digit 9. If we do not find such a digit, then output is "Not Possible".
            2. Now search the right side of above found digit 'd' for the smallest digit greater than 'd'.
               For "534976", the right side of 4 contains "976". The smallest digit greater than 4 is 6.
            3. Swap the above found two digits, we get 536974 in above example.
            4. Now sort all digits from position next to 'd' to the end of number. The number that we get after sorting
               is the output. For above example, we sort digits in bold 536974.
               We get "536479" which is the next greater number for input 534976.

        */

    }


}
