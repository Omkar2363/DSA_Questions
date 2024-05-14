package Medium;

public class Ques_7 {

    //Ques :  153. Find Minimum in Rotated Sorted Array                                    (Leet code Ques no.- 153)

    //Approach 1 :  using Binary Search algorithm.....                                 T.C.= log(n),  S.C. = O(1)
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] < nums[end]){
                end = mid;
            }
            else{
                start = mid+1;
            }
            //                                                  end = mid;         //this will give the maximum no. or sorted rotated array
        }

        return nums[end];
    }


    //Approach 2 :
    //Look for other similar problems from Notes of LB.


    public static void main(String[] args) {

        /*Ques : Given the sorted rotated array nums of unique elements, return the minimum element of this array.

                 You must write an algorithm that runs in O(log n) time.


                Example : 1
                Input   : nums = [3,4,5,1,2]
                Output  : 1
                Explanation : The original array was [1,2,3,4,5] rotated 3 times.


                Example : 2
                Input   : nums = [4,5,6,7,0,1,2]
                Output  : 0
                Explanation : The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.


                Example : 3
                Input   : nums = [11,13,15,17]
                Output  : 11
                Explanation : The original array was [11,13,15,17] and it was rotated 4 times.
        * */
    }
}
