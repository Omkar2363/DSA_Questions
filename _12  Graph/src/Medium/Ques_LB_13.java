package Medium;

import java.util.Arrays;

public class Ques_LB_13 {

    //Ques : Bellman Ford Algorithm (Simple Implementation).........                             (GFG Ques.)


    //Approach 1 : Simple Implementation........
    // A Java program for Bellman-Ford's single source shortest path algorithm.
    class GFG {

        // The main function that finds the  shortest distances from src to all other vertices
        // using Bellman-Ford algorithm.
        // The function also detects negative weight cycle
        // The row graph[i] represents i-th edge with three values u, v and w.
        static void BellmanFord(int graph[][], int V, int E, int src)
        {
            // Initialize distance of all vertices as infinite.
            int []dis = new int[V];
            for (int i = 0; i < V; i++)
                dis[i] = Integer.MAX_VALUE;

            // initialize distance of source as 0
            dis[src] = 0;

            // Relax all edges |V| - 1 times. A simple shortest path from src to any other
            // vertex can have at-most |V| - 1 edges
            for (int i = 0; i < V - 1; i++)
            {
                for (int j = 0; j < E; j++)
                {
                    if (dis[graph[j][0]] != Integer.MAX_VALUE && dis[graph[j][0]] + graph[j][2] < dis[graph[j][1]])
                        dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2];
                }
            }

            // check for negative-weight cycles.
            // The above step guarantees the shortest distances if graph doesn't contain negative weight cycle.
            // If we get a shorter path, then there is a cycle.
            for (int i = 0; i < E; i++)
            {
                int x = graph[i][0];
                int y = graph[i][1];
                int weight = graph[i][2];
                if (dis[x] != Integer.MAX_VALUE  &&  dis[x] + weight < dis[y])
                    System.out.println("Graph contains negative" +" weight cycle");
            }

            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; i++)
                System.out.println(i + "\t\t" + dis[i]);
        }

        // Driver code
        public static void main_1(String[] args)
        {
            int V = 5;                                          // Number of vertices in graph
            int E = 8;                                          // Number of edges in graph

            // Every edge has three values (u, v, w) where the edge is from vertex u to v.
            // And weight of the edge is w.
            int graph[][] = {   { 0, 1, -1 }, { 0, 2, 4 },
                                { 1, 2, 3 }, { 1, 3, 2 },
                                { 1, 4, 2 }, { 3, 2, 5 },
                                { 3, 1, 1 }, { 4, 3, -3 } };

            BellmanFord(graph, V, E, 0);
        }
    }

    /*  Time Complexity : O(V*E)
    *
    * */



    //Author's Solution :
    //Back-end function Template for Java
    class Solution {
        public int isNegativeWeightCycle(int n, int[][] edges)
        {
            int inf = 1000000000;
            int[] d = new int[n];
            int[] p = new int[n];

            Arrays.fill(d,0);
            Arrays.fill(p,-1);

            int x = -1;

            for(int i=0; i<n; i++)
            {
                x = -1;
                for(int j = 0; j<edges.length; j++)
                {
                    if(d[edges[j][0]] + edges[j][2] < d[edges[j][1]])
                    {
                        d[edges[j][1]] = d[edges[j][0]] + edges[j][2];
                        p[edges[j][1]] = edges[j][0];
                        x = edges[j][1];
                    }
                }
            }
            if(x == -1)
                return 0;
            else
                return 1;
        }
    }







    public static void main(String[] args) {

        /*Ques :
            Input  : Graph and a source vertex src
            Output : Shortest distance to all vertices from src. If there is a negative weight cycle,
                     then shortest distances are not calculated, negative weight cycle is reported.
                        1) This step initializes distances from source to all vertices as infinite and distance to
                           source itself as 0.
                           Create an array dist[] of size |V| with all values as infinite except dist[src] where src is
                           source vertex.
                        2) This step calculates the shortest distances. Do following |V|-1 times where |V| is the number
                           of vertices in given graph.
                            a). Do following for each edge u-v
                                  If dist[v] > dist[u] + weight of edge uv, then update dist[v]
                                    dist[v] = dist[u] + weight of edge uv
                        3) This step reports if there is a negative weight cycle in graph. Do following for each edge u-v
                                  If dist[v] > dist[u] + weight of edge uv, then “Graph contains negative weight cycle”

                        The idea of step 3 is, step 2 guarantees the shortest distances if graph doesn’t contain
                        negative weight cycle. If we iterate through all edges one more time and get a shorter path
                        for any vertex, then there is a negative weight cycle


            Example :

            // Follow the link for visual representation of the example.......
            // Link : https://www.geeksforgeeks.org/bellman-ford-algorithm-simple-implementation/
        *
        *
        *
        * */

    }





}
