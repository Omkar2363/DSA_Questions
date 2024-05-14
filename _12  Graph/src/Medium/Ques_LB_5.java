package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Ques_LB_5 {

    //Ques : Dijkstra’s Shortest Path Algorithm | Greedy Algo-7............                     (GFG Ques.)


    //Approach 1 :
    // A Java program for Dijkstra's single source shortest path algorithm.
    // The program is for adjacency matrix representation of the graph
    static class ShortestPath {

        // A utility function to find the vertex with minimum distance value,
        // from the set of vertices not yet included in shortest path tree
        static final int V = 9;
        int minDistance(int dist[], Boolean sptSet[])
        {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++)
                if (sptSet[v] == false && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        // A utility function to print the constructed distance array
        void printSolution(int dist[])
        {
            System.out.println("Vertex \t\t Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + " \t\t " + dist[i]);
        }

        // Function that implements Dijkstra's single source shortest path algorithm
        // for a graph represented using adjacency matrix representation
        void dijkstra(int graph[][], int src)
        {
            int dist[] = new int[V];                     // The output array.

            // dist[i] will hold the shortest distance from src to i

            // sptSet[i] will true if vertex i is included in shortest path tree or
            // shortest distance from src to i is finalized
            Boolean sptSet[] = new Boolean[V];


            // Initialize all distances as INFINITE and stpSet[] as false
            for (int i = 0; i < V; i++)
            {
                dist[i]   = Integer.MAX_VALUE;
                sptSet[i] = false;
            }

            // Distance of source vertex from itself is always 0
            dist[src] = 0;

            // Find shortest path for all vertices
            for (int count = 0; count < V - 1; count++)
            {
                // Pick the minimum distance vertex from the set of vertices not yet processed.
                // u is always equal to src in first iteration.
                int u = minDistance(dist, sptSet);

                // Mark the picked vertex as processed
                sptSet[u] = true;

                // Update dist value of the adjacent vertices of the picked vertex.
                for (int v = 0; v < V; v++)

                    // Update dist[v] only if is not in sptSet, there is an edge from u to v,
                    // and total weight of path from src to v through u is smaller than current value of dist[v]
                    if (!sptSet[v] && graph[u][v] != 0
                                && dist[u] != Integer.MAX_VALUE
                                && dist[u] + graph[u][v] < dist[v])
                        dist[v] = dist[u] + graph[u][v];
            }

            // print the constructed distance array
            printSolution(dist);
        }

        // Driver's code
        public static void main_1(String[] args)
        {
            /* Let us create the example graph discussed above */
            int graph[][]  = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                           { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                           { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                           { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                           { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                           { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                           { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                           { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                           { 0, 0, 2, 0, 0, 0, 6, 7, 0 }  };
            ShortestPath t = new ShortestPath();

            // Function call
            t.dijkstra(graph, 0);
        }
    }

    /*  Time Complexity : O(V^2)
        Auxiliary Space : O(V)

        * Notes :
           1. The code calculates the shortest distance but doesn’t calculate the path information. Create a parent array,
              update the parent array when distance is updated (like prim’s implementation),
              and use it to show the shortest path from source to different vertices.
           2. The code is for undirected graphs, the same Dijkstra function can be used for directed graphs also.
           3. The code finds the shortest distances from the source to all vertices. If we are interested only in
              the shortest distance from the source to a single target, break them for a loop when the picked minimum
              distance vertex is equal to the target.
           4. The time Complexity of the implementation is O(V2). If the input graph is represented using adjacency list,
              it can be reduced to O(E * log V) with the help of a binary heap.
              Please see Dijkstra’s Algorithm for Adjacency List Representation for more details.
           5. Dijkstra’s algorithm doesn’t work for graphs with negative weight cycles. It may give correct results
              for a graph with negative edges but you must allow a vertex can be visited multiple times and that version
              will lose its fast time complexity. For graphs with negative weight edges and cycles,
              the Bellman-Ford algorithm can be used, we will soon be discussing it as a separate post.

    *
    * */



    //Approach 2 : By using Heap (Or Priority Queue..)........
    /*  Dijkstra’s shortest path algorithm using Heap in O(E logV) :
            For Dijkstra’s algorithm, it is always recommended to use Heap (or priority queue) as the required
            operations (extract minimum and decrease key) match with the specialty of the heap (or priority queue).
            However, the problem is, that priority_queue doesn’t support the decrease key. To resolve this problem,
            do not update a key, but insert one more copy of it. So we allow multiple instances of the same vertex in
            the priority queue. This approach doesn’t require decreasing key operations and has below important properties.

               1. Whenever the distance of a vertex is reduced, we add one more instance of a vertex in priority_queue.
                  Even if there are multiple instances, we only consider the instance with minimum distance and
                  ignore other instances.
               2. The time complexity remains O(E * LogV) as there will be at most O(E) vertices in the priority queue
                  and O(logE) is the same as O(logV)

    *
    * */
    public class DijkstraAlgoForShortestDistance {
        static class Node implements Comparable<Node>
        {
            int v;
            int distance;
            public Node(int v, int distance)
            {
                this.v = v;
                this.distance = distance;
            }

            @Override public int compareTo(Node n)
            {
                if (this.distance <= n.distance) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        }

        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer> > > adj, int S)
        {
            boolean[] visited = new boolean[V];
            HashMap<Integer, Node> map = new HashMap<>();
            PriorityQueue<Node> q = new PriorityQueue<>();

            map.put(S, new Node(S, 0));
            q.add(new Node(S, 0));

            while (!q.isEmpty())
            {
                Node n = q.poll();
                int v  = n.v;
                int distance = n.distance;
                visited[v]   = true;

                ArrayList<ArrayList<Integer> > adjList = adj.get(v);
                for (ArrayList<Integer> adjLink : adjList)
                {
                    if (visited[adjLink.get(0)] == false)
                    {
                        if (!map.containsKey(adjLink.get(0)))
                        {
                            map.put(adjLink.get(0), new Node(v,distance + adjLink.get(1)));
                        }
                        else {
                            Node sn = map.get(adjLink.get(0));
                            if (distance + adjLink.get(1) < sn.distance)
                            {
                                sn.v = v;
                                sn.distance = distance + adjLink.get(1);
                            }
                        }
                        q.add(new Node(adjLink.get(0),distance + adjLink.get(1)));
                    }
                }
            }

            int[] result = new int[V];
            for (int i = 0; i < V; i++)
            {
                result[i] = map.get(i).distance;
            }

            return result;
        }

        public static void main_2(String[] args)
        {
            ArrayList<ArrayList<ArrayList<Integer> > > adj = new ArrayList<>();
            HashMap<Integer, ArrayList<ArrayList<Integer> > >  map = new HashMap<>();

            int V = 6;
            int E = 5;
            int[] u = { 0, 0, 1, 2, 4 };
            int[] v = { 3, 5, 4, 5, 5 };
            int[] w = { 9, 4, 4, 10, 3 };

            for (int i = 0; i < E; i++)
            {
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(v[i]);
                edge.add(w[i]);

                ArrayList<ArrayList<Integer> > adjList;
                if (!map.containsKey(u[i]))
                {
                    adjList = new ArrayList<>();
                }
                else {
                    adjList = map.get(u[i]);
                }
                adjList.add(edge);
                map.put(u[i], adjList);

                ArrayList<Integer> edge2 = new ArrayList<>();
                edge2.add(u[i]);
                edge2.add(w[i]);

                ArrayList<ArrayList<Integer> > adjList2;
                if (!map.containsKey(v[i]))
                {
                    adjList2 = new ArrayList<>();
                }
                else
                {
                    adjList2 = map.get(v[i]);
                }
                adjList2.add(edge2);
                map.put(v[i], adjList2);
            }

            for (int i = 0; i < V; i++)
            {
                if (map.containsKey(i))
                {
                    adj.add(map.get(i));
                }
                else {
                    adj.add(null);
                }
            }
            int S = 1;

            // Input sample
            //[0 [[3, 9], [5, 4]],
            // 1 [[4, 4]],
            // 2 [[5, 10]],
            // 3 [[0, 9]],
            // 4 [[1, 4], [5, 3]],
            // 5 [[0, 4], [2, 10], [4, 3]]
            //]
            int[] result = DijkstraAlgoForShortestDistance.dijkstra(V, adj, S);
            System.out.println(Arrays.toString(result));
        }
    }

    /*  Time Complexity : O(E * logV),  Where E is the number of edges and V is the number of vertices.
        Auxiliary Space : O(V)
    *
    * */



    public static void main(String[] args) {

        /*Ques : Given a graph and a source vertex in the graph, find the shortest paths from the source to
                 all vertices in the given graph.


            Example : 1
            Input   : src = 0, the graph is shown below.




            Output  : 0 4 12 19 21 11 9 8 14
            Explanation :   The distance from 0 to 1 = 4.
                            The minimum distance from 0 to 2 = 12. 0->1->2
                            The minimum distance from 0 to 3 = 19. 0->1->2->3
                            The minimum distance from 0 to 4 = 21. 0->7->6->5->4
                            The minimum distance from 0 to 5 = 11. 0->7->6->5
                            The minimum distance from 0 to 6 = 9.  0->7->6
                            The minimum distance from 0 to 7 = 8.  0->7
                            The minimum distance from 0 to 8 = 14. 0->1->2->8



            // Follow the link for Visual Representation of the Example......
            // Link : https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
        *
        *
        * */
    }





}
