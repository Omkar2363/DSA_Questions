package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Ques_LB8 {

    //Ques : Minimum Swaps to Sort.......                                                     (GFG Ques.)

    //Approach 1 :                                                                            T.C. = O(nlog(n)), S.C. = O(n)
    // Java program to find minimum number of swaps required to sort an array
    static class GfG_1 {
        static class Pair<I extends Number, I1 extends Number> {
            int key, value;
            Pair(int a, int b)                              //Modified Pair class : Isko bnana sikh l0.
            {
                key = a;
                value = b;
            }
            int getKey(){
                return this.key;
            }
            int getValue(){
                return this.value;
            }
        }
        // Function returns the minimum number of swaps required to sort the array
        public static int minSwaps(int[] arr)
        {
            int n = arr.length;

            // Create two arrays and use as pairs where first array is element and
            // second array is position of first element
            ArrayList<Pair<Integer, Integer>> arrpos =
                    new ArrayList <Pair <Integer,
                            Integer> > ();
            for (int i = 0; i < n; i++)
                arrpos.add(new Pair <Integer,
                        Integer> (arr[i], i));

            // Sort the array by array element values to
            // get right position of every element as the
            // elements of second array.
            arrpos.sort(new Comparator<Pair<Integer,
                                Integer>>()
            {
                @Override
                public int compare(Pair<Integer, Integer> o1,
                                   Pair<Integer, Integer> o2)
                {
                    if (o1.getKey() > o2.getKey())
                        return -1;

                        // We can change this to make
                        // it then look at the
                        // words alphabetical order
                    else if (o1.getKey() == (o2.getKey()))
                        return 0;

                    else
                        return 1;
                }
            });

            // To keep track of visited elements. Initialize
            // all elements as not visited or false.
            Boolean[] vis = new Boolean[n];
            Arrays.fill(vis, false);

            // Initialize result
            int ans = 0;

            // Traverse array elements
            for (int i = 0; i < n; i++)
            {
                // already swapped and corrected or
                // already present at correct pos
                if (vis[i] || arrpos.get(i).getValue() == i)
                    continue;

                // find out the number of  node in
                // this cycle and add in ans
                int cycle_size = 0;
                int j = i;
                while (!vis[j])
                {
                    vis[j] = true;

                    // move to next node
                    j = arrpos.get(j).getValue();
                    cycle_size++;
                }

                // Update answer by adding current cycle.
                if(cycle_size > 0)
                {
                    ans += (cycle_size - 1);
                }
            }

            // Return result
            return ans;
        }
    }
    // Driver class
    class MinSwaps {
        // Driver program to test the above function
        public static void main(String[] args)
        {
            int []a = {1, 5, 4, 3, 2};
            GfG_1 g = new GfG_1();
            System.out.println(g.minSwaps(a));
        }
    }




    //Approach 2 : Using HashMap instead of Pair.......                                      T.C. = O(nlog(n)), S.C. = O(n)
    static class GfG_2 {
        // Function returns the minimum number of swaps required to sort the array
        public static int minSwaps(int[] nums)
        {
            int len = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<len;i++)
                map.put(nums[i], i);

            Arrays.sort(nums);

            // To keep track of visited elements. Initialize
            // all elements as not visited or false.
            boolean[] visited = new boolean[len];
            Arrays.fill(visited, false);

            // Initialize result
            int ans = 0;
            for(int i=0;i<len;i++) {

                // already swapped and corrected or
                // already present at correct pos
                if(visited[i] || map.get(nums[i]) == i)
                    continue;

                int j = i, cycle_size = 0;
                while(!visited[j]) {
                    visited[j] = true;

                    // move to next node
                    j = map.get(nums[j]);
                    cycle_size++;
                }

                // Update answer by adding current cycle.
                if(cycle_size > 0) {
                    ans += (cycle_size - 1);
                }
            }
            return ans;
        }
    }
    // Driver class
    class MinSwaps_2 {
        // Driver program to test the above function
        public static void main(String[] args)
        {
            int []a = {1, 5, 4, 3, 2};
            GfG_2 g = new GfG_2();
            System.out.println(g.minSwaps(a));
        }
    }



    //Approach 3 : Greedy Solution......                                                   T.C. = O(n^2), S.C. = O(n)
    // Java program to find minimum number of swaps required to sort an array
    static class GfG_3{
        // Return the minimum number of swaps required to sort the array
        public int minSwaps(int[] arr, int N)
        {
            int ans = 0;
            int[] temp = Arrays.copyOfRange(arr, 0, N);
            Arrays.sort(temp);
            for (int i = 0; i < N; i++)
            {

                // This is checking whether the current element is at the right place or not
                if (arr[i] != temp[i])
                {
                    ans++;

                    // Swap the current element with the right index
                    // so that arr[0] to arr[i] is sorted
                    swap(arr, i, indexOf(arr, temp[i]));
                }
            }
            return ans;
        }
        public void swap(int[] arr, int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        public int indexOf(int[] arr, int ele)
        {
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i] == ele) {
                    return i;
                }
            }
            return -1;
        }
    }
    // Driver class
    class Main{

        // Driver program to test the above function
        public static void main(String[] args)
                throws Exception
        {
            int[] a = { 101, 758, 315, 730, 472, 619, 460, 479 };
            int n = a.length;
            // Output will be 5
            System.out.println(new GfG_3().minSwaps(a, n));
        }
    }




    public static void main(String[] args) {

        /*Ques : Given an array of n distinct elements. Find the minimum number of swaps required
                 to sort the array in strictly increasing order.


            Example : 1
            Input   : nums = {2, 8, 5, 4}
            Output  : 1
            Explanation : swap 8 with 4.


            Example : 2
            Input   : nums = {10, 19, 6, 3, 5}
            Output  : 2
            Explanation : swap 10 with 3 and swap 19 with 5.


            Your Task :
            You do not need to read input or print anything. Your task is to complete the function minSwaps()
            which takes the nums as input parameter and returns an integer denoting the minimum number of swaps
            required to sort the array. If the array is already sorted, return 0.


            Expected Time Complexity : O(nlog(n))
            Expected Auxiliary Space : O(n)




        * */
    }

}
