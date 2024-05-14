package Medium;

public class Ques_LB9 {

    //Ques : Search an element in a sorted and rotated Array........                          (GFG Ques.)

    //Approach 1 : Finding Pivot where rotation has happened.....                             T.C. = O(log(n)),  S.C. = O(1)
    /* Java program to search an element in a sorted and pivoted array   */
    class Main_1 {

        /* Searches an element key in a pivoted sorted array arr[]of size n */
        static int pivotedBinarySearch(int arr[], int n, int key)
        {
            int pivot = findPivot(arr, 0, n - 1);

            // If we didn't find a pivot, then array is not rotated at all
            if (pivot == -1)
                return binarySearch(arr, 0, n - 1, key);

            // If we found a pivot, then first compare with pivot and
            // then search in two subarrays around pivot
            if (arr[pivot] == key)
                return pivot;
            if (arr[0] <= key)
                return binarySearch(arr, 0, pivot - 1, key);

            return binarySearch(arr, pivot + 1, n - 1, key);
        }

        /* Function to get pivot. For array 3, 4, 5, 6, 1, 2
           it returns 3 (index of 6) */
        static int findPivot(int arr[], int low, int high) {
            // base cases
            if (high < low)
                return -1;
            if (high == low)
                return low;

            /* low + (high - low)/2; */
            int mid = (low + high) / 2;
            if (mid < high && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > low && arr[mid] < arr[mid - 1])
                return (mid - 1);
            if (arr[low] >= arr[mid])
                return findPivot(arr, low, mid - 1);

            return findPivot(arr, mid + 1, high);
        }

        /* Standard Binary Search function */
        static int binarySearch(int arr[], int low, int high, int key)
        {
            if (high < low)
                return -1;

            /* low + (high - low)/2; */
            int mid = (low + high) / 2;
            if (key == arr[mid])
                return mid;
            if (key > arr[mid])
                return binarySearch(arr, (mid + 1), high, key);

            return binarySearch(arr, low, (mid - 1), key);
        }

        // main function
        public static void main_1(String args[])
        {
            // Let us search 3 in below array
            int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
            int n = arr1.length;
            int key = 3;
            System.out.println("Index of the element is : " + pivotedBinarySearch(arr1, n, key));
        }
    }



    //Approach 2 : Direct Binary search on Array without finding Pivot....                   T.C. = O(log(n)),  S.C. = O(1)
    /* Java program to search an element in sorted and rotated array using single pass of Binary Search*/
    class Main {
        // Returns index of key in arr[l...h]
        // if key is present, otherwise returns -1
        static int search(int arr[], int l, int h, int key)
        {
            if (l > h)
                return -1;

            int mid = (l + h) / 2;
            if (arr[mid] == key)
                return mid;

            /* If arr[l...mid] first subarray is sorted */
            if (arr[l] <= arr[mid]) {

                /* As this subarray is sorted, we can quickly check if key lies in half or other half */
                if (key >= arr[l] && key <= arr[mid])
                    return search(arr, l, mid - 1, key);

                    /*  If key not lies in first half subarray, Divide other half  into two subarrays,
                        such that we can quickly check if key lies in other half  */
                return search(arr, mid + 1, h, key);
            }

            /* If arr[l...mid] first subarray is not sorted, then arr[mid...h] must be sorted subarray  */
            if (key >= arr[mid] && key <= arr[h])
                return search(arr, mid + 1, h, key);

            return search(arr, l, mid - 1, key);
        }

        // main function
        public static void main_2(String args[])
        {
            int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
            int n = arr.length;
            int key = 3;
            int i = search(arr, 0, n - 1, key);
            if (i != -1)
                System.out.println("Index: " + i);
            else
                System.out.println("Key not found");
        }
    }







    public static void main(String[] args) {

        /*Ques : Given a sorted and rotated array arr[] of size N and a key,
                 the task is to find the key in the array.

            Note : Find the element in O(logN) time and assume that all the elements are distinct.

            Example : 1
            Input   : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
            Output  : Found at index 8


            Example : 2
            Input   : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 30
            Output  : Not found


            Example : 3
            Input   : arr[] = {30, 40, 50, 10, 20}, key = 10
            Output  : Found at index 3


        *
        *
        * */
    }


}
