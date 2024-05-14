package Medium;

public class Ques_LB2 {

    //Ques : Minimum number of jumps..........                                          (GFG Ques)

    //Approach 1 :                                                                      T.C. = O(n), S.C. = O(1)
    static int minJumps(int arr[]) {

        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {

            // Check if we have reached the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                               // we must have used a jump
                jump++;

                // Check if the current index/position or lesser index is the maximum reach point
                // from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }
        return -1;
    }


    //Approach 2 :                                                                      T.C. = O(n), S.C. = O(1)

    // Returns minimum number of jumps to reach arr[n-1] from arr[0]
    static int minJumps(int arr[], int n) {

        // The number of jumps needed to reach the starting index is 0
        if (n <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // Stores the number of jumps necessary to reach that maximal reachable position.
        int jump = 1;

        // Stores the subarray last index
        int subArrEndIndex = arr[0];

        int i = 1;

        // Maximum steps covers in first half of sub array
        int subArrFistHalfMaxSteps = 0;


        // Maximum steps covers in second half of sub array
        int subArrSecondHalfMaxSteps = 0;

        // Start traversing array
        for (i = 1; i < n;) {

            subArrEndIndex = i + subArrEndIndex;

            // Check if we have reached the end of the array
            if (subArrEndIndex >= n)
                return jump;

            int firstHalfMaxStepIndex = 0;

            // Iterate the sub array and find out the maxsteps cover index
            for (; i < subArrEndIndex; i++) {
                int stepsCanCover = arr[i] + i;
                if (subArrFistHalfMaxSteps < stepsCanCover) {
                    subArrFistHalfMaxSteps = stepsCanCover;
                    subArrSecondHalfMaxSteps = 0;
                    firstHalfMaxStepIndex = i;
                } else if (subArrSecondHalfMaxSteps < stepsCanCover) {
                    subArrSecondHalfMaxSteps = stepsCanCover;
                }
            }

            if (i > subArrFistHalfMaxSteps)
                return -1;

            jump++;

            // Next subarray end index and so far calculated sub array max step cover value
            subArrEndIndex = arr[firstHalfMaxStepIndex];
            subArrFistHalfMaxSteps = subArrSecondHalfMaxSteps;
        }

        return -1;
    }



    public static void main(String[] args) {

        /*Ques : Given an array of N integers arr[] where each element represents the max length of the jump
                 that can be made forward from that element. Find the minimum number of jumps to reach the end
                 of the array (starting from the first element). If an element is 0, then you cannot move through
                 that element.


                 Note: Return -1 if you can't reach the end of the array.


            Example : 1
            Input   : N = 11
                      arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
            Output  : 3
            Explanation : First jump from 1st element to 2nd element with value 3. Now, from here
                          we jump to 5th element with value 9,and from here we will jump to the last.


            Example : 2
            Input   : N = 6
                      arr = {1, 4, 3, 2, 6, 7}
            Output  : 2
            Explanation : First we jump from the 1st to 2nd element and then jump to the last element.

        * */
    }

}
