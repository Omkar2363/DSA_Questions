package Medium;

public class Ques_LB_14 {

    //Ques : Bellman–Ford Algorithm | DP-23................                                 (GFG Ques.)


    //Approach 1 :
    // A Java program for Bellman-Ford's single source shortest path algorithm.
    // A class to represent a connected, directed and weighted graph
    static class Graph {

        // A class to represent a weighted edge in graph
        class Edge {
            int src, dest, weight;
            Edge() { src = dest = weight = 0; }
        };

        int V, E;
        Edge edge[];

        // Creates a graph with V vertices and E edges
        Graph(int v, int e)
        {
            V = v;
            E = e;
            edge = new Edge[e];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }

        // The main function that finds the shortest distances from src to all other vertices
        // using Bellman-Ford algorithm.
        // The function also detects negative weight cycle
        void BellmanFord(Graph graph, int src)
        {
            int V = graph.V, E = graph.E;
            int dist[] = new int[V];

            // Step 1: Initialize distances from src to all other vertices as INFINITE
            for (int i = 0; i < V; ++i)
                dist[i] = Integer.MAX_VALUE;

            dist[src] = 0;

            // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src to any other vertex
            //         can have at-most |V| - 1 edges
            for (int i = 1; i < V; ++i)
            {
                for (int j = 0; j < E; ++j)
                {
                    int u = graph.edge[j].src;
                    int v = graph.edge[j].dest;
                    int weight = graph.edge[j].weight;

                    if (dist[u] != Integer.MAX_VALUE  &&  dist[u] + weight < dist[v])
                        dist[v] = dist[u] + weight;

                }
            }

            // Step 3: Check for negative-weight cycles. The above step guarantees the shortest distances
            //         if graph doesn't contain negative weight cycle. If we get a shorter path, then there is a cycle.
            for (int j = 0; j < E; ++j)
            {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;

                if (dist[u] != Integer.MAX_VALUE  &&  dist[u] + weight < dist[v])
                {
                    System.out.println("Graph contains negative weight cycle");

                    return;
                }
            }
            printArr(dist, V);
        }

        // A utility function used to print the solution
        void printArr(int dist[], int V)
        {
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; ++i)
                System.out.println(i + "\t\t" + dist[i]);
        }

        // Driver's code
        public static void main(String[] args)
        {
            int V = 5;                             // Number of vertices in graph
            int E = 8;                             // Number of edges in graph

            Graph graph = new Graph(V, E);

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

            // add edge 1-4 (or B-E in above figure)
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

            // Function call
            graph.BellmanFord(graph, 0);
        }
    }


    /*  Time Complexity :  O(V * E),                where, V is the number of vertices in the graph and
                                                           E is the number of edges in the graph
        Auxiliary Space : O(E).


        Notes :
        1. Negative weights are found in various applications of graphs. For example, instead of paying the cost
           for a path, we may get some advantage if we follow the path.
        2. Bellman-Ford works better (better than Dijkstra’s) for distributed systems. Unlike Dijkstra’s where we need
           to find the minimum value of all vertices, in Bellman-Ford, edges are considered one by one.
        3. Bellman-Ford does not work with an undirected graph with negative edges as it will be declared
           as a negative cycle.
    *
    * */







    public static void main(String[] args) {

        /*Ques : Given a graph and a source vertex src in the graph, find the shortest paths from src to all vertices
                 in the given graph. The graph may contain negative weight edges.

            We have discussed Dijkstra’s algorithm for this problem. Dijkstra’s algorithm is a Greedy algorithm and
            the time complexity is O((V+E)LogV) (with the use of the Fibonacci heap).
            Dijkstra doesn’t work for Graphs with negative weights, Bellman-Ford works for such graphs.
            Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. But time complexity of
            Bellman-Ford is O(V * E), which is more than Dijkstra.

            // Follow the link for the complete discussion of algorithm......
            // Link : https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/

        * */
    }




}
