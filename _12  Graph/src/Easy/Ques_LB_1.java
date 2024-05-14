package Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ques_LB_1 {

    //Ques : Implement Graph


    //Approach 1 :
    static class Graph_1 {

        // inner class to keep track of edges
        class Edge {
            int src, dest;
        }

        // number of vertices and edges
        int vertices, edges;

        // array to store all edges
        Edge[] edge;

        Graph_1(int vertices, int edges)
        {
            this.vertices = vertices;
            this.edges = edges;

            // initialize the edge array
            edge = new Edge[edges];
            for(int i = 0; i < edges; i++) {

                // each element of the edge array is an object of Edge type
                edge[i] = new Edge();
            }
        }

        public static void main_1(String[] args)
        {

            // create an object of Graph class
            int noVertices = 5;
            int noEdges = 8;
            Graph_1 g = new Graph_1(noVertices, noEdges);

            // create graph
            g.edge[0].src = 1;   // edge 1---2
            g.edge[0].dest = 2;

            g.edge[1].src = 1;   // edge 1---3
            g.edge[1].dest = 3;

            g.edge[2].src = 1;   // edge 1---4
            g.edge[2].dest = 4;

            g.edge[3].src = 2;   // edge 2---4
            g.edge[3].dest = 4;

            g.edge[4].src = 2;   // edge 2---5
            g.edge[4].dest = 5;

            g.edge[5].src = 3;   // edge 3---4
            g.edge[5].dest = 4;

            g.edge[6].src = 3;   // edge 3---5
            g.edge[6].dest = 5;

            g.edge[7].src = 4;   // edge 4---5
            g.edge[7].dest = 5;

            // print graph
            for(int i = 0; i < noEdges; i++) {
                System.out.println(g.edge[i].src + " - " + g.edge[i].dest);
            }

        }
    }



    //Approach 2 :
    // Java program to implement Graph with the help of Generics
    static class Graph <T> {

        // We use Hashmap to store the edges in the graph
        private Map<T, List<T>> map = new HashMap<>();

        // This function adds a new vertex to the graph
        public void addVertex(T s)
        {
            map.put(s, new LinkedList<T>());
        }

        // This function adds the edge
        // between source to destination
        public void addEdge(T source, T destination, boolean bidirectional)
        {

            if (!map.containsKey(source))
                addVertex(source);

            if (!map.containsKey(destination))
                addVertex(destination);

            map.get(source).add(destination);
            if (bidirectional == true) {
                map.get(destination).add(source);
            }
        }

        // This function gives the count of vertices
        public void getVertexCount()
        {
            System.out.println("The graph has "  + map.keySet().size()  + " vertex");
        }

        // This function gives the count of edges
        public void getEdgesCount(boolean bidirection)
        {
            int count = 0;
            for (T v : map.keySet())
            {
                count += map.get(v).size();
            }
            if (bidirection == true) {
                count = count / 2;
            }
            System.out.println("The graph has " + count + " edges.");
        }

        // This function gives whether a vertex is present or not.
        public void hasVertex(T s)
        {
            if (map.containsKey(s)) {
                System.out.println("The graph contains " + s + " as a vertex.");
            }
            else {
                System.out.println("The graph does not contain " + s + " as a vertex.");
            }
        }

        // This function gives whether an edge is present or not.
        public void hasEdge(T s, T d)
        {
            if (map.get(s).contains(d)) {
                System.out.println("The graph has an edge between " + s + " and " + d + ".");
            }
            else {
                System.out.println("The graph has no edge between " + s + " and " + d + ".");
            }
        }

        // Prints the adjancency list of each vertex.
        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();

            for (T v : map.keySet())
            {
                builder.append(v.toString() + ": ");

                for (T w : map.get(v))
                {
                    builder.append(w.toString() + " ");
                }
                builder.append("\n");
            }

            return (builder.toString());
        }
    }
    // Driver Code
    public class Main {

        public static void main_2(String args[])
        {

            // Object of graph is created.
            Graph<Integer> g = new Graph<Integer>();

            // edges are added.
            // Since the graph is bidirectional,
            // so boolean bidirectional is passed as true.
            g.addEdge(0, 1, true);
            g.addEdge(0, 4, true);
            g.addEdge(1, 2, true);
            g.addEdge(1, 3, true);
            g.addEdge(1, 4, true);
            g.addEdge(2, 3, true);
            g.addEdge(3, 4, true);

            // Printing the graph
            System.out.println("Graph:\n" + g.toString());

            // Gives the no of vertices in the graph.
            g.getVertexCount();

            // Gives the no of edges in the graph.
            g.getEdgesCount(true);

            // Tells whether the edge is present or not.
            g.hasEdge(3, 4);

            // Tells whether vertex is present or not
            g.hasVertex(5);
        }
    }






    public static void main(String[] args) {

        /*Ques :
        *
        *
        * */
    }



}
