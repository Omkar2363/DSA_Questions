package Medium;

public class Ques_6 {
    //*****************      Kadane's Algorithm      ***********************        (Easy/Ques_3 : another ques on Kadane algorithm)
    //Ques :  Maximum Product Subarray                                              (Leet code Ques no. - 152)


    //Approach 1 : 2 pass Kadane algorithm                                          (Explanation is below : at tha end)
    public int maxProduct1(int[] nums) {

        int prod = 1;
        int maxProd = Integer.MIN_VALUE;

        for(int i=0 ; i<nums.length ; i++){          // forward traversal
            prod = prod * nums[i];
            maxProd = Math.max(maxProd,prod);
            if(nums[i] == 0){
                prod = 1;
            }

        }
        prod = 1;
        for(int i=nums.length-1 ; i>=0 ; i--){      // reverse traversal
            prod = prod * nums[i];
            maxProd = Math.max(maxProd,prod);
            if(nums[i] == 0){
                prod = 1;
            }

        }
        return maxProd;
    }


    //Approach 2 : Brute force
    public int maxProduct2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int answer = 0;
        int currPro = 1
                ;
        for(int i=0 ; i<nums.length ; i++){
            currPro=1;
            for(int j=i ; j<nums.length ; j++){
                currPro = currPro*nums[j];
                answer = Math.max(currPro, answer);
            }
        }
        return answer;
    }


    public static void main(String[] args) {


        /*Ques : Given an integer array nums, find a contiguous non-empty subarray within the array that
                 has the largest product, and return the product.

                 The test cases are generated so that the answer will fit in a 32-bit integer.
                 A subarray is a contiguous subsequence of the array.


            Example 1 :
            Input     :  nums = [2,3,-2,4]
            Output    :  6
            Explanation : [2,3] has the largest product 6.

            Example 2 :
            Input     :  nums = [-2,0,-1]
            Output    :  0
            Explanation : The result cannot be 2, because [-2,-1] is not a subarray.

            * */

        /*NOTE : Kadane’s algorithm is an iterative dynamic programming algorithm in which we search for
                 a maximum sum contiguous subarray within a one-dimensional numeric array.

                 ALGORITHM :
                    public int kadane(int arr[], int n)
                    {
                        int max_so_far = arr[0];
                        int max_ending_here = arr[0];

                        for (int i = 1; i < n; i++)
                        {
                            if(arr[i] < (max_ending_here + arr[i]))
                            {
                                max_ending_here = max_ending_here + arr[i];
                            }
                            else
                            {
                                max_ending_here = arr[i];
                            }
                            if(max_so_far < max_ending_here)
                            {
                                max_so_far = max_ending_here;
                            }
                        }
                        return max_so_far;
                    }

        * */


    }
}
