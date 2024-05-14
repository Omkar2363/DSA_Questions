package Medium;

public class Ques_10 {

    //Ques : Make all array elements equal with minimum cost......                       (GFG Ques.)


    //Approach 1 :                                                                       T.C. = O(nlog(n)),  S.C. = O(1)
    /*      This problem can be solved by observing the cost while changing the target equal value,
            i.e. we will see the change in cost when target equal value is changed.
            It can be observed that, as we increase the target equal value the total cost decreases
            up to a limit and then starts increasing i.e. the cost graph with respect to target equal
            value is of U-shape and as cost graph is in U-shape, the ternary search can be applied to
            this search space and our goal is to get that bottom most point of the curve which will represent
            the smallest cost. We will make smallest and largest value of the array as the limit of our search space,
            and then we will keep skipping 1/3 part of the search space until we reach to the bottom most point of our U-curve.
    *
    * */
    // JAVA Code for Make all array elements equal with minimum cost
    static class GFG {

        // Utility method to compute cost, when all values of array are made equal to X
        public static int computeCost(int arr[], int N, int X)
        {
            int cost = 0;
            for (int i = 0; i < N; i++)
                cost += Math.abs(arr[i] - X);

            return cost;
        }

        // Method to find minimum cost to make all elements equal
        public static int minCostToMakeElementEqual(int arr[], int N)
        {
            int low;
            int high;
            low = high = arr[0];

            // setting limits for ternary search by smallest and largest element
            for (int i = 0; i < N; i++) {
                if (low > arr[i])
                    low = arr[i];
                if (high < arr[i])
                    high = arr[i];
            }

            /* loop until difference between low and high become less than 3,
               because after that  mid1 and mid2 will start repeating        */
            while ((high - low) > 2)
            {
                // mid1 and mid2 are representative array equal values of search space
                int mid1 = low + (high - low) / 3;
                int mid2 = high - (high - low) / 3;

                int cost1 = computeCost(arr, N, mid1);
                int cost2 = computeCost(arr, N, mid2);

                // if mid2 point gives more total cost, skip third part
                if (cost1 < cost2)
                    high = mid2;

                    // if mid1 point gives more total cost, skip first part
                else
                    low = mid1;
            }

            // computeCost gets optimum cost by sending average of low and high as X
            return computeCost(arr, N, (low + high) / 2);
        }

        /* Driver program to test above function */
        public static void main_1(String[] args)
        {
            int arr[] = { 1, 100, 101 };
            int N = arr.length;
            System.out.println(minCostToMakeElementEqual(arr, N));
        }
    }



    //Approach 2 : Alternate solution.....                                              T.C. = O(n),  S.C. = O(1)
    /*  Alternate Solution....

        Think geometrically. Assume that array elements are co-ordinates on x-axis.
        The problem reduces to finding another co-ordinate such that the sum of distances between
        this choice and other co-ordinates is minimized.
        Observe that : If number of co-ordinates are odd then y = middle element.
                       If even then y is any number in between middle 2 co-ordinates.

           Say Input = [a, b, c, d].
           Output is any number between b and c including both.
           Hence, the cost is sum which can be computed easily now that we have chosen y. sum|(y-ai)| for all i.
    *
    * */
    class GFG_2{

        // This function assumes that a[] is sorted. If a[] is not sorted, we need to sort it first.
        public static int minCostToMakeElementEqual(int a[], int n)
        {
            // If there are odd elements, we choose middle element
            int y;

            if (n % 2 == 1)
                y = a[n / 2];

                // If there are even elements, then we choose the average of middle two.
            else
                y = (a[n / 2] + a[(n - 2) / 2]) / 2;

            // After deciding the final value, find the result.
            int s = 0;

            for(int i = 0; i < n; i++)
                s += Math.abs(a[i] - y);

            return s;
        }

        // Driver code
        public static void main_2 (String[] args)
        {
            int a[] = { 1, 100, 101 };
            int n = a.length;

            System.out.println(minCostToMakeElementEqual(a, n));
        }
    }







    public static void main(String[] args) {

        /*Ques : Given an array which contains integer values, we need to make all values of
                 this array equal to some integer value with minimum cost where the cost of changing
                 an array value x to y is abs(x-y).


            Example : 1
            Input   : arr[] = [1, 100, 101]
            Output  : 100
            Explanation : We can change all its values to 100 with minimum cost,
                          |1 - 100| + |100 - 100| + |101 - 100| = 100

            Example : 2
            Input   : arr[] = [4, 6]
            Output  : 2
            Explanation : We can change all its values to 5 with minimum cost,
                          |4 - 5| + |5 - 6| = 2


        *
        * */
    }


}
