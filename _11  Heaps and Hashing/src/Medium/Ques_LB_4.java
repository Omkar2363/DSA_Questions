package Medium;

import java.util.*;

public class Ques_LB_4 {

    //Ques : K’th Smallest/Largest Element in Unsorted Array..............                 (GFG Ques.)


    //Approach 1 : By using Sorting.......                                                 T.C. = O(nlog(n)),  S.C. = O(1)
    /*  K’th smallest element in an unsorted array using sorting :

            Sort the given array and return the element at index K-1 in the sorted array.

        * Follow the given steps to solve the problem :
           1. Sort the input array in the increasing order
           2. Return the element at the K-1 index (0 – Based indexing) in the sorted array
    *
    * */
    // Java code for Kth smallest element in an array
    class GFG {

        // Function to return K'th smallest element in a given array
        public static int kthSmallest(Integer[] arr, int K)
        {
            // Sort the given array
            Arrays.sort(arr);

            // Return K'th element in the sorted array
            return arr[K - 1];
        }

        // driver's code
        public static void main_1(String[] args)
        {
            Integer arr[] = new Integer[] { 12, 3, 5, 7, 19 };
            int K = 2;

            // Function call
            System.out.print("K'th smallest element is " + kthSmallest(arr, K));
        }
    }




    //Approach 2 : By using Set Data Structure.........                                  T.C. = O(nlog(n)),  S.C. = O(n)
    /*  K’th smallest element in an unsorted array using set data structure:
           Set data structure can be used to find the kth smallest element as it stores the distinct
           elements in sorted order. Set can be used because it is mentioned in the question that all
           the elements in the array are distinct.

        * Follow the given steps to solve the problem :
           1. Insert all array elements into the set
           2. Advance the iterator to the Kth element in the set
           3. Return the value of the element at which the iterator is pointing

    *
    * */
    // Java code for the above approach
    class GFG_2 {

        public static void main(String[] args)
        {
            int[] arr = { 12, 3, 5, 7, 19 };
            int N = arr.length;
            int K = 4;

            // since counting starts from 0 so to find kth element we need to reduce K by 1
            K--;

            // for storing elements in sorted form in set we will use TreeSet
            Set<Integer> s = new TreeSet<Integer>();

            // Adding elements to set
            for (int i = 0; i < N; i++)
                s.add(arr[i]);

            // Use iterator method of Iterator for the traversal
            Iterator<Integer> itr = s.iterator();

            while (K > 0) {
                itr.next();
                K--;
            } // itr points to the Kth element in the set

            System.out.println(itr.next());
        }
    }




    //Approach 3 : By using min heap Data Structure......                               T.C. = O(N + K*log(N)),  S.C. = O(N)
    /*  K’th smallest element in an unsorted array using Min-Heap :
            Min-Heap can be used to find the kth smallest element, by inserting all the elements into Min-Heap
            and then and call extractMin() function K times.

        * Follow the given steps to solve the problem :
            1. Insert all the array elements into the Min-Heap
            2. Call extractMin() function K times
            3. Return the value obtained at the last call of extractMin() function

    *
    * */
    // Java program to find K'th smallest element using min heap
    static class GFG_3 {

        // A class for Max Heap
        static class MinHeap {
            int[] harr;                               // pointer to array of elements in heap
            int capacity;                             // maximum possible size of min heap
            int heap_size;                            // Current number of elements in min
            // heap

            int parent(int i) {
                return (i - 1) / 2;
            }
            int left(int i) {
                return ((2 * i) + 1);
            }
            int right(int i) {
                return ((2 * i) + 2);
            }
            int getMin() {
                return harr[0];
            } // Returns minimum

            // to replace root with new node x and heapify() new root
            void replaceMax(int x)
            {
                this.harr[0] = x;
                minHeapify(0);
            }
            MinHeap(int a[], int size)
            {
                heap_size = size;
                harr = a;                                       // store address of array
                int i = (heap_size - 1) / 2;
                while (i >= 0) {
                    minHeapify(i);
                    i--;
                }
            }

