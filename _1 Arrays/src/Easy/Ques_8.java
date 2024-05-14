package Easy;

public class Ques_8 {

    //Ques : Missing no.                                  .....(Leet Code ques no. - 268)

    //Approach 1 : By using XOR (^) binary operator.
    public int missingNumber1(int[] nums) {
        int ans = 0;

        for(int i=0 ; i<nums.length+1 ; i++){
            // System.out.println(ans + " ^ " + i + " = " + (ans^i));
            ans = ans^i;
        }
        // System.out.println("\n"+ ans +"\n");

        for(int i : nums){
            // System.out.println(ans + " ^ " + i + " = " + (ans^i));        //i = nums[i]
            ans = ans^i;
        }
        return ans;
    }


    //Approach 2 : By using addition formula.
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int Tsum = n*(n+1)/2;

        for(int i=0 ; i<n ; i++){
            sum += nums[i];
        }

        return Tsum - sum;
    }

    public static void main(String[] args) {
        /*

            Ques : Given an array nums containing n distinct numbers in the range [0, n],
                   return the only number in the range that is missing from the array.

            Example 1 :
            Input  : nums = [3,0,1]
            Output : 2
            Explanation : n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
                          2 is the missing number in the range since it does not appear in nums.


            Example 2 :
            Input   : nums = [0,1]
            Output  : 2
            Explanation : n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
                          2 is the missing number in the range since it does not appear in nums.


            Example 3 :
            Input  : nums = [9,6,4,2,3,5,7,0,1]
            Output : 8
            Explanation : n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
                          8 is the missing number in the range since it does not appear in nums.
        */
    }
}
