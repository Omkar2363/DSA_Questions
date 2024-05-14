package Easy;

import java.util.Iterator;
import java.util.LinkedList;

public class Ques_LB_3 {

    //Ques : Depth First Search or DFS for a Graph..........                              (GFG QUes.)


    //Approach 1 : For Connected Graph......
    /*  Follow the below steps to solve the problem :
          1. Create a recursive function that takes the index of the node and a visited array.
          2. Mark the current node as visited and print the node.
          3. Traverse all the adjacent and unmarked nodes and call the recursive function with
             the index of the adjacent node.
    *
    * */
    // Java program to print DFS traversal from a given graph
    // This class represents a directed graph using adjacency list representation
    static class Graph {
        private int V;                                   // No. of vertices

        // Array  of lists for
        // Adjacency List Representation
        private LinkedList<Integer> adj[];

        // Constructor
        @SuppressWarnings("unchecked")
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj[v].add(w);                           // Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[])
        {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // The function to do DFS traversal.
        // It uses recursive DFSUtil()
        void DFS(int v)
        {
            // Mark all the vertices as not visited (set as false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(v, visited);
        }

        // Driver's Code
        public static void main_1(String args[])
        {
            Graph g = new Graph(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

            // Function call
            g.DFS(2);
        }
    }


    /*  Time complexity  : O(V + E),  where V is the number of vertices and E is the number of edges in the graph.
        Auxiliary Space  : O(V),      since an extra visited array of size V is required.
    *
    * */






    //Approach 2 : For Disconnected Graph........
    /*  Handling A Disconnected Graph :
            This will happen by handling a corner case.

            The above code traverses only the vertices reachable from a given source vertex. All the vertices
            may not be reachable from a given vertex, as in a Disconnected graph. To do a complete DFS traversal
            of such graphs, run DFS from all unvisited nodes after a DFS. The recursive function remains the same.


            * Follow the below steps to solve the problem :
                1. Create a recursive function that takes the index of the node and a visited array.
                2. Mark the current node as visited and print the node.
                3. Traverse all the adjacent and unmarked nodes and call the recursive function with the index
                   of the adjacent node.
                4. Run a loop from 0 to the number of vertices and check if the node is unvisited in the previous DFS,
                   then call the recursive function with the current node.

    *
    *
    * */
    // Java program to print DFS traversal from a given graph
    // This class represents a directed graph using adjacency list representation
    static class Graph_2 {
        private int V;                                    // No. of vertices

        // Array  of lists for
        // Adjacency List Representation
        private LinkedList<Integer> adj[];

        // Constructor
        @SuppressWarnings("unchecked")
        Graph_2(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj[v].add(w);                            // Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[])
        {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v + " ");

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited);
            }
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        void DFS()
        {
            // Mark all the vertices as not visited (set as false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal starting from all vertices one by one
            for (int i = 0; i < V; ++i)
                if (visited[i] == false)
                    DFSUtil(i, visited);
        }

        // Driver's Code
        public static void main_2(String args[])
        {
            Graph_2 g = new Graph_2(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Following is Depth First Traversal");

            // Function call
            g.DFS();
        }
    }



    /*  Time complexity : O(V + E),  where V is the number of vertices and E is the number of edges in the graph.
        Auxiliary Space : O(V),      since an extra visited array of size V is required.

    *
    * */








    public static void main(String[] args) {

        /*Ques : Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree.
                 The only catch here is, that, unlike trees, graphs may contain cycles (a node may be visited twice).
                 To avoid processing a node more than once, use a boolean visited array. A graph can have more than
                 one DFS traversal.


            Example : 1
            Input   : n = 4, e = 6
                      0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
            Output  : DFS from vertex 1 : 1 2 0 3
            Explanation :
            DFS Diagram :




            Example : 2
            Input   : n = 4, e = 6
                      2 -> 0, 0 -> 2, 1 -> 2, 0 -> 1, 3 -> 3, 1 -> 3
            Output  : DFS from vertex 2 : 2 0 1 3
            Explanation :
            DFS Diagram :

            // Follow the link for visual Representation of the Example.....
            // Link : https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
        *
        * */
    }






}