            // Method to remove maximum element (or root) from min heap
            int extractMin()
            {
                if (heap_size == 0)
                    return Integer.MAX_VALUE;

                // Store the maximum value.
                int root = harr[0];

                // If there are more than 1 items, move the last item to root and call heapify.
                if (heap_size > 1) {
                    harr[0] = harr[heap_size - 1];
                    minHeapify(0);
                }
                heap_size--;
                return root;
            }

            // A recursive method to heapify a subtree with root at given index.
            // This method assumes that the subtrees are already heapified
            void minHeapify(int i)
            {
                int l = left(i);
                int r = right(i);
                int smallest = i;
                if (l < heap_size && harr[l] < harr[i])
                    smallest = l;
                if (r < heap_size && harr[r] < harr[smallest])
                    smallest = r;
                if (smallest != i) {
                    int t = harr[i];
                    harr[i] = harr[smallest];
                    harr[smallest] = t;
                    minHeapify(smallest);
                }
            }
        };

        // Function to return k'th largest element in a given array
        int kthSmallest(int arr[], int N, int K)
        {

            // Build a heap of first k elements: O(k) time
            MinHeap mh = new MinHeap(arr, N);

            // Process remaining n-k elements. If current element is smaller than root,
            // replace root with current element
            for (int i = 0; i < K - 1; i++)
                mh.extractMin();

            // Return root
            return mh.getMin();
        }

        // Driver's code
        public static void main_3(String[] args)
        {
            int arr[] = { 12, 3, 5, 7, 19 };
            int N = arr.length, K = 2;
            GFG_3 gfg = new GFG_3();

            // Function call
            System.out.print("K'th smallest element is " + gfg.kthSmallest(arr, N, K));
        }
    }





    //Approach 4 : By using max heap Data Structure........                            T.C. = O(K + (N-K)log(k)),  S.C. = O(K)
    /*  K’th smallest element in an unsorted array using Max-Heap :
            Max-Heap can be used to find the kth smallest element, by inserting first K elements into
            Max-Heap and then compare remaining elements with the root of the Max-Heap and if the element
            is less than the root then remove the root and insert this element into the heap and finally
            return root of the Max-Heap

        * Follow the given steps to solve the problem :
            1. Build a Max-Heap MH of the first K elements (arr[0] to arr[K-1]) of the given array.
            2. For each element, after the Kth element (arr[K] to arr[n-1]), compare it with the root of MH.
                a) If the element is less than the root then make it the root and call heapify for Max-Heap MH
                b) Else ignore it.
            3. Finally, the root of the MH is the Kth smallest element.

    *
    * */
    // A Java program to find k'th smallest element using max heap
    static class GFG_4 {

        // A class for Max Heap
        class MaxHeap {
            int[] harr;                         // pointer to array of elements in heap
            int capacity;                       // maximum possible size of max heap
            int heap_size;                      // Current number of elements in max
            // heap

            int parent(int i) { return (i - 1) / 2; }
            int left(int i) { return (2 * i + 1); }
            int right(int i) { return (2 * i + 2); }
            int getMax() { return harr[0]; } // Returns maximum


            // to replace root with new node x and heapify() new root
            void replaceMax(int x)
            {
                this.harr[0] = x;
                maxHeapify(0);
            }
            MaxHeap(int a[], int size)
            {
                heap_size = size;
                harr = a;                                          // store address of array
                int i = (heap_size - 1) / 2;
                while (i >= 0) {
                    maxHeapify(i);
                    i--;
                }
            }

            // Method to remove maximum element (or root) from max heap
            int extractMax()
            {
                if (heap_size == 0)
                    return Integer.MAX_VALUE;

                // Store the maximum value.
                int root = harr[0];

                // If there are more than 1 items, move the last item to root and call heapify.
                if (heap_size > 1) {
                    harr[0] = harr[heap_size - 1];
                    maxHeapify(0);
                }
                heap_size--;
                return root;
            }

