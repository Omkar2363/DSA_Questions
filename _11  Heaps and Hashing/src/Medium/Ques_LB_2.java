package Medium;

public class Ques_LB_2 {

    //Ques : Heap Sort..........                                                        (GFG Ques.)


    //Approach 1 :                                                                      T.C. = O(nlog(n)),   S.C. = O(1)
    // Java program for implementation of Heap Sort
    public static class HeapSort {
        public void sort(int arr[])
        {
            int N = arr.length;

            // Build heap (rearrange array)
            for (int i = N / 2 - 1; i >= 0; i--)
                heapify(arr, N, i);

            // One by one extract an element from heap
            for (int i = N - 1; i > 0; i--)
            {
                // Move current root to end
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // call max heapify on the reduced heap
                heapify(arr, i, 0);
            }
        }

        // To heapify a subtree rooted with node i which is
        // an index in arr[]. n is size of heap
        void heapify(int arr[], int N, int i)
        {
            int largest = i;                  // Initialize largest as root
            int l = 2 * i + 1;                // left = 2*i + 1
            int r = 2 * i + 2;                // right = 2*i + 2

            // If left child is larger than root
            if (l < N && arr[l] > arr[largest])
                largest = l;

            // If right child is larger than largest so far
            if (r < N && arr[r] > arr[largest])
                largest = r;

            // If largest is not root
            if (largest != i) {
                int swap = arr[i];
                arr[i]   = arr[largest];
                arr[largest] = swap;

                // Recursively heapify the affected sub-tree
                heapify(arr, N, largest);
            }
        }

        /* A utility function to print array of size n */
        static void printArray(int arr[])
        {
            int N = arr.length;

            for (int i = 0; i < N; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }

        // Driver's code
        public static void main_1(String args[])
        {
            int arr[] = { 12, 11, 13, 5, 6, 7 };
            int N = arr.length;

            // Function call
            HeapSort ob = new HeapSort();
            ob.sort(arr);

            System.out.println("Sorted array is");
            printArray(arr);
        }
    }



    //Note : Must Visit the following Link for detail Description :
    //Link : https://www.geeksforgeeks.org/heap-sort/


    public static void main(String[] args) {


        /*Ques : What is Heap Sort  ?
                    Heap sort is a comparison-based sorting technique based on Binary Heap data structure.
                    It is similar to the selection sort where we first find the minimum element and place
                    the minimum element at the beginning. Repeat the same process for the remaining elements.

                Heap sort is an in-place algorithm.
                Its typical implementation is not stable, but can be made stable (See this)
                Typically 2-3 times slower than well-implemented QuickSort.  The reason for slowness is a lack
                of locality of reference.

                * Advantages of heapsort :
                    Efficiency   –  The time required to perform Heap sort increases logarithmically
                                    while other algorithms may grow exponentially slower as the number of items
                                    to sort increases. This sorting algorithm is very efficient.
                    Memory Usage –  Memory usage is minimal because apart from what is necessary to hold the initial
                                    list of items to be sorted, it needs no additional memory space to work
                    Simplicity   –  It is simpler to understand than other equally efficient sorting algorithms because
                                    it does not use advanced computer science concepts such as recursion

                * Applications of HeapSort:
                    - Heapsort is mainly used in hybrid algorithms like the IntroSort.
                    - Sort a nearly sorted (or K sorted) array
                    - k largest(or smallest) elements in an array

                The heap sort algorithm has limited uses because Quicksort and Mergesort are better in practice.
                Nevertheless, the Heap data structure itself is enormously used.
        *
        *
        * */
    }



}
