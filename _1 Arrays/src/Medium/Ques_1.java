package Medium;

public class Ques_1 {

    //Ques : Next Permutation        .........T.C. = O(n)  and S.C. = O(1)
    //See Editorial on GFG for proper explanation

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