            // A recursive method to heapify a subtree with root at given index.
            // This method assumes that the subtrees are already heapified
            void maxHeapify(int i)
            {
                int l = left(i);
                int r = right(i);
                int largest = i;
                if (l < heap_size && harr[l] > harr[i])
                    largest = l;
                if (r < heap_size && harr[r] > harr[largest])
                    largest = r;
                if (largest != i) {
                    int t = harr[i];
                    harr[i] = harr[largest];
                    harr[largest] = t;
                    maxHeapify(largest);
                }
            }
        };

        // Function to return k'th largest element in a given array
        int kthSmallest(int arr[], int N, int K)
        {

            // Build a heap of first k elements: O(k) time
            MaxHeap mh = new MaxHeap(arr, K);

            // Process remaining n-k elements. If current element is smaller than root,
            // replace root with current element
            for (int i = K; i < N; i++)
                if (arr[i] < mh.getMax())
                    mh.replaceMax(arr[i]);

            // Return root
            return mh.getMax();
        }

        // Driver's code
        public static void main_4 (String[] args)
        {
            int arr[] = { 12, 3, 5, 7, 19 };
            int N = arr.length, K = 4;
            GFG_4 gfg = new GFG_4();

            // Function call
            System.out.print("K'th smallest element is " + gfg.kthSmallest(arr, N, K));
        }
    }





    //Approach 5 : By using Quick Sort..........                                       T.C. = O(n^2),  S.C. = O(1)
    // Java code for kth smallest element in an array
    class GFG_5 {

        // Standard partition process of QuickSort. It considers the last element as pivot
        // and moves all smaller element to left of it and greater elements to right
        public static int partition(Integer[] arr, int l, int r)
        {
            int x = arr[r], i = l;
            for (int j = l; j <= r - 1; j++) {
                if (arr[j] <= x) {

                    // Swapping arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    i++;
                }
            }

            // Swapping arr[i] and arr[r]
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;

            return i;
        }

        // This function returns k'th smallest element in arr[l...r] using QuickSort based method.
        // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
        public static int kthSmallest(Integer[] arr, int l, int r, int K)
        {
            // If k is smaller than number of elements in array
            if (K > 0 && K <= r - l + 1) {

                // Partition the array around last element and get position of
                // pivot element in sorted array
                int pos = partition(arr, l, r);

                // If position is same as k
                if (pos - l == K - 1)
                    return arr[pos];

                // If position is more, recur for left subarray
                if (pos - l > K - 1)
                    return kthSmallest(arr, l, pos - 1, K);

                // Else recur for right subarray
                return kthSmallest(arr, pos + 1, r,K - pos + l - 1);
            }

            // If k is more than number of elements in array
            return Integer.MAX_VALUE;
        }

        // Driver's code
        public static void main_5(String[] args)
        {
            Integer arr[] = new Integer[] { 12, 3, 5, 7, 4, 19, 26 };
            int K = 3;

            // Function call
            System.out.print( "K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, K));
        }
    }




    //Approach 6 : By using Map.........                                              T.C. = O(nlog(n)),  S.C. = O(n)
    // Java program for the above approach
    class GFG_6 {
        static int Kth_smallest(TreeMap<Integer, Integer> mp, int K)
        {
            int freq = 0;
            for (Map.Entry it : mp.entrySet()) {

                // adding the frequencies of each element
                freq += (int)it.getValue();

                // if at any point frequency becomes greater than or equal to k then
                // return that element
                if (freq >= K) {
                    return (int)it.getKey();
                }
            }

            return -1;                // returning -1 if k>size of the array which is an impossible scenario
        }

