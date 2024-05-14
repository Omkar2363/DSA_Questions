package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Ques_LB_6 {

    //Ques : Topological sort............                                                   (GFG Ques.)


    //Approach 1 :
    // A Java program to print topological sorting of a DAG
    // This class represents a directed graph using adjacency list representation
    static class Graph {
        // No. of vertices
        private int V;

        // Adjacency List as ArrayList of ArrayList's
        private ArrayList<ArrayList<Integer>> adj;

        // Constructor
        Graph(int v)
        {
            V = v;
            adj = new ArrayList<ArrayList<Integer> >(v);
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<Integer>());
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w)
        {
            adj.get(v).add(w);
        }

        // A recursive function used by topologicalSort
        void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack)
        {
            // Mark the current node as visited.
            visited[v] = true;
            Integer i;

            // Recur for all the vertices adjacent to thisvertex
            Iterator<Integer> it = adj.get(v).iterator();
            while (it.hasNext())
            {
                i = it.next();
                if (!visited[i])
                    topologicalSortUtil(i, visited, stack);
            }

            // Push current vertex to stack which stores result
            stack.push(new Integer(v));
        }

        // The function to do Topological Sort. It uses recursive topologicalSortUtil()
        void topologicalSort()
        {
            Stack<Integer> stack = new Stack<Integer>();

            // Mark all the vertices as not visited
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to store Topological Sort
            // starting from all vertices one by one
            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);

            // Print contents of stack
            while (stack.empty() == false)
                System.out.print(stack.pop() + " ");
        }

        // Driver code
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

            System.out.println("Following is a Topological " + "sort of the given graph");
            // Function Call
            g.topologicalSort();
        }
    }


    /*  Complexity Analysis :
            Time Complexity : O(V+E)     The above algorithm is simply DFS with an extra stack.
                                         So time complexity is the same as DFS which is.
            Auxiliary space : O(V)       The extra space is needed for the stack.
    *
    * */





    //Author's Solution :
    class Solution {

        //Function to return list containing vertices in Topological order.
        static int[] topoSort(int N, ArrayList<ArrayList<Integer>> list)
        {
            //using boolean array to mark visited nodes and currently
            //marking all the nodes as false.
            boolean visited[] = new boolean[N];
            Arrays.fill(visited, false);
            Stack<Integer> st = new Stack<>();

            //traversing over all the vertices.
            for (int i = 0; i < N; i++)
            {
                //if the current vertex is not visited, we call the topo function.
                if (!visited[i])
                    topo(list, i, visited,st);
            }
            int A[] = new int[st.size()];
            int i = -1;
            while (!st.isEmpty())
            {
                //pushing elements of stack in list and popping them from stack.
                A[++i] = st.peek();
                st.pop();
            }
            //returning the list.
            return A;
        }

        static void topo(ArrayList<ArrayList<Integer>> list, int it, boolean visited[], Stack<Integer> s)
        {
            //marking the current vertex as visited.
            visited[it] = true;

            //traversing over the adjacent vertices.
            for (int i=0; i<list.get(it).size();i++)
            {
                //if any vertex is not visited, we call the function recursively.
                if (!visited[list.get(it).get(i)])
                    topo(list, list.get(it).get(i), visited, s);
            }
            //pushing the current vertex into the stack.
            s.push(it);
        }
    }






    public static void main(String[] args) {

        /*Ques : Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.


            Example : 1
            Input   :

            Output  : 1
            Explanation : The output 1 denotes that the order is valid. So, if you have, implemented
                          your function correctly, then output would be 1 for all test cases.
                          One possible Topological order for the graph is 3, 2, 1, 0.


            Example : 2
            Input   :

            Output  : 1
            Explanation : The output 1 denotes that the order is valid. So, if you have, implemented
                          your function correctly, then output would be 1 for all test cases.
                          One possible Topological order for the graph is 5, 4, 2, 1, 3, 0.


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function topoSort()  which
            takes the integer V denoting the number of vertices and adjacency list as input parameters and returns
            an array consisting of a the vertices in Topological order. As there are multiple Topological orders possible,
            you may return any of them. If your returned topo sort is correct then console output will be 1 else 0.


            Expected Time Complexity : O(V + E).
            Expected Auxiliary Space : O(V).


            // Follow the link for visual representation of the example :
            // Link : https://practice.geeksforgeeks.org/problems/topological-sort/1

        *
        *
        * */
    }





}
