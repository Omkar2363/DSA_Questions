package Easy;

public class Ques_3 {
    //**********     Kadane's Algorithm     **************                 (Medium/Ques_5  : another ques on Kadane algorithm)
    //Ques : Maximum subArray..........                                    (Leet Code Ques no. = 53)    (V.V Imp Ques)

    public int maxSubArray(int[] nums) {

            int sum = nums[0];
            int maxSum = nums[0];

            if(nums.length == 1)
                return nums[0];

            for(int i=1 ; i<nums.length ; i++)
            {
                sum += nums[i];
                if(sum < nums[i]){
                    sum = nums[i];
                }

                if(maxSum < sum){
                    maxSum = sum;
                }
            }

            return maxSum;
        }


    public static void main(String[] args) {

        System.out.println();

//        Solution sol = new Solution();           //make class static to remove error

        //Important Ques
        //Kadane's Algorithm.......
    }
}
