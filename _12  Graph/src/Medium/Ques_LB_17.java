package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ques_LB_17 {

    //Ques : Check whether a given graph is Bipartite or not.............                         (GFG Ques.)


    //Approach 1 : By using BFS.........(For Connected graphs only....)
    /*  Algorithm to check if a graph is Bipartite:
            One approach is to check whether the graph is 2-colorable or not using (backtracking algorithm m coloring problem).

        * Following is a simple algorithm to find out whether a given graph is Bipartite or not using (Breadth First Search (BFS)).
            1. Assign RED color to the source vertex (putting into set U).
            2. Color all the neighbors with BLUE color (putting into set V).
            3. Color all neighbor’s neighbor with RED color (putting into set U).
            4. This way, assign color to all vertices such that it satisfies all the constraints of m way coloring
               problem where m = 2.
            5. While assigning colors, if we find a neighbor which is colored with same color as current vertex,
               then the graph cannot be colored with 2 vertices (or graph is not Bipartite)
    *
    * */
    // Java program to find out whether a given graph is Bipartite or not
    static class Bipartite_1 {
        final static int V = 4;                                           // No. of Vertices

        // This function returns true if graph G[V][V] is Bipartite, else false
        boolean isBipartite(int G[][],int src)
        {
            // Create a color array to store colors assigned to all vertices.
            // Vertex number is used as index in this array. The value '-1' of colorArr[i] is used to indicate
            // that no color is assigned to vertex 'i'.
            // The value 1 is used to indicate first color is assigned and
            // The value 0 indicates second color is assigned.
            int colorArr[] = new int[V];
            for (int i=0; i<V; ++i)
                colorArr[i] = -1;

            // Assign first color to source
            colorArr[src] = 1;

            // Create a queue (FIFO) of vertex numbers and enqueue source vertex for BFS traversal
            LinkedList<Integer> q = new LinkedList<Integer>();
            q.add(src);

            // Run while there are vertices in queue (Similar to BFS)
            while (q.size() != 0)
            {
                // Dequeue a vertex from queue
                int u = q.poll();

                // Return false if there is a self-loop
                if (G[u][u] == 1)
                    return false;

                // Find all non-colored adjacent vertices
                for (int v=0; v<V; ++v)
                {
                    // An edge from u to v exists and destination v is not colored
                    if (G[u][v]==1 && colorArr[v]==-1)
                    {
                        // Assign alternate color to this adjacent v of u
                        colorArr[v] = 1-colorArr[u];
                        q.add(v);
                    }

                    // An edge from u to v exists and destination v is colored with same color as u
                    else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                        return false;
                }
            }
            // If we reach here, then all adjacent vertices can be colored with alternate color
            return true;
        }

        // Driver program to test above function
        public static void main_1(String[] args)
        {
            int G[][] = {   {0, 1, 0, 1},
                            {1, 0, 1, 0},
                            {0, 1, 0, 1},
                            {1, 0, 1, 0}    };
            Bipartite_1 b = new Bipartite_1();
            if (b.isBipartite(G, 0))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    /*  Time Complexity  : O(V*V) as adjacency matrix is used for graph but can be made O(V+E) by using adjacency list
        Space Complexity : O(V)   due to queue and color vector.
    *
    * */



    //Approach 2 : By using BFS.........(For Disconnected graphs only....)
    // JAVA Code to check whether a given graph is Bipartite or not
    class Bipartite_2 {

        public static int V = 4;

        // This function returns true if graph G[V][V] is Bipartite, else false
        public static boolean
        isBipartiteUtil(int G[][], int src, int colorArr[])
        {
            colorArr[src] = 1;

            // Create a queue (FIFO) of vertex numbers and enqueue source vertex for BFS traversal
            LinkedList<Integer> q = new LinkedList<Integer>();
            q.add(src);

            // Run while there are vertices in queue (Similar to BFS)
            while (!q.isEmpty())
            {
                // Dequeue a vertex from queue ( Refer http://goo.gl/35oz8 )
                int u = q.getFirst();
                q.pop();

                // Return false if there is a self-loop
                if (G[u][u] == 1)
                    return false;

                // Find all non-colored adjacent vertices
                for (int v = 0; v < V; ++v)
                {
                    // An edge from u to v exists and destination v is not colored
                    if (G[u][v] == 1 && colorArr[v] == -1)
                    {
                        // Assign alternate color to this adjacent v of u
                        colorArr[v] = 1 - colorArr[u];
                        q.push(v);
                    }

                    // An edge from u to v exists and destination v is colored with same color as u
                    else if (G[u][v] == 1  &&  colorArr[v] == colorArr[u])
                        return false;
                }
            }

            // If we reach here, then all adjacent vertices can be colored with alternate color
            return true;
        }

        // Returns true if G[][] is Bipartite, else false
        public static boolean isBipartite(int G[][])
        {
            // Create a color array to store colors assigned to all vertices.
            // Vertex/ number is used as index in this array. The value '-1' of colorArr[i] is used to indicate that
            // no color is assigned to vertex 'i'.
            // The value 1 is used to indicate first color is assigned and
            // the value 0 indicates second color is assigned.
            int colorArr[] = new int[V];
            for (int i = 0; i < V; ++i)
                colorArr[i] = -1;

            // This code is to handle disconnected graph
            for (int i = 0; i < V; i++)
                if (colorArr[i] == -1)
                    if (isBipartiteUtil(G, i, colorArr) == false)
                        return false;

            return true;
        }

        /* Driver code*/
        public static void main_2(String[] args)
        {
            int G[][] = {   { 0, 1, 0, 1 },
                            { 1, 0, 1, 0 },
                            { 0, 1, 0, 1 },
                            { 1, 0, 1, 0 } };

            if (isBipartite(G))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    /*  Time Complexity of the above approach is same as that Breadth First Search.
        In above implementation T.C. is O(V^2) where V is number of vertices.

        If graph is represented using adjacency list, then the complexity becomes O(V+E).
    *
    * */




    //Approach 3 : Works for both connected and disconnected Graphs........
    public class GFG_3 {
        static class Pair{
            int first, second;

            Pair(int f, int s){
                first = f;
                second = s;
            }
        }

        static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // vector to store colour of vertex assigning all to -1
            // i.e. uncoloured colours are either 0 or 1
            // for understanding take 0 as red and 1 as blue
            int col[] = new int[V];
            Arrays.fill(col, -1);

            // queue for BFS storing {vertex , colour}
            Queue<Pair> q = new LinkedList<Pair>();

            //loop in case graph is not connected
            for (int i = 0; i < V; i++) {

                // if not coloured
                if (col[i] == -1)
                {
                    // colouring with 0 i.e. red
                    q.add(new Pair(i, 0));
                    col[i] = 0;

                    while (!q.isEmpty()) {
                        Pair p = q.peek();
                        q.poll();

                        //current vertex
                        int v = p.first;

                        // colour of current vertex
                        int c = p.second;

                        // traversing vertexes connected to current vertex
                        for (int j : adj.get(v))
                        {

                            // if already coloured with parent vertex color
                            // then bipartite graph is not possible
                            if (col[j] == c)
                                return false;

                            // if uncoloured
                            if (col[j] == -1)
                            {

                                // colouring with opposite color to that of parent
                                col[j] = (c==1) ? 0 : 1;
                                q.add(new Pair(j, col[j]));
                            }
                        }
                    }
                }
            }

            // if all vertexes are coloured such that no two connected vertex have same colours
            return true;
        }

        // Driver Code Starts.
        public static void main_3(String args[])
        {

            int V, E;
            V = 4 ;
            E = 8;

            // adjacency list for storing graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }

            adj.get(0).add(1);
            adj.get(0).add(3);

            adj.get(1).add(0);
            adj.get(1).add(2);

            adj.get(2).add(1);
            adj.get(2).add(3);

            adj.get(3).add(0);
            adj.get(3).add(2);

            boolean ans = isBipartite(V, adj);

            // returns 1 if bipartite graph is possible
            if (ans)
                System.out.println("Yes");

                // returns 0 if bipartite graph is not possible
            else
                System.out.println("No");

        }
    }

    /*  Time Complexity : O(V+E)
        Auxiliary Space : O(V)
    *
    * */






    //Approach 4 : By using DFS.........(Using Recursion)
    // Java program to find out whether a given graph is Bipartite or not.
    // Using recursion.
    class GFG_4 {
        static final int V = 4;

        static boolean colorGraph(int G[][], int color[], int pos, int c)
        {
            if (color[pos] != -1  &&  color[pos] != c)
                return false;

            // color this pos as c and all its neighbours as 1-c
            color[pos] = c;
            boolean ans = true;
            for (int i = 0; i < V; i++)
            {
                if (G[pos][i] == 1)
                {
                    if (color[i] == -1)
                        ans &= colorGraph(G, color, i, 1 - c);                     //Bitwise Operation....

                    if (color[i] != -1 && color[i] != 1 - c)
                        return false;
                }
                if (!ans)
                    return false;
            }
            return true;
        }

        static boolean isBipartite(int G[][])
        {
            int[] color = new int[V];
            for (int i = 0; i < V; i++)
                color[i] = -1;

            // start is vertex 0;
            int pos = 0;

            // two colors 1 and 0
            return colorGraph(G, color, pos, 1);
        }

        // Driver Code
        public static void main_4(String[] args)
        {
            int G[][] = {   { 0, 1, 0, 1 },
                            { 1, 0, 1, 0 },
                            { 0, 1, 0, 1 },
                            { 1, 0, 1, 0 }   };

            if (isBipartite(G))
                System.out.print("Yes");
            else
                System.out.print("No");
        }
    }

    /*  Time Complexity : O(V+E)
        Auxiliary Space : O(V)
    *
    * */




    public static void main(String[] args) {

        /*Ques : A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V
                 such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U.
                 In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v to U.
                 We can also say that there is no edge that connects vertices of same set.

            Bipartite1

            A bipartite graph is possible if the graph coloring is possible using two colors such that vertices in a set are colored with the same color. Note that it is possible to color a cycle graph with even cycle using two colors. For example, see the following graph.

            Bipartite2


            It is not possible to color a cycle graph with odd cycle using two colors.

            Bipartite3


            // Follow the link for visual representation of the examples.......
            // Link : https://www.geeksforgeeks.org/bipartite-graph/

        *
        * */
    }




}
