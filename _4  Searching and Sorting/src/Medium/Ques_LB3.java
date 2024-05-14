package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Ques_LB3 {

    //Ques : Find All Four Sum Numbers...........                                        (GFG Ques.)


    //Approach 1 : A Naive Solution is to generate all possible quadruples               T.C. = O(n^4),  S.C. = O(1)
    //             and compare the sum of every quadruple with X
    // Java implementation of above approach
    static class FindFourElements_1{

        /* A naive solution to print all combination of 4 elements in A[] with sum equal to X */
        void findFourElements(int A[], int n, int X)
        {
            // Fix the first element and find other three
            for (int i = 0; i < n - 3; i++)
            {
                // Fix the second element and find other two
                for (int j = i + 1; j < n - 2; j++)
                {
                    // Fix the third element and find the fourth
                    for (int k = j + 1; k < n - 1; k++)
                    {
                        // find the fourth
                        for (int l = k + 1; l < n; l++)
                        {
                            if (A[i] + A[j] + A[k] + A[l] == X)
                                System.out.print(A[i]+" "+A[j]+" "+A[k] +" "+A[l]);
                        }
                    }
                }
            }
        }

        // Driver program to test above functions
        public static void main_1(String[] args)
        {
            FindFourElements_1 findfour = new FindFourElements_1();
            int A[] = {10, 20, 30, 40, 1, 2};
            int n = A.length;
            int X = 91;
            findfour.findFourElements(A, n, X);
        }
    }




    //Approach 2 : By using Sorting.....                                                T.C. = O(n^3),  S.C. = O(1)
    static class FindFourElements_2 {

        /* A sorting based solution to print all combination of 4 elements in A[] with sum equal to X */
        void find4Numbers(int A[], int n, int X)
        {
            int l, r;

            // Sort the array in increasing order, using library function for quick sort
            Arrays.sort(A);

            /* Now fix the first 2 elements one by one and find the other two elements */
            for (int i = 0; i < n - 3; i++)
            {
                for (int j = i + 1; j < n - 2; j++)
                {
                    // Initialize two variables as indexes of the first and last elements in the remaining elements
                    l = j + 1;
                    r = n - 1;

                    // To find the remaining two elements, move the index variables (l & r) toward each other.
                    while (l < r)
                    {
                        if (A[i] + A[j] + A[l] + A[r] == X)
                        {
                            System.out.println(A[i]+" "+A[j]+" "+A[l]+" "+A[r]);
                            l++;
                            r--;
                        }
                        else if (A[i] + A[j] + A[l] + A[r] < X)
                            l++;
                        else                                    // A[i] + A[j] + A[l] + A[r] > X
                            r--;
                    }                                           // end of while
                }                                               // end of inner for loop
            }                                                   // end of outer for loop
        }

        // Driver program to test above functions
        public static void main_2(String[] args)
        {
            FindFourElements_2 findfour = new FindFourElements_2();
            int A[] = {1, 4, 45, 6, 10, 12};
            int n = A.length;
            int X = 21;
            findfour.find4Numbers(A, n, X);
        }
    }




    //Approach 3 : Two Pointers Algorithm......                                         T.C. = O(n^2 * log(n)), S.C. = O(n^2)
    /*  Complexity Analysis :
        Time complexity : O(n^2 * Log(n)).
                          The step 1 takes O(n^2) time.
                          The second step is sorting an array of size O(n^2).Sorting can be done in O(n^2 * Log(n))
                          time using merge sort or heap sort or any other O(nLog(n)) algorithm.
                          The third step takes O(n^2) time.
                          So overall complexity is O(n^2 * Log(n)).
        Auxiliary Space : O(n^2).
                          The size of the auxiliary array is O(n^2). The big size of the auxiliary array can be a
                          concern in this method.
    * */
    // Java program to find 4 elements with given sum
    static class GFG_3{

        // The following structure is needed to store pair sums in aux[]
        static class pairSum {

            // Index (int A[]) of first element in pair
            public int first;

            // Index of second element in pair
            public int sec;

            // Sum of the pair
            public int sum;
        }

        // Function to check if two given pairs have any common element or not
        static boolean noCommon(pairSum a, pairSum b)
        {
            if (a.first == b.first || a.first == b.sec || a.sec == b.first || a.sec == b.sec)
                return false;

            return true;
        }

        // The function finds four elements with given sum X
        static void findFourElements(int[] myArr, int sum)
        {
            int i;
            int j;
            int length = myArr.length;

            // Create an auxiliary array to store all pair sums
            int size = (length * (length - 1)) / 2;
            pairSum[] aux = new pairSum[size];

            // Generate all possible pairs from A[] and store sums
            // of all possible pairs in aux[]
            int k = 0;
            for (i = 0; i < length - 1; i++) {
                for (j = i + 1; j < length; j++) {
                    aux[k] = new pairSum();
                    aux[k].sum = myArr[i] + myArr[j];
                    aux[k].first = i;
                    aux[k].sec = j;
                    k++;
                }
            }

            // Sort the aux[] array using library function for sorting
            Arrays.sort(aux, new Comparator<pairSum>() {
                // Following function is needed for sorting... pairSum array
                public int compare(pairSum a, pairSum b)
                {
                    return (a.sum - b.sum);
                }
            });

            // Now start two index variables from two corners of array and move them toward each other.
            i = 0;
            j = size - 1;
            while (i < size && j >= 0) {
                if ((aux[i].sum + aux[j].sum == sum) && noCommon(aux[i], aux[j])) {
                    String output = myArr[aux[i].first] + ", "
                                    + myArr[aux[i].sec] + ", "
                                    + myArr[aux[j].first] + ", "
                                    + myArr[aux[j].sec];
                    System.out.println(output);
                    return;
                }
                else if (aux[i].sum + aux[j].sum < sum)
                    i++;
                else
                    j--;
            }
        }

        public static void main_3(String[] args)
        {
            int[] arr = { 10, 20, 30, 40, 1, 2 };
            int X = 91;

            // Function call
            findFourElements(arr, X);
        }
    }



    //Approach 4 : Hashing based solution.....                                         T.C. = O(n^2),  S.C. = O(n^2)
    /*  Complexity Analysis :

            Time complexity : O(n^2).
                              Nested traversal is needed to store all pairs in the hash Map.
            Auxiliary Space : O(n^2).
                              All n*(n-1) pairs are stored in hash Map so the space required is O(n^2)
     */
    // A hashing based Java program to find if there are four elements with given sum.
    class GFG_4 {
        static class pair {
            int first, second;
            public pair(int first, int second)
            {
                this.first = first;
                this.second = second;
            }
        }

        // The function finds four elements with given sum X
        static void findFourElements(int arr[], int n, int X)
        {
            // Store sums of all pairs in a hash table
            HashMap<Integer, pair> mp = new HashMap<Integer, pair>();
            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++)
                    mp.put(arr[i] + arr[j], new pair(i, j));

            // Traverse through all pairs and search for X - (current pair sum).
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    int sum = arr[i] + arr[j];

                    // If X - sum is present in hash table,
                    if (mp.containsKey(X - sum)) {

                        // Making sure that all elements are distinct array elements and an element
                        // is not considered more than once.
                        pair p = mp.get(X - sum);
                        if (p.first != i && p.first != j && p.second != i && p.second != j)
                        {
                            System.out.print( arr[i] + ", " + arr[j] + ", "
                                                                        + arr[p.first] + ", "
                                                                        + arr[p.second]);
                            return;
                        }
                    }
                }
            }
        }

        // Driver Code
        public static void main_4(String[] args)
        {
            int arr[] = { 10, 20, 30, 40, 1, 2 };
            int n = arr.length;
            int X = 91;

            // Function call
            findFourElements(arr, n, X);
        }
    }




    //Approach 5 : Solution having no Duplicate elements.....                         T.C. = O(n^2),  S.C. = O(n^2)
    /*  Complexity Analysis :
            Time complexity : O(n^2).
                              Nested traversal is needed to store all pairs in the hash Map.
            Auxiliary Space : O(n^2).
                              All n*(n-1) pairs are stored in hash Map so the space required is O(n^2)
                              and the temp array takes O(n) so space comes to O(n^2).
     */
    // Java program to find four elements with the given sum
    class fourElementWithSum_5 {

        // Function to find 4 elements that add up to given sum
        public static void fourSum(int X, int[] arr, Map<Integer, pair> map)
        {
            int[] temp = new int[arr.length];

            // Iterate from 0 to temp.length
            for (int i = 0; i < temp.length; i++)
                temp[i] = 0;

            // Iterate from 0 to arr.length
            for (int i = 0; i < arr.length - 1; i++) {

                // Iterate from i + 1 to arr.length
                for (int j = i + 1; j < arr.length; j++) {

                    // Store curr_sum = arr[i] + arr[j]
                    int curr_sum = arr[i] + arr[j];

                    // Check if X - curr_sum if present in map
                    if (map.containsKey(X - curr_sum)) {

                        // Store pair having map value X - curr_sum
                        pair p = map.get(X - curr_sum);

                        if (p.first != i && p.sec != i && p.first != j && p.sec != j
                                && temp[p.first] == 0
                                && temp[p.sec] == 0 && temp[i] == 0
                                && temp[j] == 0)
                        {

                            // Print the output
                            System.out.printf("%d,%d,%d,%d", arr[i], arr[j], arr[p.first], arr[p.sec]);
                            temp[p.sec] = 1;
                            temp[i] = 1;
                            temp[j] = 1;
                            break;
                        }
                    }
                }
            }
        }

        // Program for two Sum
        public static Map<Integer, pair> twoSum(int[] nums)
        {
            Map<Integer, pair> map = new HashMap<>();
            for (int i = 0; i < nums.length - 1; i++)
            {
                for (int j = i + 1; j < nums.length; j++)
                {
                    map.put(nums[i] + nums[j], new pair(i, j));
                }
            }
            return map;
        }

        // to store indices of two sum pair
        public static class pair {
            int first, sec;

            public pair(int first, int sec)
            {
                this.first = first;
                this.sec = sec;
            }
        }

        // Driver Code
        public static void main_5(String args[])
        {
            int[] arr = { 10, 20, 30, 40, 1, 2 };
            int n = arr.length;
            int X = 91;
            Map<Integer, pair> map = twoSum(arr);

            // Function call
            fourSum(X, arr, map);
        }
    }




    public static void main(String[] args) {

        /*  Ques : Given an array of integers and another number. Find all the unique quadruple from
                   the given array that sums up to the given number.


                Example : 1
                Input   : N = 5, K = 3
                          A[] = {0,0,2,1,1}
                Output  : 0 0 1 2 $
                Explanation : Sum of 0, 0, 1, 2 is equal to K.

                Example : 2
                Input   : N = 7, K = 23
                          A[] = {10,2,3,4,5,7,8}
                Output  : 2 3 8 10 $2 4 7 10 $3 5 7 8 $
                Explanation : Sum of 2, 3, 8, 10 = 23,
                              sum of 2, 4, 7, 10 = 23 and
                              sum of 3, 5, 7, 8 = 23.

                Your Task :
                You don't need to read input or print anything. Your task is to complete the function
                fourSum() which takes the array arr[] and the integer k as its input and returns an array
                containing all the quadruples in a lexicographical manner.
                Also note that all the quadruples should be internally sorted,
                i.e. for any quadruple [q1, q2, q3, q4] the following should follow : q1 <= q2 <= q3 <= q4.
                     (In the output each quadruple is separate by $. The printing is done by the driver's code)

                Expected Time Complexity : O(N^3).
                Expected Auxiliary Space : O(N^2).


        *
        * */
    }


}
