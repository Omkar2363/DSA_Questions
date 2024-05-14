package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ques_LB10 {

    //Ques : K-th element of two sorted Arrays.......                                   (GFG Ques.)


    //Approach 1 : Basic Approach....                                                   T.C. = O(n),   S.C. = O(m+n)
    /*  Since we are given two sorted arrays, we can use the merging technique to get the final merged array.
        From this, we simply go to the k'th index.
     * */
    // Java Program to find kth element from two sorted arrays
    class Main_1{
        static int kth(int arr1[], int arr2[], int m, int n, int k)
        {
            int[] sorted1 = new int[m + n];
            int i = 0, j = 0, d = 0;
            while (i < m && j < n)
            {
                if (arr1[i] < arr2[j])
                    sorted1[d++] = arr1[i++];
                else
                    sorted1[d++] = arr2[j++];
            }
            while (i < m)
                sorted1[d++] = arr1[i++];
            while (j < n)
                sorted1[d++] = arr2[j++];

            return sorted1[k - 1];
        }

        // Driver Code
        public static void main_1 (String[] args)
        {
            int arr1[] = {2, 3, 6, 7, 9};
            int arr2[] = {1, 4, 8, 10};
            int k = 5;
            System.out.print(kth(arr1, arr2, 5, 4, k));
        }
    }



    //Approach 2 : Space Optimized Version of above approach.....                      T.C. = O(K),   S.C. = O(1)
    class GFG_2 {
        public static int find(int A[], int B[], int m, int n, int k_req)
        {
            int k = 0, i = 0, j = 0;

            // Keep taking smaller of the current elements of two sorted arrays and keep incrementing k
            while (i < m && j < n) {
                if (A[i] < B[j]) {
                    k++;
                    if (k == k_req)
                        return A[i];
                    i++;
                }
                else {
                    k++;
                    if (k == k_req)
                        return B[j];
                    j++;
                }
            }

            // If array B[] is completely traversed
            while (i < m) {
                k++;
                if (k == k_req)
                    return A[i];
                i++;
            }

            // If array A[] is completely traversed
            while (j < n) {
                k++;
                if (k == k_req)
                    return B[j];
                j++;
            }
            return -1;
        }

        // Driver Code
        public static void main_2(String[] args)
        {
            int[] A = { 2, 3, 6, 7, 9 };
            int[] B = { 1, 4, 8, 10 };
            int k = 5;

            System.out.println(find(A, B, 5, 4, k));
        }
    }



    //Approach 3 : Divide and Conquer approach.......                                  T.C. = O(log(K)),   S.C. = O(log(k))
    // Java Program to find kth element from two sorted arrays
    class GFG_3 {
        static int kth(int arr1[], int arr2[], int m, int n, int k, int st1, int st2)
        {
            // In case we have reached end of array 1
            if (st1 == m)
            {
                return arr2[st2 + k - 1];
            }

            // In case we have reached end of array 2
            if (st2 == n)
            {
                return arr1[st1 + k - 1];
            }

            // k should never reach 0 or exceed sizes of arrays
            if (k == 0 || k > (m - st1) + (n - st2))
            {
                return -1;
            }

            // Compare first elements of arrays and return
            if (k == 1)
            {
                return (arr1[st1] < arr2[st2]) ? arr1[st1] : arr2[st2];
            }
            int curr = k / 2;

            // Size of array 1 is less than k / 2
            if (curr - 1 >= m - st1)
            {

                // Last element of array 1 is not kth
                // We can directly return the (k - m)th element in array 2
                if (arr1[m - 1] < arr2[st2 + curr - 1])
                {
                    return arr2[st2 + (k - (m - st1) - 1)];
                }
                else
                {
                    return kth(arr1, arr2, m, n, k - curr, st1, st2 + curr);
                }
            }

            // Size of array 2 is less than k / 2
            if (curr - 1 >= n - st2)
            {
                if (arr2[n - 1] < arr1[st1 + curr - 1])
                {
                    return arr1[st1 + (k - (n - st2) - 1)];
                }
                else
                {
                    return kth(arr1, arr2, m, n, k - curr,st1 + curr, st2);
                }
            }
            else

                // Normal comparison, move starting index of one array k / 2 to the right
                if (arr1[curr + st1 - 1] < arr2[curr + st2 - 1])
                {
                    return kth(arr1, arr2, m, n, k - curr,st1 + curr, st2);
                }
                else
                {
                    return kth(arr1, arr2, m, n, k - curr, st1, st2 + curr);
                }
        }

        // Driver code
        public static void main_3(String[] args)
        {
            int arr1[] = {2, 3, 6, 7, 9};
            int arr2[] = {1, 4, 8, 10};
            int k = 5;
            int st1 = 0, st2 = 0;
            System.out.println(kth(arr1, arr2, 5, 4, k, st1, st2));
        }
    }




    //Approach 4 :                                                                    T.C. = O(log(k)),   S.C. = O(log(k))
    // Java Program to find kth element from two sorted arrays
    class Gfg_4 {
        static int kth(int arr1[], int m, int arr2[], int n, int k)
        {
            if (k > (m + n) || k < 1)
                return -1;

            // let m > n
            if (m > n)
                return kth(arr2, n, arr1, m, k);

            // Check if arr1 is empty returning k-th element of arr2
            if (m == 0)
                return arr2[k - 1];

            // Check if k = 1 return minimum of first two elements of both arrays
            if (k == 1)
                return Math.min(arr1[0], arr2[0]);

            // Now the divide and conquer part
            int i = Math.min(m, k / 2);
            int j = Math.min(n, k / 2);

            if (arr1[i - 1] > arr2[j - 1]) {

                // Now we need to find only k-j th element since we have found out the lowest j
                int temp[] = Arrays.copyOfRange(arr2, j, n);

                return kth(arr1, m, temp, n - j, k - j);
            }

            // Now we need to find only k-i th element since we have found out the lowest i
            int temp[] = Arrays.copyOfRange(arr1, i, m);
            return kth(temp, m - i, arr2, n, k - i);
        }

        // Driver code
        public static void main_4(String[] args)
        {
            int arr1[] = { 2, 3, 6, 7, 9 };
            int arr2[] = { 1, 4, 8, 10 };
            int m = arr1.length;
            int n = arr2.length;

            int k = 5;
            int ans = kth(arr1, m, arr2, n, k);
            if (ans == -1)
                System.out.println("Invalid query");
            else
                System.out.println(ans);
        }
    }




    //Approach 5 : Using Min-Heap......                                              T.C. = O(nlog(n)),  S.C. = O(m+n)
    // Java Program to find kth element from two sorted arrays
    class GFG_5 {

        // Function to find K-th min
        static int kth(int a[], int b[], int n, int m, int k)
        {

            // Declaring a min heap
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            // Pushing elements for
            // array a to min-heap
            for (int i = 0; i < n; i++) {
                pq.offer(a[i]);
            }

            // Pushing elements for
            // array b to min-heap
            for (int i = 0; i < m; i++) {
                pq.offer(b[i]);
            }

            // Popping-out K-1 elements
            while (k-- > 1) {
                pq.remove();
            }
            return pq.peek();
        }

        // Driver Code
        public static void main_5(String[] args)
        {
            int arr1[] = { 2, 3, 6, 7, 9 };
            int arr2[] = { 1, 4, 8, 10 };
            int k = 5;
            System.out.print(kth(arr1, arr2, 5, 4, k));
        }
    }




    //Approach 6 : By using STL.......                                               T.C. = O(log(maxN).log(N+M)),  S.C. = O(1)
    // Java program to find the kth element
    class GFG{

        static long  maxN = (long)1e10;                       // the maximum value in the array possible.
        static int upperBound(int[] a, int low, int high, long element)
        {
            while(low < high){
                int middle = low + (high - low)/2;
                if(a[middle] > element)
                    high = middle;
                else
                    low = middle + 1;
            }
            return low;
        }

        static long  kthElement(int arr1[], int arr2[], int n, int m, int k)
        {
            long  left = 1, right = maxN;           // The range of where ans can lie.
            long  ans = (long)1e15;                 // We have to find min of all the ans so take .

            // using binary search to check all possible values of kth element
            while (left <= right) {
                long  mid = (left + right) / 2;
                long  up_cnt = upperBound(arr1,0, n, mid);
                up_cnt += upperBound(arr2, 0, m, mid);

                if (up_cnt >= k) {
                    ans = Math.min(ans, mid);       // find the min of all answers.
                    right = mid - 1;                // Try to find a smaller answer.
                }
                else
                    left = mid + 1;                 // Current mid is too small so shift right.
            }

            return ans;
        }

        // Driver code
        public static void main_6(String[] args)
        {
            // Example 1
            int n = 5, m = 7, k = 7;
            int arr1[] = { 100, 112, 256, 349, 770 };
            int arr2[] = { 72, 86, 113, 119, 265, 445, 892 };
            System.out.print(kthElement(arr1, arr2, n, m, k) +"\n");
        }
    }





    public static void main(String[] args) {

        /*Ques : Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K.
                 The task is to find the element that would be at the k’th position of the final sorted array.


            Example : 1
            Input   : arr1[] = {2, 3, 6, 7, 9}
                      arr2[] = {1, 4, 8, 10}
                      k = 5
            Output  : 6
            Explanation : The final sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10
                          The 5th element of this array is 6.

            Example : 2
            Input   : arr1[] = {100, 112, 256, 349, 770}
                      arr2[] = {72, 86, 113, 119, 265, 445, 892}
                      k = 7
            Output  : 256
            Explanation : Final sorted array is - 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
                          7th element of this array is 256.

            Your Task :
            You don't need to read input or print anything. Your task is to complete the function kthElement()
            which takes the arrays arr1[], arr2[], its size N and M respectively and an integer K as inputs and
            returns the element at the Kth position.


            Expected Time Complexity  : O(Log(N) + Log(M))
            Expected Auxiliary Space  : O(Log (N))


        *
        *
        * */
    }



}
