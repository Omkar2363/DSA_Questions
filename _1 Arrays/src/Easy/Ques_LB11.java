package Easy;

public class Ques_LB11 {

    //Ques : Three way partitioning.....                                                    (GFG Ques.)


    //Approach  :  By using two pointer approach....                                        T.C. = O(n), S.C. = O(1)
                   //Idea is based on DNF (Dutch National Flag) based Quick Sort.

            // Partitions arr[0..n-1] around [lowVal..highVal]
    public static void threeWayPartition(int[] arr, int lowVal, int highVal) {

        int n = arr.length;

        // Initialize ext available positions for
        // smaller (than range) and greater elements
        int start = 0, end = n - 1;

        // Traverse elements from left
        for (int i = 0; i <= end; ) {

            // If current element is smaller than range,
            // put it on next available smaller position.

            if (arr[i] < lowVal) {

                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
                i++;
            }

            // If current element is greater than range,
            // put it on next available greater position.
            else if (arr[i] > highVal) {

                int temp = arr[end];
                arr[end] = arr[i];
                arr[i] = temp;
                end--;
            } else
                i++;
        }

    /* Driver code :
    public static void main(String[] args)
    {

        int arr[] = { 1,  14, 5,  20, 4, 2, 54,
                20, 87, 98, 3,  1, 32 };

        threeWayPartition(arr, 10, 20);

        System.out.println("Modified array ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }*/
    }



    public static void main(String[] args) {

        /*Ques : Given an array of size n and a range [a, b]. The task is to partition the array around
                 the range such that array is divided into three parts.
                    1) All elements smaller than a come first.
                    2) All elements in range a to b come next.
                    3) All elements greater than b appear in the end.
                 The individual elements of three sets can appear in any order. You are required to return the modified array.


                Example : 1
                Input   : n = 5
                          A[] = {1, 2, 3, 3, 4}
                          [a, b] = [1, 2]
                Output  : 1
                Explanation : One possible arrangement is : {1, 2, 3, 3, 4}.
                              If you return a valid arrangement, output will be 1.


                Example : 2
                Input   : n = 3
                          A[] = {1, 2, 3}
                          [a, b] = [1, 3]
                Output  : 1
                Explanation : One possible arrangement is : {1, 2, 3}.
                              If you return a valid arrangement, output will be 1.


                Your Task:
                You don't need to read input or print anything. The task is to complete the function
                threeWayPartition() which takes the array[], a and b as input parameters and modifies
                the array in-place according to the given conditions.

                Note : The generated output is 1 if you modify the given array successfully.

                Expected Time Complexity: O(n)
                Expected Auxiliary Space: O(1)

        * */
    }

}
