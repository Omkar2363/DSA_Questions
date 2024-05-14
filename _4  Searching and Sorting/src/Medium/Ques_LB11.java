package Medium;

public class Ques_LB11 {

    //Ques : Smallest number with at least n trailing zeroes in factorial.....       (GFG Ques.)


    //Approach 1 :                                                                   T.C. = O(log2N)
    /*  Time Complexity : O(log2N)

        We take log2N in binary search and our check() function takes log5N time so the overall
        time complexity becomes log2N * log5N which in a more general sense can be written as (logN)2
        which can also be written as log2N.

        Auxiliary Space: O(1)
    *
    * */
    // Java program to find the smallest number whose factorial contains at least n trailing zeroes.
    class GFG_2 {

        // Return true if number's factorial contains at least n trailing zero else false.
        static boolean check(int p, int n)
        {
            int temp = p, count = 0, f = 5;
            while (f <= temp)
            {
                count += temp / f;
                f = f * 5;
            }
            return (count >= n);
        }

        // Return smallest number whose factorial contains at least n trailing zeroes
        static int findNum(int n)
        {
            // If n equal to 1, return 5.
            // since 5! = 120.
            if (n==1)
                return 5;

            // Initialising low and high for binary search.
            int low = 0;
            int high = 5 * n;

            // Binary Search.
            while (low < high)
            {
                int mid = (low + high) >> 1;

                // Checking if mid's factorial contains n trailing zeroes.
                if (check(mid, n))
                    high = mid;
                else
                    low = mid + 1;
            }

            return low;
        }

        // Driver code
        public static void main_1(String[] args)
        {
            int n = 6;
            System.out.println(findNum(n));
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a number n. The task is to find the smallest number whose factorial contains
                 at least n trailing zeroes.


            Example : 1
            Input   : n = 1
            Output  : 5
            Explanation : 1!, 2!, 3!, 4! does not contain trailing zero.
                          5! = 120, which contains one trailing zero.

            Example : 2
            Input   : n = 6
            Output  : 25


        * */
    }


}
