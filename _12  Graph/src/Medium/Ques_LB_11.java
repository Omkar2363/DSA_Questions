package Medium;

public class Ques_LB_11 {

    //Ques : Prim’s Minimum Spanning Tree (MST) | Greedy Algo-5..........                        (GFG Ques.)
    //          (MST : Minimum Spanning Tree......)




    //Approach :
    /*  How does Prim’s Algorithm Work?
            The idea behind Prim’s algorithm is simple, a spanning tree means all vertices must be connected.
            So the two disjoint subsets (discussed above) of vertices must be connected to make a Spanning Tree.
            And they must be connected with the minimum weight edge to make it a Minimum Spanning Tree.

        * Follow the given steps to find MST using Prim’s Algorithm:
            1. Create a set mstSet that keeps track of vertices already included in MST.
            2. Assign a key value to all vertices in the input graph. Initialize all key values as INFINITE.
               Assign the key value as 0 for the first vertex so that it is picked first.
            3. While mstSet doesn’t include all vertices
                a. Pick a vertex u which is not there in mstSet and has a minimum key value.
                b. Include u in the mstSet.
                c. Update the key value of all adjacent vertices of u. To update the key values, iterate through
                   all adjacent vertices. For every adjacent vertex v, if the weight of edge u-v is less than
                   the previous key value of v, update the key value as the weight of u-v


        The idea of using key values is to pick the minimum weight edge from the cut. The key values are used only
        for vertices that are not yet included in MST, the key value for these vertices indicates the minimum weight
        edges connecting them to the set of vertices included in MST.



        Let us understand with the following illustration:

        // Follow the link for  visual representation.......
        // Link : https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
    *
    * */
    // A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
    // The program is for adjacency matrix representation of the graph
    static class MST {

        // Number of vertices in the graph
        private static final int V = 5;

        // A utility function to find the vertex with minimum key value,
        // from the set of vertices not yet included in MST
        int minKey(int key[], Boolean mstSet[])
        {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < V; v++) {
                if (mstSet[v] == false && key[v] < min) {
                    min = key[v];
                    min_index = v;
                }
            }

            return min_index;
        }

        // A utility function to print the constructed MST stored in parent[]
        void printMST(int parent[], int graph[][])
        {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < V; i++)
                System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }

        // Function to construct and print MST for a graph
        // represented using adjacency matrix representation
        void primMST(int graph[][])
        {

            // Array to store constructed MST
            int parent[] = new int[V];

            // Key values used to pick minimum weight edge in cut
            int key[] = new int[V];

            // To represent set of vertices included in MST
            Boolean mstSet[] = new Boolean[V];

            // Initialize all keys as INFINITE
            for (int i = 0; i < V; i++)
            {
                key[i] = Integer.MAX_VALUE;
                mstSet[i] = false;
            }

            // Always include first 1st vertex in MST.
            key[0] = 0;                                      // Make key 0 so that this vertex is

            // picked as first vertex
            parent[0] = -1;                                 // First node is always root of MST

            // The MST will have V vertices
            for (int count = 0; count < V - 1; count++)
            {
                // Pick thd minimum key vertex from the set of vertices not yet included in MST
                int u = minKey(key, mstSet);

                // Add the picked vertex to the MST Set
                mstSet[u] = true;

                // Update key value and parent index of the adjacent vertices of the picked vertex.
                // Consider only those vertices which are not yet included in MST
                for (int v = 0; v < V; v++) {

                    // graph[u][v] is  non-zero only for adjacent vertices of m,
                    // mstSet[v] is false for vertices not yet included in MST,
                    // Update the key only if graph[u][v] is smaller than key[v]
                    if (graph[u][v] != 0  &&  mstSet[v] == false  &&  graph[u][v] < key[v])
                    {
                        parent[v] = u;
                        key[v] = graph[u][v];
                    }
                }
            }

            // print the constructed MST
            printMST(parent, graph);
        }

        public static void main_1(String[] args)
        {
        /* Let us create the following graph
            2 3
            (0)--(1)--(2)
            | / \ |
            6| 8/ \5 |7
            | /     \ |
            (3)-------(4)
                9
        */
            MST t = new MST();
            int graph[][] = new int[][] {   { 0, 2, 0, 6, 0 },
                                            { 2, 0, 3, 8, 5 },
                                            { 0, 3, 0, 0, 7 },
                                            { 6, 8, 0, 0, 9 },
                                            { 0, 5, 7, 9, 0 } };

            // Print the solution
            t.primMST(graph);
        }
    }


    /*  Time Complexity : O(V^2),     If the input graph is represented using an adjacency list,
                                      then the time complexity of Prim’s algorithm can be reduced to O(E * log V)
                                      with the help of a binary heap.
                                      In this implementation, we are always considering the spanning tree to start from
                                      the root of the graph
        Auxiliary Space : O(V)
    *
    *
    * */



    public static void main(String[] args) {

        /*Ques : Introduction to Prim’s algorithm :
                    We have discussed Kruskal’s algorithm for Minimum Spanning Tree.
                    Like Kruskal’s algorithm, Prim’s algorithm is also a Greedy algorithm. Prim’s algorithm always
                    starts with a single node, and it moves through several adjacent nodes, in order to explore all
                    of the connected edges along the way.

                It starts with an empty spanning tree. The idea is to maintain two sets of vertices. The first set contains
                the vertices already included in the MST, the other set contains the vertices not yet included.
                At every step, it considers all the edges that connect the two sets and picks the minimum weight edge
                from these edges. After picking the edge, it moves the other endpoint of the edge to the set containing MST.


                A group of edges that connects two sets of vertices in a graph is called cut in graph theory.
                So, at every step of Prim’s algorithm, find a cut (of two sets, one contains the vertices already
                included in MST and the other contains the rest of the vertices), pick the minimum weight edge from the cut,
                and include this vertex to MST Set (the set that contains already included vertices).



        Note : What is a Spanning Tree?

        A Spanning tree is a subset to a connected graph G, where all the edges are connected, i.e, one can traverse to any edge from a particular edge with or without intermediates. Also, a spanning tree must not have any cycle in it. Thus we can say that if there are N vertices in a connected graph then the no. of edges that a spanning tree may have is N-1.

        What is a Minimum Spanning Tree?
        Given a connected and undirected graph, a spanning tree of that graph is a subgraph that is a tree and connects all the vertices together. A single graph can have many different spanning trees. A minimum spanning tree (MST) or minimum weight spanning tree for a weighted, connected, undirected graph is a spanning tree with a weight less than or equal to the weight of every other spanning tree. The weight of a spanning tree is the sum of weights given to each edge of the spanning tree.

        How many edges does a minimum spanning tree has?
        A minimum spanning tree has (V – 1) edges where V is the number of vertices in the given graph.
        *
        *
        * */
    }



}
