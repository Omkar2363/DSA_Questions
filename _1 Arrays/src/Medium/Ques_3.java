package Medium;

import java.util.Arrays;                                       //Kth smallest element : Medium Ques_10.
import java.util.PriorityQueue;

public class Ques_3 {

    //Ques : Kth Largest element in an array.                                 (Leet code Ques no. - 215)
                                                                              //Also check on GFG.

    //Approach 1 : By using sort function                   T.C. = O(nlog(n)),      S.C. = O(1)
    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        return nums[n-k];

    }


    //Approach 2 : By using Priority Queue                 T.C. = O(n * log(n)),    S.C. = O(k)
    public int findKthLargest2(int[] nums, int k){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        for (int j = 0; j < nums.length; j++) {               /* O(n)           for complete array traversal
            priorityQueue.add(nums[j]);                        * O(log(n))      for each element addition
                                                               * Priority Queue add the element in increasing order by default
                                                                 in log(n) time
                                                              */
            if(priorityQueue.size()>k)
                priorityQueue.poll();                         // log(n) time to remove element

        }
        return priorityQueue.poll();
    }


    //Approach 3 :  An improvisation of Count Sort         T.C. = O(n),             S.C. = O(1),      { Overall time complexity is O(N) + O(N/2) + O(N/2) ~= O(N)}
    public int findKthLargest(int[] nums, int k) {

        int[] count = new int[20001];
        int numberOfNonPos = 0;
        int numberOfPos = 0;

        //Complexity of this loop is O(N)
        for(int i = 0; i <nums.length; i++){

            if(nums[i] <= 0){
                count[-nums[i]]++;
                /*
                Keeping count of pos and non pos numbers.
                So that we can decide in which part, the kth largest element would fall.
                */
                numberOfNonPos++;
            }else{

                count[10000+nums[i]]++;
                numberOfPos++;
            }
        }
        if(k <= numberOfPos){
            /*
            Case where kth largest number is going to be a positive one
            Complexity of loop in this method is O(N/2), N being length of count arr
            */
            return FromPosNumbers(count, k);
        }
            /*
            Case where kth largest number is going to be a non-positive number
            Complexity of loop in this method is O(N/2), N being length of count arr
            */
        return FromNonPosNumbers(count, k-numberOfPos);

            //So overall complexity is O(N) + O(N/2) + O(N/2) ~= O(N)
    }

    public int FromPosNumbers(int[] count, int k){

        int i = count.length - 1;
        int res = 0;
        while(i > 10000){

            while(count[i] == 0){
                i--;
            }
            if(k <= count[i]){
                res = i-10000;
                break;
            }else{
                k = k - count[i];
            }
            i--;
        }

        return res;
    }

    public int FromNonPosNumbers(int[] count, int k){

        int i = 0;
        int res = 10001;
        while(i<=10000){

            while(count[i] == 0){
                i++;
            }
            if(k <= count[i]){
                res = -i;
                break;
            }
            k = k - count[i];
            i++;
        }

        return res;
    }



    public static void main(String[] args) {

        /*Ques : Given an integer array nums and an integer k, return the kth  largest element in the array.
                 Note that it is the kth largest element in the sorted order, not the kth distinct element.

                 You must solve it in O(n) time complexity.


                Example 1 :
                Input   : nums = [3,2,1,5,6,4],  k = 2
                Output  : 5


                Example 2 :
                Input   : nums = [3,2,3,1,2,4,5,5,6], k = 4
                Output  : 4

         */
    }
}

