package Medium;

import java.util.Iterator;
import java.util.LinkedList;

public class Ques_12 {

    //Ques : Check if a given graph is tree or not...........                             (GFG Ques.)


    //Approach 1 :
    // A Java Program to check whether a graph is tree or not
    // This class represents a directed graph using adjacency list representation
    static class Graph {
        private int V;                                    // No. of vertices
        private LinkedList<Integer>  adj[];               //Adjacency List

        // Constructor
        @SuppressWarnings("unchecked")
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[V];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList<Integer>();
        }

        // Function to add an edge into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
            adj[w].add(v);
        }

        // A recursive function that uses visited[] and parent to detect cycle in subgraph reachable from vertex v.
        boolean isCyclicUtil(int v, boolean visited[], int parent)
        {
            // Mark the current node as visited
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[v].iterator();
            while (it.hasNext())
            {
                i = it.next();

                // If an adjacent is not visited, then recur for that adjacent
                if (!visited[i])
                {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                }

                // If an adjacent is visited and not parent of current vertex, then there is a cycle.
                else if (i != parent)
                    return true;
            }
            return false;
        }

        // Returns true if the graph is a tree, else false.
        boolean isTree()
        {
            // Mark all the vertices as not visited and not part of recursion stack
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // The call to isCyclicUtil serves multiple purposes. It returns true if graph reachable from vertex 0 is cyclic.
            // It also marks all vertices reachable from 0.
            if (isCyclicUtil(0, visited, -1))
                return false;

            // If we find a vertex which is not reachable from 0
            // (not marked by isCyclicUtil()), then we return false
            for (int u = 0; u < V; u++)
                if (!visited[u])
                    return false;

            return true;
        }

        // Driver method
        public static void main_1(String args[])
        {
            // Create a graph given in the above diagram
            Graph g1 = new Graph(5);
            g1.addEdge(1, 0);
            g1.addEdge(0, 2);
            g1.addEdge(0, 3);
            g1.addEdge(3, 4);
            if (g1.isTree())
                System.out.println("Graph is Tree");
            else
                System.out.println("Graph is not Tree");

            Graph g2 = new Graph(5);
            g2.addEdge(1, 0);
            g2.addEdge(0, 2);
            g2.addEdge(2, 1);
            g2.addEdge(0, 3);
            g2.addEdge(3, 4);

            if (g2.isTree())
                System.out.println("Graph is Tree");
            else
                System.out.println("Graph is not Tree");

        }
    }





    //Approach 2 :
    //C++ Code......
    /*  / A C++ Program to check whether a graph is tree or not
            #include<iostream>
            #include <list>
            #include <limits.h>
            using namespace std;

            // Class for an undirected graph
            class Graph
            {
                int V;                             // No. of vertices
                  int E;                           // No. of edges
                list<int> *adj;                    // Pointer to an array for adjacency lists
                void dfsTraversal(int v, bool visited[], int parent);
            public:
                Graph(int V);                     // Constructor
                void addEdge(int v, int w);       // to add an edge to graph
                bool isConnected();               // returns true if graph is connected
                bool isTree();                    // returns true of the graph is tree
            };

            Graph::Graph(int V)
            {
                E = 0;
                this->V = V;
                adj = new list<int>[V];
            }

            void Graph::addEdge(int v, int w)
            {
                E++;                            // increase the number of edges
                adj[v].push_back(w);            // Add w to v’s list.
                adj[w].push_back(v);            // Add v to w’s list.
            }


            // A recursive dfs function that uses visited[] and parent to
            // traverse the graph and mark visited[v] to true for visited nodes
            void Graph::dfsTraversal(int v, bool visited[], int parent)
            {
                // Mark the current node as visited
                visited[v] = true;

                // Recur for all the vertices adjacent to this vertex
                list<int>::iterator i;
                for (i = adj[v].begin(); i != adj[v].end(); ++i)
                {
                    // If an adjacent is not visited, then recur for that adjacent
                    if (!visited[*i])
                    {
                       dfsTraversal(*i, visited, v);
                    }
                }
            }

            // Returns true if the graph is connected, else false.
            bool Graph::isConnected()
            {
                // Mark all the vertices as not visited and not part of recursion stack
                bool *visited = new bool[V];
                for (int i = 0; i < V; i++)
                    visited[i] = false;

                // Performing DFS traversal of the graph and marking reachable vertices from 0 to true
                dfsTraversal(0, visited, -1);

                // If we find a vertex which is not reachable from 0 (not marked by dfsTraversal(),
                // then we return false since graph is not connected
                for (int u = 0; u < V; u++)
                    if (!visited[u])
                       return false;

                // since all nodes were reachable so we returned true and hence graph is connected
                return true;
            }

            bool Graph::isTree()
            {
                // as we proved earlier if a graph is connected and has
                // V - 1 edges then it is a tree i.e. E = V - 1
                return isConnected() and E == V - 1;
            }
            // Driver program to test above functions
            int main()
            {
                Graph g1(5);
                g1.addEdge(1, 0);
                g1.addEdge(0, 2);
                g1.addEdge(0, 3);
                g1.addEdge(3, 4);
                g1.isTree() ? cout << "Graph is Tree\n"      :
                              cout << "Graph is not Tree\n";

                Graph g2(5);
                g2.addEdge(1, 0);
                g2.addEdge(0, 2);
                g2.addEdge(2, 1);
                g2.addEdge(0, 3);
                g2.addEdge(3, 4);
                g2.isTree() ? cout << "Graph is Tree\n"      :
                              cout << "Graph is not Tree\n";

                return 0;
            }
    *
    * */

    /*  Time Complexity : O(V + E)  For performing the DFS traversal
        Auxiliary Space : O(V)      For storing the visited array
    *
    * */



    public static void main(String[] args) {

        /*Ques : Write a function that returns true if a given undirected graph is tree and false otherwise.

            For example, the following graph is a tree.

            //Follow the Link for visual representation of the Example :
            //Link : https://www.geeksforgeeks.org/check-given-graph-tree/#:~:text=Since%20the%20graph%20is%20undirected,graph%20is%20connected%2C%20otherwise%20not.
        *
        * */
    }



}
