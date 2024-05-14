package Medium;

import java.util.Arrays;
import java.util.Collections;

public class Ques_4 {                                  ////Ques no -4 m editing complete kro .


    //Ques : Merge two sorted arrays with O(1) extra space........                         (GFG Ques.)


    //Approach 1 :                                                                         T.C. = O(m*n)
    /*  Algorithm:

        1) Iterate through every element of ar2[] starting from last
           element. Do following for every element ar2[i]
            a) Store last element of ar1[i]: last = ar1[i]
            b) Loop from last element of ar1[] while element ar1[j] is
               greater than ar2[i].
                  ar1[j+1] = ar1[j] // Move element one position ahead
                  j--
            c) If any element of ar1[] was moved
                  ar1[j+1] = ar2[i]
                  ar2[i] = last


        In the above loop, elements in ar1[] and ar2[] are always kept sorted.


        Time Complexity : The worst-case time complexity of code/algorithm is O(m*n).
                          The worst case occurs when all elements of ar1[] are greater than all elements of ar2[].
    *
    * */
    // Java program to merge two sorted arrays with O(1) extra space.
    class Test {
        static int arr1[] = new int[]{1, 5, 9, 10, 15, 20};
        static int arr2[] = new int[]{2, 3, 8, 13};

        static void merge(int m, int n)
        {
            // Iterate through all elements of ar2[] starting from the last element
            for (int i=n-1; i>=0; i--)
            {
            /*  Find the smallest element greater than ar2[i]. Move all elements one position
                ahead till the smallest greater element is not found */
                int j;
                int last = arr1[m-1];
                for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--)
                    arr1[j+1] = arr1[j];

                // If there was a greater element
                if (last > arr2[i])
                {
                    arr1[j+1] = arr2[i];
                    arr2[i] = last;
                }
            }
        }

