package Medium;

public class Ques_5 {

    //Ques : Product of Array Except Self                                            (Leet code Ques no. - 238)

    //Approach 1 : By using division operator........          T.C. = O(n),  S.C. = O(1)
    public int[] productExceptSelf1(int[] nums) {

        int prod = 1;
        int zeroCount = 0;
        boolean isZero = false;

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] != 0 )
                prod = prod * nums[i];
            else{
                isZero = true;
                zeroCount++;
            }
        }
        //Handling the case if more than 1 zeroes exist in the array.
        if(zeroCount > 1){
            System.out.println("check");
            for(int i=0 ; i<nums.length ; i++)
                nums[i] = 0;
            return nums;
        }

        for(int i=0 ; i<nums.length ; i++){
            if(isZero){
                if(nums[i] == 0)
                    nums[i] = prod;
                else
                    nums[i] = 0;
                continue;
            }
            else
                nums[i] = prod/nums[i];
        }
        return nums;
    }


    //Approach 2 : Without using division operator........     T.C. = O(n),  S.C. = O(n)
    public int[] productExceptSelf2(int[] nums) {
        /*
        Idea: nums = [2, 1, 3, 4, -1]
              At one index, we need to know product elements on left and right of it
              --> THEN nums[i] = left[i] * right[i]
              Example:
                    left product = 1  = (1) <--- [Ex: 2 (index=0)] ---> 1*3*4*-1*(1) = -24 = right product
                    left product = 2  = (1)*2 <--- [Ex: 1 (index=1)] ---> 3*4*-1*(1) = -12 = right product
                    left product = 2  = (1)*2*1 <--- [Ex: 3 (index=2)] ---> 4*-1*(1) = -4  = right product
                    left product = 6  = (1)*2*1*3 <--- [Ex: 4 (index=3)] ---> -1*(1) = -1  = right product
                    left product = 24 = (1)*2*1*3*4 <--- [Ex: -1 (index=4)] ---> (1) =  1  = right product

                left   =   [1,   2,  2, 6,24]
                right  =   [-24,-12,-4,-1, 1]
            --> result =   [-24,-24,-8,-6, 24]
        */

        int n = nums.length;
        int[] left = new int[n];              // 2 <= nums.length <= 105 --> It means nums always has 2 or more items
        left[0] = 1;

        int[] right = new int[n];            // 2 <= nums.length <= 105 --> It means nums always has 2 or more items
        right[n-1] = 1;

        // Calculate for left
        // [1,2,2,6,24]
        for(int i=1; i<n; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        // Calculate for right
        // [-24,-12,-4,-1,1]
        for(int i=n-1-1; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        // Calculate result[i] = left[i]*right[i] (In-place nums)
        for(int i=0; i<n; i++){
            nums[i] = left[i]*right[i];
        }

        return nums;
    }



    public static void main(String[] args) {

            /*Ques : Given an integer array nums, return an array answer such that answer[i] is equal to the
                     product of all the elements of nums except nums[i].

                     The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

                     You must write an algorithm that runs in O(n) time and without using the division operation.


                     Example 1 :
                     Input     : nums = [1,2,3,4]
                     Output    : [24,12,8,6]

                     Example 2 :
                     Input     : nums = [-1,1,0,-3,3]
                     Output    : [0,0,9,0,0]
            * */
    }
}
