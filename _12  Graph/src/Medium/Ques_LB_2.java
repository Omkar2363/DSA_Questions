package Medium;

import java.util.Iterator;
import java.util.LinkedList;

public class Ques_LB_2 {

    //Ques : Detect cycle in an undirected graph............                                (GFG Ques.)


    //Approach 1 :
    // A Java Program to detect cycle in an undirected graph
    // This class represents a directed graph using adjacency list representation
    static class Graph {

        // No. of vertices
        private int V;

        // Adjacency List Representation
        private LinkedList<Integer> adj[];

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj[v].add(w);
            adj[w].add(v);
        }

        // A recursive function that uses visited[] and parent to detect cycle in
        // subgraph reachable from vertex v.
        Boolean isCyclicUtil(int v, Boolean visited[], int parent)
        {
            // Mark the current node as visited
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();

                // If an adjacent is not visited, then recur for that adjacent
                if (!visited[i]) {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                }

                // If an adjacent is visited and not parent of current vertex, then there is a cycle.
                else if (i != parent)
                    return true;
            }
            return false;
        }

        // Returns true if the graph contains a cycle, else false.
        Boolean isCyclic()
        {

            // Mark all the vertices as not visited and not part of recursion stack
            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to detect cycle in different DFS trees
            for (int u = 0; u < V; u++) {

                // Don't recur for u if already visited
                if (!visited[u])
                    if (isCyclicUtil(u, visited, -1))
                        return true;
            }

            return false;
        }

        // Driver method to test above methods
        public static void main_1(String args[])
        {

            // Create a graph given in the above diagram
            Graph g1 = new Graph(5);
            g1.addEdge(1, 0);
            g1.addEdge(0, 2);
            g1.addEdge(2, 1);
            g1.addEdge(0, 3);
            g1.addEdge(3, 4);
            if (g1.isCyclic())
                System.out.println("Graph contains cycle");
            else
                System.out.println("Graph doesn't contain cycle");

            Graph g2 = new Graph(3);
            g2.addEdge(0, 1);
            g2.addEdge(1, 2);
            if (g2.isCyclic())
                System.out.println("Graph contains cycle");
            else
                System.out.println("Graph doesn't contain cycle");
        }
    }



    /*  Time Complexity : O(V+E), The program does a simple DFS Traversal of the graph which is
                                  represented using an adjacency list. So the time complexity is O(V+E).
        Auxiliary Space : O(V),   To store the visited array O(V) space is required.
    *
    * */






    public static void main(String[] args) {

        /*Ques : Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.


            Example : 1
            Input   : V = 5, E = 5
                      adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}
            Output  : 1
            Explanation : 1->2->3->4->1 is a cycle.


            Example : 2
            Input   : V = 4, E = 2
                      adj = {{}, {2}, {1, 3}, {2}}
            Output  : 0
            Explanation :

            No cycle in the graph.



            Your Task :
            You don't need to read or print anything. Your task is to complete the function isCycle() which takes
            V denoting the number of vertices and adjacency list as input parameters and returns a boolean value
            denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.


            NOTE : The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which
                   ith vertex is connected.



            Expected Time Complexity  : O(V + E)
            Expected Space Complexity : O(V)


            // Follow the link for visual representation of the example......
            // Link : https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

        *
        *
        * */
    }




}
