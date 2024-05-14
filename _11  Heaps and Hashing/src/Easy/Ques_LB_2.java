package Easy;

import java.util.PriorityQueue;

public class Ques_LB_2 {

    //Ques : Minimum Cost of ropes........                                                  (GFG Ques.)


    //Approach 1 : Simple Approach.........                                                 T.C. = O(nlog(n)),  S.C. = O(n)
    /* Hint : Join smaller Ropes first......
    *
    * */
    /*  * Implementation :
          Steps :-
               1. Create a min-heap priority_queue and insert all lengths into the priority_queue.
               2. Do the following while the size of priority_queue is greater than one.
               3. Extract the minimum and second minimum from priority_queue which is present at the top of priority_queue.
               4. Add the above two extracted values and insert the added value to the min-heap.
               5. Maintain a variable answer for total cost and keep incrementing it by the sum of extracted values.
               6. Return the value of the answer at the end.

        * Complexity Analysis :
            Time Complexity      : O(N*log(N)),   Because heap operations like insert and extract take O(Log(n)) time
                                                  in priority_queue and for all n elements it takes n*log(n).
            Auxiliary Complexity : O(n)           The space required to store the values in priority_queue
    *
    *
    * */
    class Solution {
        //Function to return the minimum cost of connecting the ropes.
        long minCost(long arr[], int n)
        {
            //implementing MinHeap using priority queue.
            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) pq.add(arr[i]);
            Long cost = new Long("0");

            //using a loop while there is more than one element in priority queue.
            while (pq.size() != 1)
            {
                //storing the first and second numbers from priority queue.
                long x = pq.poll();
                long y = pq.poll();

                //adding their sum in result.
                cost += (x + y);

                //pushing the sum of first and second numbers in priority queue.
                pq.add(x + y);
            }
            //returning the result.
            return cost;
        }
    }







    //Approach 2 : Another Approach......                                                  T.C. = O(nlog(n)),  S.C. = O(n)
    //C++ Code.....
    /*  class Solution
        {
            public:
            //Function to return the minimum cost of connecting the ropes.
            long long minCost(long long arr[], long long n)
            {
                // Your code here
                multiset<long long> ms;
                for(int i=0; i<n; i++)
                {
                    ms.insert(arr[i]);
                }
                long long ans = 0;
                while(ms.size() > 1) {
                    auto it = ms.begin();
                    long long cost = *it;
                    ms.erase(it);
                    it = ms.begin();
                    cost += *it;
                    ms.erase(it);
                    ms.insert(cost);
                    ans += cost;
                }
                return ans;
            }
        };

    *
    * */






    public static void main(String[] args) {

        /*Ques : There are given N ropes of different lengths, we need to connect these ropes into one rope.
                 The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with
                 minimum cost. Given N size array arr[] contains the lengths of the ropes.


            Example : 1
            Input   : n = 4
                      arr[] = {4, 3, 2, 6}
            Output  : 29
            Explanation : We can connect the ropes in following ways......
                            1) First connect ropes of lengths 2 and 3. Which makes the array {4, 5, 6}.
                               Cost of this operation 2+3 = 5.
                            2) Now connect ropes of lengths 4 and 5. Which makes the array {9, 6}.
                               Cost of this operation 4+5 = 9.
                            3) Finally connect the two ropes and all ropes have connected.
                               Cost of this operation 9+6 =15

                            Total cost for connecting all ropes is 5 + 9 + 15 = 29.
                            This is the optimized cost for connecting ropes.

                            Other ways of connecting ropes would always have same or more cost.
                            For example, if we connect 4 and 6 first (we get three rope of 3, 2 and 10),
                                         then connect 10 and 3 (we get two rope of 13 and 2).
                                         Finally, we connect 13 and 2.
                                         Total cost in this way is 10 + 13 + 15 = 38.


            Example : 2
            Input   : n = 5
                      arr[] = {4, 2, 7, 6, 9}
            Output  : 62
            Explanation : First, connect ropes 4 and 2, which makes the array {6,7,6,9}. Cost of this operation 4+2 = 6.
                          Next, add ropes 6 and 6, which results in {12,7,9}.            Cost of this operation 6+6 = 12.
                          Then, add 7 and 9, which makes the array {12,16}.              Cost of this operation 7+9 = 16.
                          And finally, add these two which gives {28}.
                          Hence, the total cost is 6 + 12 + 16 + 28 = 62.



            Your Task :
            You don't need to read input or print anything. Your task isto complete the function minCost() which
            takes an integer array arr[] and an integer n as arguments and returns the minimum cost.

            Expected Time Complexity  : O(nlog(n))
            Expected Auxilliary Space : O(n)

        *
        * */
    }



}
