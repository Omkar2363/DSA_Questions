package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ques_LB_1 {

    //Ques : Detect Cycle in a Directed Graph..........                                      (GFG Ques.)


    //Approach 1 :
    /*  Follow the below steps to Implement the idea :
          1. Create the graph using the given number of edges and vertices.
          2. Create a recursive function that initializes the current vertex, visited array, and recursion stack.
          3. Mark the current node as visited and also mark the index in the recursion stack.
          4. Find all the vertices which are not visited and are adjacent to the current node and recursively call the function for those vertices
               a. If the recursive function returns true, return true.
               b. If the adjacent vertices are already marked in the recursion stack then return true.
          5. Create a wrapper function, that calls the recursive function for all the vertices, and
               a. If any function returns true return true.
               b. Else if for all vertices the function returns false.
    *
    * */
    // A Java Program to detect cycle in a graph
    static class Graph {
        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V)
        {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++)
                adj.add(new LinkedList<>());
        }

        // This function is a variation of DFSUtil() in
        // https://www.geeksforgeeks.org/archives/18212
        private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)
        {

            // Mark the current node as visited and part of recursion stack
            if (recStack[i])
                return true;

            if (visited[i])
                return false;

            visited[i]  = true;

            recStack[i] = true;
            List<Integer> children = adj.get(i);

            for (Integer c: children)
                if (isCyclicUtil(c, visited, recStack))
                    return true;

            recStack[i] = false;

            return false;
        }

        private void addEdge(int source, int dest) {
            adj.get(source).add(dest);
        }

        // Returns true if the graph contains a cycle, else false.
        // This function is a variation of DFS() in
        // https://www.geeksforgeeks.org/archives/18212
        private boolean isCyclic()
        {

            // Mark all the vertices as not visited and not part of recursion stack
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];


            // Call the recursive helper function to detect cycle in different DFS trees
            for (int i = 0; i < V; i++)
                if (isCyclicUtil(i, visited, recStack))
                    return true;

            return false;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            Graph graph = new Graph(4);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 0);
            graph.addEdge(2, 3);
            graph.addEdge(3, 3);

            if(graph.isCyclic())
                System.out.println("Graph contains cycle");
            else
                System.out.println("Graph doesn't " + "contain cycle");
        }
    }


    /*  Time Complexity : O(V+E), the Time Complexity of this method is the same as the time complexity of
                                  DFS traversal which is O(V+E).
        Auxiliary Space : O(V)    To store the visited and recursion stack O(V) space is needed.
    *
    * */







    public static void main(String[] args) {

        /*Ques : Given the root of a Directed graph, The task is to check whether the graph contains a cycle
                 if yes then return true, return false otherwise.


            Example : 1
            Input   : N = 4, E = 6

            Detect Cycle in a Directed Graph 1

            Output  : Yes
            Explanation : The diagram clearly shows a cycle 0 -> 2 -> 0


            Example : 2
            Input   : N = 4, E = 4

            Detect Cycle in a Directed Graph 2

            Output  : No
            Explanation : The diagram clearly shows no cycle

            // Follow the link for Visual Representation of the Examples......
            // Link : https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
        *
        *
        * */
    }




}
