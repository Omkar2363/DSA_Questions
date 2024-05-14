package Easy;

public class Ques_LB_1 {

    //Ques : Merge two binary Max Heaps........                                                (GFG Ques.)


    //Approach 1 : Simple Approach.....                                                        T.C. = O(N+M),  S.C. = O(N+M)
    /*  Approach : To solve the problem follow the below idea....

        Create an array to store the result. Copy both given arrays one by one into result. Once all the elements
        have been copied, then call standard build heap to construct full merged max heap.

        * Follow the given steps to solve the problem :
            1. Create an array merged of size N+M
            2. Copy elements of both the arrays in the array merged
            3. Build Max-Heap of this array
            4. Print elements of the Max-Heap
    *
    * */
    // Java program to merge two max heaps.
    class GfG {

        // Standard heapify function to heapify a subtree rooted under idx.
        // It assumes that subtrees of node are already heapified.
        public static void maxHeapify(int[] arr, int N, int i)
        {
            // Find largest of node and its children
            if (i >= N) {
                return;
            }
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            int max;
            if (l < N && arr[l] > arr[i]) {
                max = l;
            }
            else
                max = i;
            if (r < N && arr[r] > arr[max]) {
                max = r;
            }

            // Put maximum value at root and recur for the child
            // with the maximum value
            if (max != i) {
                int temp = arr[max];
                arr[max] = arr[i];
                arr[i] = temp;
                maxHeapify(arr, N, max);
            }
        }

        // Merges max heaps a[] and b[] into merged[]
        public static void mergeHeaps(int[] arr, int[] a, int[] b, int N, int M)
        {
            for (int i = 0; i < N; i++) {
                arr[i] = a[i];
            }
            for (int i = 0; i < M; i++) {
                arr[N + i] = b[i];
            }
            N = N + M;

            // Builds a max heap of given arr[0...n-1]
            for (int i = N / 2 - 1; i >= 0; i--) {
                maxHeapify(arr, N, i);
            }
        }

        // Driver's Code
        public static void main_1(String[] args)
        {
            int[] a = { 10, 5, 6, 2 };
            int[] b = { 12, 7, 9 };
            int N = a.length;
            int M = b.length;

            int[] merged = new int[M + N];

            // Function call
            mergeHeaps(merged, a, b, N, M);

            for (int i = 0; i < M + N; i++)
                System.out.print(merged[i] + " ");
            System.out.println();
        }
    }






    public static void main(String[] args) {

        /*Ques : Given two binary max heaps as arrays, the task is to merge the given heaps.

            Example : 1
            Input   : a = {10, 5, 6, 2},
                      b = {12, 7, 9}
            Output  : {12, 10, 9, 2, 5, 7, 6}


            Example : 2
            Input   : a = {2, 5, 1, 9, 12}, b = {3, 7, 4, 10}
            Output  : {12, 10, 7, 9, 5, 3, 1, 4, 2}


            //Follow the link for visual representation of the examples.
            //Link : https://www.geeksforgeeks.org/merge-two-binary-max-heaps/

        *
        * */
    }



}
