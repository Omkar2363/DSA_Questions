package Medium;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Ques_7 {

    //Ques : Find All Duplicates in an Array......                                         (Leet code Ques no. - 442)


    //Approach 1 : Brute force....                                                          T.C. = O(nlog(n)), S.C. = O(n)
    public List<Integer> findDuplicates_1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        Arrays.sort(nums);
        while(j < nums.length){
            if(nums[i] == nums[j]){
                list.add(nums[i]);
            }
            i++;
            j++;
        }
        return list;
    }



    //Approach 2 : Efficient approach....                                                  T.C. = O(n), S.C. = O(n)
    /*  The idea is to modify the array in-place as you walk through it,
        while also preserving the original array elements.

        We know that all elements are positive initially. When we see k = | A[i] | for the first time,
        multiply A[k] by -1. The negative sign on index k indicates k has been seen once.
        As you progress through the array, you will find some j > i such that A[j] = k.
        Now when you look at A[k], it is already negative (seen once). Thus, j is a duplicate.

*/
    public List<Integer> findDuplicates_2(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i =0; i < nums.length; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                list.add(index + 1);

            nums[index] *= -1;
        }
        return list;

    }



    //Approach 3 : Using Cyclic Sort....                                                  T.C. = O(n), S.C. = O(1)
    public List<Integer> findDuplicates_3(int[] nums) {
        int i=0;
        List<Integer> list = new ArrayList<>();
        while(i<nums.length){
            int correctPos = nums[i]-1;
            if(nums[i] != nums[correctPos]){
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
            }
            else
                i++;
        }

        for(i = 0; i < nums.length; i++){
            if(nums[i]-1 != i)
                list.add(nums[i]);
        }
        return list;
    }



    //Approach 4 : Using Sorting......                                                   T.C. = O(n), S.C. = O(1)
    public List<Integer> findDuplicates_4(int[] nums) {
        int i =0;
        List<Integer> list = new ArrayList<Integer>();
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }
            else{
                i++;
            }
        }

        for(int j=0; j<nums.length; j++)
        {
            if(nums[j]!=j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }
    public void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }



    //Approach 5 : Using Array....Efficient approach...                                 T.C. = O(n), S.C. = O(n)
    public List<Integer> findDuplicates_5(int[] nums){
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length+1];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 2){
                list.add(i);
            }
        }
        return list;

    }



    public static void main(String[] args) {

        /*Ques : Given an integer array nums of length n where all the integers of nums are in
                 the range [1, n] and each integer appears once or twice,
                 return an array of all the integers that appears twice.

                 You must write an algorithm that runs in O(n) time and uses only constant extra space.


            Example : 1
            Input   : nums = [4,3,2,7,8,2,3,1]
            Output  : [2,3]

            Example : 2
            Input   : nums = [1,1,2]
            Output  : [1]

            Example : 3
            Input   : nums = [1]
            Output  : []
        *
        * */
    }


}
