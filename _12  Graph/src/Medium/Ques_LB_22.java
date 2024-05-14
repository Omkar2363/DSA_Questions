package Medium;

public class Ques_LB_22 {

    //Ques : Number of Triangles in Directed and Undirected Graphs...............               (GFG Ques.)


    //Approach 1 : For Directed Graph
    /* The idea is to use three nested loops to consider every triplet (i, j, k) and check for the above condition
       (there is an edge from i to j, j to k and k to i)

       However, in an undirected graph, the triplet (i, j, k) can be permuted to give six combination
       (See previous post for details). Hence, we divide the total count by 6 to get the actual number of triangles.

       In case of directed graph, the number of permutation would be 3 (as order of nodes becomes relevant).
       Hence, in this case the total number of triangles will be obtained by dividing total count by 3.
       For example consider the directed graph given below

     */
    // Java program to count triangles in a graph. The program is for adjacency matrix representation of the graph.
    static class GFG {

        // Number of vertices in the graph
        int V = 4;

        // function to calculate the number of triangles in a simple directed/undirected graph.
        // isDirected is true if the graph is directed, it's false otherwise.
        int countTriangle(int graph[][], boolean isDirected)
        {
            // Initialize result
            int count_Triangle = 0;

            // Consider every possible triplet of edges in graph
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    for (int k=0; k<V; k++)
                    {
                        // Check the triplet if it satisfies the condition
                        if (graph[i][j] == 1  &&  graph[j][k] == 1  &&  graph[k][i] == 1)
                            count_Triangle++;
                    }
                }
            }

            // If graph is directed , division is done by 3 else
            // division by 6 is done
            if(isDirected == true)
            {
                count_Triangle /= 3;
            }
            else
            {
                count_Triangle /= 6;
            }
            return count_Triangle;
        }

        // Driver code
        public static void main_1(String args[])
        {

            // Create adjacency matrix of an undirected graph
            int graph[][] = {   {0, 1, 1, 0},
                                {1, 0, 1, 1},
                                {1, 1, 0, 1},
                                {0, 1, 1, 0}
                                                };

            // Create adjacency matrix of a directed graph
            int digraph[][] = { {0, 0, 1, 0},
                                {1, 0, 0, 1},
                                {0, 1, 0, 0},
                                {0, 0, 1, 0}
                                                };

            GFG obj = new GFG();

            System.out.println("The Number of triangles " + "in undirected graph : " +
                                        obj.countTriangle(graph, false));

            System.out.println("\n\nThe Number of triangles" + " in directed graph : " +
                                        obj.countTriangle(digraph, true));

        }
    }






    //Approach 2 : For Undirected Graphs.
    /*      Follow the link for visual representation of the Graph.
            link : https://www.geeksforgeeks.org/number-of-triangles-in-a-undirected-graph/
    *
    * */
    // Java program to find number of triangles in an Undirected Graph.
    // The program is for adjacency matrix representation of the graph
    static class Directed {
        // Number of vertices in the graph
        int V = 4;

        // Utility function for matrix multiplication
        void multiply(int A[][], int B[][], int C[][])
        {
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    C[i][j] = 0;
                    for (int k = 0; k < V; k++)
                    {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }

        // Utility function to calculate trace of a matrix (sum of diagonal elements)
        int getTrace(int graph[][])
        {
            int trace = 0;

            for (int i = 0; i < V; i++)
            {
                trace += graph[i][i];
            }
            return trace;
        }

        // Utility function for calculating number of triangles in graph
        int triangleInGraph(int graph[][])
        {
            // To Store graph^2
            int[][] aux2 = new int[V][V];

            // To Store graph^3
            int[][] aux3 = new int[V][V];

            // Initialising aux matrices with 0
            for (int i = 0; i < V; ++i)
            {
                for (int j = 0; j < V; ++j)
                {
                    aux2[i][j] = aux3[i][j] = 0;
                }
            }

            // aux2 is graph^2 now printMatrix(aux2)
            multiply(graph, graph, aux2);

            // after this multiplication aux3 is graph^3 printMatrix(aux3)
            multiply(graph, aux2, aux3);

            int trace = getTrace(aux3);

            return trace / 6;
        }

        // Driver code
        public static void main_2(String args[])
        {
            Directed obj = new Directed();

            int graph[][] = {   {0, 1, 1, 0},
                                {1, 0, 1, 1},
                                {1, 1, 0, 1},
                                {0, 1, 1, 0}
                                                 };

            System.out.println("Total number of Triangle in Graph : " +
                                                 obj.triangleInGraph(graph));
        }
    }





    public static void main(String[] args) {

        /*Ques : Given a Graph, count number of triangles in it. The graph is can be directed or undirected.

            Example : 1
            Input   : digraph[V][V] = { {0, 0, 1, 0},
                                        {1, 0, 0, 1},
                                        {0, 1, 0, 0},
                                        {0, 0, 1, 0}
                                                     };
            Output  : 2
            Explanation : Given adjacency matrix represents following directed graph.

            // Follow the link for visual representation of the graph.
            // Link : https://www.geeksforgeeks.org/number-of-triangles-in-directed-and-undirected-graphs/
        *
        *
        * */
    }


}
