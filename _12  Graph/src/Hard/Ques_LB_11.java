package Hard;

public class Ques_LB_11 {


    //Ques :



    //Author's Solution........
    class solve {
        boolean isSafe(int v, boolean graph[][], int color[], int c, int V) {
            for (int i = 0; i < V; i++)
                if (graph[v][i] && c == color[i]) return false;

            // returning true if no connected node has same colour.
            return true;
        }
        boolean graphColoringUtil(boolean graph[][], int m, int color[], int v,
                                  int V) {
            // if all vertices have been assigned colour then we return true.
            if (v == V) return true;

            for (int c = 1; c <= m; c++) {
                // checking if this colour can be given to a particular node.
                if (isSafe(v, graph, color, c, V)) {
                    // assigning colour to the node.
                    color[v] = c;

                    // calling function recursively and checking if other nodes
                    // can be assigned other colours.
                    if (graphColoringUtil(graph, m, color, v + 1, V) == true)
                        // returning true if the current allocation was successful.
                        return true;

                    // if not true, we backtrack and remove the colour for that
                    // node.
                    color[v] = 0;
                }
            }
            // if no colour can be assigned, we return false.
            return false;
        }
        // Function to determine if graph can be coloured with at most M colours
        // such
        // that no two adjacent vertices of graph are coloured with same colour.
        boolean graphColoring(boolean graph[][], int m, int n) {
            int color[] = new int[n];
            for (int i = 0; i < n; i++) color[i] = 0;

            // checking if colours can be assigned.
            if (graphColoringUtil(graph, m, color, 0, n) == false) {
                return false;
            }

            return true;
        }
    }




    public static void main(String[] args) {

        /*Ques :
         *
         *
         * */
    }
}
