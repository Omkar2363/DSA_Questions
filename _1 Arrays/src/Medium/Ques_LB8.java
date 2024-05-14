package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ques_LB8 {

    //Ques : Given an array of size n and a number k, find all elements that appear more than n/k times   (GFG Ques.)


    //Approach 1 : Naive approach....Hashing...                                           T.C. = O(n), S.C. = O(n)
    public static void morethanNdK(int a[], int n, int k) {
        int x = n / k;

        // Hash map initialization
        HashMap<Integer, Integer> y = new HashMap<>();

        // count the frequency of each element.
        for (int i = 0; i < n; i++) {
            // is element doesn't exist in hash table
            if (!y.containsKey(a[i]))
                y.put(a[i], 1);


                // if element does exist in the hash table
            else {
                int count = y.get(a[i]);
                y.put(a[i], count + 1);
            }
        }

        // iterate over each element in the hash table and
        // check their frequency, if it is more than n/k, print it.
        for (Map.Entry m : y.entrySet()) {
            Integer temp = (Integer) m.getValue();
            if (temp > x)
                System.out.println(m.getKey());
        }
        /* Driver Code
    public static void main(String[] args)
    {

        int a[] = new int[] { 1, 1, 2, 2, 3, 5, 4,
                2, 2, 3, 1, 1, 1 };
        int n = 12;
        int k = 4;
        morethanNdK(a, n, k);
    }*/

    }



    //Approach 2 : Moore's voting algorithm                                               T.C. = O(n*k), S.C. = O(k)
    /* Moore’s Voting Algorithm  :
            We can solve the above problem in O(nk) time using O(k-1) extra space.
            Note that there can never be more than k-1 elements in output (Why?).
            There are mainly three steps in this algorithm.

            Follow the link for illustration :
            link : https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
*/
    // A structure to store an element and its current count
    static class element_Count {
        int e; // Element
        int c; // Count
    }

    // Prints elements with more than n/k occurrences in arr[]
    // of size n. If there are no such elements, then it prints nothing.
    static void moreThanNdK(int arr[], int n, int k) {

        // k must be greater than 1 to get some output
        if (k < 2)
            return;

        /* Step 1: Create a temporary array (contains element and count) of size k-1.
        Initialize count of all elements as 0 */
        element_Count[] temp = new element_Count[k - 1];

        for (int i = 0; i < k - 1; i++)
            temp[i] = new element_Count();
        for (int i = 0; i < k - 1; i++) {
            temp[i].c = 0;
        }

        /* Step 2: Process all elements of input array */
        for (int i = 0; i < n; i++) {
            int j;

        // If arr[i] is already present in the element count array, then increment its count

            for (j = 0; j < k - 1; j++) {
                if (temp[j].e == arr[i]) {
                    temp[j].c += 1;
                    break;
                }
            }

            /* If arr[i] is not present in temp[] */
            if (j == k - 1) {
                int l;

            /* If there is position available in temp[], then place arr[i] in
              the first available position and  set count as 1*/
                for (l = 0; l < k - 1; l++) {
                    if (temp[l].c == 0) {
                        temp[l].e = arr[i];
                        temp[l].c = 1;
                        break;
                    }
                }

            /* If all the position in the temp[] are filled, then decrease
               count of every element by 1 */
                if (l == k - 1)
                    for (l = 0; l < k - 1; l++)
                        temp[l].c -= 1;
            }
        }

        /*Step 3: Check actual counts of potential candidates in temp[]*/
        for (int i = 0; i < k - 1; i++) {

            // Calculate actual count of elements
            int ac = 0; // actual count
            for (int j = 0; j < n; j++)
                if (arr[j] == temp[i].e)
                    ac++;

            // If actual count is more than n/k,
            // then print it
            if (ac > n / k)
                System.out.print("Number:" + temp[i].e + " Count:" + ac + "\n");
        }


    /* Driver code
    public static void main(String[] args)
    {
        System.out.print("First Test\n");
        int arr1[] = { 4, 5, 6, 7, 8, 4, 4 };
        int size = arr1.length;
        int k = 3;
        moreThanNdK(arr1, size, k);

        System.out.print("\nSecond Test\n");
        int arr2[] = { 4, 2, 2, 7 };
        size = arr2.length;
        k = 3;
        moreThanNdK(arr2, size, k);

        System.out.print("\nThird Test\n");
        int arr3[] = { 2, 7, 2 };
        size = arr3.length;
        k = 2;
        moreThanNdK(arr3, size, k);

        System.out.print("\nFourth Test\n");
        int arr4[] = { 2, 3, 3, 2 };
        size = arr4.length;
        k = 3;
        moreThanNdK(arr4, size, k);

    }*/
    }



    //Approach 3 : By using builtin functions                                            T.C. = O(n), S.C. = O(n)
    static void printElements(int arr[], int n, int k) {

        // Calculating n/k
        int x = n / k;

        // Counting frequency of every element using Counter
        TreeMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();

        for (int i = 0; i < n; i++)
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);

        // Traverse the map and print all the elements with occurrence
        // more than n/k times
        for (Map.Entry m : mp.entrySet()) {

            if ((int) m.getValue() > x)
                System.out.println(m.getKey());
        }

        /* Driver code
        public static void main (String[]args)
        {
            int arr[]
                    = {1, 1, 2, 2, 3, 5, 4, 2, 2, 3, 1, 1, 1};
            int n = arr.length;
            int k = 4;

            printElements(arr, n, k);

        }*/
    }



    public static void main(String[] args) {

        /*Ques : Given an array of size n, find all elements in array that appear more than n/k times.

                 For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4,
                 then the output should be [2, 3]. Note that size of array is 8 (or n = 8),
                 so we need to find all elements that appear more than 2 (or 8/4) times.

                 There are two elements that appear more than two times, 2 and 3.


         *
        * */
    }
}
