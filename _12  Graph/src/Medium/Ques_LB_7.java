package Medium;

import java.util.*;

public class Ques_LB_7 {

    //Ques : Kahn’s algorithm for Topological Sorting............                          (GFG Ques.)


    //Approach :
    // A Java program to print topological sorting of a graph using indegrees
    // Class to represent a graph
    static class Graph {

        // No. of vertices
        int V;

        // An Array of List which contains references to the Adjacency List of each vertex
        List<Integer> adj[];
        // Constructor
        public Graph(int V)
        {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++)
                adj[i] = new ArrayList<Integer>();
        }

        // Function to add an edge to graph
        public void addEdge(int u, int v)
        {
            adj[u].add(v);
        }
        // prints a Topological Sort of the complete graph
        public void topologicalSort()
        {
            // Create a array to store indegrees of all vertices. Initialize all indegrees as 0.
            int indegree[] = new int[V];

            // Traverse adjacency lists to fill indegrees of vertices.
            // This step takes O(V+E) time
            for (int i = 0; i < V; i++)
            {
                ArrayList<Integer> temp = (ArrayList<Integer>)adj[i];
                for (int node : temp)
                {
                    indegree[node]++;
                }
            }

            // Create a queue and enqueue all vertices with indegree 0
            Queue<Integer> q = new LinkedList<Integer>();
            for (int i = 0; i < V; i++)
            {
                if (indegree[i] == 0)
                    q.add(i);
            }

            // Initialize count of visited vertices
            int cnt = 0;

            // Create a vector to store result (A topological ordering of the vertices)
            Vector<Integer> topOrder = new Vector<Integer>();
            while (!q.isEmpty()) {

                // Extract front of queue (or perform dequeue) and add it to topological order
                int u = q.poll();
                topOrder.add(u);

                // Iterate through all its neighbouring nodes of dequeued node u and
                // decrease their in-degree by 1
                for (int node : adj[u])
                {
                    // If in-degree becomes zero, add it to queue
                    if (--indegree[node] == 0)
                        q.add(node);
                }
                cnt++;
            }

            // Check if there was a cycle
            if (cnt != V) {
                System.out.println("There exists a cycle in the graph");
                return;
            }

            // Print topological order
            for (int i : topOrder)
            {
                System.out.print(i + " ");
            }
        }
    }
    // Driver program to test above functions
    static class Main {
        public static void main_1(String args[])
        {
            // Create a graph given in the above diagram
            Graph g = new Graph(6);
            g.addEdge(5, 2);
            g.addEdge(5, 0);
            g.addEdge(4, 0);
            g.addEdge(4, 1);
            g.addEdge(2, 3);
            g.addEdge(3, 1);
            System.out.println("Following is a Topological Sort");
            g.topologicalSort();
        }
    }


    /*  Complexity Analysis :
          * Time Complexity : O(V+E)  The outer for loop will be executed V number of times and the inner for loop will
                                      be executed E number of times.
          * Auxiliary Space : O(V)    The queue needs to store all the vertices of the graph.
                                      So the space required is O(V).
    *
    * */




    public static void main(String[] args) {

        /*Ques : Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that
                 for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph
                 is not possible if the graph is not a DAG.

            For example, a topological sorting of the following graph is “5 4 2 3 1 0?. There can be more than one
                         topological sorting for a graph. For example, another topological sorting of the following
                         graph is “4 5 2 0 3 1″. The first vertex in topological sorting is always a vertex with an
                         in-degree of 0 (a vertex with no incoming edges).


            graph

            Let’s look at a few examples with proper explanation,

            Example : 1
            Input   :




            Output  : 5 4 2 3 1 0
            Explanation : The topological sorting of a DAG is done in a order such that for every directed edge uv,
                          vertex u comes before v in the ordering. 5 has no incoming edge. 4 has no incoming edge,
                          2 and 0 have incoming edge from 4 and 5 and 1 is placed at last.



            Example : 2
            Input   :



            Output  : 0 3 4 1 2
            Explanation : 0 and 3 have no incoming edge, 4 and 1 has incoming edge from 0 and 3. 2 is placed at last.



            // Follow the link for Visual Representation of the example.....
            // Link : https://www.cdn.geeksforgeeks.org/topological-sorting-indegree-based-solution/
        *
        *
        * */
    }




}
