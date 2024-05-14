package Easy;

public class Ques_LB5 {

    //Ques : Maximum and minimum of an array using minimum number of comparisons........    (GFG Ques.)


    //Approach 1 : Maximum and minimum of an array using Linear search......             T.C. = O(n),  S.C. = O(1)
    /*  Initialize values of min and max as minimum and maximum of the first two elements respectively.
        Starting from 3rd, compare each element with max and min, and change max and min accordingly
        (i.e., if the element is smaller than min then change min, else if the element is greater than max
               then change max, else ignore the element)


     * */
    /*  static class pair {
            int min;
            int max;
        };
    *
    */
    public class GFG_1{
        /* Class Pair is used to return two values from getMinMax() */
        static class Pair {
            int min;
            int max;
        }

        static Pair getMinMax(int arr[], int n) {
            Pair minmax = new  Pair();
            int i;

            /*If there is only one element then return it as min and max both*/
            if (n == 1) {
                minmax.max = arr[0];
                minmax.min = arr[0];
                return minmax;
            }

            /* If there are more than one element, then initialize min and max*/
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            }
            else {
                minmax.max = arr[1];
                minmax.min = arr[0];
            }

            for (i = 2 ; i < n ; i++) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                else if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }

            return minmax;
        }

        /* Driver program to test above function */
        public static void main_1(String args[]) {
            int arr[] = {1000, 11, 445, 1, 330, 3000};
            int arr_size = 6;
            Pair minmax = getMinMax(arr, arr_size);
            System.out.printf("\nMinimum element is %d", minmax.min);
            System.out.printf("\nMaximum element is %d", minmax.max);

        }

    }



    //Approach 2 : Maximum and minimum of an array using the tournament method.....     T.C. = O(n),  S.C. = O(log(n))
    /*      Divide the array into two parts and compare the maximums and minimums
            of the two parts to get the maximum and the minimum of the whole array.

            Pair MaxMin(array, array_size)
                if array_size = 1
                    return element as both max and min
                else if array_size = 2
                    one comparison to determine max and min
                    return that pair
                else                                    // array_size  > 2
                recursion for max and min of left half
                recursion for max and min of right half
                one comparison determines true max of the two candidates
                one comparison determines true min of the two candidates
                    return the pair of max and min

    *
    * */
    public class GFG_2{
        /* Class Pair is used to return two values from getMinMax() */
        static class Pair {
            int min;
            int max;
        }

        static Pair getMinMax(int arr[], int low, int high)
        {
            Pair minmax = new Pair();
            Pair mml = new Pair();
            Pair mmr = new Pair();
            int mid;

            // If there is only one element
            if (low == high) {
                minmax.max = arr[low];
                minmax.min = arr[low];
                return minmax;
            }

            /* If there are two elements */
            if (high == low + 1) {
                if (arr[low] > arr[high]) {
                    minmax.max = arr[low];
                    minmax.min = arr[high];
                }
                else {
                    minmax.max = arr[high];
                    minmax.min = arr[low];
                }
                return minmax;
            }

            /* If there are more than 2 elements */
            mid = (low + high) / 2;
            mml = getMinMax(arr, low, mid);
            mmr = getMinMax(arr, mid + 1, high);

            /* compare minimums of two parts*/
            if (mml.min < mmr.min) {
                minmax.min = mml.min;
            }
            else {
                minmax.min = mmr.min;
            }

            /* compare maximums of two parts*/
            if (mml.max > mmr.max) {
                minmax.max = mml.max;
            }
            else {
                minmax.max = mmr.max;
            }

            return minmax;
        }

        /* Driver program to test above function */
        public static void main_2(String args[])
        {
            int arr[] = { 1000, 11, 445, 1, 330, 3000 };
            int arr_size = 6;
            Pair minmax = getMinMax(arr, 0, arr_size - 1);
            System.out.printf("\nMinimum element is %d", minmax.min);
            System.out.printf("\nMaximum element is %d", minmax.max);
        }
    }



    //Approach 3 : Maximum and minimum of an array by comparing in pairs........       T.C. = O(n),  S.C. = O(1)
    /*    *  If n is odd then initialize min and max as the first element.
          *  If n is even then initialize min and max as minimum and maximum of the first two elements respectively.
          *  For the rest of the elements, pick them in pairs and compare their
             maximum and minimum with max and min respectively.
    * */
    public class GFG_3{
        /* Class Pair is used to return two values from getMinMax() */
        static class Pair {
            int min;
            int max;
        }

        static Pair getMinMax(int arr[], int n) {
            Pair minmax = new Pair();
            int i;

            /* If array has even numbers of elements then initialize the first two elements as minimum and maximum */
            if (n % 2 == 0) {
                if (arr[0] > arr[1]) {
                    minmax.max = arr[0];
                    minmax.min = arr[1];
                }
                else{
                    minmax.min = arr[0];
                    minmax.max = arr[1];
                }
                i = 2;
                /* set the starting index for loop */
            }   /* If array has odd number of elements then initialize the first element as minimum and maximum */
            else {
                minmax.min = arr[0];
                minmax.max = arr[0];
                i = 1;
                /* set the starting index for loop */
            }

            /* In the while loop, pick elements in pair and compare the pair with max and min so far */
            while (i < n - 1) {
                if (arr[i] > arr[i + 1]) {
                    if (arr[i] > minmax.max) {
                        minmax.max = arr[i];
                    }
                    if (arr[i + 1] < minmax.min) {
                        minmax.min = arr[i + 1];
                    }
                }
                else {
                    if (arr[i + 1] > minmax.max) {
                        minmax.max = arr[i + 1];
                    }
                    if (arr[i] < minmax.min) {
                        minmax.min = arr[i];
                    }
                }
                i += 2;
                /* Increment the index by 2 as two elements are processed in loop */
            }

            return minmax;
        }

        /* Driver program to test above function */
        public static void main_3(String args[]) {
            int arr[] = {1000, 11, 445, 1, 330, 3000};
            int arr_size = 6;
            Pair minmax = getMinMax(arr, arr_size);
            System.out.printf("\nMinimum element is %d", minmax.min);
            System.out.printf("\nMaximum element is %d", minmax.max);

        }
    }




    public static void main(String[] args) {

        /*Ques : Given an array of size N. The task is to find the maximum and the minimum element
                 of the array using the minimum number of comparisons.


            Example : 1
            Input   : arr[] = {3, 5, 4, 1, 9}
            Output  : Minimum element is : 1
                      Maximum element is : 9

            Example : 2
            Input   : arr[] = {22, 14, 8, 17, 35, 3}
            Output  : Minimum element is : 3
                      Maximum element is : 35


        * */
    }



}
