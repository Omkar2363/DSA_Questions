package Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Ques_4 {

    //Ques : Contains Duplicate ...............                                  (LeetCode Ques no. - 217)

    //Approach 1 :
    public boolean containsDuplicate1(int[] nums) {                      //T.C. = O(nlog(n)),       S.C. = O(nlog(n))

        Arrays.sort(nums);
        for(int i=1 ; i<nums.length ; i++){
            if(nums[i-1] == nums[i]){
                return true;
            }
        }
        return false;
    }

    //Approach 2 :
    public boolean containsDuplicate2(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }

    //Approach 3 :
    public boolean containsDuplicate3(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++){

            if(!set.add(nums[i]))
                return true;
        }
        return false;

    }

    public static void main(String[] args) {

        int[] arr  = {1,2,3,4,1};
        int[] arr2 = {2,3,6,5,4,7,9,0};
        Ques_4 obj = new Ques_4();

        boolean ans = obj.containsDuplicate1(arr);
        if(ans){
            System.out.println("Contains duplicate");
        }else{
            System.out.println("No duplicate element exist ");
        }


        ans = obj.containsDuplicate1(arr2);
        if(ans){
            System.out.println("Contains duplicate");
        }else{
            System.out.println("No duplicate element exist");
        }
    }
}