        // Driver method to test the above function
        public static void main_1(String[] args)
        {
            merge(arr1.length,arr2.length);
            System.out.print("After Merging nFirst Array: ");
            System.out.println(Arrays.toString(arr1));
            System.out.print("Second Array:  ");
            System.out.println(Arrays.toString(arr2));
        }
    }



    //Approach 2 :                                                                        T.C. = O((n+m)log(n+m))
    /*      The solution can be further optimized by observing that while traversing
            the two sorted arrays parallelly, if we encounter the jth second array element is
            smaller than ith first array element, then jth element is to be included and replace
            some kth element in the first array. This observation helps us with the following algorithm

        Algorithm :

        1) Initialize i,j,k as 0,0,n-1 where n is size of arr1
        2) Iterate through every element of arr1 and arr2 using two pointers i and j respectively
            if arr1[i] is less than arr2[j]
                increment i
            else
                swap the arr2[j] and arr1[k]
                increment j and decrement k

        3) Sort both arr1 and arr2


        Time Complexity  : The time complexity while traversing the arrays in while loop is O(n+m) in worst case
                           and sorting is O(nlog(n) + mlog(m)). So overall time complexity of the code
                           becomes O((n+m)log(n+m)).
        Space Complexity : As the function does not use any extra array for any operations, the space complexity is O(1).
    * */
    // Java program for the above approach
    class GFG {
        static int arr1[] = new int[] { 1, 5, 9, 10, 15, 20 };
        static int arr2[] = new int[] { 2, 3, 8, 13 };

        // Function to merge two arrays
        static void merge(int m, int n)
        {
            int i = 0, j = 0, k = m - 1;
            while (i <= k && j < n) {
                if (arr1[i] < arr2[j])
                    i++;
                else {
                    int temp = arr2[j];
                    arr2[j] = arr1[k];
                    arr1[k] = temp;
                    j++;
                    k--;
                }
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
        }

        public static void main(String[] args)
        {
            merge(arr1.length, arr2.length);
            System.out.print("After Merging \nFirst Array: ");
            System.out.println(Arrays.toString(arr1));
            System.out.print("Second Array:  ");
            System.out.println(Arrays.toString(arr2));
        }
    }



    //Approach 3 :
    /*      Algorithm:

                1) Initialize i with 0
                2) Iterate while loop until last element of array 1 is greater than first element of array 2
                          if arr1[i] greater than first element of arr2
                              swap arr1[i] with arr2[0]
                              sort arr2
                          incrementing i
    *
    * */
    class GFG_3{

        static int arr1[] = new int[]{ 1, 5, 9, 10, 15, 20 };
        static int arr2[] = new int[]{ 2, 3, 8, 13 };

        static void merge(int n, int m)
        {
            int i = 0;
            int temp = 0;

            // While loop till last element of array 1(sorted) is greater
            // than first element of array 2(sorted)
            while (arr1[n - 1] > arr2[0])
            {
                if (arr1[i] > arr2[0])
                {

                    // Swap arr1[i] with first element of arr2 and sorting the updated
                    // arr2(arr1 is already sorted) swap(arr1[i],arr2[0]);
                    temp = arr1[i];
                    arr1[i] = arr2[0];
                    arr2[0] = temp;
                    Arrays.sort(arr2);
                }
                i++;
            }
        }

        // Driver code
        public static void main_3(String[] args)
        {
            merge(arr1.length, arr2.length);

            System.out.print("After Merging \nFirst Array: ");
            System.out.println(Arrays.toString(arr1));

            System.out.print("Second Array:  ");
            System.out.println(Arrays.toString(arr2));
        }
    }




    //Approach 4 :
    /*
    *
    * */
    class GFG_4{

        static void swap(int a, int b)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        static void rotate(int a[], int n, int idx)
        {
            int i;
            for (i = 0; i < idx / 2; i++)
                swap(a[i], a[idx - 1 - i]);
            for (i = idx; i < (n + idx) / 2; i++)
                swap(a[i], a[n - 1 - (i - idx)]);
            for (i = 0; i < n / 2; i++)
                swap(a[i], a[n - 1 - i]);
        }

        static void sol(int a1[], int a2[], int n, int m)
        {
            int l = 0, h = n - 1, idx = 0;
            //---------------------------------------------------------
            while (l <= h) {
                // select the median of the remaining subarray
                int c1 = (int)(l + h) / 2;
                // select the first elements from the larger array
                // equal to the size of remaining portion to the
                // right of the smaller array
                int c2 = n - c1 - 1;
                int l1 = a1[c1];
                int l2 = a2[c2 - 1];
                int r1 = (c1 == n - 1) ? Integer.MAX_VALUE : a1[c1 + 1];
                int r2 = (c2 == m) ? Integer.MAX_VALUE : a2[c2];

                // compare the border elements and check for the
                // target index
                if (l1 > r2) {
                    h = c1 - 1;
                    if (h == -1)
                        idx = 0;
                }
                else if (l2 > r1) {
                    l = c1 + 1;
                    if (l == n - 1)
                        idx = n;
                }
                else {
                    idx = c1 + 1;
                    break;
                }
            }

            for (int i = idx; i < n; i++)
                swap(a1[i], a2[i - idx]);

            Arrays.sort(a1);

            Arrays.sort(a2);
        }

        static void merge(int arr1[], int arr2[], int n, int m)
        {
            // code here
            if (n > m) {
                sol(arr2, arr1, m, n);
                rotate(arr1, n, n - m);

                for (int i = 0; i < m; i++)
                    swap(arr2[i], arr1[i]);
            }
            else {
                sol(arr1, arr2, n, m);
            }
        }

        // Driver Code
        public static void main (String[] args)
        {
            int ar1[] = { 1, 5, 9, 10, 15, 20 };
            int ar2[] = { 2, 3, 8, 13 };
            int m = ar1.length;
            int n = ar2.length;
            merge(ar1, ar2, m, n);

            System.out.print("After Merging \nFirst Array: ");
            for (int i = 0; i < m; i++)
                System.out.print(ar1[i] + " ");
            System.out.print("\nSecond Array: ");
            for (int i = 0; i < n; i++)
                System.out.print(ar2[i] + " ");

        }
    }



    //Approach 5 : Insertion Sort with Simultaneous Merge
    /*  Approach:

         1. sort list 1 by always comparing with head/first of list 2 and swapping if required
         2. after each head/first swap, perform insertion of the swapped element into correct position
            in list 2 which will eventually sort list 2 at the end.

         For every swapped item from list 1, perform insertion sort in list 2 to find
         its correct position so that when list 1 is sorted, list 2 is also sorted.


    *
    * */
    class GFG_5{

        static void merge(int arr1[], int arr2[], int n, int m)
        {
            // two pointer to iterate
            int i = 0;
            int j = 0;
            while (i < n && j < m)
            {

                // if arr1[i] <= arr2[j] then both array is already
                // sorted
                if (arr1[i] <= arr2[j]) {
                    i++;
                }
                else if (arr1[i] > arr2[j])
                {

                    // if arr1[i]>arr2[j] then first we swap both
                    // element so that arr1[i] become smaller means
                    // arr1[] become sorted then we check that
                    // arr2[j] is smaller than all other element in
                    // right side of arr2[j] if arr2[] is not sorted
                    // then we linearly do sorting
                    // means while adjacent element are less than
                    // new arr2[j] we do sorting like by changing
                    // position of element by shifting one position
                    // toward left
                    int t = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = t;
                    i++;
                    if (j < m - 1 && arr2[j + 1] < arr2[j]) {
                        int temp = arr2[j];
                        int tempj = j + 1;
                        while (tempj<m && arr2[tempj] < temp && tempj < m) {
                            arr2[tempj - 1] = arr2[tempj];
                            tempj++;
                        }
                        arr2[tempj - 1] = temp;
                    }
                }
            }
        }

        public static void main(String[] args)
        {

            int ar1[] = { 1, 5, 9, 10, 15, 20 };
            int ar2[] = { 2, 3, 8, 13 };
            int m = ar1.length;
            int n =ar2.length;
            merge(ar1, ar2, m, n);

            System.out.print("After Merging \nFirst Array: ");
            for (int i = 0; i < m; i++)
                System.out.print(ar1[i]+ " ");
            System.out.print("\nSecond Array: ");
            for (int i = 0; i < n; i++)
                System.out.print(ar2[i]+ " ");
        }
    }




    //Approach 6 : Using Euclidean Division Lemma
    /*  Approach:
            Just merge the two arrays as we do in merge sort, while simultaneously using Euclidean Division Lemma,
            i.e. (((Operation on array) % x) * x). And at least after merging divide both the arrays with x.
                 Where x needs to be a number greater than all elements of array. Here in this case x,
                 (according to the constraints) can be 10e7 + 1.

    * */
    class GFG_6{

        static void merge(int arr1[], int arr2[], int n, int m)
        {
            // three pointers to iterate
            int i = 0, j = 0, k = 0;

            // for euclid's division lemma
            int x=10000000+7;

            // in this loop we are rearranging the elements of arr1
            while (i < n && (j < n && k < m))
            {

                // if both arr1 and arr2 elements are modified
                if (arr1[j] >= x && arr2[k] >= x) {
                    if (arr1[j] % x <= arr2[k] % x) {
                        arr1[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr1[i] += (arr2[k++] % x) * x;
                    }
                }

                // if only arr1 elements are modified
                else if (arr1[j] >= x) {
                    if (arr1[j] % x <= arr2[k]) {
                        arr1[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr1[i] += (arr2[k++] % x) * x;
                    }
                }

                // if only arr2 elements are modified
                else if (arr2[k] >= x) {
                    if (arr1[j] <= arr2[k] % x) {
                        arr1[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr1[i] += (arr2[k++] % x) * x;
                    }
                }

                // if none elements are modified
                else {
                    if (arr1[j] <= arr2[k]) {
                        arr1[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr1[i] += (arr2[k++] % x) * x;
                    }
                }
                i++;
            }

            // we can copy the elements directly as the other array
            // is exchausted
            while (j < n && i < n) {
                arr1[i++] += (arr1[j++] % x) * x;
            }
            while (k < m && i < n) {
                arr1[i++] += (arr2[k++] % x) * x;
            }

            // we need to reset i
            i = 0;

            // in this loop we are rearranging the elements of arr2
            while (i < m && (j < n && k < m))
            {

                // if both arr1 and arr2 elements are modified
                if (arr1[j] >= x && arr2[k] >= x) {
                    if (arr1[j] % x <= arr2[k] % x) {
                        arr2[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr2[i] += (arr2[k++] % x) * x;
                    }
                }

                // if only arr1 elements are modified
                else if (arr1[j] >= x) {
                    if (arr1[j] % x <= arr2[k]) {
                        arr2[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr2[i] += (arr2[k++] % x) * x;
                    }
                }

                // if only arr2 elements are modified
                else if (arr2[k] >= x) {
                    if (arr1[j] <= arr2[k] % x) {
                        arr2[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr2[i] += (arr2[k++] % x) * x;
                    }
                }
                else
                {

                    // if none elements are modified
                    if (arr1[j] <= arr2[k]) {
                        arr2[i] += (arr1[j++] % x) * x;
                    }
                    else {
                        arr2[i] += (arr2[k++] % x) * x;
                    }
                }
                i++;
            }

            // we can copy the elements directly as the other array
            // is exhausted
            while (j < n && i < m) {
                arr2[i++] += (arr1[j++] % x) * x;
            }
            while (k < m && i < m) {
                arr2[i++] += (arr2[k++] % x) * x;
            }

            // we need to reset i
            i = 0;

            // we need to divide the whole arr1 by x
            while (i < n) {
                arr1[i++] /= x;
            }

            // we need to reset i
            i = 0;

            // we need to divide the whole arr2 by x
            while (i < m) {
                arr2[i++] /= x;
            }
        }

        public static void main(String[] args)
        {

            int ar1[] = { 1, 5, 9, 10, 15, 20 };
            int ar2[] = { 2, 3, 8, 13 };
            int m = ar1.length;
            int n =ar2.length;
            merge(ar1, ar2, m, n);

            System.out.print("After Merging \nFirst Array: ");
            for (int i = 0; i < m; i++)
                System.out.print(ar1[i]+ " ");
            System.out.print("\nSecond Array: ");
            for (int i = 0; i < n; i++)
                System.out.print(ar2[i]+ " ");
        }
    }






    //Follow the link for completing it
    // Link : https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/

    public static void main(String[] args) {

        /*Ques : We are given two sorted arrays. We need to merge these two arrays such that
                 the initial numbers (after complete sorting) are in the first array and the
                 remaining numbers are in the second array. Extra space is allowed in O(1).


            Example : 1
            Input   : ar1[] = {10};
                      ar2[] = {2, 3};
            Output  : ar1[] = {2}
                      ar2[] = {3, 10}

            Example : 2
            Input   : ar1[] = {1, 5, 9, 10, 15, 20};
                      ar2[] = {2, 3, 8, 13};
            Output  : ar1[] = {1, 2, 3, 5, 8, 9}
                      ar2[] = {10, 13, 15, 20}

         */
    }


}