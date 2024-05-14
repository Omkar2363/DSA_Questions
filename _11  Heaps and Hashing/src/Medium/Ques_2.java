package Medium;

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Ques_2 {

    //Ques : K’th largest element in a stream................                               (GFG Ques.)


    //Approach 1 : Naive Approach.......
    /*  Naive Approach : To solve the problem follow the below idea :

            Keep an array of size K. The idea is to keep the array sorted so that the Kth largest element can
            be found in O(1) time (we just need to return the first element of the array, if the array is sorted
            in increasing order

        How to process a new element of the stream?

        For every new element in the stream, check if the new element is smaller than the current Kth largest element.
        If yes, then ignore it. If no, then remove the smallest element from the array and insert the new element in
        sorted order.

        The time complexity of processing a new element is O(K)
    *
    * */




    //Approach 2 : By using Self Balancing binary search tree....
    /*  Kth largest element in a stream using a self-balancing binary search tree :

        * To solve the problem follow the below idea :
            Create a self-balancing binary search tree and for every new element in the stream, check if the new element
            is smaller than the current k’th largest element. If yes, then ignore it. If no, then remove the smallest
            element from the tree and insert a new element.

        The Kth largest element can be found in O(log K) time.
    *
    *
    * */




    //Approach 3 : By using Min-heap......                                                  T.C. = O(N * log(K)),  S.C. = O(K)
    /*  Kth largest element in a stream using a Min-Heap :

        To solve the problem follow the below idea:
            An Efficient Solution is to use a Min Heap of size K to store K largest elements of the stream.
            The Kth largest element is always at the root and can be found in O(1) time

        How to process a new element of the stream?
            Compare the new element with the root of the heap. If a new element is smaller, then ignore it.
            Otherwise, replace the root with a new element and call heapify for the root of the modified heap
    *
    *
    * */
    // Java program for the above approach
    static class GFG {

        /*
        using min heap DS :

        how data are stored in min Heap DS
               1
             2   3
        if k == 3 , then top element of heap
        itself the kth largest element

        */
        static PriorityQueue<Integer> min;
        static int k;

        static List<Integer> getAllKthNumber(int arr[])
        {

            // list to store kth largest number
            List<Integer> list = new ArrayList<>();

            // one by one adding values to the min heap
            for (int val : arr) {

                // if the heap size is less than k , we add to the heap
                if (min.size() < k)
                    min.add(val);

            /* otherwise ,
            first we  compare the current value with the min heap TOP value

            if TOP val > current element , no need to remove TOP ,
            because it will be the largest kth element anyhow

            else  we need to update the kth largest element
            by removing the top lowest element
            */

                else {
                    if (val > min.peek()) {
                        min.poll();
                        min.add(val);
                    }
                }

                // if heap size >=k we add kth largest element otherwise -1

                if (min.size() >= k)
                    list.add(min.peek());
                else
                    list.add(-1);
            }
            return list;
        }

        // Driver Code
        public static void main_3(String[] args)
        {
            min = new PriorityQueue<>();

            k = 3;

            int arr[] = { 1, 2, 3, 4, 5, 6 };

            // Function call
            List<Integer> res = getAllKthNumber(arr);

            for (int x : res)
                System.out.println("Kth largest element is " + x);
        }
    }




    //Approach 4 : By using Priority Queue......                                           T.C. = O(N * log(K)),  S.C. = O(K)
    // Java program for the above approach
    class GFG_4 {
        static int[] kthLargest(int k, int arr[], int n)
        {
            int[] ans = new int[n];

            // Creating a min-heap using priority queue
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

            // Iterating through each element
            for (int i = 0; i < n; i++) {

                // If size of priority queue is less than k
                if (pq.size() < k)
                    pq.add(arr[i]);
                else
                {
                    if (arr[i] > pq.peek())
                    {
                        pq.remove();
                        pq.add(arr[i]);
                    }
                }

                // If size is less than k
                if (pq.size() < k)
                    ans[i] = -1;
                else
                    ans[i] = pq.peek();
            }

            return ans;
        }

        // Driver Code
        public static void main_4(String[] args)
        {
            int n = 6;
            int arr[] = { 1, 2, 3, 4, 5, 6 };
            int k = 4;

            // Function call
            int[] v = kthLargest(k, arr, n);
            for (int it : v)
                System.out.print(it + " ");
        }
    }








    public static void main(String[] args) {

        /*Ques : Given an infinite stream of integers, find the Kth largest element at any point of time.

                 Note : Here we have a stream instead of a whole array and we are allowed to store only K elements.


            Example : 1
            Input   : stream[] = {10, 20, 11, 70, 50, 40, 100, 5, . . .}, K = 3
            Output  : {_,   _, 10, 11, 20, 40, 50,  50, . . .}


            Example : 2
            Input   : stream[] = {2, 5, 1, 7, 9, . . .}, K = 2
            Output  : {_, 2, 2, 5, 7, . . .}
        *
        *
        *
        * */
    }



}
