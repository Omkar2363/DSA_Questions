package Medium;

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class Ques_LB_3 {

    //Ques : k largest elements............                                         (GFG Ques.)


    //Approach 1 : By Modifying Sorting Algorithms.........
    /*  Method 1 : (Use Bubble k times)
            1) Modify Bubble Sort to run the outer loop at most k times.
            2) Print the last k elements of the array obtained in step 1.

        Time Complexity : O(n*k)

        -> Like Bubble sort, other sorting algorithms like Selection Sort can also be modified
           to get the k largest elements.
    * */



    //Approach 2 : By using Temporary array......
    /*  Method 2 : (Use temporary array)
          K largest elements from arr[0...n-1]z
            1). Store the first k elements in a temporary array temp[0..k-1].
            2). Find the smallest element in temp[], let the smallest element be min.
            3). a - For each element x in arr[k] to arr[n-1]. O(n-k)
                    If x is greater than the min then remove min from temp[] and insert x.
                b - Then, determine the new min from temp[]. O(k)
            4) Print final k elements of temp[]

          Time Complexity : O((n-k)*k). If we want the output sorted then O((n-k)*k + k*log(k))
    *
    * */



    //Approach 3 : By using Sorting........                                         T.C. = O(n*log(k)),   S.C. = O(1)
    // Java code for k largest elements in an array
    class GFG {
        public static void kLargest(Integer[] arr, int k)
        {
            // Sort the given array arr in reverse order
            // This method doesn't work with primitive data types.
            // So, instead of int, Integer type array will be used
            Arrays.sort(arr, Collections.reverseOrder());

            // Print the first kth largest elements
            for (int i = 0; i < k; i++)
                System.out.print(arr[i] + " ");
        }

        public static ArrayList<Integer> kLargest(int[] arr, int k)
        {
            //Convert using stream
            Integer[] obj_array = Arrays.stream( arr ).boxed().toArray( Integer[] :: new);
            Arrays.sort(obj_array, Collections.reverseOrder());
            ArrayList<Integer> list = new ArrayList<>(k);

            for (int i = 0; i < k; i++)
                list.add(obj_array[i]);

            return list;
        }

        public static void main_3(String[] args)
        {
            Integer arr[] = new Integer[] { 1, 23, 12, 9, 30, 2, 50 };
            int k = 3;
            kLargest(arr, k);

            //What if primitive datatype array is passed and wanted to return in ArrayList<Integer>
            int[] prim_array = { 1, 23, 12, 9, 30, 2, 50 };
            System.out.print(kLargest(prim_array, k));
        }
    }





    //Approach 4 : By using Max heap......
    /*  Method 4 (Use Max Heap)
           1) Build a Max Heap tree in O(n*log(n))
           2) Use Extract Max k times to get k maximum elements from the Max Heap O(k*log(n))

        Time complexity: O(n*log(n) + k*log(n))
    *
    * */




    //Approach  5 : By using Min heap.......                                      T.C. = O(n*log(n)),   S.C. = O(n)
    class GFG_5 {
        public static void FirstKelements(int arr[], int size, int k)
        {
            // Creating Min Heap for given array with only k elements.
            // Create min heap with priority queue.
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int i = 0; i < k; i++)
            {
                minHeap.add(arr[i]);
            }

            // Loop For each element in array after the kth element
            for(int i = k; i < size; i++)
            {

                // If current element is smaller than minimum ((top element of the minHeap) element, do nothing
                // and continue to next element
                if (minHeap.peek() > arr[i])
                    continue;

                    // Otherwise Change minimum element (top element of the minHeap) to current element
                    // by polling out the top element of the minHeap
                else
                {
                    minHeap.poll();
                    minHeap.add(arr[i]);
                }
            }

            // Now min heap contains k maximum elements, Iterate and print
            Iterator iterator = minHeap.iterator();

            while (iterator.hasNext())
            {
                System.out.print(iterator.next() + " ");
            }
        }

        // Driver code
        public static void main_5 (String[] args)
        {
            int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };

            int size = arr.length;

            // Size of Min Heap
            int k = 3;

            FirstKelements(arr, size, k);
        }
    }




    //Approach 6 : By using Quick Sort Partitioning Algorithm.........            T.C. = O(n*log(n)),  S.C. = O(n)
    class GFG_6 {

        //picks up last element between start and end
        static int findPivot(int a[], int start, int end)
        {

            // Selecting the pivot element
            int pivot = a[end];

            // Initially partition-index will be at starting
            int pIndex = start;

            for (int i = start; i < end; i++) {

                // If an element is lesser than pivot, swap it.
                if (a[i] <= pivot) {
                    int temp =a[i];
                    a[i]= a[pIndex];
                    a[pIndex]  = temp;


                    // Incrementing pIndex for further swapping.
                    pIndex++;
                }
            }

            // Lastly swapping or the correct position of pivot
            int temp = a[pIndex];
            a[pIndex] = a[end];
            a[end] = temp;
            return pIndex;
        }

        //Picks up random pivot element between start and end
        static int findRandomPivot(int arr[], int start, int end)
        {
            int n = end - start + 1;

            // Selecting the random pivot index
            int pivotInd = (int) ((Math.random()*1000000)%n);
            int temp = arr[end];
            arr[end] = arr[start+pivotInd];
            arr[start+pivotInd] = temp;
            int pivot = arr[end];

            //initialising pivoting point to start index
            pivotInd = start;
            for (int i = start; i < end; i++) {

                // If an element is lesser than pivot, swap it.
                if (arr[i] <= pivot) {
                    int temp1 = arr[i];
                    arr[i]= arr[pivotInd];
                    arr[pivotInd] = temp1;

                    // Incrementing pivotIndex for further swapping.
                    pivotInd++;
                }
            }

            // Lastly swapping or the correct position of pivot
            int tep = arr[pivotInd];
            arr[pivotInd] =  arr[end];
            arr[end] = tep;
            return pivotInd;
        }
        static void SmallestLargest(int a[], int low, int high, int k, int n)
        {
            if (low == high)
                return;
            else {
                int pivotIndex = findRandomPivot(a, low, high);

                if (k == pivotIndex) {
                    System.out.print(k+ " smallest elements are : ");
                    for (int i = 0; i < pivotIndex; i++)
                        System.out.print(a[i]+ "  ");

                    System.out.println();

                    System.out.print(k+ " largest elements are : ");
                    for (int i = (n - pivotIndex); i < n; i++)
                        System.out.print(a[i]+ "  ");
                }

                else if (k < pivotIndex)
                    SmallestLargest(a, low, pivotIndex - 1, k, n);

                else if (k > pivotIndex)
                    SmallestLargest(a, pivotIndex + 1, high, k, n);
            }
        }

        // Driver Code
        public static void main_6(String[] args)
        {
            int a[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
            int n = a.length;

            int low = 0;
            int high = n - 1;

            // Let's assume k is 3
            int k = 3;

            // Function Call
            SmallestLargest(a, low, high, k, n);
        }
    }





    //Approach 7 : By using Priority Queue STL Library........                   T.C. = O(n*log(k)),    S.C. = O(k)
    // Java code for k largest/ smallest elements in an array
    class GFG_7 {

        // Function to find k largest array element
        static void kLargest(int a[], int n, int k)
        {
            // Implementation using a Priority Queue
            PriorityQueue<Integer> pq  =  new PriorityQueue<Integer>();

            for (int i = 0; i < n; ++i)
            {
                // Insert elements into the priority queue
                pq.add(a[i]);

                // If size of the priority queue exceeds k
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            // Print the k largest element
            while (!pq.isEmpty()) {
                System.out.print(pq.peek() + " ");
                pq.poll();
            }
            System.out.println();
        }

        // Function to find k smallest array element
        static void kSmallest(int a[], int n, int k)
        {
            // Implementation using a Priority Queue
            PriorityQueue<Integer> pq  =  new PriorityQueue<Integer>(Collections.reverseOrder());

            for (int i = 0; i < n; ++i)
            {
                // Insert elements into the priority queue
                pq.add(a[i]);

                // If size of the priority queue exceeds k
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            // Print the k largest element
            while (!pq.isEmpty())
            {
                System.out.print(pq.peek() + " ");
                pq.poll();
            }
        }

        // Driver Code
        public static void main_7(String[] args)
        {
            int a[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
            int n = a.length;
            int k = 3;
            System.out.print(k + " largest elements are : ");
            // Function Call
            kLargest(a, n, k);
            System.out.print(k + " smallest elements are : ");
            // Function Call
            kSmallest(a, n, k);
        }
    }





    //Approach 8 : By Creating a BST and Getting K greatest elements........
    //C++ Code.......
    /*  #include <bits/stdc++.h>
        using namespace std;

        struct Node{
            int data;
            struct Node *left;
            struct Node *right;
        };

        class Tree{
            public:
                Node *root = NULL;
                void addNode(int data)
                {
                    Node *newNode = new Node();
                    newNode->data = data;
                    if (!root){
                        root = newNode;
                    }
                    else{
                        Node *cur = root;
                        while (cur){
                            if (cur->data > data){
                                if (cur->left){
                                    cur = cur->left;
                                }
                                else{
                                    cur->left = newNode;
                                    return;
                                }
                            }
                            else{
                                if (cur->right){
                                    cur = cur->right;
                                }
                                else{
                                    cur->right = newNode;
                                    return;
                                }
                            }
                        }
                    }
                }
                void printGreatest(int &K, vector<int> &sol, Node* node){
                    if (!node || K == 0)  return;
                    printGreatest(K, sol, node->right);
                    if (K <= 0) return;
                    sol.push_back(node->data);
                    K--;
                    printGreatest(K, sol, node->left);
                }
        };

        class Solution{
        public:

            vector<int> kLargest(int arr[], int n, int k) {
                vector<int> sol;
                Tree tree = Tree();
                for (int i = 0; i < n; i++){
                    tree.addNode(arr[i]);
                }
                tree.printGreatest(k, sol, tree.root);
                return sol;
            }

        };


        int main() {
              int n = 5, k = 2;
              int arr[] = {12, 5, 787, 1, 23};
              Solution ob;
              auto ans = ob.kLargest(arr, n, k);
              cout << "Top " << k << " Elements: ";
            for (auto x : ans) {
              cout << x << " ";
            }
            cout << "\n";
            return 0;
        }
    *
    *
    * */





    public static void main(String[] args) {

        /*Ques : Given an array Arr of N positive integers and an integer K, find K largest elements from the array.
                 The output elements should be printed in decreasing order.


            Example : 1
            Input   : N = 5, K = 2
                      Arr[] = {12, 5, 787, 1, 23}
            Output  : 787 23
            Explanation : 1st largest element in the array is 787 and second largest is 23.



            Example : 2
            Input   : N = 7, K = 3
                      Arr[] = {1, 23, 12, 9, 30, 2, 50}
            Output  : 50 30 23
            Explanation : 3 Largest element in the array are 50, 30 and 23.


            Your Task :
            You don't need to read input or print anything. Your task is to complete the function kLargest()
            which takes the array of integers arr, n and k as parameters and returns an array of integers denoting
            the answer. The array should be in decreasing order.



            Expected Time Complexity : O(N + K*(log(K))
            Expected Auxiliary Space : O(K+(N-K)*logK)



        *
        * */
    }



}
