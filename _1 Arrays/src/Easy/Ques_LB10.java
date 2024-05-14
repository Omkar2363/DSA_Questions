package Easy;

public class Ques_LB10 {

    //Ques : Smallest subarray with sum greater than x                                      (GFG Ques.)


    //Approach 1 : Simple solution (By using nested loops)                                  T.C. = O(n^2), S.C. = O(1)
    /*Returns length of the smallest subarray with sum greater than x.
    If there is no subarray with given sum, then returns n+1
   */
    static int smallestSubWithSum_1(int arr[], int n, int x) {
        //  Initialize length of the smallest subarray as n+1
        int min_len = n + 1;

        // Pick every element as starting point
        for (int start = 0; start < n; start++) {
            // Initialize sum starting with current start
            int curr_sum = arr[start];

            // If first element itself is greater
            if (curr_sum > x)
                return 1;

            // Try different ending points for curremt start
            for (int end = start + 1; end < n; end++) {
                // add last element to current sum
                curr_sum += arr[end];

                /*
                 If sum becomes more than x and length of
                 this subarray is smaller than current smallest
                 length, update the smallest length (or result)
                */
                if (curr_sum > x && (end - start + 1) < min_len)
                    min_len = (end - start + 1);
            }
        }
        return min_len;


    /* Driver program to test above functions
    public static void main(String[] args)
    {
        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        int n1 = arr1.length;
        int res1 = smallestSubWithSum(arr1, n1, x);
        if (res1 == n1+1)
            System.out.println("Not Possible");
        else
            System.out.println(res1);


        int arr2[] = {1, 10, 5, 2, 7};
        int n2 = arr2.length;
        x = 9;
        int res2 = smallestSubWithSum(arr2, n2, x);
        if (res2 == n2+1)
            System.out.println("Not Possible");
        else
            System.out.println(res2);

        int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int n3 = arr3.length;
        x = 280;
        int res3 = smallestSubWithSum(arr3, n3, x);
        if (res3 == n3+1)
            System.out.println("Not Possible");
        else
            System.out.println(res3);
    }*/
    }




    //Approach 2 : Efficient Solution....                                                  T.C. = O(n), S.C. = O(1)
    /* Returns length of the smallest subarray with sum greater than x.
       If there is no subarray with given sum, then returns n+1
    */
    static int smallestSubWithSum_2(int arr[], int n, int x) {
        // Initialize current sum and minimum length
        int curr_sum = 0, min_len = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n) {
            // Keep adding array elements while current sum is smaller than or equal to x
            while (curr_sum <= x && end < n)
                curr_sum += arr[end++];

            // If current sum becomes greater than x.
            while (curr_sum > x && start < n) {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;

                // remove starting elements
                curr_sum -= arr[start++];
            }
        }
        return min_len;

    /* Driver program to test above functions
    public static void main(String[] args)
    {
        int arr1[] = { 1, 4, 45, 6, 10, 19 };
        int x = 51;
        int n1 = arr1.length;
        int res1 = smallestSubWithSum(arr1, n1, x);
        if (res1 == n1 + 1)
            System.out.println("Not Possible");
        else
            System.out.println(res1);

        int arr2[] = { 1, 10, 5, 2, 7 };
        int n2 = arr2.length;
        x = 9;
        int res2 = smallestSubWithSum(arr2, n2, x);
        if (res2 == n2 + 1)
            System.out.println("Not Possible");
        else
            System.out.println(res2);

        int arr3[]
                = { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
        int n3 = arr3.length;
        x = 280;
        int res3 = smallestSubWithSum(arr3, n3, x);
        if (res3 == n3 + 1)
            System.out.println("Not Possible");
        else
            System.out.println(res3);
    }*/
    }



    public static void main(String[] args) {

        /*Ques : Given an array of integers (A[])  and a number x, find the smallest subarray with sum
                 greater than the given value.

                 Note : The answer always exists. It is guaranteed that x doesn't exceed
                        the summation of a[i] (from 1 to N).


                Example : 1
                Input   : A[] = {1, 4, 45, 6, 0, 19}
                          x  =  51
                Output  : 3
                Explanation : Minimum length subarray is {4, 45, 6}


                Example : 2
                Input   : A[] = {1, 10, 5, 2, 7}
                          x  = 9
                Output  : 1
                Explanation : Minimum length subarray is {10}


                Your Task :
                You don't need to read input or print anything. Your task is to complete the function
                smallestSubWithSum() which takes the array A[], its size N and an integer X as inputs
                and returns the required output.


                Expected Time Complexity: O(N)
                Expected Auxiliary Space: O(1)

        *
        * */
    }

}
