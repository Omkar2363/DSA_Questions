package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Ques_8 {

    //Ques : 3 SUM......                                                                     (Leet code Ques no.- 15)

    //Approach 1 : Using HashSet........ (Two pointer approach)                           T.C. = O(n^2),    S.C. = O(n)
    public List<List<Integer>> threeSum_1(int[] nums) {

        HashSet<ArrayList<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }

            }
        }

        return new ArrayList<>(res);
    }


    //Approach 2 : Using Two Sum concept                                                 T.C. = O(n^2),    S.C. = O(n)
    public List<List<Integer>> threeSum_2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);                                // O(n log(n))

        for (int i = 0; i < nums.length - 2; i++) {      // O(n * t(n))

            twoSum(nums, i, result);                     // t(n) = O(n)                   //Calling twoSum function

            while (i < nums.length - 2 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int start, List<List<Integer>> result) {

        int target = -nums[start];
        int left = start + 1, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
            else {
                result.add(Arrays.asList(nums[start], nums[left], nums[right]));

                do {
                    left++;
                }while (left < right && nums[left] == nums[left-1]);

                do {
                    right--;
                } while (left < right && nums[right] == nums[right+1]);
            }
        }

    }


    //Approach 3 : Two pointer approach with List                                       T.C. = O(n^2),    S.C. = O(n)
    public List<List<Integer>> threeSum_3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //set left most and right most pointer
            int left = i + 1;
            int right = nums.length - 1;

            // skip the duplicated to avoid same result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // we need both left and right, so cannot =
            while (left < right) {
                int temp = nums[left] + nums[right];
                if (temp + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;

                    // skip the same element when adding into result. Avoid adding same result
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                } else if (temp + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }


    //Approach 4 : Or Code 4.......List form using LinkedList                           T.C. = O(n^2),    S.C. = O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> count = new LinkedList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1]))
            {
                int low = i+1;
                int high = nums.length-1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum)
                    {
                        count.add(Arrays.asList(nums[i],nums[low],nums[high]));

                        while (low < high && nums[low] == nums[low+1])
                            low++;

                        while (low < high && nums[high] == nums[high-1])
                            high--;

                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] < sum)
                        low++;
                    else
                        high--;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {

        /* Ques : Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
                  such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

                  Notice that the solution set must not contain duplicate triplets.


                  Example : 1
                  Input   : nums = [-1,0,1,2,-1,-4]
                  Output  : [[-1,-1,2],[-1,0,1]]
                  Explanation :
                                nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
                                nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
                                nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
                                The distinct triplets are [-1,0,1] and [-1,-1,2].
                                Notice that the order of the output and the order of the triplets does not matter.

                  Example : 2
                  Input   : nums = [0,1,1]
                  Output  : []
                  Explanation : The only possible triplet does not sum up to 0.


                  Example : 3
                  Input   : nums = [0,0,0]
                  Output  : [[0,0,0]]
                  Explanation : The only possible triplet sums up to 0.


        * */
    }
}
