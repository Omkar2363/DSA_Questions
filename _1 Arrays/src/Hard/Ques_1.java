package Hard;

import java.util.Stack;

public class Ques_1 {

    //Ques : Trapping rain water problem.                               (Leet code Ques no. - 42)
                                                                        //Also see article from GFG - 6 approaches are given :

    //Approach  1 :  Brute force approach                        //T.C. = O(n^2), S.C = O(1)
    public static int maxWater(int[] arr, int n) {

        // To store the maximum water
        // that can be stored
        int res = 0;

        // For every element of the array
        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int left = arr[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            // Find maximum element on its right
            int right = arr[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, arr[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i];
        }
        return res;
    }



    //Approach  2 :  PreCalculation method                       //T.C. = O(n), S.C. = O(n)
    static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    static int findWater(int n){            // Method for maximum amount of water
        /*
         left[i] contains height of tallest bar to the
         left of i'th bar including itself
        */
        int left[] = new int[n];

        /*
         Right [i] contains height of tallest bar to
         the right of ith bar including itself
        */
        int right[] = new int[n];

        // Initialize result
        int water = 0;

        // Fill left array
        left[0] = arr[0];
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        // Fill right array
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        /*
         Calculate the accumulated water element by
         element consider the amount of water on i'th bar,
         the amount of water accumulated on this
         particular bar will be equal to min(left[i],
         right[i]) - arr[i] .
        */
        for (int i = 0; i < n; i++)
            water += Math.min(left[i], right[i]) - arr[i];

        return water;
    }



    //Approach  3 :  Using Stack                                //T.C. = O(n), S.C = O(n)
    public static int maxWater(int[] height) {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // size of the array
        int n = height.length;

        // Stores the final result
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack until the condition holds
            while ((!stack.isEmpty()) && (height[stack.peek()] < height[i])) {

                // store the height of the top and pop it.
                int pop_height = height[stack.peek()];
                stack.pop();

                // If the stack does not have any bars or the popped bar has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the left and right boundary of popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;

                ans += distance * min_height;
            }

            /*
             If the stack is either empty or height of the current bar is less than
             or equal to the top bar of stack
            */
            stack.push(i);
        }

        return ans;
    }


    //Approach  4 :  Horizontal scan method                     //T.C. = O(max (max_height, N)), S.C = O(1)
    public static int trappedWater(int arr[]){

        // To store the number of blocks
        int n = arr.length;

        // To store the sum of all the heights
        int num_blocks = 0;

        // To store the maximum height in the array
        int max_height = Integer.MIN_VALUE;

        // Compute the sum of all heights and the maximum height given in the array
        for (int i = 0; i < n; i++) {
            max_height = Math.max(max_height, arr[i]);
            num_blocks += arr[i];
        }

        // To store the answer and initialise the left and right pointers
        int total = 0, left = 0, right = n - 1;

        for (int i = 1; i <= max_height; i++) {

            // Compute the leftmost point greater than current row (i)
            while (arr[left] < i) {
                left++;
            }

            // Compute the rightmost point greater than current row (i)
            while (arr[right] < i) {
                right--;
            }

            // Water in this row = right - left + 1
            total += (right - left + 1);
        }

        total -= num_blocks;
        return total;
    }


    //Approach  5 :  Two pointer approach                       //T.C. = O(n), S.C = O(1)
    static int maxWater2(int[] arr, int n){

        // Indices to traverse the array
        int left = 0;
        int right = n - 1;

        // To store Left max and right max for two pointers left and right
        int l_max = 0;
        int r_max = 0;

        // To store the total amount of rain water trapped
        int result = 0;
        while (left <= right) {

            // We need check for minimum of left and right max for each element
            if (r_max <= l_max) {

                // Add the difference between current value and right max at index r
                result += Math.max(0, r_max - arr[right]);

                // Update right max
                r_max = Math.max(r_max, arr[right]);

                // Update right pointer
                right -= 1;
            }
            else {

                // Add the difference between current value and left max at index l
                result += Math.max(0, l_max - arr[left]);

                // Update left max
                l_max = Math.max(l_max, arr[left]);

                // Update left pointer
                left += 1;
            }
        }
        return result;
    }


    //Approach  6 :  Similar to linear Search                   //T.C. = O(n), S.C = O(1)
    public static int maxWater3(int arr[], int n){
        int size = n - 1;

        // Let the first element be stored as previous, we shall loop from index 1
        int prev = arr[0];

        // To store previous wall's index
        int prev_index = 0;
        int water = 0;

        // To store the water until a larger wall is found, if there are no larger walls
        // then delete temp value from water
        int temp = 0;
        for (int i = 1; i <= size; i++) {

            /*
             If the current wall is taller than the previous wall then make current
             wall as the previous wall and its index as previous wall's index
             for the subsequent loops
            */
            if (arr[i] >= prev) {
                prev = arr[i];
                prev_index = i;

                // Because larger or same height wall is found
                temp = 0;
            }
            else {

                /*
                 Since current wall is shorter than the previous, we subtract previous
                 wall's height from the current wall's height and add it to the water
                */
                water += prev - arr[i];

                /*
                 Store the same value in temp as well If we don't find any larger wall then
                 we will subtract temp from water
                */
                temp += prev - arr[i];
            }
        }

        /*
         If the last wall was larger than or equal to the previous wall then prev_index would
         be equal to size of the array (last element). If we didn't find a wall greater than or equal
         to the previous wall from the left then prev_index must be less than the index
         of the last element
        */
        if (prev_index < size) {

            /*
             Temp would've stored the water collected from previous largest wall till the end
             of array if no larger wall was found then it has excess water and remove that
             from 'water' var
            */
            water -= temp;

            // We start from the end of the array, so previous should be assigned to the last element
            prev = arr[size];

            /*
             Loop from the end of array up to the 'previous index' which would contain the
             "largest wall from the left"
            */
            for (int i = size; i >= prev_index; i--) {

                // Right end wall will be definitely smaller than the 'previous index' wall
                if (arr[i] >= prev) {
                    prev = arr[i];
                }
                else {
                    water += prev - arr[i];
                }
            }
        }

        // Return the maximum water
        return water;
    }


    public static void main(String[] args) {

        /*Ques : Given an array of N non-negative integers arr[] representing an elevation map where
                 the width of each bar is 1, compute how much water it is able to trap after raining.


                Examples :
                Input   : arr[] = {2, 0, 2}
                Output  : 2
                Explanation : The structure is like below.                         //See the picture from GFG ques
                              We can trap 2 units of water in the middle gap.



                Input   : arr[] = {3, 0, 2, 0, 4}
                Output  : 7
                Explanation : Structure is like below.                            //See the picture from GFG ques
                              We can trap "3 units" of water between 3 and 2,
                              "1 unit" on top of bar 2 and "3 units" between 2 and 4.



                Input   : arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
                Output  : 6
                Explanation : The structure is like below.                        //See the picture from GFG ques
                              Trap "1 unit" between first 1 and 2, "4 units" between
                              first 2 and 3 and "1 unit" between second last 1 and last 2

*/

    }
}
