package Easy;

public class Ques_LB_3 {

    //Ques : Convert Min Heap to Max Heap.........                                           (GFG Ques.)


    //Approach 1 :                                                                           T.C. = O(n),  S.C. = O(n)
    /*  Approach : To solve the problem follow the below idea......

            The idea is, simply build Max Heap without caring about the input. Start from the bottom-most and rightmost
            internal node of Min-Heap and heapify all internal modes in the bottom-up way to build the Max heap.

        * Follow the given steps to solve the problem :
            * Call the Heapify function from the rightmost internal node of Min-Heap
            * Heapify all internal nodes in the bottom-up way to build max heap
            * Print the Max-Heap
    *
    * */
    // Java program to convert min Heap to max Heap
    class GFG {

        // To heapify a subtree with root at given index
        static void MaxHeapify(int arr[], int i, int N)
        {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int largest = i;
            if (l < N && arr[l] > arr[i])
                largest = l;
            if (r < N && arr[r] > arr[largest])
                largest = r;
            if (largest != i) {
                // swap arr[i] and arr[largest]
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                MaxHeapify(arr, largest, N);
            }
        }

        // This function basically builds max heap
        static void convertMaxHeap(int arr[], int N)
        {
            // Start from bottommost and rightmost internal mode and
            // heapify all internal nodes in bottom up way
            for (int i = (N - 2) / 2; i >= 0; --i)
                MaxHeapify(arr, i, N);
        }

        // A utility function to print a given array of given size
        static void printArray(int arr[], int size)
        {
            for (int i = 0; i < size; ++i)
                System.out.print(arr[i] + " ");
        }

        // driver's code
        public static void main_1(String[] args)
        {
            // array representing Min Heap
            int arr[] = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };
            int N = arr.length;

            System.out.print("Min Heap array : ");
            printArray(arr, N);

            // Function call
            convertMaxHeap(arr, N);

            System.out.print("\nMax Heap array : ");
            printArray(arr, N);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given an array representation of min Heap, convert it to max Heap.


            Example : 1
            Input   : arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9}

                           3
                        /     \
                      5       9
                    /   \    /  \
                  6     8  20   10
                /  \   /
               12   18 9


            Output  : arr[] = {20, 18, 10, 12, 9, 9, 3, 5, 6, 8}

                       20
                     /    \
                  18      10
                 /    \    /  \
                12     9  9    3
               /  \   /
              5    6 8


            Example : 2
            Input   : arr[] = {3, 4, 8, 11, 13}
            Output  :  arr[] = {13, 11, 8, 4, 3}


        *
        *
        */
    }



}
