package Medium;

import java.util.HashSet;

public class Ques_LB9 {

    //Ques : Triplet Sum in Array....                                                  (GFG Ques.)


    //Approach 1 : Naive approach.....                                                  T.C. = O(n^3), S.C. = O(1)
    /* Returns true if there is triplet with sum equal
     to 'sum' present in A[]. Also, prints the triplet
    */
    boolean find3Numbers_1(int A[], int arr_size, int sum) {

        int l, r;

        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Fix the second element as A[j]
            for (int j = i + 1; j < arr_size - 1; j++) {

                // Now look for the third number
                for (int k = j + 1; k < arr_size; k++) {
                    if (A[i] + A[j] + A[k] == sum) {
                        System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]);
                        return true;
                    }
                }
            }
        }

        // If we reach here, then no triplet was found
        return false;


    /* Driver program to test above functions
    public static void main(String[] args)
    {
        FindTriplet triplet = new FindTriplet();
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        triplet.find3Numbers(A, arr_size, sum);
    }*/
    }



    //Approach 2 : By using Sorting.....                                                T.C. = O(n^2), S.C. = O(1)
    /* Returns true if there is triplet with sum equal
    to 'sum' present in A[]. Also, prints the triplet
   */
    boolean find3Numbers_2(int A[], int arr_size, int sum) {
        int l, r;

        /* Sort the elements */
        quickSort(A, 0, arr_size - 1);

        /* Now fix the first element one by one and find the other two elements */

        for (int i = 0; i < arr_size - 2; i++) {

            // To find the other two elements, start two index variables from two corners of the array
            // and move them toward each other

            l = i + 1;                           // index of the first element in the
            // remaining elements
            r = arr_size - 1;                   // index of the last element
            while (l < r) {

                if (A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                } else if (A[i] + A[l] + A[r] < sum)
                    l++;

                else                                // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }

    int partition(int A[], int si, int ei) {

        int x = A[ei];
        int i = (si - 1);
        int j;

        for (j = si; j <= ei - 1; j++) {
            if (A[j] <= x) {
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[ei];
        A[ei] = temp;
        return (i + 1);
    }

    /* Implementation of Quick Sort
        A[] --> Array to be sorted
        si  --> Starting index
        ei  --> Ending index
     */
    void quickSort(int A[], int si, int ei) {
            int pi;

            /* Partitioning index */
            if (si < ei) {
                pi = partition(A, si, ei);

                quickSort(A, si, pi - 1);
                quickSort(A, pi + 1, ei);
            }


        /* Driver program to test above functions
        public static void main(String[] args)
        {
            FindTriplet triplet = new FindTriplet();
            int A[] = { 1, 4, 45, 6, 10, 8 };
            int sum = 22;
            int arr_size = A.length;

            triplet.find3Numbers(A, arr_size, sum);
        }*/
    }




    //Approach 3 : By using Hashing....                                                 T.C. = O(n^2), S.C. = O(n)
    /* Returns true if there is triplet with sum equal to 'sum' present
     in A[]. Also, prints the triplet
    */
    static boolean find3Numbers(int A[], int arr_size, int sum) {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i]

            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++) {
                if (s.contains(curr_sum - A[j])) {
                    System.out.printf("Triplet is %d,% d, % d ", A[i], A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }

        // If we reach here, then no triplet was found
        return false;


    /* Driver code
    public static void main(String[] args)
    {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
    }*/
    }



    public static void main(String[] args) {

        /*Ques : Given an array arr of size n and an integer X. Find if there's a triplet in the array which
                 sums up to the given integer X.


                Example : 1
                Input   : n = 6, X = 13
                          arr[] = [1 4 45 6 10 8]
                Output  : 1
                Explanation : The triplet {1, 4, 8} in the array sums up to 13.


                Example : 2
                Input   : n = 5, X = 10
                          arr[] = [1 2 4 3 6]
                Output  : 1
                Explanation : The triplet {1, 3, 6} in the array sums up to 10.

                Your Task:
                You don't need to read input or print anything. Your task is to complete the function
                find3Numbers() which takes the array arr[], the size of the array (n) and the sum (X)
                as inputs and returns True if there exists a triplet in the array arr[] which sums up
                to X and False otherwise.


                Expected Time Complexity: O(n2)
                Expected Auxiliary Space: O(1)

        * */
    }

}
