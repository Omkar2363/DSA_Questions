package Medium;

import java.util.Arrays;

public class Ques_LB_12 {

    //Ques : Detect a negative cycle in a Graph | (Bellman Ford).................          (GFG Ques.)


    //Approach 1 : For Connected Graphs..........
    /*  The idea is to use Bellman-Ford Algorithm :

        * Below is an algorithm to find if there is a negative weight cycle reachable from the given source.
            1. Initialize distances from the source to all vertices as infinite and distance to the source itself as 0. Create an array dist[] of size |V| with all values as infinite except dist[src] where src is the source vertex.
            2. This step calculates the shortest distances. Do the following |V|-1 times where |V| is the number of vertices in the given graph.
                a. Do the following for each edge u-v.
                b. If dist[v] > dist[u] + weight of edge uv, then update dist[v].
                c. dist[v] = dist[u] + weight of edge uv.
            3. This step reports if there is a negative weight cycle in the graph. Do the following for each edge u-v
                a. If dist[v] > dist[u] + weight of edge uv, then the “Graph has a negative weight cycle”

        The idea of step 3 is, step 2 guarantees the shortest distances if the graph doesn’t contain a negative weight cycle.
        If we iterate through all edges one more time and get a shorter path for any vertex, then there is a negative weight
        cycle.


    *
    * */
    // Java program to check if a graph contains negative weight cycle using Bellman-Ford algorithm.
    // This program works only if all vertices are reachable from a source vertex 0.
    class GFG {

        // a structure to represent a weighted edge in graph
        static class Edge {
            int src, dest, weight;
        }

        // a structure to represent a connected, directed and weighted graph
        static class Graph {

            // V-> Number of vertices, E-> Number of edges
            int V, E;

            // graph is represented as an array of edges.
            Edge edge[];

        }

        // Creates a graph with V vertices and E edges
        static Graph createGraph(int V, int E) {
            Graph graph = new Graph();
            graph.V = V;
            graph.E = E;
            graph.edge = new Edge[graph.E];

            for (int i = 0; i < graph.E; i++) {
                graph.edge[i] = new Edge();
            }

            return graph;
        }

        // The main function that finds shortest distances from src to all other vertices using Bellman-Ford algorithm.
        // The function also detects negative weight cycle
        static boolean isNegCycleBellmanFord(Graph graph, int src) {
            int V = graph.V;
            int E = graph.E;
            int[] dist = new int[V];

            // Step 1: Initialize distances from src to all other vertices as INFINITE
            for (int i = 0; i < V; i++)
                dist[i] = Integer.MAX_VALUE;

            dist[src] = 0;

            // Step 2: Relax all edges |V| - 1 times.
            // A simple shortest path from src to any other vertex can have at-most |V| - 1 edges
            for (int i = 1; i <= V - 1; i++) {
                for (int j = 0; j < E; j++) {
                    int u = graph.edge[j].src;
                    int v = graph.edge[j].dest;
                    int weight = graph.edge[j].weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                        dist[v] = dist[u] + weight;
                }
            }

            // Step 3: check for negative-weight cycles.
            // The above step guarantees the shortest distances if graph doesn't contain negative weight cycle.
            // If we get a shorter path, then there is a cycle.
            for (int i = 0; i < E; i++) {
                int u = graph.edge[i].src;
                int v = graph.edge[i].dest;
                int weight = graph.edge[i].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    return true;
            }

            return false;
        }

        // Driver Code
        public static void main_1(String[] args) {
            int V = 5, E = 8;
            Graph graph = createGraph(V, E);

            // add edge 0-1 (or A-B in above figure)
            graph.edge[0].src = 0;
            graph.edge[0].dest = 1;
            graph.edge[0].weight = -1;

            // add edge 0-2 (or A-C in above figure)
            graph.edge[1].src = 0;
            graph.edge[1].dest = 2;
            graph.edge[1].weight = 4;

            // add edge 1-2 (or B-C in above figure)
            graph.edge[2].src = 1;
            graph.edge[2].dest = 2;
            graph.edge[2].weight = 3;

            // add edge 1-3 (or B-D in above figure)
            graph.edge[3].src = 1;
            graph.edge[3].dest = 3;
            graph.edge[3].weight = 2;

            // add edge 1-4 (or A-E in above figure)
            graph.edge[4].src = 1;
            graph.edge[4].dest = 4;
            graph.edge[4].weight = 2;

            // add edge 3-2 (or D-C in above figure)
            graph.edge[5].src = 3;
            graph.edge[5].dest = 2;
            graph.edge[5].weight = 5;

            // add edge 3-1 (or D-B in above figure)
            graph.edge[6].src = 3;
            graph.edge[6].dest = 1;
            graph.edge[6].weight = 1;

            // add edge 4-3 (or E-D in above figure)
            graph.edge[7].src = 4;
            graph.edge[7].dest = 3;
            graph.edge[7].weight = -3;

            if (isNegCycleBellmanFord(graph, 0))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }





    //Approach 2 : For Disconnected Graphs.......
    //To handle disconnected graphs, we can repeat the process for vertices for which distance is infinite.
    // A Java program for Bellman-Ford's single source shortest path algorithm.
    class GFG_2 {

