package Medium;

public class Ques_LB_1 {

    //Ques : Building Heap from Array........                                                  (GFG Ques.)


    //Approach 1 : Naive Approach......
    /*  Naive Approach :  To solve the problem follow the below idea........

            To build a Max-Heap from the above-given array elements, It can be clearly seen that the above
            complete binary tree formed does not follow the Heap property. So, the idea is to heapify the
            complete binary tree formed from the array in reverse level order following a top-down approach.
            That is first heapify, the last node in level order traversal of the tree, then heapify the second
            last node and so on.

            Time Complexity Analysis : Heapify a single node takes O(log(N)) time complexity
                                                                              where N is the total number of Nodes.
                                       Therefore, building the entire Heap will take N heapify operations and
                                       the total time complexity will be O(N*logN).
    *
    * */



    //Approach 2 : Efficient Approach.........                                                 T.C. = O(n),  S.C. = O(n)
    /*  Efficient Approach : To solve the problem using this approach follow the below idea......

           The above approach can be optimized by observing the fact that the leaf nodes need not to be heapified
           as they already follow the heap property. Also, the array representation of the complete binary tree
           contains the level order traversal of the tree. So the idea is to find the position of the last non-leaf
           node and perform the heapify operation of each non-leaf node in reverse level order.


            Last non-leaf node = parent of last-node.
            or, Last non-leaf node = parent of node at (n-1)th index.
            or, Last non-leaf node = Node at index ((n-1) – 1)/2 = (n/2) – 1.


        * Heapify Illustration :

            Array = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}
            Corresponding Complete Binary Tree is :
                             1
                          /     \
                       3         5
                    /    \     /  \
                  4      6   13  10
                 / \    / \
                9   8  15 17

            The task to build a Max-Heap from above array.

            Total Nodes = 11.
            Last Non-leaf node index = (11/2) – 1 = 4.
            Therefore, last non-leaf node = 6.

            To build the heap, heapify only the nodes: [1, 3, 5, 4, 6] in reverse order.

            Heapify 6: Swap 6 and 17.

                             1
                          /     \
                        3         5
                     /    \      /  \
                    4      17   13  10
                   / \    /  \
                  9   8  15   6

            Heapify 4: Swap 4 and 9.

                             1
                          /     \
                        3         5
                     /    \      /  \
                    9      17   13  10
                   / \    /  \
                  4   8  15   6

            Heapify 5: Swap 13 and 5.

                             1
                          /     \
                        3         13
                     /    \      /  \
                    9      17   5   10
                   / \    /  \
                  4   8  15   6

            Heapify 3: First Swap 3 and 17, again swap 3 and 15.

                             1
                         /     \
                      17         13
                    /    \      /  \
                   9      15   5   10
                  / \    /  \
                 4   8  3    6

            Heapify 1: First Swap 1 and 17, again swap 1 and 15, finally swap 1 and 6.

                             17
                          /      \
                       15         13
                     /    \      /  \
                    9      6    5   10
                   / \    /  \
                  4   8  3    1


    *
    * */
    // Java program for building Heap from Array
    public class BuildHeap {

        // To heapify a subtree rooted with node i which is an index in arr[].Nn is size of heap
        static void heapify(int arr[], int N, int i)
        {
            int largest = i;                         // Initialize largest as root
            int l = 2 * i + 1;                       // left = 2*i + 1
            int r = 2 * i + 2;                       // right = 2*i + 2

            // If left child is larger than root
            if (l < N && arr[l] > arr[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < N && arr[r] > arr[largest])
                largest = r;

            // If largest is not root
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(arr, N, largest);
            }
        }

        // Function to build a Max-Heap from the Array
        static void buildHeap(int arr[], int N)
        {
            // Index of last non-leaf node
            int startIdx = (N / 2) - 1;

            // Perform reverse level order traversal from last non-leaf node and
            // heapify each node
            for (int i = startIdx; i >= 0; i--) {
                heapify(arr, N, i);
            }
        }

        // A utility function to print the array representation of Heap
        static void printHeap(int arr[], int N)
        {
            System.out.println("Array representation of Heap is:");

            for (int i = 0; i < N; ++i)
                System.out.print(arr[i] + " ");

            System.out.println();
        }

        // Driver Code
        public static void main_2(String args[])
        {
            // Binary Tree Representation of input array
            //             1
            //         /      \
            //        3        5
            //      /   \     / \
            //     4     6   13 10
            //    /  \  /  \
            //   9   8 15  17
            int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
            int N = arr.length;

            buildHeap(arr, N);
            printHeap(arr, N);
        }
    }



    public static void main(String[] args) {

        /*Ques : Given an array of N elements. The task is to build a Binary Heap from the given array.
                 The heap can be either Max Heap or Min Heap.


            Example : 1
            Input   : arr[] = {4, 10, 3, 5, 1}
            Output  : Corresponding Max-Heap.....

                          10
                         /   \
                        5     3
                       /  \
                      4    1


            Example : 2
            Input   : arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17}
            Output  : Corresponding Max-Heap:

                             17
                          /      \
                      15         13
                     /    \      /  \
                   9      6    5   10
                 / \    /  \
                4   8  3    1


            Note :
              * Root is at index 0 in array.
              * Left child of i-th node is at (2*i + 1)th index.
              * Right child of i-th node is at (2*i + 2)th index.
              * Parent of i-th node is at (i-1)/2 index.

        *
        * */
    }



}
