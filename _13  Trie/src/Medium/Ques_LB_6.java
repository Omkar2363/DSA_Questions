package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Ques_LB_6 {

    //Ques : Unique rows in boolean matrix.........                                       (GFG Ques.)


    //Approach 1 : Simple Approach.....
    /*  Method 1 : This method explains the simple approach towards solving the above problem.

        Approach :
          A simple approach would be to check each row with all processed rows. Print the first row.
          Now, starting from the second row, for each row, compare the row with already processed rows.
          If the row matches with any of the processed rows, skip it else print it.

            * Algorithm :
               1. Traverse the matrix row-wise
               2. For each row check if there is any similar row less than the current index.
               3. If any two rows are similar then do not print the row.
               4. Else print the row.

    *
    * */
    // Given a binary matrix of M X N of integers, you need to return
    // only unique rows of binary array
    class GFG {
        static int ROW = 4;
        static int COL = 5;

        // Function that prints all unique rows in a given matrix.
        static void findUniqueRows(int M[][])
        {
            // Traverse through the matrix
            for(int i = 0; i < ROW; i++)
            {
                int flag = 0;

                // Check if there is similar column is already printed,
                // i.e. if i and jth column match.
                for(int j = 0; j < i; j++)
                {
                    flag = 1;

                    for(int k = 0; k < COL; k++)
                        if (M[i][k] != M[j][k])
                            flag = 0;

                    if (flag == 1)
                        break;
                }

                // If no row is similar
                if (flag == 0)
                {

                    // Print the row
                    for(int j = 0; j < COL; j++)
                        System.out.print(M[i][j] + " ");

                    System.out.println();
                }
            }
        }

        // Driver Code
        public static void main_1(String[] args)
        {
            int M[][] = { { 0, 1, 0, 0, 1 },
                          { 1, 0, 1, 1, 0 },
                          { 0, 1, 0, 0, 1 },
                          { 1, 0, 1, 0, 0 }  };

            findUniqueRows(M);
        }
    }

    /*  Complexity Analysis :
          * Time complexity : O( ROW^2 x COL )  So for every row check if there is any other similar row.
                                                So the time complexity is O( ROW^2 x COL ).
          * Auxiliary Space : O(1)              As no extra space is required.
    *
    * */






    //Approach 2 : By using Binary Search.......
    /*  Complexity Analysis :
          * Time complexity : O( ROW^2 x COL )     So for every row check if there is any other similar row.
                                                   So the time complexity is O( ROW^2 x COL ).
          * Auxiliary Space : O(1)                 As no extra space is required.
    *
    * */
    // Given a binary matrix of M X N of integers,
    // you need to return only unique rows of binary array
    class GFG_2 {
        static class BST {
            int data;
            BST left,right;
            BST(int v){
                this.data = v;
                this.left = this.right = null;
            }
        }
        final  static int ROW = 4;
        final  static int COL = 5;
        // convert array to decimal
        static int convert(int arr[])
        {
            int sum = 0;

            for(int i = 0; i < COL; i++)
            {
                sum += Math.pow(2,i)*arr[i];
            }
            return sum;
        }

        // print the column represented as integers
        static void print(int p)
        {
            for(int i = 0; i < COL; i++)
            {
                System.out.print(p%2+" ");
                p /= 2;
            }
            System.out.println();
        }



        // Insert function definition.
        static BST Insert(BST root, int value)
        {
            if(root == null)
            {
                // Insert the first node, if root is null.
                return new BST(value);
            }

            //if the value is present
            if(value == root.data)
                return root;

            // Insert data.
            if(value > root.data)
            {
                // Insert right node data, if the 'value' to be inserted is greater than 'root' node data.

                // Process right nodes.
                root.right = Insert(root.right, value);
            }
            else
            {
                // Insert left node data, if the 'value' to be inserted is greater than 'root' node data.

                // Process left nodes.
                root.left = Insert(root.left, value);
            }

            // Return 'root' node, after insertion.
            return root;
        }

        // Inorder traversal function. This gives data in sorted order.
        static void Inorder(BST root)
        {
            if(root == null)
            {
                return;
            }
            Inorder(root.left);
            print( root.data );
            Inorder(root.right);
        }

        // The main function that prints all unique rows in a given matrix.
        static void findUniqueRows(int M[][])
        {
            BST b, root = null;

            // Traverse through the matrix
            for(int i = 0; i < ROW; i++)
            {
                // insert the row into BST
                root=Insert(root, convert(M[i]));
            }


            //print
            Inorder(root);

        }

        // Driver Code
        public static void main_2(String[] args)
        {
            int M[][] = { {0, 1, 0, 0, 1},
                          {1, 0, 1, 1, 0},
                          {0, 1, 0, 0, 1},
                          {1, 0, 1, 0, 0} };

            findUniqueRows(M);
        }
    }

    /*  Complexity Analysis :
          * Time complexity : O( ROW x COL + ROW x log( ROW ))   To traverse the matrix time complexity is O( ROW x COL)
                                                                 and to insert them into BST time complexity is O(log ROW)
                                                                 for each row.
                                                                 So overall time complexity is O( ROW x COL + ROW x log( ROW ) )
          * Auxiliary Space : O( ROW )                           To store the BST O(ROW) space is needed.
    *
    * */







    //Approach 3 : By using Trie Data Structure........
    //C++ Code......
    /*  Given a binary matrix of M X N of integers, you need to return only unique rows of binary array
        #include <bits/stdc++.h>
        using namespace std;
        #define ROW 4
        #define COL 5

        // A Trie node
        class Node
        {
            public:
            bool isEndOfCol;
            Node *child[2];                                // Only two children needed for 0 and 1
        } ;


        // A utility function to allocate memory for a new Trie node
        Node* newNode()
        {
            Node* temp = new Node();
            temp->isEndOfCol = 0;
            temp->child[0] = temp->child[1] = NULL;
            return temp;
        }

        // Inserts a new matrix row to Trie. If row is already present, then returns 0,
        // otherwise insets the row and return 1
        bool insert(Node** root, int (*M)[COL], int row, int col )
        {
            // base case
            if (*root == NULL)
                *root = newNode();

            // Recur if there are more entries in this row
            if (col < COL)
                return insert (&((*root)->child[M[row][col]]), M, row, col + 1);

            else                                        // If all entries of this row are processed
            {
                // unique row found, return 1
                if (!((*root)->isEndOfCol))
                    return (*root)->isEndOfCol = 1;

                // duplicate row found, return 0
                return 0;
            }
        }

        // A utility function to print a row
        void printRow(int(*M)[COL], int row)
        {
            int i;
            for(i = 0; i < COL; ++i)
                cout << M[row][i] << " ";
            cout << endl;
        }

        // The main function that prints all unique rows in a given matrix.
        void findUniqueRows(int (*M)[COL])
        {
            Node* root = NULL;                         // create an empty Trie
            int i;

            // Iterate through all rows
            for (i = 0; i < ROW; ++i)

                // insert row to TRIE
                if (insert(&root, M, i, 0))

                    // unique row found, print it
                    printRow(M, i);
        }

        // Driver Code
        int main()
        {
            int M[ROW][COL] = { {0, 1, 0, 0, 1},
                                {1, 0, 1, 1, 0},
                                {0, 1, 0, 0, 1},
                                {1, 0, 1, 0, 0} };

            findUniqueRows(M);

            return 0;
        }
    *
    *
    * */

    /*  Complexity Analysis :
          * Time complexity : O( ROW x COL )      To traverse the matrix and insert in the trie the time complexity
                                                  is O( ROW x COL). This method has better time complexity.
                                                  Also, the relative order of rows is maintained while printing
                                                  but, it takes a toll on space.
          * Auxiliary Space : O( ROW x COL )      To store the Trie O(ROW x COL) space complexity is needed.
    *
    * */






    //Approach 4 : By using HashSet Data Structure........
    // Java code to print unique row in a given binary matrix
    public class GFG_4 {

        public static void printArray(int arr[][], int row, int col)
        {
            HashSet<String> set = new HashSet<String>();

            for(int i = 0; i < row; i++)
            {
                String s = "";

                for(int j = 0; j < col; j++)
                    s += String.valueOf(arr[i][j]);

                if(!set.contains(s))
                {
                    set.add(s);
                    System.out.println(s);

                }
            }
        }

        // Driver code
        public static void main_4 (String[] args) {

            int arr[][] = { {0, 1, 0, 0, 1},
                            {1, 0, 1, 1, 0},
                            {0, 1, 0, 0, 1},
                            {1, 1, 1, 0, 0}  };

            printArray(arr, 4, 5);
        }
    }








    public static void main(String[] args) {

        /*Ques : Given a binary matrix your task is to find all unique rows of the given matrix.


            Example : 1
            Input   : row = 3, col = 4
                      M[][] = { {1 1 0 1}, {1 0 0 1}, {1 1 0 1} }
            Output  : 1 1 0 1 $1 0 0 1 $
            Explanation : Above the matrix of size 3x4 looks like
                            1 1 0 1
                            1 0 0 1
                            1 1 0 1
                          The two unique rows are 1 1 0 1 and 1 0 0 1 .

            Your Task :
            You only need to implement the given function uniqueRow(). The function takes three arguments the first argument
            is a matrix M and the next two arguments are row and col denoting the rows and columns of the matrix.
            The function should return the list of the unique row of the martrix. Do not read input, instead use the
            arguments given in the function.

            Note : The drivers code print the rows "$" separated.

            Expected Time Complexity : O(row * col)
            Expected Auxiliary Space : O(row * col)


        *
        * */
    }







}
