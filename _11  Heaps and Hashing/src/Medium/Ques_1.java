package Medium;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class Ques_1 {

    //Ques : Top K Frequent Elements.............                                            (Leet Code Ques no.- 347)


    //Approach 1 : By using PriorityQueue and HashMap........                                T.C. = O(n),   S.C. = O(n)
    class Solution_1 {
        public int[] topKFrequent(int[] nums, int k)
        {
            if(nums.length == k)
                return nums;

            Map<Integer,Integer> count_map = new HashMap<>();

            // it stores frequency of each element
            for(int i: nums)
                count_map.put(i, count_map.getOrDefault(i,0)+1);

            Queue<Integer> que = new PriorityQueue<>(k, (a, b) -> count_map.get(a)-count_map.get(b));

            for(int i: count_map.keySet())
            {
                que.add(i);
                if(que.size()>k)
                    que.poll();

            }
            return que.stream().mapToInt(Integer::valueOf).toArray();
        }
    }


    //Code : 2
    class Solution {
        public int[] topKFrequent(int[] nums, int k)
        {
            HashMap<Integer, Integer> map = new HashMap<>();

            for(int num : nums)
            {
                map.put(num,(map.getOrDefault(num,0)+1));
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(map.get(a), map.get(b)));

            for(int key: map.keySet())
            {
                pq.add(key);

                if(pq.size()>k){
                    pq.poll();
                }
            }

            int[] ans = new int[pq.size()];
            int i=0;

            while(pq.size()>0){
                ans[i++] = pq.poll();
            }

            return ans;
        }
    }



    //Approach 2 : By using MaxHeap.........                                                T.C. = O(n),   S.C. = O(n)
    public class Solution_2 {
        public int[] topKFrequent(int[] nums, int k)
        {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i : nums)
            {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            Queue<Integer> maxheap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
            for(int key : map.keySet())
            {
                maxheap.add(key);
            }

            int ans[]  = new int[k];
            for(int i  = 0; i < k; i++)
            {
                ans[i] = maxheap.poll();
            }

            return ans;
        }
    }



    //Approach 3 : Note the Working of MaxHeap..........
    public class Main {
        public static void main(String[] args) {
            HashMap<Integer,Integer> map = new HashMap<>();

            map.put(1,5);
            map.put(3,8);
            map.put(2,4);
            map.put(4,7);

            PriorityQueue<Integer> maxHeap = new PriorityQueue((a,b) -> map.get(b) - map.get(a));

            for(int key : map.keySet()) maxHeap.add(key);

            System.out.println(maxHeap);
        }
    }

    /*  The output will be [3, 4, 1, 2]

            TIME COMPLEXITY  = O(K*logN)
            SPACE COMPLEXITY = O(N)
    * */



    //Approach 4 :
    /* class Solution {
        public int[] topKFrequent(int[] nums, int k)
        {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums)
            {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list,(a,b) -> map.get(b) - map.get(a));

            int[] ans = new int[k];
            int count = 0;
            while(count < k) {
                ans[count] = list.get(count);
                count++;
            }

            return ans;
        }
    }*/


    public static void main(String[] args) {

        /*Ques : Given an integer array nums and an integer k, return the k most frequent elements.
                 You may return the answer in any order.

            Example : 1
            Input   : nums = [1,1,1,2,2,3], k = 2
            Output  : [1,2]


            Example : 2
            Input   : nums = [1], k = 1
            Output  : [1]


            Follow up : Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

        *
        * */
    }




}
