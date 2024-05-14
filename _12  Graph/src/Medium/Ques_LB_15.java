package Medium;

public class Ques_LB_15 {

    //Ques  : Floyd Warshall Algorithm | DP-16.........................                        (GFG Ques.)


    //Approach :
    /*  Floyd Warshall Algorithm :
          1. Initialize the solution matrix same as the input graph matrix as a first step.
          2. Then update the solution matrix by considering all vertices as an intermediate vertex.
          3. The idea is to one by one pick all vertices and updates all shortest paths which include the picked vertex
             as an intermediate vertex in the shortest path.
          4. When we pick vertex number k as an intermediate vertex, we already have considered vertices
             {0, 1, 2, .. k-1} as intermediate vertices.
          5. For every pair (i, j) of the source and destination vertices respectively, there are two possible cases.
                a. k is not an intermediate vertex in shortest path from i to j.
                     We keep the value of dist[i][j] as it is.

                b. k is an intermediate vertex in shortest path from i to j.
                     We update the value of dist[i][j] as dist[i][k] + dist[k][j] if dist[i][j] > dist[i][k] + dist[k][j]
    *
    * */
    // Java program for Floyd Warshall All Pairs Shortest Path algorithm.
    static class AllPairShortestPath {
        final static int INF = 99999, V = 4;

        void floydWarshall(int graph[][])
        {
            int dist[][] = new int[V][V];
            int i, j, k;

            /* Initialize the solution matrix same as input graph matrix.
               Or we can say the initial values of the shortest distances are based on shortest paths
                  considering no intermediate vertex.
            */

            for (i = 0; i < V; i++)
                for (j = 0; j < V; j++)
                    dist[i][j] = graph[i][j];

            /* Add all vertices one by one to the set of intermediate vertices.
               ---> Before start of an iteration, we have the shortest distances between all pairs
                    of vertices such that the shortest distances consider only the vertices in
                    set {0, 1, 2, ... k-1} as intermediate vertices.

               ---> After the end of an iteration, vertex no. k is added to the set of intermediate
                    vertices and the set becomes {0, 1, 2, .. k}

            */
            for (k = 0; k < V; k++)
            {
                // Pick all vertices as source one by one
                for (i = 0; i < V; i++)
                {
                    // Pick all vertices as destination for the above picked source
                    for (j = 0; j < V; j++)
                    {
                        // If vertex k is on the shortest path from i to j, then update the value of dist[i][j]
                        if (dist[i][k] + dist[k][j]  < dist[i][j])
                            dist[i][j]  = dist[i][k] + dist[k][j];
                    }
                }
            }

            // Print the shortest distance matrix
            printSolution(dist);
        }

        void printSolution(int dist[][])
        {
            System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
            for (int i = 0; i < V; ++i) {
                for (int j = 0; j < V; ++j) {
                    if (dist[i][j] == INF)
                        System.out.print("INF ");
                    else
                        System.out.print(dist[i][j] + "   ");
                }
                System.out.println();
            }
        }

        // Driver's code
        public static void main(String[] args)
        {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
            int graph[][] = {   { 0, 5, INF, 10 },
                                { INF, 0, 3, INF },
                                { INF, INF, 0, 1 },
                                { INF, INF, INF, 0 } };
            AllPairShortestPath a = new AllPairShortestPath();

            // Function call
            a.floydWarshall(graph);
        }
    }


    /*  Time Complexity : O(V^3)
        Auxiliary Space : O(V^2)
    *
    * */






    //Author's Solution :
    //Back-end complete function template for JAVA
    class Solution {
        public void shortest_distance(int[][] matrix)
        {
            int INF = Integer.MAX_VALUE;
            int n = matrix.length;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == -1)
                        matrix[i][j] = INF;
                }
            }

            for (int k = 0; k < n; ++k) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (matrix[i][k] < INF && matrix[k][j] < INF && matrix[i][k] + matrix[k][j] < INF) {
                            matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                        }
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] >= INF)
                        matrix[i][j] = -1;
                }
            }
        }
    }






    public static void main(String[] args) {

        /*Ques : The Floyd Warshall Algorithm is for solving all pairs, shortest path problem. The problem is
                 to find the shortest distances between every pair of vertices in a given edge-weighted directed Graph.


            Example :
            Input   :  graph[][] = { {0,   5,  INF, 10},
                                     {INF,  0,  3,  INF},
                                     {INF, INF, 0,   1},
                                     {INF, INF, INF, 0}  };
            which represents the following graph
                         10
                  (0)——->(3)
                    |              /|\
                 5 |               |  1
                    |               |
                   \|/             |
                  (1)——->(2)
                          3
            Output: Shortest distance matrix
                0        5      8      9
               INF       0      3      4
               INF      INF     0      1
               INF      INF    INF     0


        *
        *
        *
        * */
    }




}
