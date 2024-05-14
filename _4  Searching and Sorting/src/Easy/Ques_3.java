package Easy;

import java.util.HashSet;

public class Ques_3 {

    //Ques : Find common elements in three sorted arrays........                        (GFG Ques.)


    //Approach 1 :                                                                      T.C. = O(n1 + n2 + n3),  S.C. = O(1)
    /*  A simple solution is to first find intersection of two arrays and store the intersection
        in a temporary array, then find the intersection of third array and temporary array.

        Time complexity of this solution is O(n1 + n2 + n3) where n1, n2 and n3 are sizes of ar1[], ar2[] and ar3[] respectively.

        * The above solution requires extra space and two loops,
          we can find the common elements using a single loop and without extra space.

          The idea is similar to intersection of two arrays. Like two arrays loop, we run a loop and traverse three arrays.

          => Let the current element traversed in ar1[] be x, in ar2[] be y and in ar3[] be z.
             We can have the following cases inside the loop.

               * If x, y and z are same, we can simply print any of them as common element and move ahead in all three arrays.
               * Else If x < y, we can move ahead in ar1[] as x cannot be a common element.
               * Else If x > z and y > z), we can simply move ahead in ar3[] as z cannot be a common element.
    **/
    // Java program to find common elements in three arrays
    static class FindCommon_1{
        // This function prints common elements in ar1
        void findCommon(int ar1[], int ar2[], int ar3[])
        {
            // Initialize starting indexes for ar1[], ar2[] and ar3[]
            int i = 0, j = 0, k = 0;

            // Iterate through three arrays while all arrays have elements
            while (i < ar1.length && j < ar2.length && k < ar3.length)
            {
                // If x = y and y = z, print any of them and move ahead in all arrays
                if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                    System.out.print(ar1[i] + " ");
                    i++;
                    j++;
                    k++;
                }

                // x < y
                else if (ar1[i] < ar2[j])
                    i++;

                    // y < z
                else if (ar2[j] < ar3[k])
                    j++;

                    // We reach here when x > y and z < y, : i.e. z is smallest
                else
                    k++;
            }
        }

