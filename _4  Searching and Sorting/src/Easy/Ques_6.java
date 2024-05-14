package Easy;

import java.util.HashMap;

public class Ques_6 {

    //Ques : Find a pair with the given difference.........                              (GFG Ques.)


    //Approach 1 : Simple Approach....                                                   T.C. = O(n^2),  S.C. = O(1)
    /*      The simplest method is to run two loops, the outer loop picks the first element (smaller element) and
            the inner loop looks for the element picked by outer loop plus n. Time complexity of this method is O(n2)
    * */


    //Approach 2 : Using Binary Search.....                                              T.C. = O(nlog(n)),  S.C. = O(1)
    /*  We can use sorting and Binary Search to improve time complexity to O(nLog(n)).
        The first step is to sort the array in ascending order. Once the array is sorted, traverse the array
        from left to right, and for each element arr[i], binary search for arr[i] + n in arr[i+1...n-1].

        If the element is found, return the pair. Both first and second steps take O(nLog(n)).
        So overall complexity is O(nLog(n)).
     * */



    //Approach 3 :                                                                       T.C. = O(nlog(n)),   S.C. = O(1)
    /*      The second step of the Method -2 can be improved to O(n). The first step remains the same.
            The idea for the second step is to take two index variables i and j, and initialize them as 0 and 1 respectively.
            Now run a linear loop. If arr[j] – arr[i] is smaller than n, we need to look for greater arr[j], so increment j.
            If arr[j] – arr[i] is greater than n, we need to look for greater arr[i], so increment i.

            The following code is only for the second step of the algorithm, it assumes that the array is already sorted.

    * */
    // Java program to find a pair with the given difference
    class PairDifference {
        // The function assumes that the array is sorted
        static boolean findPair(int arr[],int n)
        {
            int size = arr.length;

            // Initialize positions of two elements
            int i = 0, j = 1;

            // Search for a pair
            while (i < size && j < size)
            {
                if (i != j && (arr[j] - arr[i] == n || arr[i] - arr[j] == n))
                {
                    System.out.print("Pair Found: " + "( "+arr[i]+", "+ arr[j]+" )");
                    return true;
                }
                else if (arr[j] - arr[i] < n)
                    j++;
                else
                    i++;
            }

            System.out.print("No such pair");
            return false;
        }

        // Driver program to test above function
        public static void main_3(String[] args)
        {
            int arr[] = {1, 8, 30, 40, 100};
            int n = -60;
            findPair(arr,n);
        }
    }



    //Approach 4 : Using HashTable.....                                                 T.C. = O(n),  S.C. = O(n)
    // Java program for the above approach
    static class GFG_4 {

        // The function assumes that the array is sorted
        static boolean findPair(int[] arr, int size, int n)
        {
            HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

            // Traverse the array
            for(int i = 0; i < size; i++)
            {

                // Update frequency of arr[i]
                mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);


                // Check if any element whose frequency is greater than 1 exist or not for n == 0
                if (n == 0 && mpp.get(arr[i]) > 1)
                    return true;
            }

            // Check if difference is zero, and we are unable to find any duplicate or element whose
            // frequency is greater than 1 then no such pair found.
            if (n == 0)
                return false;

            for (int i = 0; i < size; i++) {
                if (mpp.containsKey(n + arr[i])) {
                    System.out.print("Pair Found: (" + arr[i] + ", " + (n + arr[i]) + ")");
                    return true;
                }
            }
            System.out.print("No Pair found");
            return false;
        }


        // Driver Code
        public static void main_4(String[] args)
        {
            int[] arr = { 1, 8, 30, 40, 100 };
            int size = arr.length;
            int n = -60;
            findPair(arr, size, n);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an unsorted array and a number n, find if there exists a pair of elements
                 in the array whose difference is n.


            Example : 1
            Input   : arr[] = {5, 20, 3, 2, 50, 80}, n = 78
            Output  : Pair Found: (2, 80)

            Example : 2
            Input   : arr[] = {90, 70, 20, 80, 50}, n = 45
            Output  : No Such Pair
        *
        * */
    }

}
