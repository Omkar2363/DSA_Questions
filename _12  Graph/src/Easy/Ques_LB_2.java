package Easy;

import java.util.Iterator;
import java.util.LinkedList;

public class Ques_LB_2 {

    //Ques : BFS of graph............                                                     (GFG Ques.)


    //Approach 1 :
    /*  Implementation of BFS traversal :
            * Follow the below method to implement BFS traversal.
                1. Declare a queue and insert the starting vertex.
                2. Initialize a visited array and mark the starting vertex as visited.
                3. Follow the below process till the queue becomes empty:
                    a. Remove the first vertex of the queue.
                    b. Mark that vertex as visited.
                    c. Insert all the unvisited neighbours of the vertex into the queue.
    *
    * */
    // Java program to print BFS traversal from a given source vertex.
    // BFS(int s) traverses vertices reachable from s.
    // This class represents a directed graph using adjacency list representation
    static class Graph {
        private int V;                                // No. of vertices
        private LinkedList<Integer> adj[];            //Adjacency Lists

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v,int w)
        {
            adj[v].add(w);
        }

        // prints BFS traversal from a given source s
        void BFS(int s)
        {
            // Mark all the vertices as not visited (By default set as false)
            boolean visited[] = new boolean[V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s] = true;
            queue.add(s);

            while (queue.size() != 0)
            {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                System.out.print(s + " ");

                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it visited and enqueue it
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext())
                {
                    int n = i.next();
                    if (!visited[n])
                    {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        // Driver method to
        public static void main_1(String args[])
        {
            Graph g = new Graph(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

            g.BFS(2);
        }
    }

    /*  Time Complexity : O(V+E),  where V is the number of nodes and E is the number of edges.
        Auxiliary Space : O(V)
    * */





    //Approach 2 : For Disconnected Graph.......
    /*  BFS for Disconnected Graph :
            Note that the above code traverses only the vertices reachable from a given source vertex.
            In every situation, all the vertices may not be reachable from a given vertex (i.e. for a disconnected graph).

        To print all the vertices, we can modify the BFS function to do traversal starting from all nodes
        one by one (Like the DFS modified version).

        Below is the implementation for BFS traversal for the entire graph
            (valid for directed as well as undirected graphs) with possible multiple disconnected components:
    *
    * */
    //C++ Code....
    /*
        -> Generic Function for BFS traversal of a Graph (valid for directed as well as undirected graphs
                                                           which can have multiple disconnected components)
        -- Inputs :
            -> V     - represents number of vertices in the Graph
            -> adj[] - represents adjacency list for the Graph
        -- Output :
            -> bfs_traversal - a vector containing bfs traversal for entire graph


    vector<int> bfsOfGraph(int V, vector<int> adj[])
    {
        vector<int> bfs_traversal;
        vector<bool> vis(V, false);
        for (int i = 0; i < V; ++i)
        {
            // To check if already visited
            if (!vis[i])
            {
                queue<int> q;
                vis[i] = true;
                q.push(i);

                // BFS starting from ith node
                while (!q.empty())
                {
                    int g_node = q.front();
                    q.pop();
                    bfs_traversal.push_back(g_node);
                    for (auto it : adj[g_node]) {
                        if (!vis[it]) {
                            vis[it] = true;
                            q.push(it);
                        }
                    }
                }
            }
        }
        return bfs_traversal;
    }
    *
    *
    * */







    public static void main(String[] args) {

        /*Ques : Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.

                 Note : One can move from node u to node v only if there's an edge from u to v and find the BFS traversal
                        of the graph starting from the 0th vertex, from left to right according to the graph.
                        Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


            Example : 1
            Input   : // Follow the link for Visual Representation of the Example :
                      // Link : https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

            Output  : 0 1 2 3 4
            Explanation : 0 is connected to 1 , 2 , 3.
                          2 is connected to 4.
                          So starting from 0, it will go to 1 then 2 then 3.
                          After this 2 to 4, thus bfs will be 0 1 2 3 4.


            Example : 2
            Input   :

            Output  : 0 1 2
            Explanation : 0 is connected to 1 , 2.
                          So starting from 0, it will go to 1 then 2, thus bfs will be 0 1 2.


            Your task :
            You do not need to read input or print anything. Your task is to complete the function bfsOfGraph()
            which takes the integer V denoting the number of vertices and adjacency list as input parameters and
            returns  a list containing the BFS traversal of the graph starting from the 0th vertex from left to right.


            Expected Time Complexity : O(V + E)
            Expected Auxiliary Space : O(V)


        *
        *
        * */
    }






}
