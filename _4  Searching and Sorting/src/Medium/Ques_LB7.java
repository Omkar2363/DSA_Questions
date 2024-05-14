package Medium;

import java.util.*;

public class Ques_LB7 {

    //Ques : Sort by Set Bit Count.......                                               (GFG Ques.)
    //       (Sort Array according to the count of Set Bits)


    //Approach 1 : Simple Approach.....                                                 T.C. = O(n^2),  S.C. = O(n)
    // Java program to implement simple approach to sort an array according to count of set bits.
    class GFG_1 {

        // utility function that returns total set bits count in an integer
        static int countBits(int a)
        {
            int count = 0;
            while (a > 0) {
                if ((a & 1) > 0)
                    count += 1;
                a = a >> 1;
            }
            return count;
        }

        // Function to simultaneously sort both arrays using insertion sort
        // (https://www.geeksforgeeks.org/insertion-sort/ )
        static void insertionSort(int arr[], int aux[], int n)
        {
            for (int i = 1; i < n; i++) {
                // use 2 keys because we need to sort both
                // arrays simultaneously
                int key1 = aux[i];
                int key2 = arr[i];
                int j = i - 1;

                // Move elements of arr[0..i-1] and aux[0..i-1],
                // such that elements of aux[0...i-1] are greater
                // than key1, to one position ahead of their
                // current position
                while (j >= 0 && aux[j] < key1) {
                    aux[j + 1] = aux[j];
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                aux[j + 1] = key1;
                arr[j + 1] = key2;
            }
        }

        // Function to sort according to bit count using an auxiliary array
        static void sortBySetBitCount(int arr[], int n)
        {
            // Create an array and store count of set bits in it.
            int aux[] = new int[n];
            for (int i = 0; i < n; i++)
                aux[i] = countBits(arr[i]);

            // Sort arr[] according to values in aux[]
            insertionSort(arr, aux, n);
        }

        // Utility function to print an array
        static void printArr(int arr[], int n)
        {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }

        // Driver Code
        public static void main_1(String[] args)
        {
            int arr[] = { 1, 2, 3, 4, 5, 6 };
            int n = arr.length;
            sortBySetBitCount(arr, n);
            printArr(arr, n);
        }
    }



    //Approach 2 : By using Stable Sorting Algorithm......                              T.C. = O(nlog(n)),  S.C. = O(1)
    // Java program to sort an array according to count of set bits using std::sort()
    public class Test_2 {
        public static void main(String[] args)
        {
            Integer arr[] = { 1, 2, 3, 4, 5, 6 };
            int n = 6;
            sortBySetBitCount(arr, n);
            printArr(arr, n);
            System.out.println();
        }

        private static void printArr(Integer[] arr, int n)
        {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }

        private static Integer[] sortBySetBitCount(
                Integer[] arr, int n)
        {
            Arrays.sort(arr, new Comparator<Integer>() {
                @Override
                public int compare(Integer arg0, Integer arg1)
                {
                    int c1 = Integer.bitCount(arg0);
                    int c2 = Integer.bitCount(arg1);
                    if (c1 <= c2)
                        return 1;
                    else
                        return -1;
                }
            });
            return arr;
        }
    }




    //Approach 3 : By using Counting Sort......                                        T.C. = O(n), S.C. = O(1)
    // Java program to sort an array according to count of set bits using std::sort()
    class GFG_3{

        // a utility function that returns total set bits count in an integer
        static int countBits(int a)
        {
            int count = 0;
            while (a > 0)
            {
                if ((a & 1) > 0 )
                    count += 1;
                a = a >> 1;
            }
            return count;
        }

        // Function to sort according to bit count. This function assumes that there are 32 bits in an integer.
        static void sortBySetBitCount(int arr[], int n)
        {
            Vector<Integer>[]count = new Vector[32];

            for (int i = 0; i < count.length; i++)
                count[i] = new Vector<Integer>();

            int setbitcount = 0;

            for (int i = 0; i < n; i++)
            {
                setbitcount = countBits(arr[i]);
                count[setbitcount].add(arr[i]);
            }

            // Used as an index in final sorted array
            int j = 0;

            // Traverse through all bit counts (Note that we sort array in decreasing order)
            for (int i = 31; i >= 0; i--)
            {
                Vector<Integer> v1 = count[i];

                for (int p = 0; p < v1.size(); p++)
                    arr[j++] = v1.get(p);
            }
        }

        // Utility function to print an array
        static void printArr(int arr[], int n)
        {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }

        // Driver Code
        public static void main_3(String[] args)
        {
            int arr[] = {1, 2, 3, 4, 5, 6};
            int n = arr.length;
            sortBySetBitCount(arr, n);
            printArr(arr, n);
        }
    }




    //Approach 4 : By using MultiMap......                                             T.C. = O(nlog(n)), S.C. = O(n)
    // Java program to implement simple approach to sort an array according to count of set bits.
    class GFG_4 {

        // Function to count setbits
        static int setBitCount(int num)
        {
            int count = 0;
            while ( num != 0 )
            {
                if ( (num & 1) != 0)
                    count++;
                num >>= 1;
            }
            return count;
        }

        // Function to sort By SetBitCount
        static void sortBySetBitCount(int[] arr, int n)
        {
            ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>();

            // Iterate over all values and insert into multimap
            for( int i = 0 ; i < n ; ++i )
            {
                count.add(new ArrayList<Integer>(Arrays.asList((-1) * setBitCount(arr[i]), arr[i])));
            }

            Collections.sort(count, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });

            for(int i = 0; i < count.size(); i++)
            {
                System.out.print(count.get(i).get(1) + " ");
            }

        }

        // Driver code
        public static void main_4 (String[] args)
        {

            int arr[] = {1, 2, 3, 4, 5, 6};
            int n = arr.length;
            sortBySetBitCount(arr, n);
        }
    }





    public static void main(String[] args) {

        /*Ques : Given an array of integers, sort the array (in descending order) according to
                 count of set bits in binary representation of array elements.

                 Note: For integers having same number of set bits in their binary representation,
                       sort according to their position in the original array
                       i.e. A stable sort.


            Example : 1
            Input   : arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
            Output  : 15 7 5 3 9 6 2 4 32
            Explanation : The integers in their binary representation are:
                            15 - 1111
                            7  - 0111
                            5  - 0101
                            3  - 0011
                            9  - 1001
                            6  - 0110
                            2  - 0010
                            4  - 0100
                            32 - 10000
                            Hence the non-increasing Sorted order is:
                            {15}, {7}, {5, 3, 9, 6}, {2, 4, 32}

            Example : 2
            Input   : arr[] = {1, 2, 3, 4, 5, 6};
            Output  : 3 5 6 1 2 4
            Explanation :
                            3  - 0011
                            5  - 0101
                            6  - 0110
                            1  - 0001
                            2  - 0010
                            4  - 0100
                            hence the non-increasing sorted order is
                            {3, 5, 6}, {1, 2, 4}


            Your Task :
            You don't need to print anything, printing is done by the driver code itself. You just need to
            complete the function sortBySetBitCount() which takes the array arr[] and its size N as inputs
            and sort the array arr[] inplace. Use of extra space is prohibited.


            Expected Time Complexity : O(N*log(N))
            Expected Auxiliary Space : O(1)

        * */
    }

}
