package Medium;

import java.util.*;

public class Ques_LB_18 {

    //Ques : Cheapest Flights Within K Stops..............                                 (Leet Code Ques no.- 787)

    //Approach 1 : By using BFS........(Using Queue and HashMap....)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
        {
            // Use a matrix rather than HashMap to speed up lookups as this is just a 100 x 100 graph
            int[][] adjacencyMatrix = new int[100][100];

            for (int[] flight : flights) {
                adjacencyMatrix[flight[0]][flight[1]] = flight[2];
            }

            Map<Integer, Integer> minPathCost = new HashMap<>();
            Queue<int[]> bfsQueue = new LinkedList<>();
            bfsQueue.add(new int[] { src, 0 });

            // Perform BFS upto no more than k - depth
            int cheapestPrice = Integer.MAX_VALUE;
            while (!bfsQueue.isEmpty()  &&  k >= -1)
            {
                int len = bfsQueue.size();
                for (int i = 0; i < len; i++)
                {
                    int key = bfsQueue.peek()[0];
                    int val = bfsQueue.peek()[1];
                    bfsQueue.poll();

                    if (key == dst) {
                        cheapestPrice = Math.min(cheapestPrice, val);
                    }
                    else {
                        for (int x = 0; x < 100; x++)
                        {
                            // Any route will have a positive (>0) cost
                            if (adjacencyMatrix[key][x] > 0) {

                                int cost = val + adjacencyMatrix[key][x];
                                // BFS Prunning - only proceed if:
                                // 1. The current cost is less than the cheapest price observed so far, and,
                                // 2. The current price at node 'x' is lesser than any previously observed price for the same node
                                if((cost < cheapestPrice) && (!minPathCost.containsKey(x) || minPathCost.get(x) > cost)) {
                                    bfsQueue.add(new int[] { x, cost });
                                    minPathCost.put(x, cost);
                                }
                            }
                        }
                    }
                }
                k--;
            }

            return cheapestPrice == Integer.MAX_VALUE ? -1 : cheapestPrice;
        }
    }




    //Approach 2 : By using Bellman-Ford algorithm..........
    class Solution_2{
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
        {
            int[] prev = new int[n];
            Arrays.fill(prev, Integer.MAX_VALUE);
            prev[src] = 0;

            for(int i = 0; i <= k; i++)
            {
                int[] curr = new int[n];
                for(int j = 0; j < n; j++)
                    curr[j] = prev[j];

                for(int[] edge : flights)
                {
                    int u = edge[0];
                    int v = edge[1];
                    int wt = edge[2];

                    if(prev[u] != Integer.MAX_VALUE  &&  prev[u]+wt < curr[v]){
                        curr[v] = prev[u] + wt;
                    }
                }
                for(int j = 0; j < n; j++)
                    prev[j] = curr[j];
            }

            return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
        }
    }



    //Approach 3 : By using Dijkstra algorithm..........
    class Solution_3 {
        class Pair {
            int v;
            int wt;
            int dist;

            Pair(int v, int wt, int dist){
                this.v = v;
                this.wt = wt;
                this.dist = dist;
            }
        }
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
        {
            ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

            for(int i = 0; i < n; i++){
                graph.add(new ArrayList<>());
            }

            for(int[] edge : flights){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                graph.get(u).add(new Pair(v, wt, 0));

            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
            pq.add(new Pair(src, 0, -1));
            int[] stop = new int[n];
            Arrays.fill(stop, Integer.MAX_VALUE);

            while(pq.size() > 0)
            {
                Pair p = pq.remove();
                if(p.dist > k || stop[p.v] < p.dist)
                    continue;

                stop[p.v] = p.dist;
                if(p.v == dst)
                    return p.wt;

                for(Pair nbr : graph.get(p.v))
                {
                    pq.add(new Pair(nbr.v, p.wt + nbr.wt, p.dist + 1));

                }

            }
            return -1;
        }
    }







    public static void main(String[] args) {

        /*Ques : There are n cities connected by some number of flights.
                 You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that
                 there is a flight from city fromi to city toi with cost pricei.

                You are also given three integers src, dst, and k, return the cheapest price from src to dst
                with at most k stops. If there is no such route, return -1.


            Example : 1
            Input   : n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
            Output  : 700
            Explanation : The graph is shown above.
                          The optimal path with at most 1 stop from city 0 to 3 is marked in red and
                          has cost 100 + 600 = 700.

                Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

            Example : 2
            Input   : n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
            Output  : 200
            Explanation : The graph is shown above.
                          The optimal path with at most 1 stop from city 0 to 2 is marked in red and
                          has cost 100 + 100 = 200.


            Example : 3
            Input   : n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
            Output  : 500
            Explanation : The graph is shown above.
                          The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
        *
        *
        */
    }





}
