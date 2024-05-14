package Medium;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Ques_LB3 {

    //Ques : Find the Duplicate Number                                           (Leet code Ques no. - 287 )

    //Note : Nine different approaches :

    //Approach 1 : Naive approach - 2 loops                                      T.C. = O(n^2), S.C. = O(1)
    public static int findDuplicate_2loops(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return len;
    }
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        int idx = 0;
        for(int i=0 ; i<nums.length-1 ; i++){

            if(nums[i] == nums[i+1]){
                idx = i;
            }
        }
        return nums[idx];
    }


    //Approach 2 : Count...(By using O(n) extra space)                           T.C. = O(n), S.C. = O(n)
    public static int findDuplicate_count(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }


    //Approach 3 : HashSet...(By using O(n) extra space)                         T.C. = O(n), S.C. = O(n)
    public static int findDuplicate_set(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return len;
    }


    //Approach 4 : Visited...(Marking visited value within the array)            T.C. = O(n), S.C. = (1)
    public static int findDuplicate_mark(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }

        return len;
    }


    //Approach 5 : Sort...                                                       T.C. = O(nlog(n)), S.C. = (log(n))
    //             (first sort the array, then use logn space to modify the array)
    public static int findDuplicate_sort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return len;
    }


    //Approach 6 : Index Sort...                                                 T.C. = O(n), S.C. = (1)
    /*              If the array is sorted, the value of each array element is its index value index + 1,
                    then we can do this:

                    1. If nums[i] == i + 1, it means that the order has been sorted, then skip, i++;
                    2. If nums[i] == nums[nums[i] - 1], it means that there is already a value at the correct index,
                       then this value is a duplicated element;
                    3. If none of the above is satisfied, exchange the values of nums[i] and nums[nums[i] - 1].

                    With extra O(logn) space, with modifying the input.

 */
    public static int findDuplicate_index_sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; ) {
            int n = nums[i];
            if (n == i + 1) {
                i++;
            } else if (n == nums[n - 1]) {
                return n;
            } else {
                nums[i] = nums[n - 1];
                nums[n - 1] = n;
            }
        }

        return 0;
    }


    //Approach 7 : Binary Search..............                                   T.C. = O(nlog(n)), S.C. = (1)
    /*             Note that the key is to find an integer in the array [1, 2,.., n]
                   instead of finding an integer in the input array.

                   We can use the binary search algorithm, each round we guess one number,
                   then scan the input array, narrow the search range, and finally get the answer.

                   According to the Pigeonhole Principle, n + 1 integers, placed in an array of length n,
                   at least 1 integer will be repeated.

                   So guess a number first(the number mid in the valid range [left, right]), count the elements
                   of the array which is less than or equal to mid in the array.

                   1. If cnt is strictly greater than mid. According to the Pigeonhole Principle,
                      repeated elements are in the interval [left, mid];
                   2. Otherwise, the repeated element is in the interval [mid + 1, right].

                   With extra O(1) space, without modifying the input.

*/
    public static int findDuplicate_bs(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;

            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
             }
        }

        return low;
    }


    //Approach 8 : Bit...                                                        T.C. = O(nlog(n)), S.C. = (1)
    /*              This method is convert all the numbers to binary numbers. If we can get each digit of the repeated
                   number in binary, we can rebuild the repeated number.

                   Count all the bits of [1, n] and array numbers as 1 respectively, and then restore them bit by bit
                   to get this repeated number.

                    For example, the ith digit, note that in the nums array, the sum of all the elements whose ith digit
                    is 1 is x as convert the number to binary.

                    As the range [1, n], we can also count the sum of the number whose ith digit is 1, we denoted it y.

                    We can easily get that x > y.

                    The following table lists whether each bit in the binary of each number is 1 or 0 and what
                    the x and y of the corresponding bit are:

                            1	3	4	2	2	x	y
                    Bit 0	1	1	0	0	0	2	2
                    Bit 1	1	0	1	1	1	3	2
                    Bit 2	0	0	1	0	0	1	1

                    From the table, we found that only the 1th bit x > y, so after bitwise restoration
                    target=(010)_2=(2)_10, which is the answer.

                    The proof of correctness is actually similar to method 1. We can consider the change of the
                    number x of the i-th in different example arrays.

                    *   If target appears twice in the test case array, the rest of the numbers appear once, and the
                        ith bit of target is 1, then the nums array x, is exactly one greater than y.
                        If bit i of target is 0, then both are equal.

                    *   If target appears three or more times in the array of test cases, then there must be some
                        numbers that are not in the nums array. At this time, it is equivalent to replacing these
                        with target, we consider the impact on x when replacing:

                            -> If the i-th bit of the number to be replaced is 1, and the i-th bit of target is
                               1: x remains unchanged, x > y.

                            -> If the i-th bit of the number being replaced is 0, and the i-th bit of target is
                               1: x plus one, x > y.

                            -> If the i-th bit of the number to be replaced is 1, and the i-th bit of target is
                               0: x minus one, x <= y.

                            -> If the i-th bit of the number to be replaced is 0, and the i-th bit of target is
                               0: x remains unchanged, satisfying x <= y.

                    Therefore, if the ith bit of target is 1, then after each replacement, only x will be unchanged
                    or increased. If it is 0, only x will be unchanged or decreased.

                    When x > y, the ith bit of target is 1, otherwise it is 0. We only need to restore this repeated
                    number bitwise.

                    With extra O(1) space, without modifying the input.*/
    public static int findDuplicate_bit(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }

        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }

        return ans;
    }


    //Approach 9 : Fast and slow pointer...                                      T.C. = O(n), S.C. = (1)
    public int findDuplicate_fastSlow(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }



    public static void main(String[] args) {

        /*Ques : Given an array of integers nums containing n + 1 integers where each integer is in
                 the range [1, n] inclusive.

                 There is only one repeated number in nums, return this repeated number.

                 You must solve the problem without modifying the array nums and uses only constant extra space.


            Example : 1
            Input   : nums = [1,3,4,2,2]
            Output  : 2

            Example : 2
            Input   : nums = [3,1,3,4,2]
            Output  : 3

        * */
    }


}
