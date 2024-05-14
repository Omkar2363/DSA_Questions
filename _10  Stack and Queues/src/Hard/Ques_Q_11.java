package Hard;

import java.util.LinkedList;
import java.util.Queue;

public class Ques_Q_11 {

    //Ques : Distance of nearest cell having 1...........                  (GFG Ques.)


    //Approach 1 : Brute Force Approach.........
    /*  Method 1 : This method uses a simple brute force approach to arrive at the solution.

        * Approach : The idea is to traverse the matrix for each cell and find the minimum distance, To find
                     the minimum distance traverse the matrix and find the cell which contains 1 and calculates
                     the distance between two cells and store the minimum distance.

        * Algorithm :
           1. Traverse the matrix from start to end (using two nested loops)
           2. For every element find the closest element which contains 1. To find the closest element
              traverse the matrix and find the minimum distance.
           3. Fill the minimum distance in the matrix.

    * */
    // Java program to find distance of the nearest cell having 1 in a binary matrix.
    class GFG {
        static int N = 3;
        static int M = 4;

        // Print the distance of the nearest cell having 1 for each cell.
        static void printDistance(int mat[][])
        {
            int ans[][] = new int[N][M];

            // Initialize the answer matrix with INT_MAX.
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    ans[i][j] = Integer.MAX_VALUE;

            // For each cell
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                {
                    // Traversing the whole matrix to find the minimum distance.
                    for (int k = 0; k < N; k++)
                        for (int l = 0; l < M; l++)
                        {
                            // If cell contain 1, check for minimum distance.
                            if (mat[k][l] == 1)
                                ans[i][j] = Math.min(ans[i][j], Math.abs(i-k) + Math.abs(j-l));
                        }
                }

            // Printing the answer :
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                    System.out.print( ans[i][j] + " ");

                System.out.println();
            }
        }

