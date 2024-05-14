package Easy;

public class Ques_LB5 {

    //Ques : Merge two sorted array...                                               (Leet code Ques no. - 88)


    //Approach 1 :                                                                   T.C. = O(n), S.C. = (1)
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int mute = m + n - 1;
        while(j >= 0)
        {
            if(i >= 0 && nums1[i] > nums2[j])
            {
                nums1[mute] = nums1[i];
                i--;
                mute--;
            }
            else
            {
                nums1[mute] = nums2[j];
                j--;
                mute--;
            }
        }
    }


    //Approach 2 :                                                                   T.C. = O(m+n), S.C. = (1)
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = (m + n) - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

        while(i >= 0){
            nums1[k--] = nums1[i--];
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }


    //Approach 3 : Three pointer approach...                                         T.C. = O(m+n), S.C. = (1)
    /*             Follow the link for visual understanding.
                   https://leetcode.com/problems/merge-sorted-array/discuss/2120234/Visual-Explanation-or-O(1)-Space-JAVA
    * */
    public void merge_3(int[] A, int m, int[] B, int n) {
        for (int i = m+n-1, a = m-1, b = n-1; b>=0; i--) {
            if (a >= 0 && A[a] > B[b]) A[i] = A[a--];
            else A[i] = B[b--];
        }
    }



    //Approach 4 : Most efficient approach...                                        T.C. = O(m+n), S.C. = (1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Space complexity O(1)
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (i>=0 && j>=0){
            nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--] ;
        }
        while (j>=0)
            nums1[k--] = nums2[j--];
    }



    public static void main(String[] args) {

        /*Ques : You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
                 and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

                 Merge nums1 and nums2 into a single array sorted in non-decreasing order.

                 The final sorted array should not be returned by the function, but instead be stored  inside the
                 array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote
                 the elements that should be merged, and the last n elements are set to 0 and should be  ignored.
                 nums2 has a length of n.



            Example : 1
            Input   : nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
            Output  : [1,2,2,3,5,6]
            Explanation : The arrays we are merging are [1,2,3] and [2,5,6].
                          The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.


            Example : 2
            Input   : nums1 = [1], m = 1, nums2 = [], n = 0
            Output  : [1]
            Explanation : The arrays we are merging are [1] and []. The result of the merge is [1].


            Example : 3
            Input   : nums1 = [0], m = 0, nums2 = [1], n = 1
            Output  : [1]
            Explanation : The arrays we are merging are [] and [1].
                          The result of the merge is [1].

            NOTE :   Because m = 0, there are no elements in nums1.
                     The 0 is only there to ensure the merge result can fit in nums1.


        * */
    }



}