        // A structure to represent a weighted edge in graph
        static class Edge
        {
            int src, dest, weight;
        }

        // A structure to represent a connected, directed and weighted graph
        static class Graph
        {
            // V-> Number of vertices,
            // E-> Number of edges
            int V, E;

            // Graph is represented as an array of edges.
            Edge edge[];
        }

        // Creates a graph with V vertices and E edges
        static Graph createGraph(int V, int E)
        {
            Graph graph = new Graph();
            graph.V = V;
            graph.E = E;
            graph.edge = new Edge[graph.E];

            for(int i = 0; i < graph.E; i++)
            {
                graph.edge[i] = new Edge();
            }

            return graph;
        }

        // The main function that finds shortest distances from src to all other vertices using Bellman-Ford algorithm.
        // The function also detects negative weight cycle
        static boolean isNegCycleBellmanFord(Graph graph, int src, int dist[])
        {
            int V = graph.V;
            int E = graph.E;

            // Step 1 : Initialize distances from src to all other vertices as INFINITE
            for(int i = 0; i < V; i++)
                dist[i] = Integer.MAX_VALUE;

            dist[src] = 0;

            // Step 2 : Relax all edges |V| - 1 times.
            // A simple shortest path from src to any other vertex can have at-most |V| - 1 edges
            for(int i = 1; i <= V - 1; i++)
            {
                for(int j = 0; j < E; j++)
                {
                    int u = graph.edge[j].src;
                    int v = graph.edge[j].dest;
                    int weight = graph.edge[j].weight;

                    if (dist[u] != Integer.MAX_VALUE  &&  dist[u] + weight < dist[v])
                        dist[v] = dist[u] + weight;
                }
            }

            // Step 3: check for negative-weight cycles.
            // The above step guarantees the shortest distances, if graph doesn't contain negative weight cycle.
            // If we get a shorter path, then there is a cycle.
            for(int i = 0; i < E; i++)
            {
                int u = graph.edge[i].src;
                int v = graph.edge[i].dest;
                int weight = graph.edge[i].weight;

                if (dist[u] != Integer.MAX_VALUE  &&  dist[u] + weight < dist[v])
                    return true;
            }

            return false;
        }

        // Returns true if given graph has negative weight cycle.
        static boolean isNegCycleDisconnected(Graph graph)
        {
            int V = graph.V;

            // To keep track of visited vertices to avoid recomputation.
            boolean visited[] = new boolean[V];
            Arrays.fill(visited, false);

            // This array is filled by Bellman-Ford
            int dist[] = new int[V];

            // Call Bellman-Ford for all those vertices that are not visited
            for(int i = 0; i < V; i++)
            {
                if (visited[i] == false)
                {

                    // If cycle found
                    if (isNegCycleBellmanFord(graph, i, dist))
                        return true;

                    // Mark all vertices that are visited in above call.
                    for(int j = 0; j < V; j++)
                        if (dist[j] != Integer.MAX_VALUE)
                            visited[j] = true;
                }
            }
            return false;
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            int V = 5, E = 8;
            Graph graph = createGraph(V, E);

            // Add edge 0-1 (or A-B in above figure)
            graph.edge[0].src = 0;
            graph.edge[0].dest = 1;
            graph.edge[0].weight = -1;

            // Add edge 0-2 (or A-C in above figure)
            graph.edge[1].src = 0;
            graph.edge[1].dest = 2;
            graph.edge[1].weight = 4;

            // Add edge 1-2 (or B-C in above figure)
            graph.edge[2].src = 1;
            graph.edge[2].dest = 2;
            graph.edge[2].weight = 3;

            // Add edge 1-3 (or B-D in above figure)
            graph.edge[3].src = 1;
            graph.edge[3].dest = 3;
            graph.edge[3].weight = 2;

            // Add edge 1-4 (or A-E in above figure)
            graph.edge[4].src = 1;
            graph.edge[4].dest = 4;
            graph.edge[4].weight = 2;

            // Add edge 3-2 (or D-C in above figure)
            graph.edge[5].src = 3;
            graph.edge[5].dest = 2;
            graph.edge[5].weight = 5;

            // Add edge 3-1 (or D-B in above figure)
            graph.edge[6].src = 3;
            graph.edge[6].dest = 1;
            graph.edge[6].weight = 1;

            // Add edge 4-3 (or E-D in above figure)
            graph.edge[7].src = 4;
            graph.edge[7].dest = 3;
            graph.edge[7].weight = -3;

            if (isNegCycleDisconnected(graph))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }







    public static void main(String[] args) {

        /*Ques : We are given a directed graph. We need to compute whether the graph has a negative cycle or not.
                 A negative cycle is one in which the overall sum of the cycle becomes negative.

            negative_cycle

            Negative weights are found in various applications of graphs.
            For example, instead of paying cost for a path, we may get some advantage if we follow the path.



            Example : 1
            Input   : 4 4
                      0 1 1
                      1 2 -1
                      2 3 -1
                      3 0 -1

            Output : Yes
            The graph contains a negative cycle.


            // Follow the link for visual representation of the  examples.....
            // Link : https://www.geeksforgeeks.org/detect-negative-cycle-graph-bellman-ford/
        *
        *
        * */
    }





}