        // Driven Program
        public static void main_1(String[] args)
        {
            int mat[][] = { {0, 0, 0, 1},
                    {0, 0, 1, 1},
                    {0, 1, 1, 0} };

            printDistance(mat);
        }
    }

    /*  Complexity Analysis :
          * Time Complexity   : O(N2*M2)    For every element in the matrix, the matrix is traversed and
                                            there are N*M elements So the time complexity is O(N2*M2).
          * Space Complexity  : O(1)        No extra space is required.
    *
    * */




    //Approach 2 : Improved Brute Force Approach.......
    /* Method 1(a) : Improved Brute-Force approach.

       * Approach : The idea is to load the 1's  i and j coordinates in the Matrix into a Queue and then traverse
                    all the "0" Matrix elements and compare the distance between all the  1's from Queue to
                    get minimum distance.

       * Algorithm :
           1. Traverse once the Matrix and Load all 1's i and j coordinates into the queue.
           2. Once loaded, Traverse all the Matrix elements. If the element is "0", then check the minimum distance
              by de-queuing Queue elements one by one.
           3. Once distance for a "0" elements from "1" element is obtained, push back the 1's coordinates back into
              queue again for the next "0" element.
           4. Determine Min distance from the individual distances for every "0" element.
    * */
    /* Package whatever //do not write package name here */
    class GFG_2 {
        static class matrix_element {
            int row;
            int col;
            matrix_element(int row, int col)
            {
                this.row = row;
                this.col = col;
            }
        }
        static void printDistance(int arr[][])
        {
            int Row_Count = arr.length;
            int Col_Count = arr[0].length;
            Queue<matrix_element> q = new LinkedList<matrix_element>();
            // Adding all ones in queue
            for (int i = 0; i < Row_Count; i++) {
                for (int j = 0; j < Col_Count; j++) {
                    if (arr[i][j] == 1)
                        q.add(new matrix_element(i, j));
                }
            }
            /*
             In order to find min distance we will again traverse all elements in Matrix.
             If its zero then it will check against all 1's in Queue. Whatever will be dequeued from queued,
             will be enqueued back again.
            */

            int Queue_Size = q.size();
            for (int i = 0; i < Row_Count; i++)
            {
                for (int j = 0; j < Col_Count; j++)
                {
                    int distance = 0;
                    int min_distance = Integer.MAX_VALUE;
                    if (arr[i][j] == 0) {
                        for (int k = 0; k < Queue_Size; k++)
                        {
                            matrix_element One_Pos = q.poll();
                            int One_Row = One_Pos.row;
                            int One_Col = One_Pos.col;
                            distance = Math.abs(One_Row - i) + Math.abs(One_Col - j);
                            min_distance = Math.min(min_distance, distance);
                            if (min_distance == 1)
                            {
                                arr[i][j] = 1;
                                q.add(new matrix_element(One_Row, One_Col));
                                break;
                            }
                            q.add(new matrix_element(One_Row, One_Col));
                        }
                        arr[i][j] = min_distance;
                    }
                    else {
                        arr[i][j] = 0;
                    }
                }
            }

            // print the elements
            for (int i = 0; i < Row_Count; i++) {
                for (int j = 0; j < Col_Count; j++)
                    System.out.print(arr[i][j] + " ");

                System.out.println();
            }
        }

        public static void main_2(String[] args){
            int arr[][] = { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } };

            printDistance(arr);
        }
    }

    /*
     * */





    //Approach 3 : Another Approach.......
    /*  Method 2 : This method uses the BFS or breadth-first search technique to arrive at the solution.

        * Approach  : The idea is to use multi-source Breadth-First Search. Consider each cell as a node and each
                      boundary between any two adjacent cells be an edge. Number each cell from 1 to N*M.
                      Now, push all the node whose corresponding cell value is 1 in the matrix in the queue.
                      Apply BFS using this queue to find the minimum distance of the adjacent node.

        * Algorithm :
            1. Create a graph with values assigned from 1 to M*N to all vertices. The purpose is to store position
               and adjacent information.
            2. Create an empty queue.
            3. Traverse all matrix elements and insert positions of all 1s in queue.
            4. Now do a BFS traversal of graph using above created queue.
            5. Run a loop till the size of the queue is greater than 0 then extract the front node of the queue
               and remove it and insert all its adjacent and unmarked elements. Update the minimum distance as distance
               of current node +1 and insert the element in the queue.
    * */
    //C++ Code......
    /*  C++ program to find distance of the nearest cell having 1 in a binary matrix.
            #include<bits/stdc++.h>
            #define MAX 500
            #define N 3
            #define M 4
            using namespace std;

            // Making a class of graph with bfs function.
            class graph
            {
            private:
                vector<int> g[MAX];
                int n,m;

            public:
                graph(int a, int b)
                {
                    n = a;
                    m = b;
                }

                // Function to create graph with N*M nodes considering each cell as a node and
                // each boundary as an edge.
                void createGraph()
                {
                    int k = 1;                              // A number to be assigned to a cell

                    for (int i = 1; i <= n; i++)
                    {
                        for (int j = 1; j <= m; j++)
                        {
                            // If last row, then add edge on right side.
                            if (i == n)
                            {
                                // If not bottom right cell.
                                if (j != m)
                                {
                                    g[k].push_back(k+1);
                                    g[k+1].push_back(k);
                                }
                            }

                            // If last column, then add edge toward down.
                            else if (j == m)
                            {
                                g[k].push_back(k+m);
                                g[k+m].push_back(k);
                            }

                            // Else makes an edge in all four directions.
                            else
                            {
                                g[k].push_back(k+1);
                                g[k+1].push_back(k);
                                g[k].push_back(k+m);
                                g[k+m].push_back(k);
                            }

                            k++;
                        }
                    }
                }

                // BFS function to find minimum distance
                void bfs(bool visit[], int dist[], queue<int> q)
                {
                    while (!q.empty())
                    {
                        int temp = q.front();
                        q.pop();

                        for (int i = 0; i < g[temp].size(); i++)
                        {
                            if (visit[g[temp][i]] != 1)
                            {
                                dist[g[temp][i]] =
                                min(dist[g[temp][i]], dist[temp]+1);

                                q.push(g[temp][i]);
                                visit[g[temp][i]] = 1;
                            }
                        }
                    }
                }

                // Printing the solution.
                void print(int dist[])
                {
                    for (int i = 1, c = 1; i <= n*m; i++, c++)
                    {
                        cout << dist[i] << " ";

                        if (c%m == 0)
                            cout << endl;
                    }
                }
            };

            // Find minimum distance
            void findMinDistance(bool mat[N][M])
            {
                // Creating a graph with nodes values assigned from 1 to N x M and matrix adjacent.
                graph g1(N, M);
                g1.createGraph();

                // To store minimum distance
                int dist[MAX];

                // To mark each node as visited or not in BFS
                bool visit[MAX] = { 0 };

                // Initialising the value of distance and visit.
                for (int i = 1; i <= M*N; i++)
                {
                    dist[i] = INT_MAX;
                    visit[i] = 0;
                }

                // Inserting nodes whose value in matrix is 1 in the queue.
                int k = 1;
                queue<int> q;
                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < M; j++)
                    {
                        if (mat[i][j] == 1)
                        {
                            dist[k] = 0;
                            visit[k] = 1;
                            q.push(k);
                        }
                        k++;
                    }
                }

                // Calling for Bfs with given Queue.
                g1.bfs(visit, dist, q);

                // Printing the solution.
                g1.print(dist);
            }

            // Driven Program
            int main()
            {
                bool mat[N][M] = {  0, 0, 0, 1,
                                    0, 0, 1, 1,
                                    0, 1, 1, 0  };

                findMinDistance(mat);

                return 0;
            }
    * */

    /*  Complexity Analysis :
            * Time Complexity   : O(N*M)   In BFS traversal every element is traversed only once
                                           So time Complexity is O(M*N).
            * Space Complexity  : O(M*N)   To store every element in the matrix O(M*N) space is required.

    * */




    public static void main(String[] args) {

        /*Ques : Given a binary grid of n*m. Find the distance of the nearest 1 in the grid for each cell.

                 The distance is calculated as |i1  - i2| + |j1 - j2|, where i1, j1 are the row number and column number
                 of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1.


            Example : 1
            Input   : grid = { {0,1,1,0}, {1,1,0,0}, {0,0,1,1} }
            Output  : { {1,0,0,1}, {0,0,1,1}, {1,1,0,0} }
            Explanation : The grid is -
            0 1 1 0
            1 1 0 0
            0 0 1 1
            0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's
                at (0,1), (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.


            Example : 2
            Input   : grid = { {1,0,1}, {1,1,0}, {1,0,0} }
            Output  : { {0,1,0}, {0,0,1}, {0,1,2} }
            Explanation : The grid is -
            1 0 1
            1 1 0
            1 0 0
            0's at (0,1), (1,2), (2,1) and (2,2) are at a
            distance of 1, 1, 1 and 2 from 1's at (0,0),
            (0,2), (2,0) and (1,1) respectively.


            Your Task  :
            You don't need to read or print anything, Your task is to complete the function nearest() which takes
            the grid as an input parameter and returns a matrix of the same dimensions where the value at index (i, j)
            in the resultant matrix signifies the minimum distance of 1 in the matrix from grid[i][j].


            Expected Time Complexity : O(n*m)
            Expected Auxiliary Space : O(n*m)
        *
        * */
    }



}
