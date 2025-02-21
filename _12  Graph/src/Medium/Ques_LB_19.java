package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Ques_LB_19 {

    //Ques : Find if there is a path of more than k length from a source...........            (GFG Ques.)


    //Approach 1 :
    /*  One important thing to note is, simply doing BFS or DFS and picking the longest edge at every step would not work.
        The reason is, a shorter edge can produce longer path due to higher weight edges connected through it.

        The idea is to use Backtracking. We start from given source, explore all paths from current vertex.
        We keep track of current distance from source. If distance becomes more than k, we return true.
        If a path doesn’t produces more than k distance, we backtrack.


        How do we make sure that the path is simple and we don’t loop in a cycle? The idea is to keep track of current
        path vertices in an array. Whenever we add a vertex to path, we check if it already exists or not in current path.
        If it exists, we ignore the edge.


    *
    * */
    // Java Program to find if there is a simple path with weight more than k
    public class GFG {
        static class AdjListNode {
            int v;
            int weight;
            AdjListNode(int _v, int _w)
            {
                v = _v;
                weight = _w;
            }
            int getV() { return v; }
            int getWeight() { return weight; }
        }

        // This class represents a dipathted graph using adjacency list representation
        static class Graph
        {
            int V;                                                 // No. of vertices

            // In a weighted graph, we need to store vertex and weight pair for every edge
            ArrayList<ArrayList<AdjListNode>> adj;

            // Allocates memory for adjacency list
            Graph(int V)
            {
                this.V = V;
                adj = new ArrayList<ArrayList<AdjListNode>>(V);

                for(int i = 0; i < V; i++)
                {
                    adj.add(new ArrayList<AdjListNode>());
                }
            }

            // Utility function to an edge (u, v) of weight w
            void addEdge(int u, int v, int weight)
            {
                AdjListNode node1 = new AdjListNode(v, weight);
                adj.get(u).add(node1);                                      // Add v to u's list

                AdjListNode node2 = new AdjListNode(u, weight);
                adj.get(v).add(node2);                                      // Add u to v's list
            }

            // Returns true if graph has path more than k length
            boolean pathMoreThanK(int src, int k)
            {

                // Create a path array with nothing included in path
                boolean path[] = new boolean[V];

                Arrays.fill(path, false);

                // Add source vertex to path
                path[src] = true;

                return pathMoreThanKUtil(src, k, path);
            }

            // Prints the shortest paths from src to all other vertices
            boolean pathMoreThanKUtil(int src, int k, boolean[] path)
            {

                // If k is 0 or negative, return true;
                if (k <= 0)
                    return true;

                // Get all adjacent vertices of source vertex src and recursively explore all paths from src.
                ArrayList<AdjListNode> it = adj.get(src);

                int index = 0;
                for(int i = 0; i < adj.get(src).size(); i++)
                {
                    AdjListNode vertex = adj.get(src).get(i);

                    // Get adjacent vertex and weight of edge
                    int v = vertex.v;
                    int w = vertex.weight;

                    // increase the index
                    index++;

                    // If vertex v is already there in path, then there is a cycle (we ignore this edge)
                    if (path[v] == true)
                        continue;

                    // If weight of is more than k, return true
                    if (w >= k)
                        return true;

                    // Else add this vertex to path
                    path[v] = true;

                    // If this adjacent can provide a path longer than k, return true.
                    if (pathMoreThanKUtil(v, k-w, path))
                        return true;

                    // Backtrack
                    path[v] = false;
                }

                // If no adjacent could produce longer path, return false
                return false;
            }

        }

        // Driver program to test methods of graph class
        public static void main_1(String[] args)
        {

            // create the graph given in above figure
            int V = 9;
            Graph g = new Graph(V);

            // making above shown graph
            g.addEdge(0, 1, 4);
            g.addEdge(0, 7, 8);
            g.addEdge(1, 2, 8);
            g.addEdge(1, 7, 11);
            g.addEdge(2, 3, 7);
            g.addEdge(2, 8, 2);
            g.addEdge(2, 5, 4);
            g.addEdge(3, 4, 9);
            g.addEdge(3, 5, 14);
            g.addEdge(4, 5, 10);
            g.addEdge(5, 6, 2);
            g.addEdge(6, 7, 1);
            g.addEdge(6, 8, 6);
            g.addEdge(7, 8, 7);

            int src = 0;
            int k = 62;

            if(g.pathMoreThanK(src, k))
                System.out.println("YES");
            else
                System.out.println("NO");


            k = 60;
            if(g.pathMoreThanK(src, k))
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }


    /*  Time Complexity : O(n!)
     *
    * */







    public static void main(String[] args) {

        /*Ques : Given a graph, a source vertex in the graph and a number k, find if there is a simple path
                 (without any cycle) starting from given source and ending at any other vertex such that
                 the distance from source to that vertex is atleast ‘k’ length.

            Example : 1

            Weighted Undirected Graph

            Input   : Source s = 0, k = 58
            Output  : True
                      There exists a simple path 0 -> 7 -> 1 -> 2 -> 8 -> 6 -> 5 -> 3 -> 4
                      Which has a total distance of 60 km which is more than 58.



            Input   : Source s = 0, k = 62
            Output  : False

            In the above graph, the longest simple path has distance 61 (0 -> 7 -> 1-> 2 -> 3 -> 4 -> 5-> 6 -> 8),
            so output should be false for any input greater than 61.


            // Follow the link for visual representation of the example......
            // Link : https://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/
        *
        *
        * */
    }






}
