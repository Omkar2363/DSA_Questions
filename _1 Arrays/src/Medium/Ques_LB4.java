package Medium;

public class Ques_LB4 {

    //Ques : Rearrange array in alternating positive & negative items with O(1) extra space            (GFG Ques)

    //Approach 1 : Naive approach....
    /*Naive Approach:
        The above problem can be easily solved if O(n) extra space is allowed.

        We can store the positive values and negative values in two separate data structures.
        We will start filling the original array with alternating negative and positive values in the same order
        in which it appears in the original array.
    */


    //Approach 2 : Optimized approach....                                           T.C.  = O(n^2), S.C. = O(1)
    /*  The idea is to process the array from left to right. While processing, find the first out-of-place element in
        the remaining unprocessed array. An element is out of place if it is negative and at odd index (0-based index),
        or if it is positive and at even index (0-based index). Once we find an out-of-place element, we find the first
        element after it with an opposite sign. We right rotate the subarray between these two elements
        (including these two).

        Algorithm :
        =>We will maintain a variable to mark if the element is in its correct position or not.
          Let the variable be outofplace. Initially, it is -1.

        * We will iterate over the array
        * If outofplace is -1, we will check if the current index is out of place.
            - If the current index is out of place we will update the outofplace with the index value.
            - Else we will keep the value as it is.
        *If the outofplace is not -1, we will search for the next index which has a different sign than that of the value that is present in outofplace position.
            - Now we will pass this two positions to right rotate our array.
            - Update the value of outofplace by 2 unit.
        */
    //class RearrangeArray {
        // Utility function to right rotate all elements between [outofplace, cur]
        void rightrotate(int arr[], int n, int outofplace, int cur){
            int tmp = arr[cur];
            for (int i = cur; i > outofplace; i--)
                arr[i] = arr[i - 1];
            arr[outofplace] = tmp;
        }

        void rearrange(int arr[], int n){
            int outofplace = -1;

            for (int index = 0; index < n; index++) {
                if (outofplace >= 0) {
                    /*
                     find the item which must be moved into the out-of-place entry if out-of-place
                     entry is positive and current entry is negative OR if out-of-place entry is
                     negative and current entry is negative then right rotate

                     [...-3, -4, -5, 6...] -->   [...6, -3,
                     -4, -5...]
                          ^                          ^
                          |                          |
                         outofplace      -->      outofplace

                    */
                    if (((arr[index] >= 0)
                            && (arr[outofplace] < 0))
                            || ((arr[index] < 0)
                            && (arr[outofplace] >= 0))) {
                        rightrotate(arr, n, outofplace, index);

                        // the new out-of-place entry is now 2
                        // steps ahead
                        if (index - outofplace >= 2)
                            outofplace = outofplace + 2;
                        else
                            outofplace = -1;
                    }
                }

                // if no entry has been flagged out-of-place
                if (outofplace == -1) {
                    // check if current entry is out-of-place
                    if (((arr[index] >= 0)
                            && ((index & 0x01) == 0))
                            || ((arr[index] < 0)
                            && (index & 0x01) == 1))
                        outofplace = index;
                }
            }
        }                              //Function with logic

        // A utility function to print an array 'arr[]' of size 'n'
        void printArray(int arr[], int n){
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println("");
        }

        /*Driver Code
        public static void main(String[] args)
        {
            RearrangeArray rearrange = new RearrangeArray();
        //int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
        //int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4};
        //int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4};
        //int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4};
        //int arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };

        int n = arr.length;

            System.out.println("Given array is ");
            rearrange.printArray(arr, n);

            rearrange.rearrange(arr, n);

            System.out.println("RearrangeD array is ");
            rearrange.printArray(arr, n);
        }
        */

//}



    public static void main(String[] args) {

        /*Ques : Given an array of positive and negative numbers, arrange them in an alternate fashion  such  that
                 every positive number is followed by a negative and vice-versa maintaining the order of appearance.
                 The number of positive and negative numbers need not be equal. If there are more positive  numbers
                 they appear at the end of the array. If there are more negative numbers, they  too  appear  at the
                 end of the array.


            Example : 1
            Input   :  arr[] = {1, 2, 3, -4, -1, 4}
            Output  : arr[] = {-4, 1, -1, 2, 3, 4}

            Example : 2
            Input   : arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
            Output  : arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}


        * */


    }


}
