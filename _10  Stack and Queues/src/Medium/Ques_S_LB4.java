package Medium;

import java.util.Stack;

public class Ques_S_LB4 {

    //Ques : Maximum Rectangular Area in a Histogram..........                                  (GFG Ques.)


    //Approach 1 : Efficient Approach........                                                   T.C. = O(n),  S.C. = O(n)
    //Java program to find maximum rectangular area in linear time
    public class RectArea {

        // The main function to find the maximum rectangular area under given histogram with n bars
        static int getMaxArea(int hist[], int n)
        {
            // Create an empty stack. The stack holds indexes of hist[] array.
            // The bars stored in stack are always in increasing order of their heights.
            Stack<Integer> s = new Stack<>();

            int max_area = 0;                              // Initialize max area
            int tp;                                        // To store top of stack
            int area_with_top;                             // To store area with top bar as the smallest bar

            // Run through all bars of given histogram
            int i = 0;
            while (i < n)
            {
                // If this bar is higher than the bar on top stack, push it to stack
                if (s.empty() || hist[s.peek()] <= hist[i])
                    s.push(i++);

                    /*
                     If this bar is lower than top of stack, then calculate area of rectangle
                     with stack top as the smallest (or minimum height) bar.
                     'i' is 'right index' for the top and element before top in stack is 'left index'
                    */
                else
                {
                    tp = s.peek();                         // store the top index
                    s.pop();                               // pop the top

                    // Calculate the area with hist[tp] stack as smallest bar
                    area_with_top = hist[tp] * (s.empty()  ?  i  :  (i - s.peek() - 1));

                    // update max area, if needed
                    if (max_area < area_with_top)
                        max_area = area_with_top;
                }
            }

            // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar
            while (s.empty() == false)
            {
                tp = s.peek();
                s.pop();
                area_with_top = hist[tp] * (s.empty()  ?  i  :  (i - s.peek() - 1));

                if (max_area < area_with_top)
                    max_area = area_with_top;
            }

            return max_area;

        }

        // Driver program to test above function
        public static void main_1(String[] args)
        {
            int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
            System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
        }
    }




    //Approach 2 : Another Efficient Approach..........                                         T.C. = O(n),  S.C. = O(n)
    public class RectArea_2 {

        //Function to find the largest rectangular area possible in a given histogram.
        public static int getMaxArea(int arr[], int n)
        {
            // your code here
            //we create an empty stack here.
            Stack<Integer> s = new Stack<>();

            /*
            we push -1 to the stack because for some elements there will be no previous
            smaller element in the array, and we can store -1 as the index for previous smaller.
            */
            s.push(-1);
            int max_area = arr[0];

            /*
            We declare left_smaller and right_smaller array of size n and initialize them with -1 and n as
            their default value.
              left_smaller[i]  will store the index of previous smaller element for ith element of the array.
              right_smaller[i] will store the index of next smaller element for ith element of the array.
            */
            int left_smaller[] = new int[n];
            int right_smaller[] = new int[n];
            for (int i = 0; i < n; i++){
                left_smaller[i] = -1;
                right_smaller[i] = n;
            }

            int i = 0;
            while (i < n)
            {
                while(!s.empty()&&s.peek()!=-1&&arr[i]<arr[s.peek()]){
                    /*
                    if the current element is smaller than element with index stored on the top of stack then,
                     we pop the top element and store the current element index as the right_smaller
                     for the popped element.
                    */
                    right_smaller[s.peek()] = (int)i;
                    s.pop();
                }
                if(i>0  &&  arr[i]==arr[(i-1)])
                {
                    /*
                    we use this condition to avoid the unnecessary loop to find the left_smaller.
                    since the previous element is same as current element, the left_smaller will always
                     be the same for both.
                    */
                    left_smaller[i] = left_smaller[(int)(i-1)];
                }else{
                    //Element with the index stored on the top of the stack is always smaller than the current element.
                    //Therefore, the left_smaller[i] will always be s.top().
                    left_smaller[i] = s.peek();
                }
                s.push(i);
                i++;
            }


            for(i = 0; i<n; i++)
            {
                //here we find area with every element as the smallest element in their range and
                // compare it with the previous area. In this way we get our max Area form this.....
                max_area = Math.max(max_area, arr[i]*(right_smaller[i] - left_smaller[i] - 1));
            }

            return max_area;
        }

        public static void main_2(String[] args)
        {
            int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
            System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
        }
    }





    public static void main(String[] args) {

        /*Ques : Find the largest rectangular area possible in a given histogram where the largest rectangle
                 can be made of a number of contiguous bars. For simplicity, assume that all bars have the same
                 width and the width is 1 unit, there will be N bars height of each bar will be given by the array arr.


            Example : 1
            Input   : N = 7
                      arr[] = {6,2,5,4,5,1,6}
            Output  : 12
            Explanation :


            Example : 2
            Input   : N = 8
                      arr[] = {7 2 8 9 1 3 6 5}
            Output  : 16
            Explanation : Maximum size of the histogram will be 8  and there will be 2 consecutive histogram.
                          And hence the area of the histogram will be 8x2 = 16.


            Your Task :
            The task is to complete the function getMaxArea() which takes the array arr[] and its size N as inputs
            and finds the largest rectangular area possible and returns the answer.

            Expected Time Complexity   : O(N)
            Expected Auxilliary Space  : O(N)


        * */
    }



}
