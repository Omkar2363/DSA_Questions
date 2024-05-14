package Easy;

import java.util.HashSet;

public class Ques_LB7 {

    //Ques : Common elements                                                            (GFG Ques)

    //Approach 1 : Three pointer approach....                                           T.C. = O(n1+n2+n3), S.C. = O(1)
    //class FindCommon{
    void findCommon_1(int ar1[], int ar2[], int ar3[]) {
        // Initialize starting indexes for ar1[], ar2[] and ar3[]
        int i = 0, j = 0, k = 0;

        // Iterate through three arrays while all arrays have elements
        while (i < ar1.length && j < ar2.length && k < ar3.length) {

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

                // We reach here when x > y and z < y,  i.e. z is smallest
            else
                k++;
        }

        /* Driver code to test above
        public static void main(String args[])
        {
            FindCommon ob = new FindCommon();

            int ar1[] = { 1, 5, 10, 20, 40, 80 };
            int ar2[] = { 6, 7, 20, 80, 100 };
            int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

            System.out.print("Common elements are ");
            ob.findCommon(ar1, ar2, ar3);
        }*/
    }


    //Approach 2 :                                                                      T.C. = O(n1+n2+n3), S.C. = O(1)
    /*  The approach used above works well if the arrays does not contain duplicate values however it can fail in cases
        where the array elements are repeated. This can lead to a single common element to get printed multiple times.

        These duplicate entries can be handled without using any additional data structure by keeping the track of the
        previous element. Since the elements inside the array are arranged in sorted manner there is no possibility for
        the repeated elements to occur at random positions.

*/
    void findCommon_2(int ar1[], int ar2[], int ar3[]) {
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

                // If x = y and y = z, print any of them, update prev1 prev2, prev3 and move ahead in each array
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

                // We reach here when x > y and z < y, i.e. z is the smallest update prev3
                // and increment k
                else {
                    prev3 = ar3[k];
                    k++;
                }
            }
        }
    }


    //Approach 3 :                                                                     T.C. = O(n1+n2), S.C. = O(max. element in array)
    /*  In this approach, we will first delete the duplicate from each array, and after this, we will find the frequency
        of each element and the element whose frequency equals 3 will be printed. For finding the frequency we can use a
        map but in this, we will use an array instead of a map.
        But the problem with using an array is, we cannot find the frequency of negative numbers so in the  code  given
        below we will consider each and every element of array to be positive.

     */
    public static void commonElements(int[] arr1, int[] arr2, int[] arr3, int n1, int n2, int n3){
        /*
         Creating a max variable for storing the maximum value present in the all the three array
         this will be the size of array for calculating the frequency of each element present in all the array
        */
        int max = Integer.MIN_VALUE;

        // deleting duplicates in linear time for arr1
        int res1 = 1;
        for (int i = 1; i < n1; i++) {
            max = Math.max(arr1[i], max);
            if (arr1[i] != arr1[res1 - 1]) {
                arr1[res1] = arr1[i];
                res1++;
            }
        }

        // deleting duplicates in linear time for arr2
        int res2 = 1;
        for (int i = 1; i < n2; i++) {
            max = Math.max(arr2[i], max);
            if (arr2[i] != arr2[res2 - 1]) {
                arr2[res2] = arr2[i];
                res2++;
            }
        }

        // deleting duplicates in linear time for arr3
        int res3 = 1;
        for (int i = 1; i < n3; i++) {
            max = Math.max(arr3[i], max);
            if (arr3[i] != arr3[res3 - 1]) {
                arr3[res3] = arr3[i];
                res3++;
            }
        }

        // creating an array for finding frequency
        int[] freq = new int[max + 1];

        // calculating the frequency of all the elements present in all the array
        for (int i = 0; i < res1; i++)
            freq[arr1[i]]++;
        for (int i = 0; i < res2; i++)
            freq[arr2[i]]++;
        for (int i = 0; i < res3; i++)
            freq[arr3[i]]++;

        // iterating till max and whenever the frequency of element will be three we print that element
        for (int i = 0; i <= max; i++)
            if (freq[i] == 3)
                System.out.print(i + " ");
    }


    //Approach 4 : Using STL                                                           T.C. = O(n1+n2+n3), S.C. = O(n1+n2+n3)
    /*  The idea is to use hash set. Here we use 2 of the sets to store elements of the 1st and 2nd arrays.
        The elements of the 3rd array are then checked if they are present in the first 2 sets.
        Then, we use a 3rd set to prevent any duplicates from getting added to the required array.
     */
    static void findCommon(int a[], int b[], int c[], int n1, int n2,int n3) {

        // three sets to maintain frequency of elements
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set1.add(a[i]);
        }
        for (int i = 0; i < n2; i++) {
            set2.add(b[i]);
        }


        // checking if elements of 3rd array are present in first 2 sets
        for (int i = 0; i < n3; i++) {
            if (set1.contains(c[i]) && set2.contains(c[i])) {

                // using a 3rd set to prevent duplicates
                if (set3.contains(c[i]) == false)
                    System.out.print(c[i]+" ");

                set3.add(c[i]);
            }
        }
    }


    //Approach 5 : Using Binary Search                                                T.C. = O(n1(log(n2*n3)), S.C. = O(1)
    /*  This approach is a modification of previous approach. Here Instead of using map,
        we use binary search to find elements of 1st array that are present in 2nd and 3rd arrays.
    * */
    public static boolean binary_search(int arr[], int n, int element) {
        int l = 0, h = n - 1;
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

    public static void findCommon_5(int a[], int b[], int c[], int n1, int n2,int n3) {
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




    public static void main(String[] args) {

        /*Ques : Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.

                 Note : can you take care of the duplicates without using any additional Data Structure?


            Example : 1
            Input   :   n1 = 6; A = {1, 5, 10, 20, 40, 80}
                        n2 = 5; B = {6, 7, 20, 80, 100}
                        n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
            Output  : 20 80
            Explanation : 20 and 80 are the only common elements in A, B and C.


            Your Task:
            You don't need to read input or print anything. Your task is to complete the function commonElements()
            which take the 3 arrays A[], B[], C[] and their respective sizes n1, n2 and n3 as inputs and returns an
            array containing the common element present in all the 3 arrays in sorted order.

            If there are no such elements return an empty array. In this case the output will be printed as -1.

            Expected Time Complexity: O(n1 + n2 + n3)
            Expected Auxiliary Space: O(n1 + n2 + n3)

        *
        * */


    }


}