        // Driver code to test above
        public static void main_1(String args[])
        {
            FindCommon_1 ob = new FindCommon_1();

            int ar1[] = { 1, 5, 10, 20, 40, 80 };
            int ar2[] = { 6, 7, 20, 80, 100 };
            int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

            System.out.print("Common elements are ");
            ob.findCommon(ar1, ar2, ar3);
        }
    }



    //Approach 2 :                                                                     T.C. = O(n1 + n2 + n3),  S.C. = O(1)
    // Java program to find common elements in three arrays
    static class FindCommon_2 {

        // This function prints common elements in ar1
        void findCommon(int ar1[], int ar2[], int ar3[])
        {

            // Initialize starting indexes for ar1[], ar2[] and ar3[]
            int i = 0, j = 0, k = 0;
            int n1 = ar1.length;
            int n2 = ar2.length;
            int n3 = ar3.length;

            // Declare three variables prev1, prev2, prev3 to track previous element
            int prev1, prev2, prev3;

            // Initialize prev1, prev2, prev3 with INT_MIN
            prev1 = prev2 = prev3 = Integer.MIN_VALUE;

            while (i < n1 && j < n2 && k < n3) {

                // If ar1[i] = prev1 and i < n1, keep incrementing i
                while (i < n1 && ar1[i] == prev1)
                    i++;

                // If ar2[j] = prev2 and j < n2, keep incrementing j
                while (j < n2 && ar2[j] == prev2)
                    j++;

                // If ar3[k] = prev3 and k < n3, keep incrementing k
                while (k < n3 && ar3[k] == prev3)
                    k++;

                if (i < n1 && j < n2 && k < n3) {

                    // If x = y and y = z, print any of them, update prev1 prev2, prev3
                    // and move ahead in each array
                    if (ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
                        System.out.print(ar1[i] + " ");
                        prev1 = ar1[i];
                        prev2 = ar2[j];
                        prev3 = ar3[k];
                        i++;
                        j++;
                        k++;
                    }

                    // If x < y, update prev1 and increment i
                    else if (ar1[i] < ar2[j]) {
                        prev1 = ar1[i];
                        i++;
                    }

                    // If y < z, update prev2 and increment j
                    else if (ar2[j] < ar3[k]) {
                        prev2 = ar2[j];
                        j++;
                    }

                    // We reach here when x > y and z < y,
                    // i.e.  z is the smallest update prev3 and increment k
                    else {
                        prev3 = ar3[k];
                        k++;
                    }
                }
            }
        }

        // Driver code
        public static void main_2(String args[])
        {
            FindCommon_2 ob = new FindCommon_2();

            int ar1[] = { 1, 5, 10, 20, 40, 80, 80 };
            int ar2[] = { 6, 7, 20, 80, 80, 100 };
            int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 80, 120 };

            System.out.print("Common elements are ");

            ob.findCommon(ar1, ar2, ar3);
        }
    }



    //Approach 3 :                                                                    T.C. = O(n1 + n2),  S.C. = O(maximum element in array)
    // Java implementation of the above approach
    class GFG_3 {
        public static void commonElements(int[] arr1, int[] arr2, int[] arr3, int n1, int n2, int n3)
        {
            /*
             creating a max variable for storing the maximum value present in the all
             the three array this will be the size of array for calculating the
             frequency of each element present in all the array
            */
            int max = Integer.MIN_VALUE;

            // deleting duplicates in linear time for arr1
            int res1 = 1;
            for (int i = 1 ; i < n1 ; i++) {
                max = Math.max(arr1[i], max);
                if (arr1[i] != arr1[res1 - 1]) {
                    arr1[res1] = arr1[i];
                    res1++;
                }
            }

            // deleting duplicates in linear time for arr2
            int res2 = 1;
            for (int i = 1 ; i < n2 ; i++) {
                max = Math.max(arr2[i], max);
                if (arr2[i] != arr2[res2 - 1]) {
                    arr2[res2] = arr2[i];
                    res2++;
                }
            }

            // deleting duplicates in linear time for arr3
            int res3 = 1;
            for (int i = 1 ; i < n3 ; i++) {
                max = Math.max(arr3[i], max);
                if (arr3[i] != arr3[res3 - 1]) {
                    arr3[res3] = arr3[i];
                    res3++;
                }
            }

            // creating an array for finding frequency
            int[] freq = new int[max + 1];

            // calculating the frequency of all the elements present in
            // all the array
            for (int i = 0; i < res1; i++)
                freq[arr1[i]]++;
            for (int i = 0; i < res2; i++)
                freq[arr2[i]]++;
            for (int i = 0; i < res3; i++)
                freq[arr3[i]]++;

            // iterating till max and whenever the frequency of element
            // will be three we print that element
            for (int i = 0 ; i <= max ; i++)
                if (freq[i] == 3)
                    System.out.print(i + " ");
        }

        // Driver Code
        public static void main_3(String[] arg)
        {

            int arr1[] = { 1, 5, 10, 20, 40, 80 };
            int arr2[] = { 6, 7, 20, 80, 100 };
            int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

            commonElements(arr1, arr2, arr3, 6, 5, 8);
        }
    }



    //Approach 4 : Using STL.......                                                  T.C. = O(n1 + n2 + n3),  S.C. = O(n1 + n2 + n3)
    class GFG_4 {
        static void findCommon(int a[], int b[], int c[], int n1, int n2,int n3)
        {
            // three sets to maintain frequency of elements
            HashSet<Integer> uset = new HashSet<>();
            HashSet<Integer> uset2 = new HashSet<>();
            HashSet<Integer> uset3 = new HashSet<>();
            for (int i = 0 ; i < n1 ; i++) {
                uset.add(a[i]);
            }
            for (int i = 0 ; i < n2 ; i++) {
                uset2.add(b[i]);
            }
            // checking if elements of 3rd array are present in first 2 sets
            for (int i = 0; i < n3; i++) {
                if (uset.contains(c[i]) && uset2.contains(c[i])) {
                    // using a 3rd set to prevent duplicates
                    if (uset3.contains(c[i]) == false)
                        System.out.print(c[i]+" ");
                    uset3.add(c[i]);
                }
            }
        }

        // Driver Code
        public static void main_4(String args[])
        {
            int ar1[] = { 1, 5, 10, 20, 40, 80 };
            int ar2[] = { 6, 7, 20, 80, 100 };
            int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
            int n1 = ar1.length;
            int n2 = ar2.length;
            int n3 = ar3.length;

            System.out.println("Common Elements are ");
            findCommon(ar1, ar2, ar3, n1, n2, n3);
        }
    }




    //Approach 5 :                                                                   T.C. = O(n1(log(n2*n3)),  S.C. = O(1)
    public class Main {
        public static boolean binary_search(int arr[], int n, int element)
        {
            int l = 0;
            int h = n - 1;
            while (l <= h) {
                int mid = (l + h) / 2;
                if (arr[mid] == element) {
                    return true;
                }
                else if (arr[mid] > element) {
                    h = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            return false;
        }

        public static void findCommon(int a[], int b[], int c[], int n1, int n2,int n3)
        {
            // Iterate on first array
            for (int j = 0; j < n1; j++)
            {
                if (j != 0 && a[j] == a[j - 1]) {
                    continue;
                }
                // check if the element is present in 2nd and 3rd array.
                if (binary_search(b, n2, a[j]) && binary_search(c, n3, a[j])) {

                    System.out.print(a[j] + " ");

                }
            }
        }

        /* Driver code */
        public static void main_5(String[] args)
        {

            int ar1[] = { 1, 5, 10, 20, 40, 80 };
            int ar2[] = { 6, 7, 20, 80, 100 };
            int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };
            int n1 = ar1.length;
            int n2 = ar2.length;
            int n3 = ar3.length;
            System.out.println("Common elements are ");
            // function calling
            findCommon(ar1, ar2, ar3, n1, n2, n3);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given three arrays sorted in non-decreasing order, print all common elements in these arrays.


            Example : 1
            Input   : ar1[] = {1, 5, 10, 20, 40, 80}
                      ar2[] = {6, 7, 20, 80, 100}
                      ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
            Output  : 20, 80

            Example : 2
            Input   : ar1[] = {1, 5, 5}
                      ar2[] = {3, 4, 5, 5, 10}
                      ar3[] = {5, 5, 10, 20}
            Output  : 5, 5


        *
        * */
    }

}
