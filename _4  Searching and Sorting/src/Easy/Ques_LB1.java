package Easy;

import java.util.ArrayList;

public class Ques_LB1 {

    //Ques : First and last occurrences of x......                                     (GFG Ques.)


    //Approach 1 :                                                                     T.C. = O(log(n)),  S.C. = O(1)
    //JAVA Code using Binary Search Algorithm
    class GFG {

        ArrayList<Long> find(long arr[], int n, int x)
        {
            // code here
            ArrayList<Long> ans = new ArrayList<Long>();

            ans.add((long)binarySearch(arr, x, true));
            ans.add((long)binarySearch(arr, x, false));

            return ans;
        }

        static int binarySearch(long[] arr, int x, boolean findFirstIndex)
        {
            int start = 0;
            int end = arr.length - 1;
            int ans = -1;

            while(start <= end){
                int mid = start + (end - start) / 2;

                if(x > arr[mid]){
                    start = mid + 1;
                }
                else if(x < arr[mid]){
                    end = mid - 1;
                }
                else{
                    ans = mid;
                    if(findFirstIndex == true){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
            }
            return ans;
        }
    }




    public static void main(String[] args) {

        /*Ques : Given a sorted array arr containing n elements with possibly duplicate elements,
                 the task is to find indexes of first and last occurrences of an element x in the given array.


            Example : 1
            Input   : n=9, x=5
                      arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
            Output  : 2 5
            Explanation : First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5.


            Example : 2
            Input   : n=9, x=7
                      arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
            Output  : 6 6

            Your Task :
            Since, this is a function problem. You don't need to take any input, as it is already accomplished
            by the driver code. You just need to complete the function find() that takes array arr,
            integer n and integer x as parameters and returns the required answer.

            Note: If the number x is not found in the array just return both index as -1.


            Expected Time Complexity: O(logN)
            Expected Auxiliary Space: O(1).


         */

    }

}
