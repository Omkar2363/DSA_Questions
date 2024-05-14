package Medium;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Ques_LB_10 {

    //Ques : Find the number of islands.......                                             (GFG Ques.)


    //Approach 1 : By using DFS........(using an additional Matrix)
    /*  Finding the number of islands using an additional Matrix :
            The idea is to keep an additional matrix to keep track of the visited nodes in the given matrix,
            and perform DFS to find the total number of islands

        * Follow the steps below to solve the problem :
           1. Initialize a boolean matrix visited of the size of the given matrix to false.
           2. Initialize count = 0, to store the answer.
           3. Traverse a loop from 0 till ROW
               a. Traverse a nested loop from 0 to COL
                   * If the value of the current cell in the given matrix is 1 and is not visited
                        i. Call DFS function
                             1. Initialize rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 } and
                                colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 } for the neighbour cells.
                             2. Mark the current cell as visited
                             3. Run a loop from 0 till 8 to traverse the neighbor
                                    * If the neighbor is safe to visit and is not visited
                                        * Call DFS recursively on the neighbor.
                        ii. Increment count by 1
           4. Return count as the final answer.
    *
    * */
    // Java program to count islands in boolean 2D matrix
    static class Islands {
        // No of rows and columns
        static final int ROW = 5, COL = 5;

        // A function to check if a given cell (row, col) can be included in DFS
        boolean isSafe(int M[][], int row, int col, boolean visited[][])
        {
            // row number is in range, column number is in range and value is 1 and not yet visited
            return (row >= 0) && (row < ROW) && (col >= 0)  && (col < COL)
                                                               && (M[row][col] == 1 && !visited[row][col]);
        }

        // A utility function to do DFS for a 2D boolean matrix.
        // It only considers the 8 neighbors as adjacent vertices
        void DFS(int M[][], int row, int col, boolean visited[][])
        {
            // These arrays are used to get row and column numbers of 8 neighbors of a given cell
            int rowNbr[]  = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
            int colNbr[]  = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

            // Mark this cell as visited
            visited[row][col] = true;

            // Recur for all connected neighbours
            for (int k = 0; k < 8; ++k)
                if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                    DFS(M, row + rowNbr[k], col + colNbr[k], visited);
                }
        }

        // The main function that returns count of islands in a given boolean 2D matrix
        int countIslands(int M[][])
        {
            // Make a bool array to mark visited cells.
            // Initially all cells are unvisited
            boolean visited[][] = new boolean[ROW][COL];

            // Initialize count as 0 and traverse through the all cells of given matrix
            int count = 0;
            for (int i = 0; i < ROW; ++i)
                for (int j = 0; j < COL; ++j)
                    if (M[i][j] == 1   &&  !visited[i][j])         // If a cell with value 1 is not visited yet,
                    {                                              // then new island found, Visit all cells in this island
                                                                   // and increment island count
                        DFS(M, i, j, visited);
                        ++count;
                    }

            return count;
        }

        // Driver method
        public static void main_1(String[] args) throws java.lang.Exception
        {
            int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                      { 0, 1, 0, 0, 1 },
                                      { 1, 0, 0, 1, 1 },
                                      { 0, 0, 0, 0, 0 },
                                      { 1, 0, 1, 0, 1 } };
            Islands I = new Islands();
            System.out.println("Number of islands is: " + I.countIslands(M));
        }
    }

    /*  Time complexity : O(ROW x COL),   where ROW is the number of rows and COL is the number of columns
                                          in the given matrix.
        Auxiliary Space : O(ROW x COL),   for creating an additional visited matrix.
    *
    *
    * */




    //Approach 2 : By using DFS.......(using constant extra space)
    /*  Finding the number of islands using constant extra space :
            The idea is to modify the given matrix, and perform DFS to find the total number of islands

        * Follow the steps below to solve the problem :
            1. Initialize count = 0, to store the answer.
            2. Traverse a loop from 0 till ROW
                * Traverse a nested loop from 0 to COL
                    * If the value of the current cell in the given matrix is 1
                       i.  Increment count by 1
                       ii. Call DFS function
                             a. If the cell exceeds the boundary or the value at the current cell is 0
                                 * Return.
                             b. Update the value at the current cell as 0.
                             c. Call DFS on the neighbor recursively
            3. Return count as the final answer.
    *
    * */
    // Java Program to count islands in boolean 2D matrix
    public class Main {

        // A utility function to do DFS for a 2D boolean matrix.
        // It only considers the 8 neighbours as adjacent vertices
        static void DFS(int[][] M, int i, int j, int ROW, int COL)
        {
            // Base condition :
            // If i less than 0 or j less than 0 or i greater than ROW-1 or j greater than COL-
            // or if M[i][j] != 1 then we will simply return

            if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != 1)
            {
                return;
            }

            if (M[i][j] == 1)
            {
                M[i][j] = 0;
                DFS(M, i + 1, j, ROW, COL);                    // right side traversal
                DFS(M, i - 1, j, ROW, COL);                    // left side traversal
                DFS(M, i, j + 1, ROW, COL);                    // upward side traversal
                DFS(M, i, j - 1, ROW, COL);                    // downward side traversal
                DFS(M, i + 1, j + 1, ROW, COL);             // upward-right side traversal
                DFS(M, i - 1, j - 1, ROW, COL);             // downward-left side traversal
                DFS(M, i + 1, j - 1, ROW, COL);             // downward-right side traversal
                DFS(M, i - 1, j + 1, ROW, COL);             // upward-left side traversal
            }
        }

        static int countIslands(int[][] M)
        {
            int ROW = M.length;
            int COL = M[0].length;
            int count = 0;
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (M[i][j] == 1) {
                        count++;
                        DFS(M, i, j, ROW, COL); // traversal starts from current cell
                    }
                }
            }
            return count;
        }

        // Driver code
        public static void main_2(String[] args)
        {
            int[][] M = {   { 1, 1, 0, 0, 0 },
                            { 0, 1, 0, 0, 1 },
                            { 1, 0, 0, 1, 1 },
                            { 0, 0, 0, 0, 0 },
                            { 1, 0, 1, 0, 1 }  };

            System.out.print("Number of islands is: " + countIslands(M));
        }
    }


    /*  Time complexity : O(ROW x COL), where ROW is the number of rows and COL is the number of columns
                                        in the given matrix.
        Auxiliary Space : O(1),         as constant extra space is required.


    *
    * */





    //Approach 3 : By using BFS........
    // A BFS based solution to count number of islands in a graph.
    class GFG {

        // R x C matrix
        static final int R = 5;
        static final int C = 5 ;
        static class pair
        {
            int first, second;
            public pair(int first, int second)
            {
                this.first = first;
                this.second = second;
            }
        }

        // A function to check if a given cell (u, v) can be included in DFS
        static boolean isSafe(int mat[][], int i, int j, boolean vis[][])
        {
            return (i >= 0) && (i < R) && (j >= 0) && (j < C) &&
                                                         (mat[i][j]==1 && !vis[i][j]);
        }

        static void BFS(int mat[][], boolean vis[][], int si, int sj)
        {

            // These arrays are used to get row and column numbers of 8 neighbours of a given cell
            int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
            int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

            // Simple BFS first step, we enqueue source and mark it as visited
            Queue<pair> q = new LinkedList<pair>();
            q.add(new pair(si, sj));
            vis[si][sj] = true;

            // Next step of BFS. We take out items one by one from queue and
            // enqueue their unvisited adjacent
            while (!q.isEmpty())
            {

                int i = q.peek().first;
                int j = q.peek().second;
                q.remove();

                // Go through all 8 adjacent
                for (int k = 0; k < 8; k++)
                {
                    if (isSafe(mat, i + row[k], j + col[k], vis))
                    {
                        vis[i + row[k]][j + col[k]] = true;
                        q.add(new pair(i + row[k], j + col[k]));
                    }
                }
            }
        }

        // This function returns number islands (connected components) in a graph.
        // It simply works as BFS for disconnected graph and returns count of BFS calls.
        static int countIslands(int mat[][])
        {
            // Mark all cells as not visited
            boolean [][]vis = new boolean[R][C];

            // Call BFS for every unvisited vertex. Whenever we see an univisted vertex,
            // we increment res (number of islands) also.
            int res = 0;
            for (int i = 0; i < R; i++)
            {
                for (int j = 0; j < C; j++)
                {
                    if (mat[i][j]==1 && !vis[i][j])
                    {
                        BFS(mat, vis, i, j);
                        res++;
                    }
                }
            }
            return res;
        }

        // Driver code
        public static void main_3(String[] args)
        {
            int mat[][] = { { 1, 1, 0, 0, 0 },
                            { 0, 1, 0, 0, 1 },
                            { 1, 0, 0, 1, 1 },
                            { 0, 0, 0, 0, 0 },
                            { 1, 0, 1, 0, 1 } };

            System.out.print(countIslands(mat));
        }
    }


    /*  Time Complexity : O(ROW * COL) where ROW is number of ROWS and COL is number of COLUMNS in the matrix.
     *
    * */








    //Approach 4 : By using Disjoint Set........
    /*  We can also solve the question using disjoint set data structure explained here.

            The idea is to consider all 1 values as individual sets. Traverse the matrix and do a union of
            all adjacent 1 vertices. Below are detailed steps.

        * Approach :
            1) Initialize result (count of islands) as 0
            2) Traverse each index of the 2D matrix.
            3) If the value at that index is 1, check all its 8 neighbours. If a neighbour is also equal to 1,
               take the union of the index and its neighbour.
            4) Now define an array of size row*column to store frequencies of all sets.
            5) Now traverse the matrix again.
            6) If the value at index is 1, find its set.
            7) If the frequency of the set in the above array is 0, increment the result be 1.
    *
    * */
    // Java program to find number of islands using Disjoint Set data structure.
    public static class Main_4 {

        public static void main(String[] args) throws IOException
        {
            int[][] a = new int[][] {   {1, 1, 0, 0, 0},
                                        {0, 1, 0, 0, 1},
                                        {1, 0, 0, 1, 1},
                                        {0, 0, 0, 0, 0},
                                        {1, 0, 1, 0, 1}     };

            System.out.println("Number of Islands is: " + countIslands(a));
        }

        // Returns number of islands in a[][]
        static int countIslands(int a[][])
        {
            int n = a.length;
            int m = a[0].length;

            DisjointUnionSets dus = new DisjointUnionSets(n*m);

            /* The following loop checks for its neighbours and unites the indexes  if both are 1. */
            for (int j=0; j<n; j++)
            {
                for (int k=0; k<m; k++)
                {
                    // If cell is 0, nothing to do
                    if (a[j][k] == 0)
                        continue;

                    // Check all 8 neighbours and do a union with neighbour's set if neighbour is also 1
                    if (j+1 < n  &&  a[j+1][k] == 1)
                        dus.union(j*(m) + k, (j+1)*(m) + k);

                    if (j-1 >= 0 &&  a[j-1][k] == 1)
                        dus.union(j*(m) + k, (j-1)*(m) + k);

                    if (k+1 < m  &&  a[j][k+1] == 1)
                        dus.union(j*(m) + k, (j)*(m) + k+1);

                    if (k-1 >= 0 &&  a[j][k-1] == 1)
                        dus.union(j*(m) + k, (j)*(m) + k-1);

                    if (j+1<n  &&  k+1<m  &&  a[j+1][k+1]==1)
                        dus.union(j*(m) + k, (j+1)*(m) + k+1);

                    if (j+1<n  &&  k-1>=0  &&  a[j+1][k-1]==1)
                        dus.union(j*m+k, (j+1)*(m)+k-1);

                    if (j-1>=0  &&  k+1<m  &&  a[j-1][k+1]==1)
                        dus.union(j*m+k, (j-1)*m+k+1);

                    if (j-1>=0  &&  k-1>=0  &&  a[j-1][k-1]==1)
                        dus.union(j*m+k, (j-1)*m+k-1);
                }
            }

            // Array to note down frequency of each set
            int[] c = new int[n*m];
            int numberOfIslands = 0;
            for (int j=0; j<n; j++)
            {
                for (int k=0; k<m; k++)
                {
                    if (a[j][k] == 1)
                    {

                        int x = dus.find(j*m+k);

                        // If frequency of set is 0, increment numberOfIslands
                        if (c[x] == 0)
                        {
                            numberOfIslands++;
                            c[x]++;
                        }

                        else
                            c[x]++;
                    }
                }
            }
            return numberOfIslands;
        }
    }
    // Class to represent Disjoint Set Data structure
    static class DisjointUnionSets {
        int[] rank, parent;
        int n;

        public DisjointUnionSets(int n)
        {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet()
        {
            // Initially, all elements are in their own set.
            for (int i=0; i<n; i++)
                parent[i] = i;
        }

        // Finds the representative of the set that x is an element of
        int find(int x)
        {
            if (parent[x] != x)
            {
                /*
                 if x is not the parent of itself, then x is not the representative of its set.
                 so we recursively call Find on its parent and move i's node directly under the
                 representative of this set
                */
                parent[x]=find(parent[x]);
            }

            return parent[x];
        }

        // Unites the set that includes x and the set that includes y
        void union(int x, int y)
        {
            // Find the representatives (or the root nodes) for x and y
            int xRoot = find(x);
            int yRoot = find(y);

            // Elements are in the same set, no need to unite anything.
            if (xRoot == yRoot)
                return;

            // If x's rank is less than y's rank
            // Then move x under y  so that depth of tree remains less
            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;

                // Else if y's rank is less than x's rank
                // Then move y under x so that depth of tree remains less
            else if(rank[yRoot]<rank[xRoot])
                parent[yRoot] = xRoot;

            else  // Else if their ranks are the same
            {
                // Then move y under x (doesn't matter which one goes where)
                parent[yRoot] = xRoot;

                // And increment the result tree's rank by 1
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }


    /*  Time Complexity : O(N * M), where N is number of rows and M is number of columns in the matrix.
        Auxiliary Space : O(N * M)
    *
    * */








    //Author's Solution :
    class Solution {
        boolean isSafe(char M[][], int row, int col, boolean visited[][], int ROW, int COL)
        {
            // row number is in range, column number is in range and value is 1 and not yet visited
            return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) &&
                                                               (M[row][col] == '1' && !visited[row][col]);
        }
        void DFS(char M[][], int row, int col, boolean visited[][], int ROW, int COL)
        {
            // These arrays are used to get row and column numbers of 8 neighbors of a given cell
            int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
            int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

            // Mark this cell as visited
            visited[row][col] = true;

            // Recur for all connected neighbours
            for (int k = 0; k < 8; ++k)
                if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL))
                {
                    DFS(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
                }
        }
        // Function to find the number of islands.
        public int numIslands(char[][] grid) {
            // Code here
            int ROW = grid.length;
            int COL = grid[0].length;
            boolean visited[][] = new boolean[ROW][COL];

            // Initialize count as 0 and traverse through the all cells of given matrix
            int count = 0;
            for (int i = 0; i < ROW; ++i)
                for (int j = 0; j < COL; ++j)
                    if (grid[i][j] == '1' && !visited[i][j])       // If a cell with value 1 is not visited yet,
                    {                                               // then new island found, Visit all cells in this island
                                                                   // and increment island count
                        DFS(grid, i, j, visited, ROW, COL);
                        ++count;
                    }

            return count;
        }
    }





    public static void main(String[] args) {
        /*Ques : Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid)
                 consisting of '0's (Water) and '1's(Land). Find the number of islands.

             Note : An island is surrounded by water and is formed by connecting adjacent lands horizontally or
                    vertically or diagonally i.e., in all 8 directions.

            Example : 1
            Input   : grid = {{0,1},{1,0},{1,1},{1,0}}
            Output  : 1
            Explanation : The grid is-
                            0 1
                            1 0
                            1 1
                            1 0
                          All lands are connected.

            Example : 2
            Input   : grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
            Output  : 2
            Explanation : The grid is-
                            0 1 1 1 0 0 0
                            0 0 1 1 0 1 0
                          There are two islands : one is colored in blue and other in orange.

            Your Task :
            You don't need to read or print anything. Your task is to complete the function numIslands() which takes
            the grid as an input parameter and returns the total number of islands.

            Expected Time Complexity  : O(n*m)
            Expected Space Complexity : O(n*m)
        *
        *
        *   // Follow the link for visual representation of the Ques.....
            // Link : https://www.geeksforgeeks.org/find-number-of-islands/

        *
        *  */

    }




}
