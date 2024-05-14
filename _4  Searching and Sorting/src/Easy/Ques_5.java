package Easy;

public class Ques_5 {

    //Ques : Ceiling in a sorted array...........                                       (GFG Ques.)


    //Approach 1 :  Linear Search....                                                   T.C. = O(n),  S.C. = O(1)
    /*  Algorithm to search ceiling of x:

        1. If x is smaller than or equal to the first element in the array then return 0(index of the first element).
        2. Else linearly search for an index i such that x lies between arr[i] and arr[i+1].
        3. If we do not find an index i in step 2, then return -1.

    *
    * */
    class Main {
        /* Function to get index of ceiling of x in arr[low...high] */
        static int ceilSearch(int arr[], int low, int high, int x)
        {
            int i;

            /* If x is smaller than or equal to first element,then return the first element */
            if(x <= arr[low])
                return low;

            /* Otherwise, linearly search for ceil value */
            for(i = low; i < high; i++)
            {
                if(arr[i] == x)
                    return i;

            /* if x lies between arr[i] and arr[i+1] including arr[i+1], then return arr[i+1] */
                if(arr[i] < x && arr[i+1] >= x)
                    return i+1;
            }

            /* If we reach here then x is greater than the last element of the array, return -1 in this case */
            return -1;
        }


        /* Driver program to check above functions */
        public static void main_1 (String[] args)
        {
            int arr[] = {1, 2, 8, 10, 10, 12, 19};
            int n = arr.length;
            int x = 3;
            int index = ceilSearch(arr, 0, n-1, x);
            if(index == -1)
                System.out.println("Ceiling of " + x + " doesn't exist in array");
            else
                System.out.println("ceiling of " + x + " is " + arr[index]);
        }
    }


    //Approach 2 : Binary Search.....                                                  T.C. = O(log(n)),  S.C. = O(1)
    /*  Instead of using linear search, binary search is used here to find out the index.
        Binary search reduces the time complexity to O(Logn).
     * */
    class Main_2 {
        /* Function to get index of ceiling of x in arr[low...high] */
        static int ceilSearch(int arr[], int low, int high, int x)
        {
            // base condition if length of arr == 0 then return -1
            if (high == 0) {
                return -1;
            }
        /* this while loop function will run until condition not break once condition break loop will return
           start and ans is low which will be next smallest greater than target which is ceiling */
            while (low <= high) {
                int mid = low + (high - low) / 2;                 // calculate mid

                if (x == arr[mid]) {
                    return mid;
                }
                if (x < arr[mid]) {
                    high = mid - 1;
                }

                else {
                    low = mid + 1;
                }
            }
            return low;
        }
        /*  step 1 : { low = 1, 2, 8, 10 = mid, 10, 12, 19 = high };
                        if( x < mid) yes set high = mid -1;
            step 2 : { low = 1, 2 = mid, 8 = high, 10, 10, 12, 19 };
                        if( x < mid) no set low = mid + 1;
            step 3 : { 1, 2, 8 = high, low, low, 10, 10, 12, 19 };
                        if( x == mid ) yes return mid
                        if( x < mid ) no low = mid + 1
            step 4 : { 1, 2, 8 = high, mid, 10 = low, 10, 12, 19};
                        check while(low < = high)
                        condition break and return low which will next greater of target   */

        /* Driver program to check above functions */
        public static void main_2(String[] args)
        {
            int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
            int n = arr.length;
            int x = 8;
            int index = ceilSearch(arr, 0, n - 1, x);
            if (index == -1)
                System.out.println("Ceiling of " + x + " doesn't exist in array");
            else
                System.out.println("ceiling of " + x + " is " + arr[index]);
        }
    }

    //Code 2 :
    class Main_3 {
        /* Function to get index of ceiling of x in arr[low...high]*/
        static int ceilSearch(int arr[], int low, int high, int x)
        {
            // base condition if length of arr == 0 then return -1
            if (x == 0) {
                return -1;
            }
            /* this while loop function will run until condition not break once condition break
               loop will return start and ans is low which will be next smallest greater than target which is ceiling*/
            while (low <= high) {
                int mid
                        = low + (high - low) / 2;                             // calculate mid

                if (x == arr[mid]) {
                    return mid;
                }
                if (x < arr[mid]) {
                    high = mid - 1;
                }

                else {
                    low = mid + 1;
                }
            }
            return low;
        }
        /*  step 1 : { low = 1, 2, 8, 10 = mid, 10, 12, 19 = high};
                        if( x < mid) yes set high = mid -1;
            step 2 : { low = 1, 2 = mid, 8 = high, 10, 10, 12, 19};
                        if( x < mid) no set low = mid + 1;
            step 3 : {1, 2, 8 = high, low, low, 10, 10, 12, 19};
                        if( x == mid ) yes return mid
                        if( x < mid ) no low = mid + 1
            step 4 : {1, 2, 8 = high,mid, 10 = low, 10, 12, 19};
                        check while(low < = high)
                        condition break and return low which will next greater of target    */

        /* Driver program to check above functions */
        public static void main_3(String[] args)
        {
            int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
            int n = arr.length;
            int x = 8;
            int index = ceilSearch(arr, 0, n - 1, x);
            if (index == -1)
                System.out.println("Ceiling of " + x + " doesn't exist in array");
            else
                System.out.println("ceiling of " + x + " is " + arr[index]);
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a sorted array and a value x, the ceiling of x is the smallest element in
                 an array greater than or equal to x, and the floor is the greatest element smaller
                 than or equal to x. Assume that the array is sorted in non-decreasing order.
                 Write efficient functions to find the floor and ceiling of x.


            Examples :

            For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
            For x = 0:    floor doesn't exist in array,  ceil  = 1
            For x = 1:    floor  = 1,  ceil  = 1
            For x = 5:    floor  = 2,  ceil  = 8
            For x = 20:   floor  = 19, ceil doesn't exist in array

        *
        * */
    }



}