        // Driver's code
        public static void main_6(String[] args)
        {
            int N = 5;
            int K = 2;
            int[] arr = { 12, 3, 5, 7, 19 };
            TreeMap<Integer, Integer> mp = new TreeMap<>();

            for (int i = 0; i < N; i++) {

                // mapping every element with its frequency
                mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            }

            // Function call
            int ans = Kth_smallest(mp, K);

            System.out.println("The " + K + "th smallest element is " + ans);
        }
    }





    //Approach 7 : By using Priority Queue..........                                  T.C. = O(K*log(K) + (N-K)*log(K)),  S.C. = O(K)
    // Java code to implement the approach
    // Custom comparator class to form the Max heap
    static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer number1, Integer number2)
        {
            int value = number1.compareTo(number2);

            // Elements are sorted in reverse order
            if (value > 0) {
                return -1;
            }
            else if (value < 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
    static class GFG_7 {

        // Function to find kth smallest array element
        static int kthSmallest(int[] v, int N, int K)
        {
            // For finding min element we need (Max heap)priority queue
            PriorityQueue<Integer> heap1  = new PriorityQueue<Integer>(new MinHeapComparator());

            for (int i = 0; i < N; ++i) {

                // Insert elements into the priority queue
                heap1.add(v[i]);

                // If current element is less than top, that means there are other k-1 lesser elements are
                // present at bottom thus pop that element and add kth largest element into the heap till
                // curr at last all the greater element than kth element will get pop off and at the top of heap
                // there will be kth smallest element
                if (heap1.size() > K) {
                    heap1.remove();
                }
            }

            // Return the top of the heap as kth smallest element
            return heap1.peek();
        }

        // Driver's code
        public static void main_7(String[] args)
        {
            // Given array
            int[] vec = { 10, 5, 4, 3, 48, 15, 6, 2, 33, 53, 10 };

            // Size of array
            int N = vec.length;

            // Given K
            int K = 4;

            // Function Call
            System.out.println("Kth Smallest Element: " + kthSmallest(vec, N, K));
        }
    }






    //Approach 8 : By using Binary Search...........
    // Java code for kth smallest element in an array
    class GFG_8 {
        static int count(int[] nums, int mid)
        {
            // function to calculate number of elements less than equal to mid
            int cnt = 0;

            for (int i = 0; i < nums.length; i++)
                if (nums[i] <= mid)
                    cnt++;

            return cnt;
        }

        static int kthSmallest(int[] nums, int k)
        {
            int low  = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            // calculate minimum and maximum the array.
            for (int i = 0; i < nums.length; i++)
            {
                low = Math.min(low, nums[i]);
                high = Math.max(high, nums[i]);
            }
            // Our answer range lies between minimum and maximum element of the array
            // on which Binary Search is Applied
            while (low < high)
            {
                int mid = low + (high - low) / 2;

                /* If the count of number of elements in the array less than equal to mid is less than k
                   then increase the number. Otherwise, decrement the number and try to find a better answer.
                */
                if (count(nums, mid) < k)
                    low = mid + 1;

                else
                    high = mid;
            }

            return low;
        }

        // Driver's code
        public static void main_8(String[] args)
        {
            int arr[] = { 1, 4, 5, 3, 19, 3 };
            int k = 3;

            // Function call
            System.out.print("Kth smallest element is " + kthSmallest(arr, k));
        }
    }

    /*  Complexity Analysis :
            * Time complexity : O((mx-mn) * log (mx-mn)),   where mn be minimum and mx be maximum.
            * Auxiliary Space : O(1)
    *
    *
    * */





    public static void main(String[] args) {

        /*Ques : Given an array and a number K where K is smaller than the size of the array.
                 Find the K’th smallest element in the given array. Given that all array elements are distinct.


            Example : 1
            Input   : arr[] = {7, 10, 4, 3, 20, 15}, K = 3
            Output  : 7


            Example : 2
            Input   : arr[] = {7, 10, 4, 3, 20, 15}, K = 4
            Output  : 10
        *
        * */
    }



}
